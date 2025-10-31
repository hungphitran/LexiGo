package com.ptithcm.lexigo.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.ptithcm.lexigo.R;
import com.ptithcm.lexigo.activities.AuthActivity;

/**
 * Fragment cho tab Đăng nhập
 */
public class LoginFragment extends Fragment {

    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private MaterialButton btnLogin;
    private TextView tvForgotPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        // Khởi tạo views
        initViews(view);

        // Thiết lập sự kiện click
        setupClickListeners();

        return view;
    }

    /**
     * Khởi tạo các view components
     */
    private void initViews(View view) {
        etEmail = view.findViewById(R.id.etLoginEmail);
        etPassword = view.findViewById(R.id.etLoginPassword);
        btnLogin = view.findViewById(R.id.btnLogin);
        tvForgotPassword = view.findViewById(R.id.tvForgotPassword);
    }

    /**
     * Thiết lập các sự kiện click
     */
    private void setupClickListeners() {
        // Xử lý sự kiện nút Đăng nhập
        btnLogin.setOnClickListener(v -> handleLogin());

        // Xử lý sự kiện Quên mật khẩu
        tvForgotPassword.setOnClickListener(v -> handleForgotPassword());
    }

    /**
     * Xử lý đăng nhập
     */
    private void handleLogin() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Validate input
        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Vui lòng nhập email");
            etEmail.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Email không hợp lệ");
            etEmail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Vui lòng nhập mật khẩu");
            etPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            etPassword.setError("Mật khẩu phải có ít nhất 6 ký tự");
            etPassword.requestFocus();
            return;
        }

        // TODO: Implement actual login logic with backend/Firebase
        // Giả lập đăng nhập thành công
        Toast.makeText(getContext(), "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();

        // Chuyển sang màn hình trang chủ
        if (getActivity() instanceof AuthActivity) {
            ((AuthActivity) getActivity()).navigateToHome();
        }
    }

    /**
     * Xử lý quên mật khẩu
     */
    private void handleForgotPassword() {
        Toast.makeText(getContext(), "Chức năng quên mật khẩu đang được phát triển", Toast.LENGTH_SHORT).show();
        // TODO: Implement forgot password functionality
    }
}

