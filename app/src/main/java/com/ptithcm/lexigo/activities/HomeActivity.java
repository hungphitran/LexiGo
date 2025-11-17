package com.ptithcm.lexigo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ptithcm.lexigo.R;
import com.ptithcm.lexigo.adapters.LearningCategoryAdapter;
import com.ptithcm.lexigo.api.TokenManager;
import com.ptithcm.lexigo.api.models.ProgressSummary;
import com.ptithcm.lexigo.api.models.User;
import com.ptithcm.lexigo.api.repositories.LexiGoRepository;
import com.ptithcm.lexigo.models.LearningCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Màn hình trang chủ của ứng dụng
 * Hiển thị các mục học tập và tiến độ người dùng
 */
public class HomeActivity extends AppCompatActivity {

    // UI Components
    private MaterialButton btnAccount;
    private TextView tvLessonsCompleted;
    private TextView tvDailyGoal;
    private ProgressBar progressDaily;
    private RecyclerView rvLearningCategories;
    private FloatingActionButton fabDictionary;

    // Adapter
    private LearningCategoryAdapter categoryAdapter;

    // Managers & Repositories
    private TokenManager tokenManager;
    private LexiGoRepository repository;

    private int dailyGoalTarget = 5; // Mặc định
    private int completedLessons = 0;
    private int dailyGoalCurrent = 0;

    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Khởi tạo managers & repositories
        tokenManager = TokenManager.getInstance(this);
        repository = LexiGoRepository.getInstance(this);

        initViews();

        // Load user profile để lấy goals
        loadUserProfile();

        // Thiết lập RecyclerView
        setupRecyclerView();

        // Thiết lập các sự kiện click
        setupClickListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh user profile và progress data khi quay lại activity
        loadUserProfile();
    }

    /**
     * Khởi tạo các view components
     */
    private void initViews() {
        btnAccount = findViewById(R.id.btnAccount);
        tvLessonsCompleted = findViewById(R.id.tvLessonsCompleted);
        tvDailyGoal = findViewById(R.id.tvDailyGoal);
        progressDaily = findViewById(R.id.progressDaily);
        rvLearningCategories = findViewById(R.id.rvLearningCategories);
        fabDictionary = findViewById(R.id.fabDictionary);
    }

    /**
     * Thiết lập dữ liệu tiến độ học tập
     */
    private void setupProgressData() {
        // Hiển thị số bài đã hoàn thành
        tvLessonsCompleted.setText(getString(R.string.lessons_completed, completedLessons));

        // Hiển thị mục tiêu hàng ngày
        tvDailyGoal.setText(getString(R.string.daily_goal, dailyGoalCurrent, dailyGoalTarget));

        // Cập nhật progress bar

        int progressPercentage = dailyGoalTarget > 0 ? (dailyGoalCurrent * 100) / dailyGoalTarget : 0;
        progressDaily.setProgress(progressPercentage);
    }

    /**
     * Load thông tin user để lấy goals
     */
    private void loadUserProfile() {
        if (!tokenManager.isLoggedIn()) {
            // Nếu chưa đăng nhập, hiển thị dữ liệu mặc định
            setupProgressData();
            return;
        }

        repository.getProfile(new LexiGoRepository.ApiCallback<>() {
            @Override
            public void onSuccess(User user) {
                currentUser = user;

                // Lấy goals từ user
                if (user.getGoals() != null) {
                    dailyGoalTarget = user.getGoals().getDailyLessons();
                }

                // Sau khi có goals, load progress data
                loadProgressData();
            }

            @Override
            public void onError(String error) {
                // Nếu lỗi, vẫn load progress với goal mặc định
                loadProgressData();
            }
        });
    }

    /**
     * Load dữ liệu tiến độ thực từ API
     */
    private void loadProgressData() {
        String userId = tokenManager.getUserId();
        if (userId == null) {
            // Nếu chưa đăng nhập, hiển thị dữ liệu mặc định
            setupProgressData();
            return;
        }

        repository.getProgressSummary(userId, new LexiGoRepository.ApiCallback<>() {
            @Override
            public void onSuccess(ProgressSummary progressSummary) {
                // Cập nhật tổng số bài đã hoàn thành
                completedLessons = progressSummary.getTotalCompleted();

                // Tính số bài đã học trong ngày dựa trên last_updated
                dailyGoalCurrent = calculateDailyProgress(progressSummary);

                setupProgressData();
            }

            @Override
            public void onError(String error) {
                // Nếu lỗi, hiển thị dữ liệu mặc định
                setupProgressData();
            }
        });
    }

    /**
     * Tính số bài đã học trong ngày
     * Lưu ý: Hiện tại API không có endpoint riêng cho daily progress
     * Workaround: Kiểm tra last_updated có phải hôm nay không
     */
    private int calculateDailyProgress(ProgressSummary summary) {
        if (summary == null || summary.getLastUpdated() == null) {
            return 0;
        }

        try {
            // Parse last_updated: "2025-11-12T09:09:51.022000"
            String lastUpdated = summary.getLastUpdated();
            String dateOnly = lastUpdated.substring(0, 10); // "2025-11-12"

            // Lấy ngày hôm nay
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.US);
            String today = sdf.format(new java.util.Date());

            // Nếu last_updated là hôm nay, giả định user đã học ít nhất 1 bài
            if (dateOnly.equals(today)) {
                // Tạm thời return total_completed % dailyGoalTarget để mô phỏng
                // Trong thực tế, cần API endpoint riêng cho daily progress
                int total = summary.getTotalCompleted();
                return Math.min(total, dailyGoalTarget);
            }

            return 0;
        } catch (Exception e) {
            Log.e("HomeActivity", "Error calculating daily progress", e);
            return 0;
        }
    }

    /**
     * Thiết lập RecyclerView với danh sách các mục học tập
     */
    private void setupRecyclerView() {
        // Tạo danh sách các mục học tập
        List<LearningCategory> categories = createLearningCategories();

        // Khởi tạo adapter
        categoryAdapter = new LearningCategoryAdapter(this, categories);

        // Thiết lập adapter và layout manager
        rvLearningCategories.setLayoutManager(new LinearLayoutManager(this));
        rvLearningCategories.setAdapter(categoryAdapter);

        // Xử lý sự kiện click item
        categoryAdapter.setOnItemClickListener(category -> {
            Intent intent = null;
            String title = category.getTitle();
            
            // Điều hướng đến các màn hình tương ứng
            if (title.equals("Học từ vựng")) {
                intent = new Intent(this, VocabTopicsActivity.class);
            } else if (title.equals("Ngữ pháp")) {
                intent = new Intent(this, GrammarLessonsActivity.class);
            } else if (title.equals("Luyện nghe")) {
                intent = new Intent(this, LevelSelectionActivity.class);
            } else if (title.equals("Luyện đọc")) {
                Toast.makeText(this, "Tính năng đang phát triển", Toast.LENGTH_SHORT).show();
            }
            
            if (intent != null) {
                startActivity(intent);
            }
        });
    }

    /**
     * Tạo danh sách các mục học tập
     */
    private List<LearningCategory> createLearningCategories() {
        List<LearningCategory> categories = new ArrayList<>();

        categories.add(new LearningCategory(
            "Học từ vựng",
            "100 từ mới",
            android.R.drawable.ic_menu_agenda
        ));

        categories.add(new LearningCategory(
            "Ngữ pháp",
            "50 bài học",
            android.R.drawable.ic_menu_info_details
        ));

        categories.add(new LearningCategory(
            "Luyện nghe",
            "30 bài nghe",
            android.R.drawable.ic_btn_speak_now
        ));

        categories.add(new LearningCategory(
            "Luyện đọc",
            "40 bài đọc",
            android.R.drawable.ic_menu_view
        ));

        return categories;
    }

    /**
     * Thiết lập các sự kiện click
     */
    private void setupClickListeners() {
        // Nút Tài khoản - mở ProfileActivity
        btnAccount.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        // Floating Action Button - mở Từ điển
        fabDictionary.setOnClickListener(v -> {
            Toast.makeText(this, "Mở từ điển", Toast.LENGTH_SHORT).show();
            // TODO: Implement dictionary feature
        });
    }
}

