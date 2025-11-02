package com.ptithcm.lexigo.api;

import android.content.Context;
import android.widget.Toast;

import com.ptithcm.lexigo.api.models.Goals;
import com.ptithcm.lexigo.api.models.Progress;
import com.ptithcm.lexigo.api.models.ProgressSummary;
import com.ptithcm.lexigo.api.models.ProgressUpdateRequest;
import com.ptithcm.lexigo.api.models.Statistics;
import com.ptithcm.lexigo.api.models.User;
import com.ptithcm.lexigo.api.models.UserLoginRequest;
import com.ptithcm.lexigo.api.models.UserRegisterRequest;
import com.ptithcm.lexigo.api.models.UserUpdateRequest;
import com.ptithcm.lexigo.api.repositories.LexiGoRepository;
import com.ptithcm.lexigo.api.responses.LoginResponse;
import com.ptithcm.lexigo.api.responses.RegisterResponse;

/**
 * Class chứa các ví dụ về cách sử dụng API
 * Sử dụng các method này trong Activity/Fragment của bạn
 */
public class ApiUsageExamples {

    /**
     * Ví dụ 1: Đăng ký tài khoản mới
     */
    public static void registerExample(Context context, String name, String email, String password) {
        // Tạo request với thông tin cơ bản
        UserRegisterRequest request = new UserRegisterRequest(name, email, password);

        // Hoặc tạo request với đầy đủ thông tin
        Goals goals = new Goals(20, 2);
        UserRegisterRequest fullRequest = new UserRegisterRequest(name, email, password, "Intermediate", goals);

        // Gọi API
        LexiGoRepository repository = LexiGoRepository.getInstance(context);
        repository.register(request, new LexiGoRepository.ApiCallback<RegisterResponse>() {
            @Override
            public void onSuccess(RegisterResponse data) {
                String userId = data.getUserId();
                Toast.makeText(context, "Đăng ký thành công! ID: " + userId, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(context, "Lỗi: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Ví dụ 2: Đăng nhập
     */
    public static void loginExample(Context context, String email, String password) {
        UserLoginRequest request = new UserLoginRequest(email, password);

        LexiGoRepository repository = LexiGoRepository.getInstance(context);
        repository.login(request, new LexiGoRepository.ApiCallback<LoginResponse>() {
            @Override
            public void onSuccess(LoginResponse data) {
                // Lưu token
                TokenManager tokenManager = TokenManager.getInstance(context);
                tokenManager.saveToken(data.getAccessToken());

                // Lưu thông tin user
                User user = data.getUser();
                tokenManager.saveUserInfo(user.getId(), user.getName(), user.getEmail());

                Toast.makeText(context, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(context, "Đăng nhập thất bại: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Ví dụ 3: Lấy profile người dùng hiện tại
     */
    public static void getProfileExample(Context context) {
        LexiGoRepository repository = LexiGoRepository.getInstance(context);
        repository.getProfile(new LexiGoRepository.ApiCallback<User>() {
            @Override
            public void onSuccess(User user) {
                String info = String.format("Name: %s\nEmail: %s\nLevel: %s",
                    user.getName(), user.getEmail(), user.getLevel());
                Toast.makeText(context, info, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(context, "Lỗi: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Ví dụ 4: Cập nhật thông tin người dùng
     */
    public static void updateUserExample(Context context) {
        UserUpdateRequest request = new UserUpdateRequest();
        request.setName("Nguyễn Văn B");
        request.setLevel("Advanced");
        request.setGoals(new Goals(30, 3));

        LexiGoRepository repository = LexiGoRepository.getInstance(context);
        repository.updateUser(request, new LexiGoRepository.ApiCallback<User>() {
            @Override
            public void onSuccess(User user) {
                Toast.makeText(context, "Cập nhật thành công!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(context, "Lỗi: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Ví dụ 5: Lấy thông tin người dùng theo ID
     */
    public static void getUserInfoExample(Context context, String userId) {
        LexiGoRepository repository = LexiGoRepository.getInstance(context);
        repository.getUserInfo(userId, new LexiGoRepository.ApiCallback<User>() {
            @Override
            public void onSuccess(User user) {
                Toast.makeText(context, "User: " + user.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(context, "Lỗi: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Ví dụ 6: Lấy thống kê bài học
     */
    public static void getUserStatisticsExample(Context context, String userId) {
        LexiGoRepository repository = LexiGoRepository.getInstance(context);
        repository.getUserStatistics(userId, new LexiGoRepository.ApiCallback<Statistics>() {
            @Override
            public void onSuccess(Statistics stats) {
                String info = String.format(
                    "Total: %d\nVocab: %d\nGrammar: %d\nListening: %d\nReading: %d",
                    stats.getTotalCompleted(),
                    stats.getVocabCompleted(),
                    stats.getGrammarCompleted(),
                    stats.getListeningCompleted(),
                    stats.getReadingCompleted()
                );
                Toast.makeText(context, info, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(context, "Lỗi: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Ví dụ 7: Cập nhật tiến độ học
     */
    public static void updateProgressExample(Context context) {
        ProgressUpdateRequest request = new ProgressUpdateRequest();
        request.setVocabCompleted(5);
        request.setGrammarCompleted(2);
        request.setListeningCompleted(3);
        request.setReadingCompleted(1);

        LexiGoRepository repository = LexiGoRepository.getInstance(context);
        repository.updateProgress(request, new LexiGoRepository.ApiCallback<Progress>() {
            @Override
            public void onSuccess(Progress progress) {
                Toast.makeText(context, "Cập nhật tiến độ thành công!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(context, "Lỗi: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Ví dụ 8: Lấy tiến độ học
     */
    public static void getProgressExample(Context context, String userId) {
        LexiGoRepository repository = LexiGoRepository.getInstance(context);
        repository.getProgress(userId, new LexiGoRepository.ApiCallback<Progress>() {
            @Override
            public void onSuccess(Progress progress) {
                String info = String.format(
                    "Vocab: %d\nGrammar: %d\nListening: %d\nReading: %d",
                    progress.getVocabCompleted(),
                    progress.getGrammarCompleted(),
                    progress.getListeningCompleted(),
                    progress.getReadingCompleted()
                );
                Toast.makeText(context, info, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(context, "Lỗi: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Ví dụ 9: Lấy tổng hợp tiến độ
     */
    public static void getProgressSummaryExample(Context context, String userId) {
        LexiGoRepository repository = LexiGoRepository.getInstance(context);
        repository.getProgressSummary(userId, new LexiGoRepository.ApiCallback<ProgressSummary>() {
            @Override
            public void onSuccess(ProgressSummary summary) {
                String info = String.format(
                    "Total Completed: %d\nVocab: %d\nGrammar: %d\nListening: %d\nReading: %d",
                    summary.getTotalCompleted(),
                    summary.getTotalVocab(),
                    summary.getTotalGrammar(),
                    summary.getTotalListening(),
                    summary.getTotalReading()
                );
                Toast.makeText(context, info, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(context, "Lỗi: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Ví dụ 10: Kiểm tra trạng thái đăng nhập
     */
    public static boolean isUserLoggedIn(Context context) {
        TokenManager tokenManager = TokenManager.getInstance(context);
        return tokenManager.isLoggedIn();
    }

    /**
     * Ví dụ 11: Đăng xuất
     */
    public static void logoutExample(Context context) {
        TokenManager tokenManager = TokenManager.getInstance(context);
        tokenManager.clearToken();
        Toast.makeText(context, "Đã đăng xuất!", Toast.LENGTH_SHORT).show();
    }

    /**
     * Ví dụ 12: Lấy thông tin user từ TokenManager
     */
    public static void getUserInfoFromToken(Context context) {
        TokenManager tokenManager = TokenManager.getInstance(context);
        String userId = tokenManager.getUserId();
        String userName = tokenManager.getUserName();
        String userEmail = tokenManager.getUserEmail();

        String info = String.format("ID: %s\nName: %s\nEmail: %s", userId, userName, userEmail);
        Toast.makeText(context, info, Toast.LENGTH_LONG).show();
    }
}

