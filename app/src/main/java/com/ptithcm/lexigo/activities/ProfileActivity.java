package com.ptithcm.lexigo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.ptithcm.lexigo.R;

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

    // Dữ liệu mẫu
    private String userName = "Nguyễn Văn A";
    private String userEmail = "nguyenvana@example.com";
    private String userLevel = "Intermediate"; // Beginner, Intermediate, Advanced
    private int completedLessons = 45;
    private int totalLessons = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Khởi tạo views
        initViews();

        // Hiển thị dữ liệu người dùng
        displayUserData();

        // Thiết lập sự kiện click
        setupClickListeners();
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
    }

    /**
     * Hiển thị dữ liệu người dùng
     */
    private void displayUserData() {
        // Hiển thị thông tin cá nhân
        tvUserName.setText(userName);
        tvUserEmail.setText(userEmail);

        // Thiết lập cấp độ và màu tương ứng
        chipLevel.setText(userLevel);
        setLevelColor(userLevel);

        // Hiển thị thống kê
        tvLessonsStatistics.setText(getString(R.string.lessons_statistics, completedLessons));
        tvTotalLessons.setText(getString(R.string.total_lessons, totalLessons));

        // Cập nhật progress bar
        int progressPercentage = (completedLessons * 100) / totalLessons;
        progressLessons.setProgress(progressPercentage);
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
        // TODO: Clear user session, preferences, etc.
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

