package com.ptithcm.lexigo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.ptithcm.lexigo.R;
import com.ptithcm.lexigo.api.TokenManager;
import com.ptithcm.lexigo.api.models.Statistics;
import com.ptithcm.lexigo.api.models.User;
import com.ptithcm.lexigo.api.repositories.LexiGoRepository;

/**
 * Màn hình thông tin tài khoản người dùng
 * Hiển thị thông tin cá nhân, thống kê và các chức năng quản lý
 */
public class ProfileActivity extends AppCompatActivity {

    // UI Components
    private ImageView imgAvatar;
    private TextView tvUserName;
    private TextView tvUserEmail;
    private Chip chipLevel;
    private TextView tvLessonsStatistics;
    private ProgressBar progressLessons;
    private TextView tvTotalLessons;
    private MaterialButton btnUpdateProfile;
    private MaterialButton btnSetGoal;
    private MaterialButton btnDetailedStats;
    private MaterialButton btnLogout;
    private ProgressBar loadingIndicator;

    // Managers & Repositories
    private TokenManager tokenManager;
    private LexiGoRepository repository;

    // Dữ liệu người dùng
    private User currentUser;
    private Statistics userStatistics;
    private int totalLessons = 100; // Tổng số bài học trong hệ thống

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Khởi tạo managers & repositories
        tokenManager = TokenManager.getInstance(this);
        repository = LexiGoRepository.getInstance(this);

        // Khởi tạo views
        initViews();

        // Thiết lập sự kiện click
        setupClickListeners();

        // Kiểm tra đăng nhập và load dữ liệu
        checkLoginAndLoadData();
    }

    /**
     * Kiểm tra trạng thái đăng nhập và load dữ liệu
     */
    private void checkLoginAndLoadData() {
        if (!tokenManager.isLoggedIn()) {
            // Chưa đăng nhập, chuyển về màn hình đăng nhập
            Toast.makeText(this, "Vui lòng đăng nhập", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ProfileActivity.this, AuthActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
            return;
        }

        // Đã đăng nhập, load dữ liệu
        loadUserProfile();
        loadUserStatistics();
    }

    /**
     * Khởi tạo các view components
     */
    private void initViews() {
        imgAvatar = findViewById(R.id.imgAvatar);
        tvUserName = findViewById(R.id.tvUserName);
        tvUserEmail = findViewById(R.id.tvUserEmail);
        chipLevel = findViewById(R.id.chipLevel);
        tvLessonsStatistics = findViewById(R.id.tvLessonsStatistics);
        progressLessons = findViewById(R.id.progressLessons);
        tvTotalLessons = findViewById(R.id.tvTotalLessons);
        btnUpdateProfile = findViewById(R.id.btnUpdateProfile);
        btnSetGoal = findViewById(R.id.btnSetGoal);
        btnDetailedStats = findViewById(R.id.btnDetailedStats);
        btnLogout = findViewById(R.id.btnLogout);
        loadingIndicator = findViewById(R.id.loadingIndicator);
    }

    /**
     * Load thông tin profile người dùng từ API
     */
    private void loadUserProfile() {
        showLoading(true);

        repository.getProfile(new LexiGoRepository.ApiCallback<User>() {
            @Override
            public void onSuccess(User user) {
                currentUser = user;
                displayUserProfile();
                showLoading(false);
            }

            @Override
            public void onError(String error) {
                showLoading(false);
                Toast.makeText(ProfileActivity.this,
                    "Lỗi tải thông tin: " + error, Toast.LENGTH_SHORT).show();

                // Hiển thị thông tin từ cache nếu có
                displayCachedUserInfo();
            }
        });
    }

    /**
     * Load thống kê người dùng từ API
     */
    private void loadUserStatistics() {
        String userId = tokenManager.getUserId();
        if (userId == null) return;

        repository.getUserStatistics(userId, new LexiGoRepository.ApiCallback<Statistics>() {
            @Override
            public void onSuccess(Statistics statistics) {
                userStatistics = statistics;
                displayUserStatistics();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(ProfileActivity.this,
                    "Lỗi tải thống kê: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Hiển thị thông tin profile người dùng
     */
    private void displayUserProfile() {
        if (currentUser == null) return;

        // Hiển thị tên và email
        tvUserName.setText(currentUser.getName() != null ? currentUser.getName() : "Người dùng");
        tvUserEmail.setText(currentUser.getEmail() != null ? currentUser.getEmail() : "");

        // Thiết lập cấp độ
        String level = currentUser.getLevel() != null ? currentUser.getLevel() : "Beginner";
        chipLevel.setText(level);
        setLevelColor(level);
    }

    /**
     * Hiển thị thống kê người dùng
     */
    private void displayUserStatistics() {
        if (userStatistics == null) return;

        int completedLessons = userStatistics.getTotalCompleted();

        // Hiển thị số bài đã hoàn thành
        tvLessonsStatistics.setText(getString(R.string.lessons_statistics, completedLessons));
        tvTotalLessons.setText(getString(R.string.total_lessons, totalLessons));

        // Cập nhật progress bar
        int progressPercentage = totalLessons > 0 ? (completedLessons * 100) / totalLessons : 0;
        progressLessons.setProgress(progressPercentage);
    }

    /**
     * Hiển thị thông tin từ cache (SharedPreferences)
     */
    private void displayCachedUserInfo() {
        String cachedName = tokenManager.getUserName();
        String cachedEmail = tokenManager.getUserEmail();

        if (cachedName != null) {
            tvUserName.setText(cachedName);
        }
        if (cachedEmail != null) {
            tvUserEmail.setText(cachedEmail);
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

    /**
     * Thiết lập màu cho chip cấp độ
     */
    private void setLevelColor(String level) {
        int colorResId;
        switch (level) {
            case "Beginner":
                colorResId = R.color.beginner_color;
                break;
            case "Advanced":
                colorResId = R.color.advanced_color;
                break;
            case "Intermediate":
            default:
                colorResId = R.color.intermediate_color;
                break;
        }
        chipLevel.setChipBackgroundColorResource(colorResId);
    }

    /**
     * Thiết lập các sự kiện click
     */
    private void setupClickListeners() {
        // Nút Cập nhật thông tin
        btnUpdateProfile.setOnClickListener(v -> {
            Toast.makeText(this, "Mở màn hình cập nhật thông tin", Toast.LENGTH_SHORT).show();
            // TODO: Implement update profile screen
        });

        // Nút Đặt mục tiêu học tập
        btnSetGoal.setOnClickListener(v -> {
            Toast.makeText(this, "Mở màn hình đặt mục tiêu", Toast.LENGTH_SHORT).show();
            // TODO: Implement goal setting dialog/screen
        });

        // Nút Thống kê chi tiết
        btnDetailedStats.setOnClickListener(v -> {
            Toast.makeText(this, "Mở màn hình thống kê chi tiết", Toast.LENGTH_SHORT).show();
            // TODO: Implement detailed statistics screen
        });

        // Nút Đăng xuất
        btnLogout.setOnClickListener(v -> handleLogout());
    }

    /**
     * Xử lý đăng xuất
     */
    private void handleLogout() {
        // Xóa token và thông tin user
        tokenManager.clearToken();

        Toast.makeText(this, "Đã đăng xuất", Toast.LENGTH_SHORT).show();

        // Chuyển về màn hình đăng nhập
        Intent intent = new Intent(ProfileActivity.this, AuthActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        // Trở về HomeActivity thay vì thoát ứng dụng
        super.onBackPressed();
        finish();
    }
}

