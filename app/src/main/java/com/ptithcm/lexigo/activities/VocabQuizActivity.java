package com.ptithcm.lexigo.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.ptithcm.lexigo.R;
import com.ptithcm.lexigo.api.ApiClient;
import com.ptithcm.lexigo.api.models.Progress;
import com.ptithcm.lexigo.api.models.VocabQuiz;
import com.ptithcm.lexigo.api.responses.ApiResponse;
import com.ptithcm.lexigo.api.services.LexiGoApiService;
import com.ptithcm.lexigo.utils.ProgressTracker;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VocabQuizActivity extends AppCompatActivity {
    private static final String TAG = "VocabQuizActivity";
    
    private MaterialToolbar toolbar;
    private TextView tvQuestion, tvQuestionNumber, tvScore, tvExplanation;
    private RadioGroup radioGroup;
    private Button btnSubmit, btnNext;
    private ProgressBar progressBar;
    
    private LexiGoApiService apiService;
    private List<VocabQuiz> quizList;
    private int currentQuestionIndex = 0;
    private int score = 0;
    
    private String topicId;
    private String level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab_quiz);
        
        // Get topic ID from intent
        if (getIntent() != null) {
            topicId = getIntent().getStringExtra("topic_id");
            level = getIntent().getStringExtra("level");
            String topicName = getIntent().getStringExtra("topic_name");
            
            if (getSupportActionBar() != null && topicName != null) {
                getSupportActionBar().setTitle(topicName + " - Quiz");
            }
        }
        
        initViews();
        loadQuiz();
    }
    
    private void initViews() {
        // Setup toolbar
        toolbar = findViewById(R.id.toolbar);
        if (getIntent() != null) {
            String topicName = getIntent().getStringExtra("topic_name");
            if (topicName != null) {
                toolbar.setTitle(topicName + " - Quiz");
            } else {
                toolbar.setTitle("Từ vựng Quiz");
            }
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        tvQuestionNumber = findViewById(R.id.tv_question_number);
        tvQuestion = findViewById(R.id.tv_question);
        tvScore = findViewById(R.id.tv_score);
        tvExplanation = findViewById(R.id.tv_explanation);
        radioGroup = findViewById(R.id.radio_group);
        btnSubmit = findViewById(R.id.btn_submit);
        btnNext = findViewById(R.id.btn_next);
        progressBar = findViewById(R.id.progress_bar);
        
        apiService = ApiClient.getInstance(this).getApiService();
        
        btnSubmit.setOnClickListener(v -> checkAnswer());
        btnNext.setOnClickListener(v -> loadNextQuestion());
    }
    
    private void loadQuiz() {
        if (topicId == null) {
            showError("Topic ID is required");
            finish();
            return;
        }
        
        progressBar.setVisibility(View.VISIBLE);
        
        Call<ApiResponse<List<VocabQuiz>>> call = apiService.getVocabQuizzes(topicId, level);
        call.enqueue(new Callback<ApiResponse<List<VocabQuiz>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<VocabQuiz>>> call, 
                                 Response<ApiResponse<List<VocabQuiz>>> response) {
                progressBar.setVisibility(View.GONE);
                
                if (response.isSuccessful() && response.body() != null) {
                    ApiResponse<List<VocabQuiz>> apiResponse = response.body();
                    if (apiResponse.isSuccess() && apiResponse.getData() != null) {
                        quizList = apiResponse.getData();
                        if (!quizList.isEmpty()) {
                            displayQuestion();
                        } else {
                            showError("No quiz questions available");
                        }
                    } else {
                        showError("Failed to load quiz: " + apiResponse.getMessage());
                    }
                } else {
                    showError("Failed to load quiz");
                }
            }
            
            @Override
            public void onFailure(Call<ApiResponse<List<VocabQuiz>>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.e(TAG, "Error loading quiz", t);
                showError("Network error: " + t.getMessage());
            }
        });
    }
    
    private void displayQuestion() {
        if (quizList == null || currentQuestionIndex >= quizList.size()) {
            showQuizComplete();
            return;
        }
        
        VocabQuiz currentQuiz = quizList.get(currentQuestionIndex);
        
        tvQuestionNumber.setText("Question " + (currentQuestionIndex + 1) + " of " + quizList.size());
        tvQuestion.setText(currentQuiz.getQuestion());
        tvScore.setText("Score: " + score + "/" + quizList.size());
        tvExplanation.setVisibility(View.GONE);
        
        // Clear previous options
        radioGroup.removeAllViews();
        radioGroup.clearCheck();
        
        // Add new options
        if (currentQuiz.getOptions() != null) {
            for (String option : currentQuiz.getOptions()) {
                RadioButton radioButton = new RadioButton(this);
                radioButton.setText(option);
                radioButton.setTextSize(16);
                radioButton.setPadding(16, 16, 16, 16);
                radioGroup.addView(radioButton);
            }
        }
        
        btnSubmit.setEnabled(true);
        btnSubmit.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.GONE);
    }
    
    private void checkAnswer() {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
            return;
        }
        
        RadioButton selectedButton = findViewById(selectedId);
        String selectedAnswer = selectedButton.getText().toString();
        
        VocabQuiz currentQuiz = quizList.get(currentQuestionIndex);
        
        if (selectedAnswer.equals(currentQuiz.getCorrectAnswer())) {
            score++;
            tvScore.setText("Score: " + score + "/" + quizList.size());
            Toast.makeText(this, "Correct! ✓", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong! Correct answer: " + currentQuiz.getCorrectAnswer(), 
                         Toast.LENGTH_LONG).show();
        }
        
        // Show explanation if available
        if (currentQuiz.getExplanation() != null && !currentQuiz.getExplanation().isEmpty()) {
            tvExplanation.setText("Explanation: " + currentQuiz.getExplanation());
            tvExplanation.setVisibility(View.VISIBLE);
        }
        
        btnSubmit.setEnabled(false);
        btnNext.setVisibility(View.VISIBLE);
    }
    
    private void loadNextQuestion() {
        currentQuestionIndex++;
        displayQuestion();
    }
    
    private void showQuizComplete() {
        tvQuestion.setText("Quiz Complete!");
        tvQuestionNumber.setText("");
        radioGroup.setVisibility(View.GONE);
        btnSubmit.setVisibility(View.GONE);
        btnNext.setVisibility(View.GONE);
        
        double percentage = (double) score / quizList.size() * 100;
        tvExplanation.setText(String.format("Your final score: %d/%d (%.1f%%)", 
                                          score, quizList.size(), percentage));
        tvExplanation.setVisibility(View.VISIBLE);

        // Tự động cập nhật tiến độ học vocab
        ProgressTracker.updateProgress(this, ProgressTracker.ExerciseType.VOCAB,
            new ProgressTracker.ProgressUpdateCallback() {
                @Override
                public void onSuccess(Progress progress) {
                    Log.d(TAG, "Vocab progress updated successfully");
                }

                @Override
                public void onError(String message) {
                    Log.e(TAG, "Failed to update vocab progress: " + message);
                }
            });
    }
    
    private void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
