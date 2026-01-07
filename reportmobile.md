
BỘ THÔNG TIN VÀ TRUYỀN THÔNG
HỌC VIỆN CÔNG NGHỆ BƯU CHÍNH VIỄN THÔNG




BÁO CÁO 
ĐỒ ÁN MÔN HỌC

Đề tài:
“Ứng dụng mobile học tiếng anh LexiGo”

Giảng viên hướng dẫn:	Nguyễn Trung Hiếu 
Sinh viên thực hiện :	TRẦN PHI HÙNG
		VŨ HOÀNG PHÁT
		PHẠM NGUYỄN QUỐC HUY
 Mã số sinh viên	:	N22DCCN132
		N22DCCN058
		N22DCCI018
Lớp	:	E22CQCN01-N Khoá :	2022-2027
Hệ	:	CLC
 
TP. HCM
2025
 




TP.HCM, tháng 12/2025 
 
MỤC LỤC
 
LỜI MỞ ĐẦU	1
CHƯƠNG 1. GIỚI THIỆU ĐỀ TÀI	3
1.1	Tìm hiểu “Ứng dụng mobile học tiếng Anh LexiGo”	3
1.2	Nền tảng công nghệ	3
1.3	Công cụ lập trình và công nghệ được sử dụng	3
1.4	Giới thiệu ngôn ngữ lập trình Java	3
1.5	Giới thiệu hệ quản trị cơ sở dữ liệu (API Backend)	4
1.6	Các thư viện – framework hỗ trợ	5
1.6.1	Retrofit 2	5
1.6.2	Material Design Components	6
1.6.3	SharedPreferences	6
CHƯƠNG 2. PHÂN TÍCH YÊU CẦU	7
2.1	Hiện trạng thực tế	7
2.2	Giải pháp nâng cao hiệu quả học tiếng Anh	7
2.3	Xây dựng bản đặc tả yêu cầu hệ thống	7
2.3.1	Mục tiêu hệ thống	7
2.3.2	Phạm vi hệ thống	8
2.3.3	Chức năng hệ thống	8
2.4	Mô tả các qui trình nghiệp vụ	9
CHƯƠNG 3. PHÂN TÍCH VÀ THIẾT KẾ HỆ THỐNG	11
3.1  Sơ đồ phân cấp chức năng	11
3.2  Mô hình luồng dữ liệu DFD	17
3.3  Mô hình usecase	17
3.4  Xác định thực thể	31
3.5  Mô hình ERD	31
3.6  Mô hình cơ sở dữ liệu quan hệ	32
3.7  Mô hình dữ liệu	36
CHƯƠNG 4. THIẾT KẾ TÀI LIỆU	39
4.1  Thiết kế khái quát	39
4.2 Thiết kế chi tiết	39
CHƯƠNG 5. ỨNG DỤNG MOBILE APPLICATION	40
5.1  Yêu cầu hệ thống	40
5.2  Demo giao diện	40
CHƯƠNG 6. TỔNG KẾT VÀ HƯỚNG PHÁT TRIỂN	52
6.1  Tổng kết	52
6.2  Hướng phát triển	52


 
KÝ HIỆU CÁC CỤM TỪ VIẾT TẮT

CSDL:	Cơ sở dữ liệu
API:	Application Programming Interface
UI:	User Interface
UX:	User Experience
JWT:	JSON Web Token

 

LỜI MỞ ĐẦU


Trong bối cảnh hội nhập toàn cầu, tiếng Anh đã trở thành ngôn ngữ quốc tế thiết yếu trong học tập, công việc và giao tiếp. Tuy nhiên, người học hiện nay thường gặp khó khăn do sự phân tán tài nguyên học tập: phải dùng nhiều ứng dụng khác nhau cho từ vựng, ngữ pháp, luyện nghe và luyện đọc. Điều này gây bất tiện và khó theo dõi lộ trình tiến bộ tổng thể.

Nhận thấy nhu cầu về một giải pháp học tập tập trung và toàn diện, nhóm chúng em đã chọn đề tài “Ứng dụng mobile học tiếng Anh LexiGo”. LexiGo là một nền tảng "All-in-One" tích hợp đầy đủ 4 kỹ năng (Nghe – Đọc – Từ vựng – Ngữ pháp) cùng với các công cụ hỗ trợ đắc lực như Từ điển và Chatbot AI.

Mục tiêu của LexiGo là mang lại trải nghiệm học tập chủ động, thú vị và hiệu quả, giúp người học có thể rèn luyện mọi lúc, mọi nơi chỉ với chiếc điện thoại di động.

Chúng em xin chân thành cảm ơn thầy Nguyễn Trung Hiếu đã tận tình hướng dẫn và giúp đỡ chúng em hoàn thành đồ án này.

 
CHƯƠNG 1. GIỚI THIỆU ĐỀ TÀI
1.1	Tìm hiểu “Ứng dụng mobile học tiếng Anh LexiGo”:
Trong kỷ nguyên số, việc học tập trên thiết bị di động (Mobile Learning) đang trở thành xu hướng tất yếu. LexiGo được xây dựng nhằm giải quyết vấn đề phân mảnh công cụ học tập, cung cấp một hệ sinh thái toàn diện cho người học tiếng Anh.
Ứng dụng tập trung vào trải nghiệm người dùng (UX) với giao diện hiện đại, dễ sử dụng, đồng thời tích hợp công nghệ AI để hỗ trợ người học tương tác và giải đáp thắc mắc tức thì. LexiGo không chỉ là một ứng dụng học tập mà còn là người bạn đồng hành, giúp người dùng duy trì động lực qua hệ thống theo dõi tiến độ và thống kê chi tiết.

1.2	Nền tảng công nghệ:
Mobile App: Android (Java)
Backend API: RESTful API (Client-Server Architecture)

1.3	Công cụ lập trình và công nghệ được sử dụng:
-	Công cụ lập trình: Android Studio
-	Ngôn ngữ lập trình: Java
-	Công nghệ giao tiếp API: Retrofit 2
-	Lưu trữ cục bộ: SharedPreferences
-	Giao diện: XML, Material Design

1.4	Giới thiệu ngôn ngữ lập trình Java:
Java là một ngôn ngữ lập trình hướng đối tượng (OOP) mạnh mẽ, bảo mật và đa nền tảng. Trong phát triển ứng dụng Android, Java đóng vai trò là ngôn ngữ chủ đạo (cùng với Kotlin), cung cấp bộ thư viện phong phú và cộng đồng hỗ trợ lớn.
LexiGo sử dụng Java để xây dựng toàn bộ logic xử lý phía Client, từ việc quản lý giao diện, xử lý sự kiện người dùng đến việc giao tiếp với Server qua API. Tính ổn định và hiệu năng của Java đảm bảo ứng dụng hoạt động mượt mà trên nhiều dòng thiết bị Android khác nhau.

1.5	Giới thiệu hệ quản trị cơ sở dữ liệu (API Backend):
LexiGo hoạt động theo mô hình Client-Server. Dữ liệu không được lưu trữ trực tiếp trên thiết bị (trừ một số dữ liệu cache và cấu hình) mà được quản lý tập trung tại Server.
Ứng dụng Mobile (Client) giao tiếp với Server thông qua chuẩn RESTful API. Mọi thao tác như đăng nhập, lấy bài học, nộp bài kiểm tra, lưu tiến độ đều được thực hiện qua các HTTP Request (GET, POST, PUT, DELETE).
Dữ liệu trả về thường ở định dạng JSON, được ứng dụng phân tích (parse) và hiển thị lên giao diện người dùng.

1.6	Các thư viện – framework hỗ trợ:
1.6.1	Retrofit 2:
Retrofit là một thư viện HTTP Client an toàn và mạnh mẽ cho Android và Java, được phát triển bởi Square. Nó giúp đơn giản hóa việc kết nối và tiêu thụ các RESTful Web Services.
Trong LexiGo, Retrofit được sử dụng để:
-	Định nghĩa các API Endpoints (Login, Register, Get Lessons, etc.).
-	Tự động chuyển đổi JSON response thành các Java Objects (POJO).
-	Quản lý các request network một cách hiệu quả, hỗ trợ bất đồng bộ (asynchronous).

1.6.2	Material Design Components:
Thư viện cung cấp các thành phần giao diện chuẩn theo ngôn ngữ thiết kế Material Design của Google. LexiGo sử dụng các component như CardView, RecyclerView, FloatingActionButton, TextInputEditText để tạo nên giao diện đẹp mắt, nhất quán và thân thiện với người dùng.

1.6.3	SharedPreferences:
Là một cơ chế lưu trữ dữ liệu nhỏ gọn dưới dạng key-value trên Android. LexiGo sử dụng SharedPreferences để:
-	Lưu trữ Token xác thực (JWT) sau khi đăng nhập.
-	Lưu trữ thông tin cơ bản của người dùng.
-	Lưu trữ cài đặt cá nhân và trạng thái tiến độ học tập trong ngày (Daily Goals).

CHƯƠNG 2. PHÂN TÍCH YÊU CẦU 
2.1	Hiện trạng thực tế:
Trong quá trình học tiếng Anh, người học hiện nay thường đối mặt với các rào cản sau:
-	Sự phân mảnh công cụ: Người học thường phải cài đặt nhiều ứng dụng khác nhau (một app để tra từ điển, một app để học ngữ pháp, một app khác để luyện nghe), gây bất tiện và khó theo dõi lộ trình tổng thể.
-	Phương pháp học thụ động: Nhiều ứng dụng cũ chỉ cung cấp bài tập trắc nghiệm khô khan, thiếu sự tương tác hai chiều, khiến người học nhanh chán và không áp dụng được vào thực tế.
-	Thiếu môi trường luyện tập: Việc tìm kiếm người bản xứ hoặc gia sư để luyện giao tiếp (Speaking/Chat) thường tốn kém và khó sắp xếp thời gian.
-	Khó duy trì động lực: Không có công cụ thống kê trực quan để người học nhìn thấy sự tiến bộ của mình mỗi ngày.

2.2	Giải pháp nâng cao hiệu quả học tiếng Anh:
LexiGo giải quyết các vấn đề trên thông qua một nền tảng di động "All-in-One":
-	Hệ sinh thái toàn diện: Tích hợp chặt chẽ 4 kỹ năng (Nghe, Đọc, Từ vựng, Ngữ pháp) và Từ điển vào một ứng dụng duy nhất.
-	Ứng dụng Trí tuệ nhân tạo (AI): Tính năng Chat AI đóng vai trò như một "Gia sư ảo" 24/7, cho phép người dùng hỏi đáp ngữ pháp, luyện hội thoại tự nhiên.
-	Cá nhân hóa trải nghiệm: Hệ thống tự động lưu trữ tiến độ và đưa ra thống kê chi tiết.
-	Tiếp cận dễ dàng: Học mọi lúc, mọi nơi trên thiết bị di động.

2.3	Xây dựng bản đặc tả yêu cầu hệ thống:
2.3.1	Mục tiêu hệ thống:
Hệ thống được xây dựng nhằm cung cấp giải pháp học tiếng Anh toàn diện, giúp:
•	Cung cấp kho tài liệu học tập phong phú (Từ vựng, Ngữ pháp, Bài đọc, Bài nghe).
•	Tạo môi trường luyện tập tương tác qua Chat AI.
•	Theo dõi và đánh giá chính xác tiến độ học tập của người dùng.
•	Đảm bảo trải nghiệm người dùng mượt mà, dễ sử dụng.

2.3.2	Phạm vi hệ thống:
•	 Người dùng chính:
1.	Người học (User): Sử dụng ứng dụng để học tập, làm bài kiểm tra, tra từ điển, chat với AI.
2.	Quản trị viên (Admin - Web Portal): Quản lý nội dung bài học, quản lý người dùng (Phạm vi Backend/Web).
•	Các chức năng chính trên Mobile App:
1.	Xác thực: Đăng ký, Đăng nhập, Quên mật khẩu, Đổi mật khẩu.
2.	Học tập:
	Học Từ vựng theo chủ đề.
	Học Ngữ pháp (Lý thuyết & Bài tập).
	Luyện Nghe (Điền từ).
	Luyện Đọc (Đọc hiểu & Trả lời câu hỏi).
3.	Công cụ:
	Chat AI (Hỏi đáp, Luyện hội thoại).
	Từ điển Anh-Việt (Tra cứu, Phát âm).
4.	Cá nhân:
	Quản lý hồ sơ (Profile).
	Thống kê tiến độ (Statistics).
	Đặt mục tiêu hàng ngày (Daily Goals).

2.3.3	Chức năng hệ thống:
1.	Xác thực & Tài khoản:
•	Đăng ký: Tạo tài khoản mới với email và mật khẩu.
•	Đăng nhập: Truy cập ứng dụng bằng tài khoản đã đăng ký.
•	Quên mật khẩu: Khôi phục mật khẩu qua email (OTP).
•	Đổi mật khẩu: Thay đổi mật khẩu hiện tại.
•	Quản lý hồ sơ: Cập nhật thông tin cá nhân (Avatar, Tên, Cấp độ).
2.	Học Từ vựng (Vocabulary):
•	Danh sách chủ đề: Hiển thị các chủ đề từ vựng theo cấp độ.
•	Bài học từ vựng: Xem chi tiết từ (nghĩa, phiên âm, ví dụ), nghe phát âm.
•	Kiểm tra từ vựng (Quiz): Bài tập trắc nghiệm để ôn tập từ vựng.
3.	Học Ngữ pháp (Grammar):
•	Danh sách bài học: Các bài ngữ pháp phân theo cấp độ.
•	Chi tiết bài học: Lý thuyết, công thức, quy tắc, ví dụ minh họa.
•	Bài tập ngữ pháp: Trắc nghiệm, điền từ, đúng/sai.
4.	Luyện Nghe (Listening):
•	Chọn cấp độ: Beginner, Intermediate, Advanced.
•	Bài tập nghe: Nghe đoạn hội thoại/văn bản và điền từ còn thiếu (Fill-in-the-blank).
5.	Luyện Đọc (Reading):
•	Danh sách bài đọc: Các bài đọc hiểu theo chủ đề và cấp độ.
•	Chi tiết bài đọc: Nội dung văn bản đầy đủ.
•	Kiểm tra đọc hiểu: Trả lời câu hỏi trắc nghiệm dựa trên nội dung bài đọc.
6.	Chat AI:
•	Trò chuyện tự do: Giao tiếp với AI về mọi chủ đề.
•	Hỗ trợ học tập: Hỏi đáp ngữ pháp, từ vựng, sửa lỗi câu.
•	Lưu lịch sử chat: Xem lại các cuộc trò chuyện trước đó.
7.	Từ điển (Dictionary):
•	Tra cứu Anh-Việt: Tìm kiếm từ vựng.
•	Chi tiết từ: Định nghĩa, loại từ, phiên âm, ví dụ, từ đồng nghĩa.
•	Phát âm: Nghe cách đọc chuẩn của từ.
8.	Quản lý Tiến độ & Thống kê:
•	Theo dõi tiến độ: Tự động ghi nhận số bài học đã hoàn thành.
•	Mục tiêu hàng ngày (Daily Goals): Đặt và theo dõi mục tiêu học tập mỗi ngày.
•	Thống kê chi tiết: Biểu đồ năng lực từng kỹ năng, chuỗi ngày học (Streak).

2.4	 Mô tả các quy trình nghiệp vụ :
1. Quy trình Học tập:
1.1 Người dùng chọn kỹ năng muốn học (Từ vựng/Ngữ pháp/Nghe/Đọc).
1.2 Hệ thống hiển thị danh sách bài học/chủ đề phù hợp.
1.3 Người dùng chọn bài học và tiến hành học/làm bài tập.
1.4 Hệ thống chấm điểm và cập nhật tiến độ ngay sau khi hoàn thành.

2. Quy trình Chat AI:
2.1 Người dùng mở tính năng Chat.
2.2 Nhập câu hỏi hoặc nội dung trò chuyện.
2.3 Hệ thống gửi yêu cầu đến Server AI.
2.4 AI phản hồi và hiển thị câu trả lời lên màn hình.

3. Quy trình Tra từ điển:
3.1 Người dùng nhập từ khóa vào ô tìm kiếm.
3.2 Hệ thống truy vấn cơ sở dữ liệu.
3.3 Hiển thị kết quả chi tiết (nghĩa, phát âm, ví dụ).

 
CHƯƠNG 3. PHÂN TÍCH VÀ THIẾT KẾ HỆ THỐNG
3.1 Sơ đồ phân cấp chức năng:
 
Sơ đồ 3.1 Sơ đồ phân rã chức năng mức đỉnh

Hệ thống LexiGo bao gồm các nhóm chức năng chính: Quản lý Tài khoản, Học tập (Từ vựng, Ngữ pháp, Nghe, Đọc), Công cụ (Chat AI, Từ điển) và Thống kê.

3.2 Mô hình luồng dữ liệu DFD (Data Flow Diagram) 
(Mô tả luồng dữ liệu giữa Người dùng - Ứng dụng Mobile - Server API)

3.3	 Mô hình usecase:
3.3.1	Xác định Actor:
•	User (Người học): Người sử dụng ứng dụng để học tiếng Anh.
•	AI System: Hệ thống trí tuệ nhân tạo phản hồi tin nhắn.

3.3.2	Xác định các Use Case:
Actor	Use Case
User	Đăng nhập, Đăng ký, Quên mật khẩu, Đổi mật khẩu, Cập nhật hồ sơ.
	Học từ vựng, Làm Quiz từ vựng.
	Học ngữ pháp, Làm bài tập ngữ pháp.
	Luyện nghe, Luyện đọc.
	Tra từ điển.
	Chat với AI.
	Xem thống kê tiến độ.

3.3.3	Đặc tả Use Case (Chi tiết các luồng hoạt động chính):

a. Đăng ký & Đăng nhập:
•	Tên Use Case: Đăng ký & Đăng nhập
•	Actor: User
•	Mô tả: Người dùng tạo tài khoản và đăng nhập vào hệ thống.
•	Dòng sự kiện chính (Đăng ký):
1.	User mở ứng dụng, chọn tab "Đăng ký".
2.	User nhập Họ tên, Email, Mật khẩu.
3.	Hệ thống kiểm tra định dạng email và độ dài mật khẩu.
4.	Hệ thống gọi API đăng ký.
5.	Nếu thành công, thông báo và yêu cầu đăng nhập.
•	Dòng sự kiện chính (Đăng nhập):
1.	User nhập Email và Mật khẩu.
2.	Hệ thống gọi API đăng nhập.
3.	Nếu thành công, hệ thống lưu Token và chuyển đến màn hình chính (Home).

b. Học Từ vựng:
•	Tên Use Case: Học Từ vựng
•	Actor: User
•	Mô tả: Quy trình học từ vựng và làm bài kiểm tra.
•	Dòng sự kiện chính:
1.	User chọn "Học từ vựng" từ màn hình chính.
2.	Hệ thống tải danh sách chủ đề (Topics) từ API.
3.	User chọn một chủ đề.
4.	Hệ thống hiển thị danh sách từ vựng (Word, Meaning, Example).
5.	User nhấn icon loa để nghe phát âm.
6.	User chọn icon "Quiz" để làm bài kiểm tra.
7.	Hệ thống hiển thị câu hỏi trắc nghiệm.
8.	User chọn đáp án, hệ thống chấm điểm ngay lập tức (Đúng/Sai).
9.	Kết thúc Quiz, hệ thống hiển thị tổng điểm và cập nhật tiến độ.

c. Học Ngữ pháp:
•	Tên Use Case: Học Ngữ pháp
•	Actor: User
•	Mô tả: Xem lý thuyết và làm bài tập ngữ pháp.
•	Dòng sự kiện chính:
1.	User chọn "Học ngữ pháp".
2.	Hệ thống hiển thị danh sách bài học.
3.	User chọn bài học để xem chi tiết (Lý thuyết, Ví dụ).
4.	User nhấn "Start Exercise".
5.	Hệ thống tải bài tập (Trắc nghiệm, Điền từ).
6.	User làm bài và nộp.
7.	Hệ thống hiển thị kết quả và giải thích chi tiết.

d. Luyện Nghe:
•	Tên Use Case: Luyện Nghe
•	Actor: User
•	Mô tả: Luyện kỹ năng nghe qua bài tập điền từ.
•	Dòng sự kiện chính:
1.	User chọn "Luyện nghe" và chọn cấp độ (Beginner/Intermediate/Advanced).
2.	Hệ thống tải bài tập nghe (Script with blanks).
3.	User nhấn Play để nghe audio.
4.	User điền từ còn thiếu vào ô trống.
5.	User nhấn "Kiểm tra".
6.	Hệ thống phản hồi Đúng/Sai và hiển thị đáp án đúng.

e. Luyện Đọc:
•	Tên Use Case: Luyện Đọc
•	Actor: User
•	Mô tả: Đọc văn bản và trả lời câu hỏi.
•	Dòng sự kiện chính:
1.	User chọn "Luyện đọc".
2.	Hệ thống hiển thị danh sách bài đọc.
3.	User chọn bài đọc và đọc nội dung.
4.	User nhấn "Start Quiz".
5.	User trả lời các câu hỏi đọc hiểu.
6.	User nộp bài, hệ thống chấm điểm và hiển thị kết quả.

f. Chat AI:
•	Tên Use Case: Chat với AI
•	Actor: User, AI System
•	Mô tả: Giao tiếp với trợ lý ảo.
•	Dòng sự kiện chính:
1.	User nhấn nút Chat (FAB).
2.	Hệ thống khởi tạo phiên chat.
3.	User nhập tin nhắn và nhấn Gửi.
4.	Hệ thống hiển thị tin nhắn của User.
5.	Hệ thống gọi API gửi tin nhắn đến AI.
6.	AI phản hồi, hệ thống hiển thị tin nhắn của AI.

g. Tra Từ điển:
•	Tên Use Case: Tra Từ điển
•	Actor: User
•	Mô tả: Tra cứu nghĩa của từ.
•	Dòng sự kiện chính:
1.	User chọn "Từ điển".
2.	User nhập từ khóa vào ô tìm kiếm.
3.	Hệ thống gọi API tra cứu.
4.	Hệ thống hiển thị kết quả chi tiết (Nghĩa, Phiên âm, Ví dụ).
5.	User nhấn icon loa để nghe phát âm.

3.4 Xác định thực thể (Data Models):
Dựa trên cấu trúc dữ liệu của ứng dụng:
-	User (userId, name, email, password, level, avatar)
-	Topic (topicId, name, image, level)
-	Lesson (lessonId, title, content)
-	Vocabulary (wordId, word, meaning, phonetic, audioUrl, topicId)
-	GrammarLesson (id, title, theory, rules, examples)
-	ListeningScript (id, scriptWithBlank, fullScript, audioUrl, level)
-	ReadingPassage (id, title, content, level)
-	Question (id, questionText, options, correctAnswer, type)
-	Progress (userId, vocabCompleted, grammarCompleted, etc.)
-	ChatMessage (id, conversationId, sender, message, timestamp)

3.5 Mô hình ERD:
(Mô tả mối quan hệ giữa các thực thể)
-	User 1-n Progress (Mỗi user có bản ghi tiến độ)
-	Topic 1-n Vocabulary (Một chủ đề có nhiều từ vựng)
-	GrammarLesson 1-n Question (Một bài học có nhiều câu hỏi)
-	ReadingPassage 1-n Question (Một bài đọc có nhiều câu hỏi)
-	User 1-n ChatMessage (User gửi nhiều tin nhắn)

3.6 Mô hình cơ sở dữ liệu quan hệ:
•	Bảng Users:
-	user_id (PK): ID người dùng
-	email: Email đăng nhập
-	password_hash: Mật khẩu đã mã hóa
-	full_name: Họ tên
-	level: Trình độ hiện tại

•	Bảng Vocabulary:
-	vocab_id (PK): ID từ vựng
-	topic_id (FK): ID chủ đề
-	word: Từ tiếng Anh
-	meaning: Nghĩa tiếng Việt
-	phonetic: Phiên âm
-	audio_url: Link file âm thanh

•	Bảng Progress:
-	progress_id (PK)
-	user_id (FK)
-	lesson_type: Loại bài học (Vocab, Grammar, etc.)
-	lesson_id: ID bài học đã hoàn thành
-	score: Điểm số (nếu có)
-	completed_at: Thời gian hoàn thành

CHƯƠNG 4. THIẾT KẾ TÀI LIỆU
4.1 Thiết kế khái quát:
Sơ đồ điều hướng ứng dụng (Navigation Flow):
-	Màn hình Chào (Splash Screen) -> Màn hình Đăng nhập/Đăng ký.
-	Màn hình Chính (Home Activity):
    -	Menu Học tập: Từ vựng, Ngữ pháp, Nghe, Đọc.
    -	Menu Công cụ: Chat AI, Từ điển.
    -	Menu Cá nhân: Profile, Thống kê.
-	Màn hình Học tập -> Danh sách bài học -> Chi tiết bài học -> Làm bài tập (Quiz).
-	Màn hình Chat -> Giao diện Chat.

4.2 Thiết kế chi tiết:
-	Giao diện được thiết kế theo chuẩn Material Design.
-	Màu sắc chủ đạo: Xanh dương (Blue) tạo cảm giác tin cậy và tập trung.
-	Font chữ: Roboto (chuẩn Android).
-	Icon: Sử dụng bộ icon vector sắc nét.

CHƯƠNG 5. ỨNG DỤNG MOBILE APPLICATION
5.1 Yêu cầu hệ thống:
-	Hệ điều hành: Android 8.0 (Oreo) trở lên.
-	Kết nối Internet: Yêu cầu kết nối mạng (Wifi/4G) để tải dữ liệu bài học và chat với AI.
-	Dung lượng trống: Tối thiểu 100MB.

5.2 Demo giao diện:

5.2.1 Màn hình Đăng nhập & Đăng ký:
[Hình ảnh: Giao diện Đăng nhập với logo LexiGo, ô nhập Email/Password]
Người dùng nhập thông tin tài khoản để truy cập ứng dụng. Hỗ trợ tính năng "Quên mật khẩu" và chuyển đổi nhanh giữa Đăng nhập/Đăng ký.

5.2.2 Màn hình Chính (Home):
[Hình ảnh: Giao diện Home với các card chức năng: Vocabulary, Grammar, Listening, Reading, Chat AI]
Hiển thị tổng quan tiến độ học tập trong ngày (Daily Goal). Các chức năng được bố trí dạng lưới (Grid) trực quan, dễ thao tác.

5.2.3 Giao diện Học Từ vựng:
[Hình ảnh: Danh sách chủ đề từ vựng]
[Hình ảnh: Chi tiết từ vựng với nghĩa, phiên âm và nút phát âm]
Người dùng chọn chủ đề và xem danh sách từ vựng. Mỗi từ có đầy đủ thông tin và audio phát âm chuẩn.

5.2.4 Giao diện Chat AI:
[Hình ảnh: Giao diện chat với tin nhắn của người dùng và phản hồi của AI]
Người dùng có thể trò chuyện tự do hoặc theo chủ đề với trợ lý ảo AI. AI phản hồi nhanh chóng và tự nhiên, hỗ trợ sửa lỗi ngữ pháp.

5.2.5 Giao diện Làm bài tập (Quiz):
[Hình ảnh: Giao diện câu hỏi trắc nghiệm với 4 đáp án]
Sau khi học lý thuyết, người dùng làm bài kiểm tra để củng cố kiến thức. Hệ thống chấm điểm và hiển thị kết quả ngay lập tức (Đúng/Sai).

5.2.6 Giao diện Thống kê (Profile):
[Hình ảnh: Biểu đồ thống kê tiến độ học tập]
Hiển thị số lượng bài học đã hoàn thành ở từng kỹ năng, chuỗi ngày học liên tục (Streak) và cấp độ hiện tại của người dùng.

CHƯƠNG 6. TỔNG KẾT VÀ HƯỚNG PHÁT TRIỂN 
6.1 Tổng kết:
Sau thời gian nghiên cứu và thực hiện, nhóm đã hoàn thành ứng dụng LexiGo với các kết quả đạt được:
-	Xây dựng thành công ứng dụng Android hoàn chỉnh với đầy đủ các tính năng học tập cơ bản.
-	Tích hợp thành công API Chat AI, mang lại trải nghiệm học tập hiện đại.
-	Hệ thống hoạt động ổn định, giao diện thân thiện và dễ sử dụng.
-	Đáp ứng được nhu cầu học tiếng Anh "All-in-One" của người dùng.

Tuy nhiên, ứng dụng vẫn còn một số hạn chế:
-	Chưa hỗ trợ chế độ học Offline hoàn toàn (cần mạng để tải bài học).
-	Chưa có tính năng luyện nói (Speaking) chuyên sâu (chấm điểm phát âm).
-	Nội dung bài học cần được bổ sung phong phú hơn.

6.2 Hướng phát triển:
Trong tương lai, nhóm dự định phát triển thêm các tính năng:
-	Speaking Practice: Tích hợp công nghệ nhận diện giọng nói (Speech-to-Text) để chấm điểm phát âm cho người dùng.
-	Gamification: Thêm bảng xếp hạng (Leaderboard), huy hiệu (Badges) để tăng tính cạnh tranh và động lực học tập.
-	Offline Mode: Cho phép tải bài học về máy để học khi không có mạng.
-	Social Learning: Tính năng kết bạn, thách đấu từ vựng với bạn bè.
-	Cải thiện AI: Tối ưu hóa Chatbot để phản hồi thông minh hơn và hỗ trợ sửa lỗi văn bản (Writing correction).

DANH MỤC TÀI LIỆU THAM KHẢO 
1.	Google Developers. (2024). Android Developer Documentation. https://developer.android.com/
2.	Square. (2024). Retrofit Documentation. https://square.github.io/retrofit/
3.	OpenAI. (2024). API Documentation. https://platform.openai.com/docs/
4.	Material Design. (2024). Material Design Guidelines. https://m3.material.io/
