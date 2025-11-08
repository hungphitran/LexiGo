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

    // Progress Summary Views
    private TextView tvTotalLessons;
    private TextView tvCompletedLessons;
    private TextView tvInProgressLessons;
    private TextView tvTotalQuizzes;
    private TextView tvCompletedQuizzes;
    private TextView tvAverageScore;
    private TextView tvStreak;

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

        // Progress Summary
        tvTotalLessons = findViewById(R.id.tvTotalLessons);
        tvCompletedLessons = findViewById(R.id.tvCompletedLessons);
        tvInProgressLessons = findViewById(R.id.tvInProgressLessons);
        tvTotalQuizzes = findViewById(R.id.tvTotalQuizzes);
        tvCompletedQuizzes = findViewById(R.id.tvCompletedQuizzes);
        tvAverageScore = findViewById(R.id.tvAverageScore);
        tvStreak = findViewById(R.id.tvStreak);

        // Progress bars
        progressTotal = findViewById(R.id.progressTotal);
        progressVocab = findViewById(R.id.progressVocab);
        progressGrammar = findViewById(R.id.progressGrammar);
        progressListening = findViewById(R.id.progressListening);
        progressReading = findViewById(R.id.progressReading);

        loadingIndicator = findViewById(R.id.loadingIndicator);
        cardStatistics = findViewById(R.id.cardStatistics);
        cardProgress = findViewById(R.id.cardProgress);
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
                displayProgressSummary(summary);
                cardProgress.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(String error) {
                // Handle 404 gracefully - user doesn't have progress data yet
                if (error.contains("404")) {
                    // Create and display default empty progress summary
                    ProgressSummary defaultSummary = new ProgressSummary();
                    displayProgressSummary(defaultSummary);
                    cardProgress.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(DetailedStatisticsActivity.this,
                            "Lỗi tải tiến độ: " + error, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Hiển thị thống kê
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
     * Hiển thị tóm tắt tiến độ
     */
    private void displayProgressSummary(ProgressSummary summary) {
        if (summary == null) return;

        tvTotalLessons.setText(String.format("Tổng: %d", summary.getTotalLessons()));
        tvCompletedLessons.setText(String.format("Hoàn thành: %d", summary.getCompletedLessons()));
        tvInProgressLessons.setText(String.format("Đang học: %d", summary.getInProgressLessons()));

        tvTotalQuizzes.setText(String.format("Tổng quiz: %d", summary.getTotalQuizzes()));
        tvCompletedQuizzes.setText(String.format("Đã làm: %d", summary.getCompletedQuizzes()));

        tvAverageScore.setText(String.format("Điểm TB: %.1f%%", summary.getAverageScore()));
        tvStreak.setText(String.format("%d ngày", summary.getCurrentStreak()));
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

