package com.ptithcm.lexigo.api.services;

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

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LexiGoApiService {
    
    // ============ Authentication Endpoints ============
    
    /**
     * Đăng ký tài khoản mới
     * @param request UserRegisterRequest
     * @return ApiResponse<RegisterResponse>
     */
    @POST("auth/register")
    Call<ApiResponse<RegisterResponse>> register(@Body UserRegisterRequest request);
    
    /**
     * Đăng nhập
     * @param request UserLoginRequest
     * @return ApiResponse<LoginResponse>
     */
    @POST("auth/login")
    Call<ApiResponse<LoginResponse>> login(@Body UserLoginRequest request);
    
    /**
     * Lấy thông tin profile người dùng hiện tại (yêu cầu token)
     * @return ApiResponse<User>
     */
    @GET("auth/profile")
    Call<ApiResponse<User>> getProfile();
    
    
    // ============ User Management Endpoints ============
    
    /**
     * Cập nhật thông tin người dùng (yêu cầu token)
     * @param request UserUpdateRequest
     * @return ApiResponse<User>
     */
    @PUT("user/update")
    Call<ApiResponse<User>> updateUser(@Body UserUpdateRequest request);
    
    /**
     * Lấy thông tin người dùng theo ID
     * @param userId ID người dùng
     * @return ApiResponse<User>
     */
    @GET("user/info/{user_id}")
    Call<ApiResponse<User>> getUserInfo(@Path("user_id") String userId);
    
    /**
     * Lấy thống kê bài học của người dùng
     * @param userId ID người dùng
     * @return ApiResponse<Statistics>
     */
    @GET("user/statistics/{user_id}")
    Call<ApiResponse<Statistics>> getUserStatistics(@Path("user_id") String userId);
    
    
    // ============ Progress Tracking Endpoints ============
    
    /**
     * Cập nhật tiến độ học (yêu cầu token)
     * @param request ProgressUpdateRequest
     * @return ApiResponse<Progress>
     */
    @POST("progress/update")
    Call<ApiResponse<Progress>> updateProgress(@Body ProgressUpdateRequest request);
    
    /**
     * Lấy tiến độ học của người dùng
     * @param userId ID người dùng
     * @return ApiResponse<Progress>
     */
    @GET("progress/{user_id}")
    Call<ApiResponse<Progress>> getProgress(@Path("user_id") String userId);
    
    /**
     * Lấy tổng hợp tiến độ
     * @param userId ID người dùng
     * @return ApiResponse<ProgressSummary>
     */
    @GET("progress/summary/{user_id}")
    Call<ApiResponse<ProgressSummary>> getProgressSummary(@Path("user_id") String userId);
}

