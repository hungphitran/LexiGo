# Tài liệu màn hình LexiGo

Tài liệu này mô tả các màn hình chính của ứng dụng theo dạng bảng với các cột:

- **Chức năng**: Mô tả ngắn gọn nghiệp vụ/màn hình
- **View file**: Tên layout XML (hoặc item layout) tương ứng
- **Fragment/Activity**: Class chính sử dụng view đó
- **API sử dụng**: Service hoặc endpoint chính được gọi (nếu có)
- **Model sử dụng**: Các model dữ liệu chính được màn hình sử dụng

---

## 1. Màn hình / Activity chính

| Chức năng                                                                 | View file                                   | Fragment/Activity                             | API sử dụng                                                                 | Model sử dụng                                                                                 |
|---------------------------------------------------------------------------|---------------------------------------------|-----------------------------------------------|-------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------|
| Màn hình xác thực (đăng nhập/đăng ký, màn hình khởi động app – launcher) | `activity_auth.xml`                         | `com.ptithcm.lexigo.activities.AuthActivity`  | `LexiGoApiService` (`login`, `register`) qua `LexiGoRepository`              | `UserLoginRequest`, `UserRegisterRequest`, `LoginResponse`, `RegisterResponse`, `User`, `TokenManager` |
| Màn hình Home sau khi đăng nhập (tổng quan học tập, điều hướng các module) | `activity_home.xml`                        | `com.ptithcm.lexigo.activities.HomeActivity`  | `LexiGoApiService` (lấy tổng quan tiến độ, mục tiêu, thống kê nhanh)         | `ProgressSummary`, `Goals`, `Statistics`, `User`, `DailyProgressTracker`, `ProgressTracker`   |
| Màn hình hồ sơ người dùng (xem thông tin cá nhân, thống kê cơ bản)       | `activity_profile.xml`                      | `com.ptithcm.lexigo.activities.ProfileActivity` | `LexiGoApiService` (lấy thông tin user, thống kê tóm tắt)                    | `User`, `Statistics`, `ProgressSummary`, `Goals`                                              |
| Màn hình cập nhật thông tin cá nhân (sửa tên, email, mục tiêu, ...)      | `activity_update_profile.xml`               | `com.ptithcm.lexigo.activities.UpdateProfileActivity` | `LexiGoApiService.updateUser`, `LexiGoApiService.updateGoals` (qua repository) | `UserUpdateRequest`, `Goals`, `User`, `ApiResponse`                                          |
| Màn hình thống kê chi tiết (thời gian học, số bài, tiến độ từng kỹ năng) | `activity_detailed_statistics.xml`          | `com.ptithcm.lexigo.activities.DetailedStatisticsActivity` | `LexiGoApiService.getStatistics`                                             | `Statistics`, `Progress`, `ProgressSummary`, `Goals`                                          |
| Màn hình chọn chủ đề từ vựng                                             | `activity_vocab_topics.xml`                 | `com.ptithcm.lexigo.activities.VocabTopicsActivity` | `LexiGoApiService.getVocabTopics`                                             | `VocabTopic`, `LearningCategory`                                                              |
| Màn hình danh sách bài học từ vựng trong một chủ đề                      | `activity_vocab_lessons.xml`                | `com.ptithcm.lexigo.activities.VocabLessonsActivity` | `LexiGoApiService.getVocabLessonsByTopic`                                    | `VocabLesson`, `VocabTopic`                                                                   |
| Màn hình quiz/bài kiểm tra từ vựng                                      | `activity_vocab_quiz.xml`                   | `com.ptithcm.lexigo.activities.VocabQuizActivity` | `LexiGoApiService.getVocabQuiz`, cập nhật tiến độ quiz                       | `VocabQuiz`, `ProgressUpdateRequest`, `Progress`, `Statistics`                                |
| Màn hình danh sách bài học ngữ pháp                                      | `activity_grammar_lessons.xml`              | `com.ptithcm.lexigo.activities.GrammarLessonsActivity` | `LexiGoApiService.getGrammarLessons`                                          | `GrammarLesson`, `LearningCategory`                                                           |
| Màn hình chi tiết một bài ngữ pháp (nội dung, ví dụ, bài tập liên quan)  | `activity_grammar_lesson_detail.xml`        | `com.ptithcm.lexigo.activities.GrammarLessonDetailActivity` | `LexiGoApiService.getGrammarLessonDetail`, `LexiGoApiService.getGrammarExercises` | `GrammarLesson`, `GrammarExercise`, `Script`                                                  |
| Màn hình quiz chung (có thể dùng cho từ vựng & ngữ pháp – unified quiz)  | `activity_quiz.xml`                         | `com.ptithcm.lexigo.activities.QuizActivity`  | `LexiGoApiService` (lấy câu hỏi quiz theo kiểu/bài), cập nhật tiến độ       | `VocabQuiz`, `GrammarExercise`, `ProgressUpdateRequest`, `Progress`, `Statistics`             |
| Màn hình chọn cấp độ cho bài luyện nghe                                  | `activity_level_selection.xml`              | `com.ptithcm.lexigo.activities.LevelSelectionActivity` | `LexiGoApiService.getListeningLevels`                                         | `ListeningExercise` (metadata theo cấp độ), `LearningCategory`                               |
| Màn hình bài luyện nghe (phát audio, câu hỏi nghe hiểu)                  | `activity_listening_exercise.xml`           | `com.ptithcm.lexigo.activities.ListeningExerciseActivity` | `LexiGoApiService.getListeningExercises`, cập nhật tiến độ                  | `ListeningExercise`, `Script`, `ProgressUpdateRequest`, `Progress`, `Statistics`              |
| Màn hình chính gốc (cũ, có thể dùng làm shell hoặc test)                 | `activity_main.xml`                         | `com.ptithcm.lexigo.MainActivity`             | Không/ít gọi API trực tiếp (dùng cho test/legacy)                            | Không dùng model đặc thù (hoặc dùng chung `User`, `ProgressSummary` nếu có)                   |

---

## 2. Fragment (bên trong `AuthActivity`)

| Chức năng                         | View file               | Fragment/Activity                                   | API sử dụng                                              | Model sử dụng                                                                 |
|-----------------------------------|-------------------------|-----------------------------------------------------|----------------------------------------------------------|-------------------------------------------------------------------------------|
| Màn hình đăng ký tài khoản        | `fragment_register.xml` | `com.ptithcm.lexigo.fragments.RegisterFragment`    | `LexiGoApiService.register` qua `LexiGoRepository`       | `UserRegisterRequest`, `RegisterResponse`, `User`, `ApiResponse`             |
| Màn hình đăng nhập                | `fragment_login.xml`    | `com.ptithcm.lexigo.fragments.LoginFragment`       | `LexiGoApiService.login` qua `LexiGoRepository`          | `UserLoginRequest`, `LoginResponse`, `User`, `TokenManager`, `ApiResponse`   |

---

## 3. Dialog / Component đặc biệt

| Chức năng                                              | View file              | Fragment/Activity / Dialog                         | API sử dụng                                        | Model sử dụng                         |
|--------------------------------------------------------|------------------------|----------------------------------------------------|----------------------------------------------------|---------------------------------------|
| Dialog đặt mục tiêu học tập (số từ/ngày, thời lượng…) | `dialog_set_goals.xml` | `com.ptithcm.lexigo.dialogs.SetGoalsDialog`       | Có thể gọi `LexiGoApiService.updateGoals` (qua Activity/Repository) | `Goals`, `User`, `ApiResponse`       |
| Header dùng chung (tiêu đề, nút back, biểu tượng, ...) | `include_header.xml`   | Được include trong nhiều Activity/Layout khác      | Không gọi API trực tiếp                             | Không dùng model đặc thù              |

---

## 4. Item view trong RecyclerView / List

| Chức năng (item hiển thị)                                        | View file                   | Fragment/Activity / Adapter sử dụng                     | API sử dụng                                      | Model sử dụng                         |
|------------------------------------------------------------------|-----------------------------|---------------------------------------------------------|--------------------------------------------------|---------------------------------------|
| Item chủ đề từ vựng trong danh sách chủ đề                      | `item_vocab_topic.xml`      | `VocabTopicAdapter` (dùng trong `VocabTopicsActivity`)  | Dữ liệu từ `LexiGoApiService.getVocabTopics`    | `VocabTopic`                          |
| Item bài học từ vựng trong danh sách bài học                    | `item_vocab_lesson.xml`     | `VocabLessonAdapter` (dùng trong `VocabLessonsActivity`)| Dữ liệu từ `LexiGoApiService.getVocabLessonsByTopic` | `VocabLesson`, `VocabTopic`          |
| Item danh mục học (LearningCategory: từ vựng, ngữ pháp, nghe…) | `item_learning_category.xml`| `LearningCategoryAdapter` (thường hiển thị ở Home)     | Dữ liệu có thể được build từ cấu hình/app hoặc API tổng hợp | `LearningCategory`, `ProgressSummary` |
| Item bài học ngữ pháp trong danh sách bài học ngữ pháp         | `item_grammar_lesson.xml`   | `GrammarLessonAdapter` (dùng trong `GrammarLessonsActivity`) | Dữ liệu từ `LexiGoApiService.getGrammarLessons` | `GrammarLesson`                       |
| Item bài tập ngữ pháp trong danh sách bài tập                  | `item_grammar_exercise.xml` | `GrammarExerciseAdapter` (dùng trong phần bài tập ngữ pháp) | Dữ liệu từ `LexiGoApiService.getGrammarExercises` | `GrammarExercise`                     |

---

## 5. Tổng hợp nhanh theo Activity/Fragment

| Fragment/Activity                                  | View file                            | Nhóm chức năng chính                          | API sử dụng                                                             | Model sử dụng                                                                 |
|----------------------------------------------------|--------------------------------------|-----------------------------------------------|-------------------------------------------------------------------------|-------------------------------------------------------------------------------|
| `com.ptithcm.lexigo.activities.AuthActivity`       | `activity_auth.xml`                  | Auth, host Login/Register Fragment            | `LexiGoApiService.login`, `LexiGoApiService.register`                  | `UserLoginRequest`, `UserRegisterRequest`, `LoginResponse`, `RegisterResponse`, `User` |
| `com.ptithcm.lexigo.fragments.RegisterFragment`    | `fragment_register.xml`              | Đăng ký                                      | `LexiGoApiService.register`                                            | `UserRegisterRequest`, `RegisterResponse`, `User`                           |
| `com.ptithcm.lexigo.fragments.LoginFragment`       | `fragment_login.xml`                 | Đăng nhập                                    | `LexiGoApiService.login`                                               | `UserLoginRequest`, `LoginResponse`, `User`, `TokenManager`                 |
| `com.ptithcm.lexigo.activities.HomeActivity`       | `activity_home.xml`                  | Trang chủ, tóm tắt học tập, điều hướng       | API tổng quan tiến độ, goal, thống kê (qua `LexiGoRepository`)        | `ProgressSummary`, `Goals`, `Statistics`, `User`                            |
| `com.ptithcm.lexigo.activities.ProfileActivity`    | `activity_profile.xml`               | Hồ sơ người dùng                              | API lấy thông tin user, thống kê tóm tắt                               | `User`, `Statistics`, `ProgressSummary`                                     |
| `com.ptithcm.lexigo.activities.UpdateProfileActivity` | `activity_update_profile.xml`      | Cập nhật thông tin cá nhân                    | `LexiGoApiService.updateUser`, `LexiGoApiService.updateGoals`          | `UserUpdateRequest`, `Goals`, `User`, `ApiResponse`                         |
| `com.ptithcm.lexigo.activities.DetailedStatisticsActivity` | `activity_detailed_statistics.xml` | Thống kê chi tiết                             | `LexiGoApiService.getStatistics`                                       | `Statistics`, `Progress`, `ProgressSummary`, `Goals`                        |
| `com.ptithcm.lexigo.activities.VocabTopicsActivity`| `activity_vocab_topics.xml`          | Danh sách chủ đề từ vựng                      | `LexiGoApiService.getVocabTopics`                                      | `VocabTopic`                                                                |
| `com.ptithcm.lexigo.activities.VocabLessonsActivity` | `activity_vocab_lessons.xml`        | Danh sách bài học từ vựng                     | `LexiGoApiService.getVocabLessonsByTopic`                              | `VocabLesson`, `VocabTopic`                                                |
| `com.ptithcm.lexigo.activities.VocabQuizActivity`  | `activity_vocab_quiz.xml`            | Quiz từ vựng                                   | `LexiGoApiService.getVocabQuiz`, cập nhật tiến độ                      | `VocabQuiz`, `ProgressUpdateRequest`, `Progress`, `Statistics`             |
| `com.ptithcm.lexigo.activities.GrammarLessonsActivity` | `activity_grammar_lessons.xml`     | Danh sách bài học ngữ pháp                    | `LexiGoApiService.getGrammarLessons`                                   | `GrammarLesson`                                                             |
| `com.ptithcm.lexigo.activities.GrammarLessonDetailActivity` | `activity_grammar_lesson_detail.xml` | Chi tiết bài học ngữ pháp                 | `LexiGoApiService.getGrammarLessonDetail`, `LexiGoApiService.getGrammarExercises` | `GrammarLesson`, `GrammarExercise`, `Script`                      |
| `com.ptithcm.lexigo.activities.QuizActivity`       | `activity_quiz.xml`                  | Quiz chung (vocab/grammar)                    | Các API lấy quiz tương ứng + cập nhật tiến độ                          | `VocabQuiz`, `GrammarExercise`, `ProgressUpdateRequest`, `Progress`        |
| `com.ptithcm.lexigo.activities.LevelSelectionActivity` | `activity_level_selection.xml`     | Chọn cấp độ nghe                               | `LexiGoApiService.getListeningLevels`                                  | `ListeningExercise` (thông tin cấp độ)                                     |
| `com.ptithcm.lexigo.activities.ListeningExerciseActivity` | `activity_listening_exercise.xml` | Làm bài luyện nghe                            | `LexiGoApiService.getListeningExercises`, cập nhật tiến độ             | `ListeningExercise`, `Script`, `ProgressUpdateRequest`, `Progress`         |
| `com.ptithcm.lexigo.MainActivity`                  | `activity_main.xml`                  | Activity gốc (test/legacy shell)              | Không/ít dùng API                                                      | Không dùng model đặc thù                                                   |

---

*Ghi chú:* Một số tên method API là ước lượng dựa trên convention (`getX`, `updateY`, `...Detail`). Khi triển khai thực tế có thể khác tên chính xác nhưng vẫn dùng các model đã liệt kê.
