package com.ptithcm.lexigo.api.repositories;

import android.content.Context;

import androidx.annotation.NonNull;

import com.ptithcm.lexigo.api.ApiClient;
import com.ptithcm.lexigo.api.models.Progress;
import com.ptithcm.lexigo.api.models.ProgressSummary;
import com.ptithcm.lexigo.api.models.ProgressUpdateRequest;
import com.ptithcm.lexigo.api.models.Statistics;
import com.ptithcm.lexigo.api.models.User;
import com.ptithcm.lexigo.api.models.UserLoginRequest;
import com.ptithcm.lexigo.api.models.UserRegisterRequest;
import com.ptithcm.lexigo.api.models.UserUpdateRequest;
import com.ptithcm.lexigo.api.responses.ApiResponse;
import com.ptithcm.lexigo.api.responses.LoginResponse;
import com.ptithcm.lexigo.api.responses.RegisterResponse;
import com.ptithcm.lexigo.api.services.LexiGoApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Repository để quản lý tất cả API calls
 */
public class LexiGoRepository {
    private LexiGoApiService apiService;
    private static LexiGoRepository instance;

    private LexiGoRepository(Context context) {
        apiService = ApiClient.getInstance(context).getApiService();
    }

    public static synchronized LexiGoRepository getInstance(Context context) {
        if (instance == null) {
            instance = new LexiGoRepository(context.getApplicationContext());
        }
        return instance;
    }

    // ============ Authentication Methods ============

    /**
     * Đăng ký tài khoản mới
     */
    public void register(UserRegisterRequest request, ApiCallback<RegisterResponse> callback) {
        apiService.register(request).enqueue(new Callback<ApiResponse<RegisterResponse>>() {
            @Override
            public void onResponse(@NonNull Call<ApiResponse<RegisterResponse>> call,
                                 @NonNull Response<ApiResponse<RegisterResponse>> response) {
                handleResponse(response, callback);
            }

            @Override
            public void onFailure(@NonNull Call<ApiResponse<RegisterResponse>> call,
                                @NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    /**
     * Đăng nhập
     */
    public void login(UserLoginRequest request, ApiCallback<LoginResponse> callback) {
        apiService.login(request).enqueue(new Callback<ApiResponse<LoginResponse>>() {
            @Override
            public void onResponse(@NonNull Call<ApiResponse<LoginResponse>> call,
                                 @NonNull Response<ApiResponse<LoginResponse>> response) {
                handleResponse(response, callback);
            }

            @Override
            public void onFailure(@NonNull Call<ApiResponse<LoginResponse>> call,
                                @NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    /**
     * Lấy profile người dùng hiện tại
     */
    public void getProfile(ApiCallback<User> callback) {
        apiService.getProfile().enqueue(new Callback<ApiResponse<User>>() {
            @Override
            public void onResponse(@NonNull Call<ApiResponse<User>> call,
                                 @NonNull Response<ApiResponse<User>> response) {
                handleResponse(response, callback);
            }

            @Override
            public void onFailure(@NonNull Call<ApiResponse<User>> call,
                                @NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    // ============ User Management Methods ============

    /**
     * Cập nhật thông tin người dùng
     */
    public void updateUser(UserUpdateRequest request, ApiCallback<User> callback) {
        apiService.updateUser(request).enqueue(new Callback<ApiResponse<User>>() {
            @Override
            public void onResponse(@NonNull Call<ApiResponse<User>> call,
                                 @NonNull Response<ApiResponse<User>> response) {
                handleResponse(response, callback);
            }

            @Override
            public void onFailure(@NonNull Call<ApiResponse<User>> call,
                                @NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    /**
     * Lấy thông tin người dùng theo ID
     */
    public void getUserInfo(String userId, ApiCallback<User> callback) {
        apiService.getUserInfo(userId).enqueue(new Callback<ApiResponse<User>>() {
            @Override
            public void onResponse(@NonNull Call<ApiResponse<User>> call,
                                 @NonNull Response<ApiResponse<User>> response) {
                handleResponse(response, callback);
            }

            @Override
            public void onFailure(@NonNull Call<ApiResponse<User>> call,
                                @NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    /**
     * Lấy thống kê bài học của người dùng
     */
    public void getUserStatistics(String userId, ApiCallback<Statistics> callback) {
        apiService.getUserStatistics(userId).enqueue(new Callback<ApiResponse<Statistics>>() {
            @Override
            public void onResponse(@NonNull Call<ApiResponse<Statistics>> call,
                                 @NonNull Response<ApiResponse<Statistics>> response) {
                handleResponse(response, callback);
            }

            @Override
            public void onFailure(@NonNull Call<ApiResponse<Statistics>> call,
                                @NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    // ============ Progress Tracking Methods ============

    /**
     * Cập nhật tiến độ học
     */
    public void updateProgress(ProgressUpdateRequest request, ApiCallback<Progress> callback) {
        apiService.updateProgress(request).enqueue(new Callback<ApiResponse<Progress>>() {
            @Override
            public void onResponse(@NonNull Call<ApiResponse<Progress>> call,
                                 @NonNull Response<ApiResponse<Progress>> response) {
                handleResponse(response, callback);
            }

            @Override
            public void onFailure(@NonNull Call<ApiResponse<Progress>> call,
                                @NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    /**
     * Lấy tiến độ học của người dùng
     */
    public void getProgress(String userId, ApiCallback<Progress> callback) {
        apiService.getProgress(userId).enqueue(new Callback<ApiResponse<Progress>>() {
            @Override
            public void onResponse(@NonNull Call<ApiResponse<Progress>> call,
                                 @NonNull Response<ApiResponse<Progress>> response) {
                handleResponse(response, callback);
            }

            @Override
            public void onFailure(@NonNull Call<ApiResponse<Progress>> call,
                                @NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    /**
     * Lấy tổng hợp tiến độ
     */
    public void getProgressSummary(String userId, ApiCallback<ProgressSummary> callback) {
        apiService.getProgressSummary(userId).enqueue(new Callback<ApiResponse<ProgressSummary>>() {
            @Override
            public void onResponse(@NonNull Call<ApiResponse<ProgressSummary>> call,
                                 @NonNull Response<ApiResponse<ProgressSummary>> response) {
                handleResponse(response, callback);
            }

            @Override
            public void onFailure(@NonNull Call<ApiResponse<ProgressSummary>> call,
                                @NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    // ============ Helper Methods ============

    /**
     * Xử lý response chung
     */
    private <T> void handleResponse(Response<ApiResponse<T>> response, ApiCallback<T> callback) {
        if (response.isSuccessful() && response.body() != null) {
            ApiResponse<T> apiResponse = response.body();
            if (apiResponse.isSuccess()) {
                callback.onSuccess(apiResponse.getData());
            } else {
                String errorMsg = apiResponse.getMessage();
                if (apiResponse.getDetail() != null) {
                    errorMsg += ": " + apiResponse.getDetail();
                }
                callback.onError(errorMsg);
            }
        } else {
            callback.onError("HTTP " + response.code() + ": " + response.message());
        }
    }

    /**
     * Interface callback cho API calls
     */
    public interface ApiCallback<T> {
        void onSuccess(T data);
        void onError(String error);
    }
}

