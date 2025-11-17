package com.ptithcm.lexigo.api.services;

import com.ptithcm.lexigo.api.models.GrammarExercise;
import com.ptithcm.lexigo.api.models.GrammarLesson;
import com.ptithcm.lexigo.api.models.ListeningExercise;
import com.ptithcm.lexigo.api.models.Progress;
import com.ptithcm.lexigo.api.models.ProgressSummary;
import com.ptithcm.lexigo.api.models.ProgressUpdateRequest;
import com.ptithcm.lexigo.api.models.Script;
import com.ptithcm.lexigo.api.models.Statistics;
import com.ptithcm.lexigo.api.models.User;
import com.ptithcm.lexigo.api.models.UserLoginRequest;
import com.ptithcm.lexigo.api.models.UserRegisterRequest;
import com.ptithcm.lexigo.api.models.UserUpdateRequest;
import com.ptithcm.lexigo.api.models.VocabLesson;
import com.ptithcm.lexigo.api.models.VocabQuiz;
import com.ptithcm.lexigo.api.models.VocabTopic;
import com.ptithcm.lexigo.api.responses.ApiResponse;
import com.ptithcm.lexigo.api.responses.LoginResponse;
import com.ptithcm.lexigo.api.responses.RegisterResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

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
    
    
    // ============ Vocabulary Lessons Endpoints ============
    
    /**
     * Lấy danh sách chủ đề từ vựng
     * @param level (Optional) Beginner, Intermediate, hoặc Advanced
     * @return ApiResponse<List<VocabTopic>>
     */
    @GET("api/v1/lessons/vocab/topics")
    Call<ApiResponse<List<VocabTopic>>> getVocabTopics(@Query("level") String level);
    
    /**
     * Lấy danh sách từ vựng theo chủ đề
     * @param topicId ID của chủ đề
     * @param level (Optional) Beginner, Intermediate, hoặc Advanced
     * @return ApiResponse<List<VocabLesson>>
     */
    @GET("api/v1/lessons/vocab/lessons")
    Call<ApiResponse<List<VocabLesson>>> getVocabLessons(
            @Query("topic_id") String topicId,
            @Query("level") String level
    );
    
    /**
     * Lấy danh sách câu hỏi quiz từ vựng theo chủ đề
     * @param topicId ID của chủ đề
     * @param level (Optional) Beginner, Intermediate, hoặc Advanced
     * @return ApiResponse<List<VocabQuiz>>
     */
    @GET("api/v1/lessons/vocab/quizzes")
    Call<ApiResponse<List<VocabQuiz>>> getVocabQuizzes(
            @Query("topic_id") String topicId,
            @Query("level") String level
    );
    
    
    // ============ Grammar Lessons Endpoints ============
    
    /**
     * Lấy danh sách bài học ngữ pháp
     * @param level (Optional) Beginner, Intermediate, hoặc Advanced
     * @return ApiResponse<List<GrammarLesson>>
     */
    @GET("api/v1/lessons/grammar")
    Call<ApiResponse<List<GrammarLesson>>> getGrammarLessons(@Query("level") String level);
    
    /**
     * Lấy chi tiết bài học ngữ pháp
     * @param id ID của bài học
     * @return ApiResponse<GrammarLesson>
     */
    @GET("api/v1/lessons/grammar/{id}")
    Call<ApiResponse<GrammarLesson>> getGrammarLessonDetail(@Path("id") String id);
    
    /**
     * Lấy danh sách bài tập ngữ pháp cho một bài học
     * @param lessonId ID của bài học (có thể là lesson hoặc grammar_id)
     * @return ApiResponse<List<GrammarExercise>>
     */
    @GET("api/v1/lessons/grammar/exercises")
    Call<ApiResponse<List<GrammarExercise>>> getGrammarExercises(@Query("lesson") String lessonId);

    /**
     * Lấy danh sách bài tập ngữ pháp theo grammar_id
     * @param grammarId ID của điểm ngữ pháp
     * @return ApiResponse<List<GrammarExercise>>
     */
    @GET("api/v1/lessons/grammar/exercises")
    Call<ApiResponse<List<GrammarExercise>>> getGrammarExercisesByGrammarId(@Query("grammar_id") String grammarId);


    // ============ Listening Endpoints ============

    /**
     * Lấy danh sách script theo level
     * @param level Beginner, Intermediate, hoặc Advanced
     * @return ApiResponse<List<Script>>
     */
    @GET("api/v1/lessons/listening/scripts")
    Call<ApiResponse<List<Script>>> getScripts(@Query("level") String level);

    /**
     * Lấy bài tập listening theo script_id
     * @param scriptId ID của script
     * @return ApiResponse<ListeningExercise>
     */
    @GET("api/v1/lessons/listening/exercise")
    Call<ApiResponse<ListeningExercise>> getListeningExercise(@Query("script_id") String scriptId);
}

