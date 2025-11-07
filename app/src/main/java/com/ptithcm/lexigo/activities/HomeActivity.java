package com.ptithcm.lexigo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

    // Dữ liệu mẫu
    private int completedLessons = 15;
    private int dailyGoalTarget = 5;
    private int dailyGoalCurrent = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Khởi tạo views
        initViews();

        // Thiết lập dữ liệu
        setupProgressData();

        // Thiết lập RecyclerView
        setupRecyclerView();

        // Thiết lập các sự kiện click
        setupClickListeners();
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
        int progressPercentage = (dailyGoalCurrent * 100) / dailyGoalTarget;
        progressDaily.setProgress(progressPercentage);
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
                Toast.makeText(this, "Tính năng đang phát triển", Toast.LENGTH_SHORT).show();
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

