# Tài liệu Mô tả Cơ sở Dữ liệu (Database Schema Documentation)

Tài liệu này mô tả các bảng dữ liệu được sử dụng trong hệ thống LexiGo, dựa trên các mô hình dữ liệu (Data Models) trong mã nguồn ứng dụng Android.

## 1. Users (Người dùng)
Lưu trữ thông tin tài khoản người dùng.
- **id**: String (Primary Key) - Định danh duy nhất của người dùng.
- **name**: String - Tên hiển thị người dùng.
- **email**: String - Địa chỉ email.
- **level**: String - Trình độ hiện tại của người dùng (ví dụ: Beginner, Intermediate).
- **goals**: Object - Mục tiêu học tập cá nhân.
    - `daily_words`: int - Số từ mới mục tiêu mỗi ngày.
    - `daily_lessons`: int - Số bài học mục tiêu mỗi ngày.
- **created_at**: String - Thời gian tạo tài khoản.

## 2. DailyProgress (Tiến độ Hằng ngày)
Lưu trữ thông tin tiến độ học tập của người dùng theo ngày.
- **user_id**: String - ID người dùng (Foreign Key liên kết tới Users).
- **date**: String - Ngày ghi nhận tiến độ (Format: YYYY-MM-DD).
- **vocab**: Object - Tiến độ phần Từ vựng.
    - `total_lessons`: int - Số bài đã học.
    - `average_score`: double - Điểm trung bình.
    - `study_time_minutes`: int - Thời gian học (phút).
- **grammar**: Object - Tiến độ phần Ngữ pháp (cấu trúc tương tự `vocab`).
- **listening**: Object - Tiến độ phần Nghe (cấu trúc tương tự `vocab`).
- **reading**: Object - Tiến độ phần Đọc (cấu trúc tương tự `vocab`).
- **total_study_time_minutes**: int - Tổng thời gian học trong ngày.
- **created_at**: String - Thời gian tạo bản ghi.
- **updated_at**: String - Thời gian cập nhật lần cuối.

## 3. VocabTopics (Chủ đề Từ vựng)
Các chủ đề học từ vựng.
- **_id**: String (Primary Key) - Định danh chủ đề.
- **name**: String - Tên chủ đề.
- **level**: String - Trình độ phù hợp.
- **description**: String - Mô tả chủ đề.
- **image_url**: String - Đường dẫn ảnh đại diện chủ đề.
- **word_count**: int - Số lượng từ trong chủ đề.

## 4. VocabLessons (Bài học Từ vựng / Từ vựng chi tiết)
Chi tiết từng từ vựng trong bài học.
- **_id**: String (Primary Key) - Định danh từ vựng.
- **word**: String - Từ vựng tiếng Anh.
- **meaning**: String - Nghĩa của từ.
- **example**: String - Ví dụ minh họa.
- **pronunciation**: String - Phiên âm.
- **image_url**: String - Đường dẫn ảnh minh họa.
- **audio_url**: String - Đường dẫn phát âm.
- **level**: String - Trình độ.
- **topic_id**: String - ID chủ đề (Foreign Key liên kết tới VocabTopics).

## 5. VocabQuizzes (Câu hỏi trắc nghiệm Từ vựng)
Các câu hỏi kiểm tra từ vựng.
- **_id**: String (Primary Key) - Định danh câu hỏi.
- **question**: String - Nội dung câu hỏi.
- **question_type**: String - Loại câu hỏi (ví dụ: multiple_choice, fill_in_blank).
- **options**: List<String> - Các đáp án lựa chọn.
- **correct_answer**: String - Đáp án đúng (dạng text).
- **correct_option_index**: Integer - Chỉ số của đáp án đúng trong danh sách `options`.
- **topic_id**: String - Liên kết tới chủ đề.
- **level**: String - Trình độ.
- **explanation**: String - Giải thích đáp án.

## 6. GrammarLessons (Bài học Ngữ pháp)
Các bài học về ngữ pháp.
- **_id**: String (Primary Key) - Định danh bài học.
- **title**: String - Tiêu đề bài học.
- **level**: String - Trình độ.
- **description**: String - Mô tả ngắn.
- **content**: String - Nội dung chi tiết bài học.
- **rules**: List<String> - Các quy tắc ngữ pháp.
- **examples**: List<String> - Các ví dụ.
- **explanation**: String - Giải thích chi tiết.
- **tips**: String - Mẹo ghi nhớ.
- **image_url**: String - Ảnh minh họa.

## 7. ReadingPassages (Bài đọc)
Các bài văn, đoạn văn luyện đọc.
- **_id**: String (Primary Key) - Định danh bài đọc.
- **title**: String - Tiêu đề bài đọc.
- **excerpt**: String - Đoạn trích dẫn ngắn.
- **content_blocks**: List<Object> - Nội dung chi tiết (chia thành các khối văn bản).
- **level**: String - Trình độ.
- **category**: String - Danh mục bài đọc (Ví dụ: Science, News).
- **tags**: List<String> - Các thẻ liên quan.
- **cover_image_url**: String - Ảnh bìa.
- **audio_url**: String - File nghe bài đọc (nếu có).
- **published_at**: String - Ngày xuất bản.

## 8. ReadingQuestions (Câu hỏi luyện đọc)
Câu hỏi trắc nghiệm liên quan đến bài đọc.
- **_id**: String (Primary Key) - Định danh câu hỏi.
- **question**: String - Nội dung câu hỏi.
- **options**: List<String> - Các phương án trả lời.
- **correct_option**: int - Chỉ số đáp án đúng.
*Lưu ý: Thường được nhúng trong ReadingPassage hoặc truy vấn theo ReadingPassage ID.*

## 9. ListeningExercises (Bài luyện nghe)
Các bài tập luyện nghe điền từ hoặc trắc nghiệm.
- **audio_url**: String - Đường dẫn file âm thanh.
- **script_with_blank**: String - Lời thoại có chỗ trống (để điền từ).
- **answer**: String - Đáp án đúng.
- **script_id**: String - ID của đoạn script gốc.
- **expires_in**: int - Thời gian giới hạn (giây).

## 10. ChatTopics (Chủ đề trò chuyện AI)
Các chủ đề để luyện nói chuyện với AI.
- **id**: String (Primary Key) - Định danh chủ đề.
- **name**: String - Tên chủ đề (ví dụ: Travel, Business).
- **description**: String - Mô tả chủ đề.
