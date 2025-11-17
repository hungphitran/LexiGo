package com.ptithcm.lexigo.activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.ptithcm.lexigo.R;
import com.ptithcm.lexigo.api.ApiClient;
import com.ptithcm.lexigo.api.models.ListeningExercise;
import com.ptithcm.lexigo.api.models.Progress;
import com.ptithcm.lexigo.api.models.Script;
import com.ptithcm.lexigo.api.responses.ApiResponse;
import com.ptithcm.lexigo.api.services.LexiGoApiService;
import com.ptithcm.lexigo.utils.ProgressTracker;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Activity hiển thị bài tập nghe với audio và script có chỗ trống
 */
public class ListeningExerciseActivity extends AppCompatActivity {

    private static final String TAG = "ListeningExercise";
    private static final int MAX_EXERCISES = 10; // Tối đa 10 câu hỏi

    private MaterialToolbar toolbar;
    private TextView tvLevel, tvScriptWithBlank, tvResult;
    private EditText etAnswer;
    private MaterialButton btnPlayAudio, btnSubmit, btnNext, btnHome;
    private ProgressBar progressBar;

    private String level;
    private List<Script> scripts;
    private List<Script> shuffledScripts; // Danh sách đã shuffle
    private int currentExerciseIndex = 0; // Vị trí câu hỏi hiện tại
    private Script currentScript;
    private ListeningExercise currentExercise;
    private MediaPlayer mediaPlayer;
    private LexiGoApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening_exercise);

        // Lấy level từ Intent
        level = getIntent().getStringExtra("level");
        if (level == null) {
            level = "Beginner";
        }

        initViews();
        apiService = ApiClient.getInstance(this).getApiService();

        loadScripts();
    }

    /**
     * Khởi tạo các view components
     */
    private void initViews() {
        // Setup toolbar
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Bài tập nghe");
        toolbar.setNavigationOnClickListener(v -> finish());

        tvLevel = findViewById(R.id.tvLevel);
        tvScriptWithBlank = findViewById(R.id.tvScriptWithBlank);
        tvResult = findViewById(R.id.tvResult);
        etAnswer = findViewById(R.id.etAnswer);
        btnPlayAudio = findViewById(R.id.btnPlayAudio);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnNext = findViewById(R.id.btnNext);
        btnHome = findViewById(R.id.btnHome);
        progressBar = findViewById(R.id.progressBar);

        updateLevelText();

        setupClickListeners();
    }

    /**
     * Cập nhật text hiển thị level và progress
     */
    private void updateLevelText() {
        if (shuffledScripts != null && !shuffledScripts.isEmpty()) {
            tvLevel.setText(String.format("Cấp độ: %s | Câu %d/%d",
                level, currentExerciseIndex + 1, shuffledScripts.size()));
        } else {
            tvLevel.setText("Cấp độ: " + level);
        }
    }

    /**
     * Thiết lập các sự kiện click
     */
    private void setupClickListeners() {
        btnPlayAudio.setOnClickListener(v -> playAudio());
        btnSubmit.setOnClickListener(v -> checkAnswer());
        btnNext.setOnClickListener(v -> loadNextExercise());
        btnHome.setOnClickListener(v -> {
            // Quay về HomeActivity
            android.content.Intent intent = new android.content.Intent(this, HomeActivity.class);
            intent.setFlags(android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP | android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });
    }

    /**
     * Load danh sách scripts theo level
     */
    private void loadScripts() {
        progressBar.setVisibility(View.VISIBLE);

        Call<ApiResponse<List<Script>>> call = apiService.getScripts(level);
        call.enqueue(new Callback<ApiResponse<List<Script>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Script>>> call, Response<ApiResponse<List<Script>>> response) {
                progressBar.setVisibility(View.GONE);

                if (response.isSuccessful() && response.body() != null) {
                    ApiResponse<List<Script>> apiResponse = response.body();

                    if (apiResponse.isSuccess() && apiResponse.getData() != null) {
                        scripts = apiResponse.getData();

                        if (!scripts.isEmpty()) {
                            // Shuffle và lấy tối đa 10 câu hỏi ngẫu nhiên
                            shuffleAndLimitScripts();
                            // Load câu hỏi đầu tiên
                            loadCurrentExercise();
                        } else {
                            Toast.makeText(ListeningExerciseActivity.this,
                                "Không có bài tập nào cho cấp độ này", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(ListeningExerciseActivity.this,
                            apiResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ListeningExerciseActivity.this,
                        "Lỗi khi tải dữ liệu", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Script>>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(ListeningExerciseActivity.this,
                    "Lỗi kết nối: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Shuffle danh sách scripts và chỉ lấy tối đa 10 câu hỏi
     * Chỉ thực hiện 1 lần duy nhất
     */
    private void shuffleAndLimitScripts() {
        if (scripts == null || scripts.isEmpty()) {
            return;
        }

        // Tạo bản sao của danh sách để shuffle
        shuffledScripts = new java.util.ArrayList<>(scripts);

        // Shuffle danh sách
        java.util.Collections.shuffle(shuffledScripts);

        // Giới hạn tối đa MAX_EXERCISES câu
        if (shuffledScripts.size() > MAX_EXERCISES) {
            shuffledScripts = shuffledScripts.subList(0, MAX_EXERCISES);
        }

        // Reset index về 0
        currentExerciseIndex = 0;

        Log.d(TAG, "Shuffled and limited to " + shuffledScripts.size() + " exercises");
    }

    /**
     * Load bài tập hiện tại dựa trên index
     */
    private void loadCurrentExercise() {
        if (shuffledScripts == null || shuffledScripts.isEmpty()) {
            Toast.makeText(this, "Không có bài tập nào", Toast.LENGTH_SHORT).show();
            return;
        }

        if (currentExerciseIndex >= shuffledScripts.size()) {
            // Đã hoàn thành tất cả bài tập
            showCompletionMessage();
            return;
        }

        currentScript = shuffledScripts.get(currentExerciseIndex);
        loadExercise(currentScript.getScriptId());
    }

    /**
     * Hiển thị thông báo hoàn thành tất cả bài tập
     */
    private void showCompletionMessage() {
        Toast.makeText(this,
            "🎉 Bạn đã hoàn thành tất cả " + shuffledScripts.size() + " bài tập nghe!",
            Toast.LENGTH_LONG).show();

        // Ẩn các nút Submit và Next, hiển thị nút Home
        btnSubmit.setVisibility(View.GONE);
        btnNext.setVisibility(View.GONE);
        btnHome.setVisibility(View.VISIBLE);

        // Cập nhật text để hiển thị hoàn thành
        tvScriptWithBlank.setText("Chúc mừng! Bạn đã hoàn thành tất cả bài tập nghe ở cấp độ " + level + "!");
        tvResult.setVisibility(View.GONE);
        etAnswer.setVisibility(View.GONE);
    }

    /**
     * Load bài tập listening theo script_id
     */
    private void loadExercise(String scriptId) {
        progressBar.setVisibility(View.VISIBLE);

        Call<ApiResponse<ListeningExercise>> call = apiService.getListeningExercise(scriptId);
        call.enqueue(new Callback<ApiResponse<ListeningExercise>>() {
            @Override
            public void onResponse(Call<ApiResponse<ListeningExercise>> call,
                                 Response<ApiResponse<ListeningExercise>> response) {
                progressBar.setVisibility(View.GONE);

                if (response.isSuccessful() && response.body() != null) {
                    ApiResponse<ListeningExercise> apiResponse = response.body();

                    if (apiResponse.isSuccess() && apiResponse.getData() != null) {
                        currentExercise = apiResponse.getData();
                        displayExercise();
                    } else {
                        Toast.makeText(ListeningExerciseActivity.this,
                            apiResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ListeningExerciseActivity.this,
                        "Lỗi khi tải bài tập", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<ListeningExercise>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(ListeningExerciseActivity.this,
                    "Lỗi kết nối: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Hiển thị bài tập
     */
    private void displayExercise() {
        if (currentExercise == null) {
            return;
        }

        // Ẩn bàn phím trước khi cập nhật UI
        hideKeyboard();

        // Cập nhật hiển thị số câu hỏi
        updateLevelText();

        tvScriptWithBlank.setText(currentExercise.getScriptWithBlank());
        etAnswer.setText("");
        etAnswer.clearFocus(); // Clear focus from EditText
        tvResult.setVisibility(View.GONE);
        btnSubmit.setEnabled(true);
        btnNext.setVisibility(View.GONE);

        // Disable và reset button trước khi prepare audio
        btnPlayAudio.setEnabled(false);
        btnPlayAudio.setText("Đang tải...");

        // Chuẩn bị audio
        prepareAudio(currentExercise.getAudioUrl());
    }

    /**
     * Chuẩn bị audio player với MediaPlayer
     */
    private void prepareAudio(String audioUrl) {
        Log.d(TAG, "prepareAudio: " + audioUrl);

        // Release MediaPlayer cũ nếu có
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }

        progressBar.setVisibility(View.VISIBLE);
        btnPlayAudio.setEnabled(false);
        btnPlayAudio.setText("Đang tải...");

        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(audioUrl);

            // Listener khi audio đã sẵn sàng
            mediaPlayer.setOnPreparedListener(mp -> {
                Log.d(TAG, "Audio ready");
                progressBar.setVisibility(View.GONE);
                btnPlayAudio.setEnabled(true);
                btnPlayAudio.setText("Phát");
            });

            // Listener khi audio phát xong
            mediaPlayer.setOnCompletionListener(mp -> {
                Log.d(TAG, "Audio completed");
                btnPlayAudio.setText("Phát lại");
            });

            // Listener khi có lỗi
            mediaPlayer.setOnErrorListener((mp, what, extra) -> {
                Log.e(TAG, "MediaPlayer error: what=" + what + ", extra=" + extra);
                progressBar.setVisibility(View.GONE);
                btnPlayAudio.setEnabled(true);
                btnPlayAudio.setText("Thử lại");
                Toast.makeText(ListeningExerciseActivity.this,
                    "Lỗi tải audio. Vui lòng thử lại.", Toast.LENGTH_LONG).show();
                return true;
            });

            // Chuẩn bị audio bất đồng bộ
            mediaPlayer.prepareAsync();

            Log.d(TAG, "MediaPlayer prepareAsync() called with URL: " + audioUrl);

        } catch (Exception e) {
            Log.e(TAG, "Error preparing audio", e);
            progressBar.setVisibility(View.GONE);
            btnPlayAudio.setEnabled(true);
            btnPlayAudio.setText("Thử lại");
            Toast.makeText(this, "Lỗi khi tải audio: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }



    /**
     * Phát audio
     */
    private void playAudio() {
        if (mediaPlayer == null) {
            Toast.makeText(this, "Audio chưa sẵn sàng", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                btnPlayAudio.setText("Phát");
            } else {
                mediaPlayer.start();
                btnPlayAudio.setText("Tạm dừng");
            }
        } catch (Exception e) {
            Log.e(TAG, "Error playing audio", e);
            Toast.makeText(this, "Lỗi phát audio", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Kiểm tra câu trả lời
     */
    private void checkAnswer() {
        String userAnswer = etAnswer.getText().toString().trim();

        if (userAnswer.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập câu trả lời", Toast.LENGTH_SHORT).show();
            return;
        }

        // Ẩn bàn phím sau khi submit
        hideKeyboard();

        if (currentExercise == null) {
            return;
        }

        String correctAnswer = currentExercise.getAnswer();

        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
            tvResult.setText("✓ Chính xác!");
            tvResult.setTextColor(getResources().getColor(android.R.color.holo_green_dark));

            // Tự động cập nhật tiến độ khi trả lời đúng
            ProgressTracker.updateProgress(this, ProgressTracker.ExerciseType.LISTENING,
                new ProgressTracker.ProgressUpdateCallback() {
                    @Override
                    public void onSuccess(Progress progress) {
                        Log.d(TAG, "Listening progress updated successfully");
                    }

                    @Override
                    public void onError(String message) {
                        Log.e(TAG, "Failed to update listening progress: " + message);
                    }
                });
        } else {
            tvResult.setText("✗ Sai rồi! Đáp án đúng là: " + correctAnswer);
            tvResult.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }

        tvResult.setVisibility(View.VISIBLE);
        btnSubmit.setEnabled(false);
        btnNext.setVisibility(View.VISIBLE);
    }

    /**
     * Load bài tập tiếp theo
     */
    private void loadNextExercise() {
        hideKeyboard(); // Hide keyboard before loading next exercise
        currentExerciseIndex++;
        loadCurrentExercise();
    }

    /**
     * Ẩn bàn phím
     */
    private void hideKeyboard() {
        try {
            android.view.View view = this.getCurrentFocus();
            if (view != null) {
                android.view.inputmethod.InputMethodManager imm =
                    (android.view.inputmethod.InputMethodManager) getSystemService(android.content.Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Error hiding keyboard", e);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Tạm dừng audio khi activity pause
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            btnPlayAudio.setText("Phát");
        }
        // Ẩn bàn phím khi activity pause để tránh lỗi IME
        hideKeyboard();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Release MediaPlayer
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
