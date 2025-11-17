package com.ptithcm.lexigo.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;
import com.ptithcm.lexigo.R;
import com.ptithcm.lexigo.api.TokenManager;
import com.ptithcm.lexigo.api.models.ProgressSummary;
import com.ptithcm.lexigo.api.models.Statistics;
import com.ptithcm.lexigo.api.repositories.LexiGoRepository;

/**
 * Activity hiển thị thống kê chi tiết của người dùng
 */
public class DetailedStatisticsActivity extends AppCompatActivity {

    private MaterialToolbar toolbar;

    // Statistics Views
    private TextView tvTotalCompleted;
    private TextView tvVocabCompleted;
    private TextView tvGrammarCompleted;
    private TextView tvListeningCompleted;
    private TextView tvReadingCompleted;
    private TextView tvLastUpdated;

    private ProgressBar progressTotal;
    private ProgressBar progressVocab;
    private ProgressBar progressGrammar;
    private ProgressBar progressListening;
    private ProgressBar progressReading;

    private ProgressBar loadingIndicator;
    private MaterialCardView cardStatistics;
    private MaterialCardView cardProgress;

    private TokenManager tokenManager;
    private LexiGoRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_statistics);

        // Khởi tạo managers & repositories
        tokenManager = TokenManager.getInstance(this);
        repository = LexiGoRepository.getInstance(this);

        // Khởi tạo views
        initViews();

        // Thiết lập toolbar
        setupToolbar();

        // Load dữ liệu
        loadStatistics();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh progress data khi quay lại activity
        loadStatistics();
        loadProgressSummary();
    }

    /**
     * Khởi tạo các view components
     */
    private void initViews() {
        toolbar = findViewById(R.id.toolbar);

        // Statistics
        tvTotalCompleted = findViewById(R.id.tvTotalCompleted);
        tvVocabCompleted = findViewById(R.id.tvVocabCompleted);
        tvGrammarCompleted = findViewById(R.id.tvGrammarCompleted);
        tvListeningCompleted = findViewById(R.id.tvListeningCompleted);
        tvReadingCompleted = findViewById(R.id.tvReadingCompleted);
        tvLastUpdated = findViewById(R.id.tvLastUpdated);


        // Progress bars
        progressTotal = findViewById(R.id.progressTotal);
        progressVocab = findViewById(R.id.progressVocab);
        progressGrammar = findViewById(R.id.progressGrammar);
        progressListening = findViewById(R.id.progressListening);
        progressReading = findViewById(R.id.progressReading);

        loadingIndicator = findViewById(R.id.loadingIndicator);
        cardStatistics = findViewById(R.id.cardStatistics);
    }

    /**
     * Thiết lập toolbar
     */
    private void setupToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Thống kê chi tiết");
        }
        toolbar.setNavigationOnClickListener(v -> finish());
    }

    /**
     * Load thống kê người dùng từ API
     */
    private void loadStatistics() {
        String userId = tokenManager.getUserId();
        if (userId == null) {
            Toast.makeText(this, "Không tìm thấy thông tin người dùng", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        showLoading(true);

        repository.getUserStatistics(userId, new LexiGoRepository.ApiCallback<Statistics>() {
            @Override
            public void onSuccess(Statistics statistics) {
                displayStatistics(statistics);
                showLoading(false);
                cardStatistics.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(String error) {
                showLoading(false);
                // Handle 404 gracefully - user doesn't have statistics yet
                if (error.contains("404")) {
                    // Create and display default empty statistics
                    Statistics defaultStats = new Statistics();
                    defaultStats.setTotalCompleted(0);
                    defaultStats.setVocabCompleted(0);
                    defaultStats.setGrammarCompleted(0);
                    defaultStats.setListeningCompleted(0);
                    defaultStats.setReadingCompleted(0);
                    displayStatistics(defaultStats);
                    cardStatistics.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(DetailedStatisticsActivity.this,
                            "Lỗi tải thống kê: " + error, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Load tóm tắt tiến độ từ API
     */
    private void loadProgressSummary() {
        String userId = tokenManager.getUserId();
        if (userId == null) return;

        repository.getProgressSummary(userId, new LexiGoRepository.ApiCallback<ProgressSummary>() {
            @Override
            public void onSuccess(ProgressSummary summary) {
                // Hiển thị cả statistics từ progress summary
                displayStatisticsFromProgress(summary);
                cardStatistics.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(String error) {
                // Handle 404 gracefully - user doesn't have progress data yet
                if (error.contains("404")) {
                    // Create and display default empty progress summary
                    ProgressSummary defaultSummary = new ProgressSummary();
                    displayStatisticsFromProgress(defaultSummary);
                    cardProgress.setVisibility(View.VISIBLE);
                    cardStatistics.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(DetailedStatisticsActivity.this,
                            "Lỗi tải tiến độ: " + error, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Hiển thị thống kê từ ProgressSummary
     */
    private void displayStatisticsFromProgress(ProgressSummary summary) {
        if (summary == null) return;

        int total = summary.getTotalCompleted();
        int vocab = summary.getTotalVocab();
        int grammar = summary.getTotalGrammar();
        int listening = summary.getTotalListening();
        int reading = summary.getTotalReading();

        tvTotalCompleted.setText(String.valueOf(total));
        tvVocabCompleted.setText(String.format("Từ vựng: %d bài", vocab));
        tvGrammarCompleted.setText(String.format("Ngữ pháp: %d bài", grammar));
        tvListeningCompleted.setText(String.format("Nghe: %d bài", listening));
        tvReadingCompleted.setText(String.format("Đọc: %d bài", reading));

        if (summary.getLastUpdated() != null) {
            tvLastUpdated.setText(String.format("Cập nhật: %s", summary.getLastUpdated()));
        } else {
            tvLastUpdated.setText("Cập nhật: Chưa có");
        }

        // Cập nhật progress bars
        int maxValue = Math.max(total, 100); // Giả sử tối đa 100 bài
        progressTotal.setMax(maxValue);
        progressTotal.setProgress(total);

        if (total > 0) {
            progressVocab.setMax(total);
            progressVocab.setProgress(vocab);

            progressGrammar.setMax(total);
            progressGrammar.setProgress(grammar);

            progressListening.setMax(total);
            progressListening.setProgress(listening);

            progressReading.setMax(total);
            progressReading.setProgress(reading);
        } else {
            // Reset về 0 nếu chưa có dữ liệu
            progressVocab.setMax(100);
            progressVocab.setProgress(0);

            progressGrammar.setMax(100);
            progressGrammar.setProgress(0);

            progressListening.setMax(100);
            progressListening.setProgress(0);

            progressReading.setMax(100);
            progressReading.setProgress(0);
        }
    }

    /**
     * Hiển thị thống kê (deprecated - use displayStatisticsFromProgress instead)
     */
    private void displayStatistics(Statistics statistics) {
        if (statistics == null) return;

        int total = statistics.getTotalCompleted();
        int vocab = statistics.getVocabCompleted();
        int grammar = statistics.getGrammarCompleted();
        int listening = statistics.getListeningCompleted();
        int reading = statistics.getReadingCompleted();

        tvTotalCompleted.setText(String.valueOf(total));
        tvVocabCompleted.setText(String.format("Từ vựng: %d bài", vocab));
        tvGrammarCompleted.setText(String.format("Ngữ pháp: %d bài", grammar));
        tvListeningCompleted.setText(String.format("Nghe: %d bài", listening));
        tvReadingCompleted.setText(String.format("Đọc: %d bài", reading));

        if (statistics.getLastUpdated() != null) {
            tvLastUpdated.setText(String.format("Cập nhật: %s", statistics.getLastUpdated()));
        }

        // Cập nhật progress bars
        int maxValue = Math.max(total, 100); // Giả sử tối đa 100 bài
        progressTotal.setMax(maxValue);
        progressTotal.setProgress(total);

        if (total > 0) {
            progressVocab.setMax(total);
            progressVocab.setProgress(vocab);

            progressGrammar.setMax(total);
            progressGrammar.setProgress(grammar);

            progressListening.setMax(total);
            progressListening.setProgress(listening);

            progressReading.setMax(total);
            progressReading.setProgress(reading);
        }
    }


    /**
     * Hiển thị/ẩn loading indicator
     */
    private void showLoading(boolean show) {
        if (loadingIndicator != null) {
            loadingIndicator.setVisibility(show ? View.VISIBLE : View.GONE);
        }
    }
}

