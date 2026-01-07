

BỘ THÔNG TIN VÀ TRUYỀN THÔNG
HỌC VIỆN CÔNG NGHỆ BƯU CHÍNH VIỄN THÔNG




BÁO CÁO 
ĐỒ ÁN MÔN HỌC

Đề tài:
“Ứng dụng mobile học tiếng anh LexiGo”

Giảng viên hướng dẫn:	Nguyễn Trung Hiếu 
Sinh viên thực hiện :	TRẦN PHI HÙNG
		VŨ HOÀNG PHÁT
		PHẠM NGUYỄN QUỐC		HUY
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
1.1	Tìm hiểu “Xây dựng website quản lý thư viện”	3
1.2	Nền tảng công nghệ	3
1.3	Công cụ lập trình và công nghệ được sử dụng:	3
1.4	Giới thiệu ngôn ngữ lập trình Java:	3
1.5	Giới thiệu hệ quản trị cơ sở dữ liệu SQL SERVER	4
1.6	Các thư viện – framework hỗ trợ	5
1.6.1	Apache Tomcat (phiên bản 10):	5
1.6.2	Java Database Connectivity (JDBC)	6
1.6.3	Spring Boot	6
CHƯƠNG 2. PHÂN TÍCH YÊU CẦU	7
2.1	Hiện trạng thực tế	7
2.2	Giải pháp nâng cao hiệu quả của quản lý thư viện điện tử	7
2.3	Xây dựng bản đặc tả yêu cầu hệ thống	7
2.3.1	Mục tiêu hệ thống	7
2.3.2	Phạm vi hệ thống	8
2.3.3	Chức năng hệ thống	8
2.3.3.1	Chức năng cho Quản lý(admin)	8
2.3.3.2	Chức năng cho Người dùng(user) 	9	
2.4	Mô tả các qui trình nghiệp vụ:	9
2.4.1	Sơ đồ cơ cấu tổ chức	9
2.4.2	Qui trình nghiệp vụ	9
CHƯƠNG 3. PHÂN TÍCH VÀ THIẾT KẾ HỆ THỐNG	11
3.1  Hiện trạng thực tế	11
3.1.1     Mục tiêu hệ thống	11
3.1.2     Sơ đồ phân rã chức năng	11
3.1.2.1 Quản lý kho sách	11
3.1.2.1 Quản lý mượn sách	12
3.1.2.3 Quản lý độc giả	13
3.1.2.4 Thống kê	13
3.1.2.5 Chức năng mượn sách	14
3.1.2.6 Chức năng trả sách	14
3.1.2.7 Chức năng tìm kiếm sách	15
3.1.2.8 Chức năng xem thông tin tài khoản	15

3.2  Mô hình luồng dữ liệu DFD (Data Flow Diagram)	17
 3.2.1    Biểu đồ DFD mức ngữ cảnh	17
 3.2.2    Mô hình luồng dữ liệu DFD phân rã cấp 0 (Chức năng chính)	17
3.3  Mô hình usecase	17
			3.3.1    Xác định Actor	17
			3.3.2    Xác định các Use Case	17
			3.3.3    Xây dựng biểu đồ Use Case tổng quát	17
			3.3.4    Đặc tả Use Case	19
	3.3.4.1 Thao tác dành cho Quản lý	19
	3.3.4.2 Thao tác dành cho Độc giả	21
3.3.5   Biểu đồ tuần tự tương ứng với các Use Case	24
3.4  Xác định thực thể	31
3.5  Mô hình ERD	31
3.6  Mô hình cơ sở dữ liệu quan hệ	32
3.7  Mô hình dữ liệu	36
	3.7.1 Xét User - Borrow_Return	36
	3.7.2 Xét Borrow_Return – Book	36
	3.7.3 Xét Author – Book	36
	3.7.4 Xét Category – Book	37
	3.7.5 Xét Users – Notifications	37
	3.7.6 Xét Users – Import_Invoice	37
	3.7.7 Xét Import_Invoice – Import_Details	38
	3.7.8 Xét Book – Import_Details	38
3.8  Phân tích và hoàn thiện mô hình quan hệ 	38
CHƯƠNG 4.THIẾT KẾ TÀI LIỆU	39
4.1  Thiết kế khái quát	39
	4.1.1 Độc giả	39
	4.1.2 Admin	39
4.2 Thiết kế chi tiết	39
4.3 Chi tiết các thiết kế	39
CHƯƠNG 5. ỨNG DỤNG WEB APPLICATION	40
5.1  Yêu cầu hệ thống	40
5.2  Demo giao diện dành cho Độc giả	40
5.2.1 Giao diện Danh sách thư viện và Thông tin sách	40
5.2.2 Giao diện Tài khoản	44
5.3 Demo giao diện dành cho Admin	49
CHƯƠNG 6.TỔNG KẾT VÀ HƯỚNG PHÁT TRIỂN	52
6.1  Tổng kết	52
6.2  Hướng phát triển	52


 
DANH MỤC CÁC BẢNG, SƠ ĐỒ, HÌNH
Hình 1. 1 Giới thiệu ngôn ngữ lập trình Java
Hình 1. 2 Giới hiệu hệ quản trị CSDL SQL Server
Bảng 2. 1 Các vấn đề và giải pháp nâng cao hiệu quả quản lý thư viện
Sơ đồ 2. 1 Sơ đồ cơ cấu tổ chức quản lý thư viện
Sơ đồ 3. 1 Sơ đồ phân rã chức năng mức đỉnh
Sơ đồ 3. 2 Sơ đồ phân rã quản lý sách
Sơ đồ 3. 3 Sơ đồ phân rã quản lý mượn trả sách
Sơ đồ 3. 4 Sơ đồ phân rã quản lý độc giả
Sơ đồ 3. 5 Sơ đồ phân rã thống kê
Sơ đồ 3. 6 Sơ đồ phân rã chức năng mượn sách
Sơ đồ 3. 7 Sơ đồ phân rã chức năng trả sách
Sơ đồ 3. 8 Sơ đồ phân rã chức năng tìm kiếm sách
Sơ đồ 3. 9 Sơ đồ phân rã chức năng xem thông tin tài khoản
Sơ đồ 3. 10 Biểu đồ DFD mức ngữ cảnh
Sơ đồ 3. 11 Biểu đồ DFD phân rã cấp 0
Sơ đồ 3. 12 Biểu đồ usecase cho Quản lý
Sơ đồ 3. 13 Biểu đồ usecase cho độc giả
Sơ đồ 3. 14 Biểu đồ usecase Đăng nhập
Sơ đồ 3. 15 Biểu đồ trình tự Đăng nhập 
Sơ đồ 3. 16 Biểu đồ usecase Tìm kiếm 
Sơ đồ 3. 17 Biểu đồ usecase Mượn sách 
Sơ đồ 3. 18 Biểu đồ trình tự Mượn sách 
Sơ đồ 3. 19 Biểu đồ usecase Trả sách 
Sơ đồ 3. 20 Biểu đồ trình tự Trả sách 
Sơ đồ 3. 21 Biểu đồ usecase Thống kê 
Sơ đồ 3. 22 Biểu đồ trình tự Thống kê 
Sơ đồ 3. 23 Biểu đồ usecase Thêm sách 
Sơ đồ 3. 24 Biểu đồ trình tự Thêm sách
Sơ đồ 3. 25 Biểu đồ usecase Cập nhật sách
Sơ đồ 3. 26 Biểu đồ trình tự Cập nhật sách
Sơ đồ 3. 27 Biểu đồ usecase Xóa sách
Sơ đồ 3. 28 Biểu đồ trình tự Xóa sách
Sơ đồ 3. 29 Biểu đồ usecase Xem thông tin
Sơ đồ 3. 30 Biểu đồ trình tự Xem thông tin
Sơ đồ 3. 31 Mô hình  ERD
Sơ đồ 3. 32 Mô hình  Users – Borrow_Return
Sơ đồ 3. 33 Mô hình  Borrow_Return - Book
Sơ đồ 3. 34 Mô hình  Author - Book
Sơ đồ 3. 35 Mô hình  Category – Book
Sơ đồ 3. 36 Mô hình Users – Notification
Sơ đồ 3. 37 Mô hình Users – Import_Invoice
Sơ đồ 3. 38 Mô hình Import_Invoice - Import_Details
Sơ đồ 3. 39 Mô hình Book -  Import_Details
Sơ đồ 3. 40 Mô hình diagrams
Bảng 3. 1 Xác định các use case
Bảng 3. 2 Bảng thực thể Users
Bảng 3. 3 Bảng thực thể Book
Bảng 3. 4 Bảng thực thể Book_Author
Bảng 3. 5 Bảng thực thể Author
Bảng 3. 6 Bảng thực thể Category
Bảng 3. 7 Bảng thực thể Borrow_Return
Bảng 3. 8 Bảng thực thể Import_Details
Bảng 3. 9 Bảng thực thể Import_Invoice
Bảng 3. 10 Bảng thực thể Notification
Bảng 3. 11 Bảng thực thể Password_Reset
Hình 5. 1 Danh sách thư viện (Phần trên) 
Hình 5. 2 Danh sách thư viện (Phần dưới) 
Hình 5. 3 Danh sách thư viện (Trang 2)
Hình 5. 4 Lọc sách theo danh mục
Hình 5. 5 Trường hợp không có sách
Hình 5. 6 Thông tin chi tiết sách
Hình 5. 7 Thông báo cho sách đề xuất
Hình 5. 8 Thông báo hết sách cho mượn
Hình 5. 9 Trang đăng nhập
Hình 5. 10 Trang đăng nhập
Hình 5. 11 Form sửa thông tin
Hình 5. 12 Thông báo sai định dạng 
Hình 5. 13 Thay đổi thành công
Hình 5. 14 Cập nhật Ngày xác nhận mượn
Hình 5. 15 Thông báo mượn quá số lần cho phép
Hình 5. 16 Thao tác hủy (2 trường hợp)
Hình 5. 17 Thao tác gia hạn
Hình 5. 18 Hết lượt gia hạn
Hình 5. 19 Tìm kiếm sách 
Hình 5. 20 Không tìm được sách 
Hình 5. 21 Giao diện bên Admin 
Hình 5. 22 Thông báo Xác nhận mượn 
Hình 5. 23 Chọn tình trạng sách khi trả 
Hình 5. 24 Thông tin sách sau khi trả
Hình 5. 25 Tìm kiếm sách






























 
KÝ HIỆU CÁC CỤM TỪ VIẾT TẮT

CSDL:	Cơ sở dữ liệu
SQL:	Structured Query Language
UI:	User Interface
HTML:	Hyper Text Markup Language

	
 

LỜI MỞ ĐẦU


Trong bối cảnh nhu cầu học tiếng Anh ngày càng trở nên quan trọng trong học tập, công việc và giao tiếp quốc tế, người học phải đối mặt với nhiều khó khăn: tài nguyên phân tán ở nhiều ứng dụng khác nhau, thiếu công cụ luyện tập thực tế, và đặc biệt là khó duy trì động lực trong quá trình học dài hạn. Nhóm chúng em nhận thấy cần xây dựng một giải pháp học tập tập trung, trực quan và thực tiễn hơn.
Từ nhu cầu đó, nhóm chọn đề tài “Ứng dụng mobile học tiếng Anh LexiGo”—một nền tảng giúp người học rèn luyện các kỹ năng (Listening – Reading – Vocabulary – Grammar) cùng hệ thống từ điển và chatbot AI.
Nhóm hy vọng sản phẩm không chỉ hỗ trợ học viên cải thiện năng lực tiếng Anh mà còn mang lại trải nghiệm học tập chủ động, thú vị và hiệu quả hơn.
Chúng em xin chân thành cảm ơn !!!







TÓM TẮT
1.	Bối cảnh và vấn đề:
Trong quá trình học tiếng Anh, người học hiện nay thường đối mặt với các rào cản sau:
-	Sự phân mảnh công cụ: Người học thường phải cài đặt nhiều ứng dụng khác nhau (một app để tra từ điển, một app để học ngữ pháp, một app khác để luyện nghe), gây bất tiện và khó theo dõi lộ trình tổng thể.
-	Phương pháp học thụ động: Nhiều ứng dụng cũ chỉ cung cấp bài tập trắc nghiệm khô khan, thiếu sự tương tác hai chiều, khiến người học nhanh chán và không áp dụng được vào thực tế.
-	Thiếu môi trường luyện tập: Việc tìm kiếm người bản xứ hoặc gia sư để luyện giao tiếp (Speaking/Chat) thường tốn kém và khó sắp xếp thời gian.
-	Khó duy trì động lực: Không có công cụ thống kê trực quan để người học nhìn thấy sự tiến bộ của mình mỗi ngày.
2.	Mục tiêu và giải pháp:
LexiGo giải quyết các vấn đề trên thông qua một nền tảng di động "All-in-One":
-	Hệ sinh thái toàn diện: Tích hợp chặt chẽ 4 kỹ năng (Nghe, Đọc, Từ vựng, Ngữ pháp) và Từ điển vào một ứng dụng duy nhất, giúp người học tiết kiệm thời gian và dung lượng bộ nhớ.
-	Ứng dụng Trí tuệ nhân tạo (AI): Tính năng Chat AI đóng vai trò như một "Gia sư ảo" 24/7, cho phép người dùng hỏi đáp ngữ pháp, luyện hội thoại tự nhiên và nhận phản hồi tức thì.
-	Cá nhân hóa trải nghiệm: Hệ thống tự động lưu trữ tiến độ và đưa ra thống kê chi tiết, giúp người học tự điều chỉnh lộ trình phù hợp với năng lực bản thân.
-	Tiếp cận dễ dàng: Là ứng dụng di động (Mobile App), LexiGo cho phép học mọi lúc, mọi nơi, tận dụng các khoảng thời gian "chết" trong ngày để nâng cao trình độ.
3.	Công nghệ:
Ứng dụng được xây dựng dựa trên các tiêu chuẩn công nghệ di động hiện đại, đảm bảo hiệu năng và trải nghiệm người dùng mượt mà:
-	Kiến trúc hệ thống: Mô hình Client-Server. Ứng dụng mobile (Client) giao tiếp với Máy chủ (Server) thông qua chuẩn RESTful API để trao đổi dữ liệu.
-	Xử lý đa phương tiện (Multimedia): Tích hợp trình phát âm thanh (Audio Player) tối ưu hóa cho việc streaming và phát các file nghe offline.
-	Trí tuệ nhân tạo (AI Integration): Tích hợp API Chatbot thông minh để xử lý ngôn ngữ tự nhiên, đóng vai trò trợ lý học tập ảo.
-	Lưu trữ cục bộ (Local Storage): Sử dụng cơ chế lưu trữ bảo mật để quản lý Token đăng nhập (Session management) và caching dữ liệu bài học để tăng tốc độ tải.
-	Giao diện người dùng (UI/UX): Thiết kế theo hướng hiện đại, tập trung vào trải nghiệm học tập (Learning Experience), hỗ trợ tương tác chạm, vuốt và phản hồi tức thì.
4.	Kết quả:
-	Hệ thống xác thực đầy đủ (Đăng ký, Đăng nhập, Quên mật khẩu, Đổi mật khẩu)
-	 4 module học tập chính: Từ vựng, Ngữ pháp, Luyện nghe, Luyện đọc
-	Chat AI hỗ trợ học tập
-	Từ điển Anh-Việt tích hợp
-	Hệ thống tracking tiến độ tự động
5.	Hạn chế:
-	Chưa hỗ trợ học offline, phụ thuộc hoàn toàn vào kết nối mạng
-	Chưa cache nội dung lessons, mỗi lần load đều gọi API
-	Xử lý lỗi mạng chưa tối ưu, chưa có retry mechanism
-	Chưa sử dụng thư viện tối ưu hình ảnh (Glide/Picasso)
-	Chưa có tính năng luyện nói thực sự (chỉ Chat AI)
-	Chưa có AI check grammar & writing
-	Chưa tích hợp video lessons
-	Chưa cho phép tạo danh sách từ riêng
-	Chưa có flashcard với thuật toán lặp lại tối ưu
6.	Hướng phát triển:
-	Speaking Practice (Luyện Nói)
•	Speech recognition: Công nghệ AI chuyển đổi giọng nói thành văn bản để nhận diện chính xác nội dung người học phát âm.
•	Pronunciation scoring: Hệ thống chấm điểm chi tiết dựa trên sự so sánh giữa giọng người học và giọng chuẩn bản xứ.
•	Real-time feedback: Cung cấp đánh giá và chỉ ra lỗi sai ngay lập tức khi người dùng vừa dứt lời.
-	Writing Practice (Luyện Viết)
•	AI grammar checker: Tự động phát hiện và đề xuất sửa lỗi ngữ pháp, chính tả cũng như cấu trúc câu.
•	Essay scoring: Đánh giá toàn diện và chấm điểm bài luận dựa trên từ vựng, độ mạch lạc và ý tưởng.
•	Writing prompts: Cung cấp ngân hàng chủ đề và gợi ý ý tưởng phong phú để kích thích tư duy viết.
-	Gamification (Trò chơi hóa)
•	Achievements & badges: Trao tặng các huy hiệu và danh hiệu đặc biệt khi người dùng đạt được cột mốc học tập nhất định.
•	Daily challenges: Đưa ra các nhiệm vụ nhỏ được làm mới mỗi ngày để duy trì thói quen học tập liên tục.
•	XP & leveling system: Tích lũy điểm kinh nghiệm qua từng bài học để thăng cấp và trực quan hóa sự tiến bộ.
CHƯƠNG 1. GIỚI THIỆU ĐỀ TÀI
1.1	Tìm hiểu “Xây dựng website quản lý thư viện:
Trong thời đại công nghệ 4.0, việc ứng dụng công nghệ vào quản lý đang trở thành xu thế phổ biến, và hệ thống quản lý thư viện cũng không nằm ngoài xu hướng này. Thư viện – nơi lưu trữ tri thức và phục vụ nhu cầu học tập, nghiên cứu – ngày càng đòi hỏi một phương thức quản lý hiện đại, hiệu quả và tiện lợi hơn.
Dựa trên nhu cầu thực tế, chúng em lựa chọn đề tài “Xây dựng website quản lý thư viện.” Hệ thống quản lý thư viện trực tuyến sẽ hỗ trợ các thư viện trong việc tối ưu hóa quy trình hoạt động, từ quản lý thông tin độc giả, tài liệu đến xử lý mượn và trả sách. Hệ thống này không chỉ giúp giảm thiểu sai sót mà còn tăng năng suất làm việc, dễ dàng kiểm soát tài liệu, thống kê số liệu và tiết kiệm thời gian, chi phí cho cả cán bộ thư viện và người dùng.Giải pháp này hứa hẹn sẽ trở thành công cụ hỗ trợ đắc lực, giúp các thư viện nâng cao chất lượng phục vụ, đáp ứng nhu cầu ngày càng tăng của độc giả trong thời kỳ chuyển đổi số.
1.2	Nền tảng công nghệ:
Web : Sử dụng Java Spring Boot
1.3	Công cụ lập trình và công nghệ được sử dụng:
-	   Hệ quản trị cơ sở dữ liệu : MongoDB 
-	Công cụ lập trình : Android Studio
-	Ngôn ngữ lập trình : Java
-	Công nghệ xử lý back-end : Framework FastAPI
1.4	Giới thiệu ngôn ngữ lập trình Java:

Hình 1. 1 Giới thiệu ngôn ngữ lập trình Java
Java là một trong những ngôn ngữ lập trình phổ biến nhất trên thế giới, được phát triển bởi Sun Microsystems (hiện thuộc Oracle) vào năm 1995. Được thiết kế với triết lý “viết một lần, chạy mọi nơi” (Write Once, Run Anywhere - WORA), Java cho phép các ứng dụng được viết bằng ngôn ngữ này có thể chạy trên nhiều nền tảng khác nhau mà không cần chỉnh sửa mã nguồn.
Java được biết đến với các đặc điểm nổi bật như tính hướng đối tượng (Object-Oriented), bảo mật cao, hiệu năng ổn định, và thư viện phong phú hỗ trợ phát triển ứng dụng từ web, desktop đến di động. Bên cạnh đó, Java còn có một cộng đồng phát triển lớn mạnh và tài liệu phong phú, giúp người mới học dễ dàng tiếp cận và người dùng lâu năm có thể giải quyết các vấn đề phức tạp.
Với những ưu điểm vượt trội, Java đã trở thành lựa chọn lý tưởng cho nhiều dự án lớn nhỏ, từ hệ thống doanh nghiệp, ứng dụng thương mại điện tử, đến các ứng dụng quản lý như hệ thống thư viện, nhà hàng, và nhiều lĩnh vực khác.

1.5	Giới thiệu hệ quản trị cơ sở dữ liệu SQL Server:
 
Hình 1. 2 Giới thiệu hệ quản trị CSDL SQL Server
Microsoft SQL Server là một hệ quản trị cơ sở dữ liệu quan hệ được phát triển bởi Microsoft. Là một máy chủ cơ sở dữ liệu, nó là một sản phẩm phần mềm có chức năng chính là lưu trữ và truy xuất dữ liệu theo yêu cầu của các ứng dụng phần mềm khác. Có thể chạy trên cùng một máy tính hoặc trên một máy tính khác trên mạng (bao gồm cả Internet). SQL Server cung cấp cho người dùng các công cụ và tính năng để quản lý, lưu trữ, xử lý các truy vấn dữ liệu, kiểm soát truy cập, xử lý giao dịch và hỗ trợ tích hợp dữ liệu từ nhiều nguồn khác nhau. Ngoài ra, SQL Server cũng cung cấp các công cụ để tạo báo cáo, phân tích và quản lý cơ sở dữ liệu trực quan thông qua giao diện người dùng hoặc các script lệnh SQL. SQL Server được xây dựng dựa trên SQL, ngôn ngữ truy vấn mang tính cấu trúc để tương tác với cơ sở dữ liệu quan hệ. SQL Server được liên kết với Transact-SQL hoặc T-SQL, triển khai SQL của Microsoft có bổ sung một tập hợp các cấu trúc lập trình độc quyền.
SQL Server thường đi kèm với việc thực hiện riêng các ngôn ngữ SQL, T-SQL,... Cụ thể như sau: T-SQL là một trong những loại ngôn ngữ thuộc quyền sở hữu của Microsoft và được gọi với cái tên Transact-SQL. Nó thường cung cấp thêm rất nhiều cho các khả năng khai báo biến, thủ tục lưu trữ và xử lý ngoại lệ,... Microsoft SQL Server Management Studio (SSMS) là một ứng dụng phần mềm được Microsoft phát triển, được sử dụng để cấu hình, quản lý và điều hành tất cả các thành phần trong Microsoft SQL Server. Công cụ này bao gồm cả trình chỉnh sửa script và các công cụ đồ họa, hoạt động với các đối tượng và tính năng của máy chủ.
1.6	Các thư viện – framework hỗ trợ:
1.6.1	Apache Tomcat (phiên bản 10):
Apache Tomcat là một máy chủ ứng dụng mã nguồn mở được phát triển bởi Quỹ Apache, chuyên hỗ trợ chạy các ứng dụng web được xây dựng trên nền tảng Java. Tomcat tuân thủ các tiêu chuẩn Java Servlet, JavaServer Pages (JSP), và WebSocket, cho phép triển khai và quản lý các ứng dụng web động một cách hiệu quả và đáng tin cậy.

 
1.6.2	Java Database Connectivity (JDBC):
JDBC (Java Database Connectivity) là một API (Application Programming Interface) do Oracle phát triển, cho phép các ứng dụng Java kết nối và làm việc với cơ sở dữ liệu một cách dễ dàng. JDBC cung cấp các phương thức tiêu chuẩn để thực hiện các thao tác như gửi câu lệnh SQL, truy vấn dữ liệu, cập nhật dữ liệu và xử lý kết quả trả về từ cơ sở dữ liệu.
Là một phần của nền tảng Java, JDBC hỗ trợ kết nối với nhiều hệ quản trị cơ sở dữ liệu khác nhau như MySQL, SQL Server, Oracle, PostgreSQL, và nhiều hệ thống khác. Nó hoạt động như một cầu nối giữa ứng dụng Java và cơ sở dữ liệu, giúp lập trình viên tập trung phát triển logic ứng dụng mà không cần lo lắng về các chi tiết kỹ thuật của cơ sở dữ liệu cụ thể.
JDBC có các thành phần chính như Driver Manager, Connection, Statement, và ResultSet, cung cấp đầy đủ công cụ để thực hiện các thao tác từ kết nối cơ sở dữ liệu, gửi lệnh SQL, đến xử lý kết quả. Với tính linh hoạt và dễ sử dụng, JDBC là một trong những công nghệ quan trọng và được sử dụng rộng rãi trong phát triển ứng dụng Java có tích hợp cơ sở dữ liệu.
1.6.3	Spring Boot:
Spring Boot là một trong những thành viên của hệ sinh thái Spring framework. Nó giúp cho chúng ta đơn giản hóa công đoạn khởi tạo một dự án với Spring, thay vào đó các bạn chỉ tập trung vào việc phát triển business cho ứng dụng mà thôi. Dưới đây là một số ưu điểm của Spring Boot:
-	Tạo ứng dụng Spring độc lập, đóng gói dưới dạng một file JAR (stand- alone application).
-	Tối ưu công đoạn cấu hình cho ứng dụng Spring, không yêu cầu XML config…
-	Nhúng trực tiếp các ứng dụng server (Tomcat, Jetty…) do đó không cần phải triển khai file WAR
-	Cung cấp nhiều plugin.
-	Các starter dependency giúp việc cấu hình Maven đơn giản hơn.

 
CHƯƠNG 2. PHÂN TÍCH YÊU CẦU 
2.1	Hiện trạng thực tế:
Vào các kỳ thi hoặc thời gian cao điểm, số lượng bạn đọc tại thư viện tăng đột biến, dẫn đến tình trạng quá tải, thời gian chờ mượn sách lâu hơn bình thường. Nhiều tài liệu không có sẵn phải mượn từ thư viện liên kết, gây chậm trễ trong việc phục vụ. Ngoài ra, do khó dự đoán nhu cầu, thư viện đôi khi không có đủ sách cần thiết. Việc quản lý thủ công dễ dẫn đến sai sót, và quy trình xử lý mượn/trả sách chậm trễ khiến bạn đọc phải chờ lâu. Những vấn đề này ảnh hưởng đến trải nghiệm người dùng và hiệu quả hoạt động của thư viện.
2.2	Giải pháp nâng cao hiệu quả của quản lý thư viện:
Những vấn đề trên cho thấy cần có giải pháp nâng cao hiệu quả hoạt động của thư viện để phục vụ bạn đọc tốt hơn. Một trong những giải pháp quan trọng là ứng dụng công nghệ thông tin vào quản lý và vận hành trong phạm vi điều kiện cho phép. Dưới đây là một số vấn đề và giải pháp tương ứng:
Vấn đề	Giải pháp
Xử lý yêu cầu mượn/trả sách chậm, dễ sai sót	Sử dụng hệ thống trực tuyến để đăng ký và cập nhật trạng thái mượn/trả sách
Kiểm kê sách thủ công, dễ thiếu sót	Ứng dụng phần mềm quản lý kho sách giúp theo dõi tình trạng sách theo thời gian thực
Dự báo nhu cầu sách không chính xác	Phân tích dữ liệu mượn sách để dự đoán nhu cầu và lập kế hoạch bổ sung kịp thời

		Bảng 2.1 Các vấn đề và giải pháp nâng cao hiệu quả quản lý thư viện

Bảng trên đề xuất một hệ thống quản lý thư viện hiện đại, cho phép bạn đọc tra cứu và đặt mượn sách trực tuyến, giúp giảm thời gian chờ đợi. Hệ thống cũng tự động tổng hợp nhu cầu, hỗ trợ quản lý tài liệu hiệu quả hơn. Việc thanh toán phí trễ hạn hay mượn liên thư viện có thể thực hiện nhanh chóng qua hệ thống, giảm công việc thủ công cho nhân viên. Ngoài ra, dữ liệu được thu thập hàng ngày giúp phân tích xu hướng mượn sách, từ đó thư viện có thể dự báo nhu cầu, tối ưu hóa kho tài liệu và phân bổ nhân sự hợp lý. Những cải tiến này không chỉ nâng cao chất lượng phục vụ mà còn giúp thư viện hoạt động hiệu quả và khoa học hơn.

2.3	Xây dựng bản đặc tả yêu cầu hệ thống:
2.3.1	Mục tiêu hệ thống:
Hệ thống được xây dựng nhằm cung cấp giải pháp quản lý thư viện hiện đại, giúp:
•	Tăng cường hiệu quả quản lý sách và độc giả.
•	Tối ưu hóa quy trình mượn/trả sách.
•	Cung cấp các chức năng tìm kiếm và gợi ý sách một cách nhanh chóng, chính xác.
•	Đảm bảo quyền truy cập và phân quyền giữa người quản lý và người dùng.
2.3.2	Phạm vi hệ thống:
•	 Người dùng chính:
1.	Quản lý: Nhân viên thư viện có toàn quyền truy cập và chỉnh sửa dữ liệu.
2.	Người dùng (User): Độc giả với quyền hạn giới hạn để mượn sách, tìm kiếm sách.
•	Các chức năng chính:
1.	Quản lý (Admin):
	Đăng nhập.
	Quản lý sách (thêm, sửa, xóa thông tin sách).
	Xử lý mượn/trả sách.
	Tìm kiếm sách theo tên sách, tác giả.
2.	Người dùng (User):
	Đăng nhập.
	Tìm kiếm sách (tên sách, tác giả).
	Lọc sách theo năm phát hành.
	Mượn sách (tối đa 3 quyển).
	Xem danh sách sách thịnh hành (Top 10).
2.3.3	Chức năng hệ thống:
2.3.3.1	 Chức năng Quản lý(admin):
1.	Đăng nhập:
•	Nhập tên tài khoản và mật khẩu.
•	Xác thực và phân quyền.
2.	Quản lý sách:
•	Thêm sách mới: Nhập thông tin sách (tên, tác giả, năm xuất bản, số lượng).
•	Sửa thông tin sách: Cập nhật thông tin sách hiện tại.
•	Xóa sách: Gỡ bỏ sách khỏi hệ thống.
3.	Xử lý mượn/trả sách:
•	Xác nhận yêu cầu mượn sách từ người dùng.
•	Cập nhật trạng thái trả sách.
4.	Tìm kiếm sách:
•	Tìm kiếm sách theo tên hoặc tác giả.
2.3.3.2	Chức năng Người dùng(user)
1.	Đăng nhập:
•	Nhập tên tài khoản và mật khẩu.
•	Hệ thống xác thực quyền truy cập.
2.	Tìm kiếm sách:
•	Tìm kiếm sách theo tên sách hoặc tác giả.
3.	Lọc sách:
•	Lọc danh sách sách theo năm phát hành.
4.	Mượn sách:
•	Đặt mượn tối đa 3 quyển sách trong cùng thời điểm.
5.	Sách thịnh hành:
•	Xem danh sách Top 10 sách được mượn nhiều nhất.
2.4	 Mô tả các quy trình nghiệp vụ :
2.4.1	Sơ đồ cơ cấu tổ chức : 
 
Sơ đồ 2.1 Sơ đồ cơ cấu tổ chức quản lý thư viện
2.4.2	Quy trình nghiệp vụ :
1. Đăng nhập:
1.1 Người dùng/Quản lý nhập thông tin tài khoản.
1.2 Hệ thống kiểm tra tính hợp lệ của thông tin và phân quyền.
2. Tìm kiếm sách:
2.1 Người dùng/Quản lý nhập từ khóa tìm kiếm (tên sách/tác giả).
2.2 Hệ thống trả về danh sách kết quả phù hợp.
3. Mượn sách:
3.1 Người dùng chọn sách và gửi yêu cầu mượn.
3.2 Quản lý xác nhận yêu cầu mượn và cập nhật số lượng sách.
4. Trả sách:
4.1 Người dùng trả sách tại thư viện.
4.1 Quản lý cập nhật trạng thái trả sách trên hệ thống.
5. Lọc sách theo năm phát hành:
5.1 Người dùng nhập năm phát hành.
5.2 Hệ thống hiển thị danh sách sách phù hợp.
6. Xem Top 10 sách thịnh hành:
6.1 Người dùng truy cập mục sách thịnh hành.
6.2 Hệ thống hiển thị danh sách 10 cuốn sách được mượn nhiều nhất.
 
CHƯƠNG 3. PHÂN TÍCH VÀ THIẾT KẾ HỆ THỐNG
3.1 Sơ đồ phân cấp chức năng:
 
Sơ đồ 3.1 Sơ đồ phân rã chức năng mức đỉnh
3.1.1 Sơ đồ phân cấp chức năng mức đỉnh:
Hệ thống nghiệp vụ được xét gồm các chức năng chính: Quản lý Kho Sách, Quản lý mượn trả, Quản lý độc giả, Thống kê, Mượn sách, Trả sách, Tìm kiếm sách, Xem thông tin tài khoản. Mỗi chức này được phân rã thành một số chức năng nhỏ hơn mà thao tác thực hiện nó đủ đơn giản cho việc lập trình.
3.1.2 Sơ đồ phân rã chức năng:
3.1.2.1 Quản lý kho sách:
Mô tả chi tiết các chức năng :

 
Sơ đồ 3.2 Sơ đồ phân rã quản lý sách

•	Cập nhật sách: Thủ thư sẽ thực hiện những việc như thêm, sửa, xóa các thông tin về sách (Tên, Tác giả, Năm xuất bản,…). 
•	Phân loại sách: Sách được phân loại ra dựa theo tên tác giả hay thể loại.
•	Tìm kiếm sách: Tìm những thông tin liên qua tới sách như tên, tác giả , thể loại ….

3.1.2.2 Quản lý mượn trả sách :
Mô tả chi tiết chức năng:
 
Sơ đồ 3.3 Sơ đồ phân rã quản lý mượn trả sách
•	Xác nhận mượn sách: Khi độc giả muốn mượn sách thì thủ thư sẽ xác định thông tin của độc giả dựa trên chứng minh thư và đối chiếu với thông tin trong tài khoản của độc giả trên hệ thống bằng chức năng tìm kiếm độc giả.
•	Xác nhận trả sách: Khi độc giả trả sách thì thủ thư sẽ kiểm tra xem độc giả có trả quá hạn hay là sách có bị hư hỏng hay không nếu có thì sẽ bị tính phí phạt dựa theo số ngày quá hạn.
•	Quản lý thời hạn mượn: Thời gian được tính từ khi sách được mượn tới khi sách được trả.
•	Phạt khi trả sách trễ: Đối chiếu theo thời gian mượn trả ở chức năng quản lý thời hạn mượn nếu vượt quá 7 ngày độc giả sẽ phải nộp phí trả sách trễ giữa trên số ngày nộp trễ.
3.1.2.3 Quản lý độc giả :
Mô tả chi tiết chức năng:
 
Sơ đồ 3.4 Sơ đồ phân rã quản lý độc giả
•	Thông tin tài khoản: Hiện thị các thông tin cá nhân và trạng thái mượn trả của độc giả.
•	Tìm kiếm độc giả: Tìm kiếm các thông tin như tên và chứng minh thư của độc giả để hiện thị các thông tin liên quan tới độc giả cần tìm. 
•	Cập nhật danh sách độc giả: Dùng để kiểm tra trạng thái tài khoản của độc giả, có vi phạm chính sách mượn trả hay không. Giúp đề xuất các loại sách phù hợp với độc giả.
3.1.2.4 Thống kê :
Mô tả chi tiết các chức năng:


 
Sơ đồ 3.5 Sơ đồ phân rã thống kê
•	Báo cáo số lượng sách: Kiểm kê số lượng sách, giảm thiểu khả năng thiếu sách. Hỗ trợ cho việc sách và bảo trì sách kịp thời.
•	Độc giả mượn nhiều nhất: Hỗ trợ việc nhập thêm đầu sách nào dựa trên nhóm độc giả mượn nhiều nhất, khuyến khích việc đọc.
3.1.2.5 Chức năng mượn sách:
Mô tả chi tiết các chức năng :
 
Sơ đồ 3.6 Sơ đồ phân rã chức năng mượn sách
•	Chọn sách muốn mượn: Chức năng này hỗ trợ người dùng chọn sách muốn mượn.
•	Xác nhận mượn sách: Giúp cho người dùng xác định đúng sách muốn mượn. 
•	Gửi yêu cầu mượn sách: Người dùng sẽ gửi một yêu cầu mượn sách về thủ thư nếu người dùng không có vi phạm thì sẽ được duyệt còn nếu có thì sẽ bị từ chối.

3.1.2.6 Chức năng trả sách:
Mô tả chi tiết chức năng:
 
Sơ đồ 3.7 Sơ đồ phân rã chức năng trả sách

•	Chọn sách muốn trả: Cho phép độc giả chọn sách mìn muốn trả từ danh sách đang mượn. 
•	Gửi yêu cầu trả sách: Khi độc giả gửi yêu cầu trả sách thì bên phía thủ thư sẽ kiểm tra xem sách có bị tổn hại gì hay không và người dùng có mượn vượt quá thời gian qui định hay không. 
•	Xử lý phạt: Người dùng sẽ chỉ thực hiện chức năng này khi vi phạm qui định của thư viện.
3.1.2.7 Chức năng tìm kiếm sách :
Mô tả chi tiết chức năng:
 
Sơ đồ 3.8 Sơ đồ phân rã chức năng tìm kiếm sách
•	Xem thông tin sách: Cho phép người dùng xem thông tin mà họ vừa tìm kiếm. 
•	Kiểm tra sách còn hay hết: Giúp người dùng xác nhận là sách này còn trong kho hay không để tiến hành việc mượn sách.

3.1.2.8 Chức năng xem thông tin tài khoản :
Mô tả chi tiết các chức năng:
 
Sơ đồ 3.9 Sơ đồ chức năng xem thông tin tài khoản
•	Xem lịch sử mượn: Cho phép người dùng kiểm tra xem mình đã mượn những cuốn sách nào và kiểm tra thời gian mượn của chúng.
•	Thông tin độc giả: Cho người dùng xem thông tin cá nhân và chỉnh sửa thông tin nếu cần thiết.
•	Chỉnh sửa thông tin tài khoản: Chỉnh sửa những thông tin cá nhân của tài khoản.

3.2 Mô hình luồng dữ liệu DFD (Data Flow Diagram) 
3.2.1 Biểu đồ DFD mức ngữ cảnh:
 
Sơ đồ 3.10 Biểu đồ DFD mức ngữ cảnh

3.2.2 Mô hình luồng dữ liệu DFD phân rã cấp 0 (chức năng chính):

 
Sơ đồ 3.11 Biểu đồ DFD phân rã cấp 0

3.3	 Mô hình usecase:
3.3.1	Xác định Actor:
Dựa vào yêu cầu của bài toán, ta có các actor: Quản lý và độc giả 
3.3.2	Xác định các Use Case:
Từ yêu cầu chức năng ứng với từng actor ta có thể xác định được các use case như sau:

Actor	Use Case

Quản lý	Đăng nhập/Đăng ký, Thêm sách, Cập nhật sách, Xóa sách, Quản lý tài khoản độc giả, Quản lý Mượn / Trả sách, …

Độc giả 	Đăng nhập/đăng ký, Tìm kiếm sách, Xem sách, Mượn sách, Gia hạn, Trả sách, …

Bảng 3.1 Xác định các use case
3.3.3	Xây dựng biểu đồ Use Case tổng quát:
	Biểu đồ use case tổng quát dành cho quản lý:
 
Sơ đồ 3.12 Biểu đồ usecase cho Quản lý

	Biểu đồ use case tổng quát dành cho độc giả:
 
	Sơ đồ 3.13 Biểu đồ usecase cho độc giả

3.3.4 Đặc tả Use Case
3.3.4.1	 Thao tác dành cho Quản lý
a. Thêm sách vào kho: 
Mô tả: Quản lý có thể thêm sách mới vào hệ thống bằng cách nhập các thông tin như tên sách, tác giả, thể loại, số lượng và vị trí lưu trữ.
Đặc tả: 
Precondition:
-	Quản lý đã đăng nhập vào hệ thống.
-	Quản lý chọn Thêm 1 sách / Thêm bằng file Excel.
Dòng sự kiện chính:
1.	Quản lý chọn chức năng "Thêm sách".
2.	Hệ thống hiển thị giao diện chọn cách thêm sách.
3.	Nếu quản lý chọn Thêm 1 sách : hệ thống hiện trang nhập thông tin sách.
4.	Sau khi quản lý nhập thông tin, hệ thống kiểm tra tính hợp lệ và lưu vào cơ sở dữ liệu.
5.	Nếu quản lý chọn Thêm bằng Excel : hệ thống hiện trang chọn file Excel chứa nhiều sách.
6.	Sau khi chọn file, hệ thống kiểm tra tính hợp lệ và lưu vào cơ sở dữ liệu.
Dòng sự kiện mở rộng:
•	Nếu thông tin nhập không hợp lệ, hệ thống yêu cầu nhập lại.
•	Nếu lưu dữ liệu thất bại, hiển thị thông báo lỗi.
Poscondition:
•	Sách được thêm vào hệ thống và có thể tìm kiếm.
b. Cập nhật sách:
Tên Use Case: Cập nhật sách
Mô tả: Quản lý có thể cập nhật thông tin sách đã có trong hệ thống.
Actor liên quan: Quản lý
Precondition:
•	Quản lý đã đăng nhập vào hệ thống.
•	Sách cần cập nhật tồn tại trong hệ thống.
Dòng sự kiện chính:
1.	Quản lý chọn sách cần cập nhật.
2.	Quản lý chọn chức năng "Sửa" ở cột sau cùng của mỗi cuốn sách.
3.	Hệ thống hiển thị thông tin sách.
4.	Quản lý sửa đổi thông tin sách.
5.	Hệ thống kiểm tra tính hợp lệ và lưu thông tin mới.
6.	Hệ thống hiển thị thông báo cập nhật thành công.
Dòng sự kiện mở rộng:
•	Nếu thông tin không hợp lệ, hệ thống yêu cầu nhập lại.
Poscondition:
•	Thông tin sách được cập nhật thành công.
c.Xóa sách
Tên Use Case: Xóa sách
Mô tả: Quản lý có thể xóa sách không còn sử dụng khỏi hệ thống.
Actor liên quan: Quản lý
Precondition:
•	Quản lý đã đăng nhập vào hệ thống.
•	Sách không có ai đang mượn.
Dòng sự kiện chính:
1.	Quản lý chọn sách cần xóa.
2.	Quản lý chọn chức năng "Xóa" ở cột sau cùng của mỗi cuốn sách.
3.	Hệ thống hiển thị hộp thoại xác nhận.
4.	Quản lý xác nhận xóa sách.
5.	Hệ thống xóa sách khỏi cơ sở dữ liệu và hiển thị thông báo thành công.
Dòng sự kiện mở rộng:
•	Nếu sách đang có người mượn, hệ thống hiển thị thông báo không thể xóa.
Poscondition:
•	Sách không còn tồn tại trong hệ thống.
d. Quản lý mượn/trả sách
Tên Use Case: Quản lý mượn/trả sách
Mô tả: Quản lý có thể xem yêu cầu mượn sách của độc giả và xác nhận hoặc từ chối, cũng như theo dõi việc trả sách.
Actor liên quan: Quản lý
Precondition:
•	Quản lý đã đăng nhập vào hệ thống.
Dòng sự kiện chính:
1.	Quản lý xem danh sách yêu cầu mượn sách.
2.	Quản lý phê duyệt hoặc từ chối yêu cầu.
3.	Hệ thống cập nhật trạng thái mượn sách.
4.	Khi độc giả trả sách, quản lý kiểm tra tình trạng sách.
5.	Hệ thống cập nhật kho sách.
Dòng sự kiện mở rộng:
•	Nếu sách bị hư hỏng hay trả sách quá hạn hệ thống áp dụng phí phạt.
Poscondition:
•	Hệ thống cập nhật trạng thái mượn/trả sách thành công.
3.3.4.2	 Thao tác dành cho Độc giả
a.Tìm kiếm sách
Tên Use Case: Tìm kiếm sách
Mô tả: Độc giả có thể tìm kiếm sách theo tên, tác giả, thể loại hoặc các tiêu chí khác.
Actor liên quan: Độc giả
Precondition:
•	Độc giả đã đăng nhập vào hệ thống.
Dòng sự kiện chính:
1.	Độc giả nhập từ khóa tìm kiếm.
2.	Hệ thống hiển thị danh sách sách phù hợp.
3.	Độc giả chọn sách để xem chi tiết.
Dòng sự kiện mở rộng:
•	Nếu không có sách phù hợp, hệ thống hiển thị thông báo không tìm thấy.
Poscondition:
•	Độc giả có thể xem thông tin sách.
b.Mượn sách
Tên Use Case: Mượn sách
Mô tả: Độc giả có thể chọn sách và gửi yêu cầu mượn sách đến quản lý.
Actor liên quan: Độc giả
Precondition:
•	Độc giả đã đăng nhập vào hệ thống.
•	Sách còn trong kho.
Dòng sự kiện chính:
1.	Độc giả chọn sách muốn mượn.
2.	Hệ thống hiển thị thông tin sách.
3.	Độc giả gửi yêu cầu mượn sách.
4.	Hệ thống lưu yêu cầu vào hệ thống và chờ quản lý phê duyệt.
Dòng sự kiện mở rộng:
•	Nếu sách hết, hệ thống thông báo không thể mượn.
Poscondition:
•	Yêu cầu mượn được ghi nhận vào hệ thống.
c.Trả sách
Tên Use Case: Trả sách
Mô tả: Độc giả có thể trả sách sau khi mượn.
Actor liên quan: Độc giả
Precondition:
•	Độc giả đã đăng nhập vào hệ thống.
•	Sách đang trong trạng thái đã mượn.
Dòng sự kiện chính:
1.	Độc giả chọn chức năng "Trả sách".
2.	Hệ thống hiển thị danh sách sách đang mượn.
3.	Độc giả chọn sách cần trả.
4.	Hệ thống cập nhật trạng thái sách và thông báo trả thành công.
Dòng sự kiện mở rộng:
•	Nếu sách bị hư hỏng, mất hoặc trả quá hạn, hệ thống tính phí phạt.
Poscondition:
•	Hệ thống cập nhật trạng thái sách thành "Có sẵn" trong kho.
d.Xem thông tin độc giả
Tên Use Case: Xem thông tin độc giả
Mô tả: Chức năng cho phép độc giả xem thông tin cá nhân, bao gồm họ tên, mã độc giả, số sách đã mượn, lịch sử mượn/trả sách, trạng thái tài khoản (còn hiệu lực hay bị khóa).
Actor liên quan: Độc giả 
Precondition:
•	Độc giả đã đăng nhập vào hệ thống.
•	Tài khoản của độc giả phải còn hiệu lực.
Dòng sự kiện chính:
1.	Độc giả chọn chức năng "Xem thông tin tài khoản" trên giao diện hệ thống.
2.	Hệ thống hiển thị thông tin tài khoản của độc giả:
o	Họ tên
o	Mã độc giả
o	Số sách đã mượn
o	Lịch sử mượn/trả sách
o	Trạng thái tài khoản
3.	Độc giả có thể kiểm tra thông tin và thoát khỏi màn hình.
Dòng sự kiện khác:
•	Nếu tài khoản bị khóa, hệ thống hiển thị thông báo: "Tài khoản của bạn đã bị khóa, vui lòng liên hệ quản lý thư viện."
Poscondition:
•	Hệ thống hiển thị đúng thông tin tài khoản của độc giả.
Mở rộng
•	Độc giả có thể chọn "Đổi mật khẩu" từ màn hình này.
•	Độc giả có thể yêu cầu cập nhật thông tin cá nhân 
3.3.5	Biểu đồ tuần tự tương ứng với các Use Case:
➢ Use case đăng nhập (Admin và User):

 
Sơ đồ 3.14 Biểu đồ usecase Đăng nhập

Biểu đồ trình tự đăng nhập:

 
Sơ đồ 3.15 Biểu đồ trình tự Đăng nhập
➢ Use case tìm kiếm:

 
Sơ đồ 3.16 Biểu đồ usecase Tìm kiếm

Biểu đồ trình tự tìm kiếm:

 
Sơ đồ 3.16 Biểu đồ trình tự Tìm kiếm

➢ Use case mượn sách:
 
Sơ đồ 3.17 Biểu đồ usecase Mượn sách



Biểu đồ trình tự mượn sách:

 
Sơ đồ 3.18 Biểu đồ trình tự Mượn sách
➢ Use case trả sách:

 
Sơ đồ 3.19 Biểu đồ usecase Trả sách

Biểu đồ trình tự trả sách:

 
Sơ đồ 3.20 Biểu đồ trình tự Trả sách


➢ Use case xem thống kê:

 
Sơ đồ 3.21 Biểu đồ usecase Thống kê

Biểu đồ trình tự xem thống kê:

 
Sơ đồ 3.22 Biểu đồ trình tự Thống kê
➢ Use case thêm sách:

 
Sơ đồ 3.23 Biểu đồ usecase Thêm sách
Biểu đồ trình tự thêm sách:

 
Sơ đồ 3.24 Biểu đồ trình tự Thêm sách

➢ Use case cập nhật sách:

 
Sơ đồ 3.25 Biểu đồ usecase Cập nhật sách

Biểu đồ trình tự cập nhật sách:

 
Sơ đồ 3.26 Biểu đồ trình tự Cập nhật sách



➢ Use case xóa sách:
 
Sơ đồ 3.27 Biểu đồ usecase Xóa sách

Biểu đồ trình tự xóa sách:
 
Sơ đồ 3.28 Biểu đồ trình tự Xóa sách

➢ Use case xem thông tin:

 
Sơ đồ 3.29 Biểu đồ usecase Xem thông tin

Biểu đồ trình tự xem thông tin:

 
Sơ đồ 3.30 Biểu đồ trình tự Xem thông tin

3.4 Xác định thực thể:
-	Users (user_id, cmt, name, phone, email, username, password, status, role)
-	Book (book_id, book_name, book_image, author_id, category_id, amount, publish_year) 
-	Author (author_id, author_name)
-	Book_Author(author_id, book_id)
-	Category (category_id, category_name)
-	Borrow_Return (id, book_id, user_id, start_date, end_date, status, renew_count)
-	Import_Details(amount, book_id, detail_id, invoice_id)
-	Import_Invoice(import_date, invoice_id)
-	Notifications(id, is_read, created_at, user_id, message, type)
-	Password_Reset (created_at, expired_at, id, email, otp)

3.5 Mô hình ERD:

 

Sơ đồ 3.31 Mô hình  ERD

3.6 Mô hình cơ sở dữ liệu quan hệ: 
Quy ước : Primary Key: (gạch chân) MABP ; Foreign Key: (in đậm) MABP ; PK_FK: (vừa thuộc khóa chính, vừa là khóa ngoại, gạch chân): MABP, MAHP	

-	Users(user_id, cmt, name, phone, email, username, password, status, role, borrow_count, violation_count)
-	Book(book_id, book_name, book_image, author_id, category_id, amount, publish_year, borrow_count, is_deleted)
-	Author(author_id, author_name)
-	Book_Author(author_id, book_id)
-	Category(category_id, category_name)
-	Borrow_Return(id, book_id, user_id, start_date, end_date, user_confirm_date, status, renew_count)  
-	Import_Details(amount, book_id, detail_id, invoice_id)
-	Import_Invoice(inport_date, invoice_id)
-	Notifications(id, is_read, created_at, user_id, message, type)
-	Password_Reset (created_at, expired_at, id, email, otp)
•	Thực thể Users: Thông tin Admin / User

Stt	Thuộc tính	Mô tả	Kiểu dữ liệu	Khóa	Not Null
1	user_id	Id người dùng	bigint 	Khóa chính	X
2	cmt	Chứng minh thư	varchar(12) 		X
3	name	Họ tên	nvarchar(50)		X
4	phone	Số điện thoại	char(10)		X
5	email	Email 	varchar(30)		X
6	username	Tên tài khoản	varchar(30)		X
7	password	Mật khẩu	varchar(30)		X
8	status 	Trạng thái	nvarchar(20) 		X
9
	role	Quyền hạn	varchar(20) 		X


10	borrow_count 	Số lần mượn	int		X

11	violation_count  	Số lần vi phạm 
	int 		X
Bảng 3.2 Bảng thực thể Users








•	Thực thể Book: Thông tin sách

Stt	Thuộc tính	Mô tả	Kiểu dữ liệu	Khóa	Not Null
1	book_id	Id sách	bigint 	Khóa chính	X
2	book_name	Tên sách	nvarchar(50)		X
3	book_image 	Ảnh sách	varbinary(max)		X
3	author_id	Id Tác giả	bigint  	Khóa ngoại	X
4	category_id	Id thể loại	bigint  	Khóa ngoại	X
5	amount  	Số lượng 	int 		X
6	publish_year	Năm xuất bản	int 		X
7	borrow_count  	Số lần mượn	int 		X
8	is_deleted 	Trạng thái sách	bit   		X
Bảng 3.3 Bảng thực thể Book


Thực thể Book_Author:

Stt	Thuộc tính	Mô tả	Kiểu dữ liệu	Khóa	Not Null
1	author_id 	Id tác giả	bigint  	Khóa ngoại	X
2	book_id  	Id sách	bigint 	Khóa ngoại	X
Bảng 3.4 Bảng thực thể Book_Author
 
Thực thể Author: Thông tin tác giả

Stt	Thuộc tính	Mô tả	Kiểu dữ liệu	Khóa	Not Null
1	author_id 	Id tác giả	bigint  	Khóa chính	X
2	author_name 	Tên tác giả	nvarchar(50)		X
Bảng 3.5 Bảng thực thể Author

•	Thực thể Category: Thông tin thể loại

Stt	Thuộc tính	Mô tả	Kiểu dữ liệu	Khóa	Not Null
1	category_id	Id thể loại	bigint 	Khóa chính	X
2	category_name	Tên thể loại	nvarchar(50)		X
Bảng 3.6 Bảng thực thể Category

•	Thực thể Borrow_Return: Thông tin mượn / trả sách

Stt	Thuộc tính	Mô tả	Kiểu dữ liệu	Khóa	Not Null
1	book_id 	Id sách	bigint 	Khóa ngoại	X
2	user_id 	Id người dùng	bigint 	Khóa ngoại	X
3	start_date  	Ngày mượn	datetime 		X
4	end_date 	Ngày trả	datetime 		
5	status  	Trạng thái 	nvarchar(20) 		X
6	renew_count 	Gia hạn	int		X
7	id 	Id mượn/trả	bigint 	Khóa chính	X
8	user_confirm_date	Ngày xác nhận mượn	datetime  		X
Bảng 3.7 Bảng thực thể Borrow_Return







•	Thực thể Import_Details: Thông tin chi tiết nhập hàng

Stt	Thuộc tính	Mô tả	Kiểu dữ liệu	Khóa	Not Null
1	amount  	Số lượng sách được nhập	int  		X
2	book_id  	Id sách	bigint 	Khóa ngoại	X
3	id  	Id	bigint  	Khóa chính	X
4	invoice_id  	Id phiếu nhập hàng	varchar(255)  	Khóa ngoại	X
Bảng 3.8 Bảng thực thể Import_Details

•	Thực thể Import_Invoice: Thông tin ngày nhập hàng

Stt	Thuộc tính	Mô tả	Kiểu dữ liệu	Khóa	Not Null
1	import_date 	Ngày nhập hàng	date		X
2	invoice_id	Id phiếu nhập hàng	bigint 	Khóa chính	X
Bảng 3.9 Bảng thực thể Import_Invoice

•	Thực thể Notifications: Bảng dữ liệu lưu thông báo

Stt	Thuộc tính	Mô tả	Kiểu dữ liệu	Khóa	Not Null
1	id 	Id 	int  	Khóa chính	X
2	is_read 	Xác nhận thông báo được đọc	bit 		X
3	created_at  	Thời gian thông báo được tạo	datetime2(6)		
4	user_id 	Id độc giả	bigint  	Khóa ngoại	X
5	message 	Thông báo	nvarchar(255)  		
6	type 	Loại thông báo 	nvarchar(50) 		
Bảng 3.10 Bảng thực thể Notification





•	Thực thể Password_Reset: Thông tin khi thao tác quên mật khẩu

Stt	Thuộc tính	Mô tả	Kiểu dữ liệu	Khóa	Not Null
1	created_at 	Thời điểm tạo mã OTP	datetime2(6) 		
2	expired_at 	Thời điểm mã hết hạn (5 phút)	datetime2(6) 		
3	id  	Id 	bigint 	Khóa chính	X
4	email  	Email người dùng	varchar(255)  		X
5	otp    	Mã OTP 	varchar(255)  		
Bảng 3.11 Bảng thực thể Password_Reset

3.7 Mô hình dữ liệu :
3.7.1 Xét Users – Borrow_Return :
Mỗi người dùng có thể mượn / trả nhiều sách, mỗi sách chỉ được mượn / trả bởi một người dùng

 
Sơ đồ 3.32 Mô hình  Users – Borrow_Return

3.7.2 Xét Borrow_Return – Book :
Mỗi sách có thể được mượn / trả  nhiều lần bởi người dùng.

 
Sơ đồ 3.33 Mô hình  Borrow_Return - Book

3.7.3 Xét Author – Book :
Mỗi tác giả có thể viết được nhiều sách, mỗi sách chỉ thuộc về một tác giả

 
Sơ đồ 3.34 Mô hình  Author - Book

3.7.4 Xét Category – Book :
Mỗi thể loại có thể chứa nhiều sách, mỗi sách chỉ thuộc một thể loại

 
Sơ đồ 3.35 Mô hình  Category – Book

3.7.5 Xét Users – Notifications
Mỗi người dùng có thể có nhiều thông báo, mỗi thông báo chỉ báo cho một người dùng
 
Sơ đồ 3.36 Mô hình Users – Notification

3.7.6 Xét Users - Import_Invoice
Mỗi người dùng có thể có nhiều thông tin ngày nhập hàng, mỗi thông tin ngày nhập hàng chỉ thuộc về một người dùng
 
Sơ đồ 3.37 Mô hình Users – Import_Invoice

3.7.7 Xét Import_Invoice - Import_Details
Mỗi thông tin ngày nhập hàng có một thông tin nhập hàng chi tiết, mỗi thông tin nhập hàng chi tiết có một thông tin ngày nhập hàng
 
Sơ đồ 3.38 Mô hình Import_Invoice - Import_Details
3.7.8 Xét Book -  Import_Details
Mỗi sách có thể có nhiều thông tin chi tiết nhập hàng, mỗi thông tin chi tiết nhập hàng chỉ thuộc về một sách
 
Sơ đồ 3.39 Mô hình Book -  Import_Details
3.8 Phân tích và hoàn thiện mô hình quan hệ:

 
Sơ đồ 3.40 Mô hình diagrams

CHƯƠNG 4. THIẾT KẾ TÀI LIỆU
4.1 Thiết kế khái quát :
4.1.1 Độc giả :
-	Đăng nhập
-	Đăng ký
-	Nhập email khôi phục tài khoản
-	Nhập mã OTP và mật khẩu mới
-	Trang chủ
-	Sách mới nhất
-	Sách mượn nhiều nhất
-	Sách theo chủ đề
-	Trang thông tin sách
-	Tài khoản
-	Hộp thoại chỉnh sửa tài khoản
 4.1.2 Admin :
-	Admin_Signin
-	Admin_Main
-	Admin_Danh sách thư viện
-	Admin_Sửa sách
-	Admin_Xóa sách
-	Admin_Danh sách nhập hàng
-	Admin_Thêm sách
-	Admin_Thêm 1 sách
-	Admin_Thêm sách bằng Excel
-	Admin_Danh sách độc giả
-	Admin_Khóa tài khoản
-	Admin_Lịch sử mượn trả
-	Admin_Danh sách vi phạm
-	Admin_Báo cáo số lượng sách
-	Admin_Báo cáo tổng số lượng sách
-	Admin_Tổng số sách đang mượn
-	Admin_Tổng số sách sẵn sàng
-	Admin_Tổng số sách bị hư hại
-	Admin_Độc giả mượn nhiều nhất
4.2 Thiết kế chi tiết :
-	Sách theo chủ đề
-	Tài khoản
-	Admin_Lịch sử mượn trả
4.3 Chi tiết các thiết kế :
-	Chi tiết xem file thiết kế tài liệu

CHƯƠNG 5. ỨNG DỤNG WEB APPLICATION
5.1 Yêu cầu hệ thống:
-	Hệ quản trị cơ sở dữ liệu: SQL Server.
-	Công cụ lập trình: Eclipse.
-	Trình duyệt web: Chrome, Internet Explorer, Brave, …

5.2 Demo giao diện dành cho Độc giả:

5.2.1 Giao diện Danh sách thư viện và Thông tin sách :

 
 

Hình 5.1 Danh sách thư viện (Phần trên) 



 

Hình 5.2 Danh sách thư viện (Phần dưới) 

Hình trên là trang hiển thị các sách trong thư viện khi người dùng click vào Danh sách thư viện ở thanh menu phía trên hoặc click vào ô Sách theo theo chủ đề ở ngoài Trang chủ. Danh sách được phân trang với số trang được hiện ở cuối danh sách. Người dùng có thể click vào để qua trang tiếp theo :

 

Hình 5.3 Danh sách thư viện (Trang 2)

Bên trái màn hình hiện danh sách tên các chủ đề và thông tin các năm giúp người dùng chọn lọc sách theo ý muốn (ví dụ : chọn chủ đề ‘Lịch sử’ và chọn khoảng thời gian ‘1990 – 2004’) :
 

Hình 5.4 Lọc sách theo danh mục


Trường hợp chủ đề hoặc khoảng thời gian người dùng chọn chưa có sách thì hiện thông báo như sau:

 

Hình 5.5 Trường hợp không có sách






Người dùng có thể click Xem sách ở từng ô hiện sách để xem thông tin chi tiết của sách đó:

 
Hình 5.6 Thông tin chi tiết sách

Trang này hiển thị các thông tin như tên tác giả, thể loại, năm xuất bản và số lượng sách hiện tại sẵn sàng cho mượn. Phía dưới là danh sách sách cùng tác giả, đề xuất cho người dùng. Trường hợp không có thông tin sách được đề xuất, trang được hiển thị như sau:


 

Hình 5.7 Thông báo cho sách đề xuất

Trường hợp số lượng sách sẵn sàng cho mượn đã hết, hệ thống hiện thông báo cho người dùng nếu click mượn sách đó :

 

Hình 5.8 Thông báo hết sách cho mượn


5.2.2 Giao diện Tài khoản :
Đây là trang hiển thị thông tin cá nhân của độc giả như tên tài khoản, họ tên, số điện thoại và email. Người dùng có thể truy cập trang bằng cách click mục Tài khoản ở trên thanh menu, và chỉ xem được trang khi đã đăng nhập. Nếu chưa đăng nhập, hệ thống sẽ chuyển sang trang đăng nhập : 

 

Hình 5.9 Trang đăng nhập

Trường hợp đã đăng nhập, hệ thống sẽ hiển thị cho người dùng :

 

Hình 5.10 Trang đăng nhập

Bên trái của trang hiển thị thông tin cá nhân, người dùng có thể thay đổi thông tin hiện tại bằng cách click nút thay đổi phía dưới. Sau khi click trang sẽ pop-up một form được điền sẵn thông tin cho người dùng thao tác. (Lưu ý : người dùng không được phép đổi tên tài khoản) :

 

Hình 5.11 Form sửa thông tin

Sau khi người dùng đổi thông tin (nếu có), click nút Lưu để cập nhật dữ liệu mới vào hệ thống hoặc click Hủy để tắt form. Hệ thống sẽ kiểm tra định dạng thông tin trước khi lưu. Nếu có lỗi, hệ thống sẽ hiện các thông báo cho người dùng. Nếu không có lỗi, hệ thống cập nhật dữ liệu mới thành công :

 		  	

Hình 5.12 Thông báo sai định dạng	Hình 5.13 Thay đổi thành công






Bên phải phần giao diện chính là mục Lưu ý dành cho người dùng và bảng lịch sử mượn/trả. Tại đây người dùng sẽ thực hiện Xác nhận mượn sau khi click Mượn sách ở trang chi tiết. Thao tác này sẽ thông báo cho thư viện giữ sách cho người dùng trong thời gian có hạn cho đến khi người dùng nhận sách trực tiếp. Người dùng có thể hủy mượn sách, với điều kiện là chưa nhận sách. Ngoài ra, người dùng có thể gia hạn thời gian mượn sách với số lần cho phép và tìm kiếm sách theo trạng thái ở vùng tìm kiếm.

Sau khi click Xác nhận mượn, hệ thống sẽ cập nhật thời gian thực :

 

Hình 5.14 Cập nhật Ngày xác nhận mượn

Mỗi người dùng chỉ được mượn tối đa 3 quyển sách. Trường hợp mượn quá số lần cho phép, hệ thống hiện thông báo cho người dùng :

 

Hình 5.15 Thông báo mượn quá số lần cho phép

Người dùng có thể click hủy để ngừng quá trình mượn sách (Lưu ý : chỉ được hủy khi chưa nhận sách, khi hệ thống cập nhật thời gian Ngày mượn, nút hủy sẽ biến mất) :

 

Hình 5.16 Thao tác hủy (2 trường hợp)

Sau khi người dùng nhận sách, hệ thống cập nhật trạng thái mượn của sách và ngày mượn và cho phép thao tác gia hạn trên trang. Mỗi người dùng có số lần gia hạn cho phép. Hệ thống sẽ thông báo cho người dùng sau khi hết lượt gia hạn : 

 

Hình 5.17 Thao tác gia hạn

 

Hình 5.18 Hết lượt gia hạn


Người dùng có thể tìm kiếm thông tin sách cùng với trạng thái mượn/trả của sách đó để kiểm tra lịch sử của mình : 
 
Hình 5.19 Tìm kiếm sách 




Trường hợp không có dữ liệu, hệ thống thông báo cho người dùng : 

 	
Hình 5.20 Không tìm được sách 

5.3 Demo giao diện dành cho Admin:
Đây là trang dành cho admin, cho phép thao tác các chức năng như xác nhận mượn và trả sách theo các yêu cầu của người dùng :

 

Hình 5.21 Giao diện bên Admin 
	 
Tại đây admin xác nhận yêu cầu của tác giả. Sau khi click Xác nhận mượn, hệ thống sẽ cập nhật thời gian thực ở Ngày mượn, đồng nghĩa với việc hoàn thành quá trình mượn sách của độc giả, và cập nhật trạng thái mượn/trả của sách là “Đang mượn”. Lưu ý : chỉ có thể xác nhận khi độc giả đã xác nhận mượn bên trang của họ (có dữ liệu Ngày xác nhận mượn), nếu không hệ thống sẽ thông báo : 

 

Hình 5.22 Thông báo Xác nhận mượn 

Khi click Xác nhận trả, hệ thống sẽ pop-up một form để admin chọn tình trạng của sách lúc trả :

 

Hình 5.23 Chọn tình trạng sách khi trả 

Có 2 lựa chọn cho admin : Tốt và Hư hỏng/Mất sách. Nếu chọn Tốt và Xác nhận, hệ thống ghi nhận sách không có tổn thất và hoàn tất quá trình trả sách. Nếu chọn Hư hỏng/Mất sách, hệ thống ghi nhận tổn thất và tiến hành cảnh báo độc giả. Nếu độc giả vượt quá số lần vi phạm quy định, hệ thống tiến hành khóa tài khoản độc giả. Sau khi xác nhận tình trạng sách, hệ thống sẽ cập nhật thời gian thực cho Ngày trả và trạng thái mượn/trả là “Đã trả” :

 

Hình 5.24 Thông tin sách sau khi trả

Admin cũng có thể tìm kiếm sách theo lịch sử mượn/trả sách của độc giả :

 

Hình 5.25 Tìm kiếm sách



















CHƯƠNG 6. TỔNG KẾT VÀ HƯỚNG PHÁT TRIỂN 

6.1 Tổng kết: 
Mặc dù đã gặp không ít khó khăn nhưng với sự giúp đỡ của các thầy cô giáo, đặc biệt là thầy Nguyễn Trung Hiếu, chúng em đã tìm hiểu thực tiễn hoạt động, giải quyết các vấn đề nghiệp vụ website quản lý thư viện và đã hoàn thành đồ án của mình theo đúng thời gian yêu cầu đề ra. Đồng thời đạt được những mục tiêu đặt ra ở bài báo cáo môn học:
* Kết quả đạt được: 
•	Phân tích và thiết kế Database. 
•	Nắm được một ngôn ngữ lập trình. 
•	Khảo sát và nắm được sơ lược về quy trình của website quản lý thư viện. 
•	Xây dựng được cơ sở dữ liệu và giao diện cho chương trình bằng hệ quản trị cơ sở dữ liệu SQL Server và Java. 
Xây dựng được một số chức năng của chương trình như: 
•	Giải quyết những hạn chế và khó khăn trong quá trình quản lý thư viện, đáp ứng được quy trình làm việc trên website theo khảo sát hiện trạng ở mục 1.1 
•	Quản lý sách: giúp việc kiểm kê và nắm được số lượng sách đang có.
•	Quản lý nhập hàng: hỗ trợ kiểm soát việc nhập sách kịp thời để đáp ứng với nhu cầu của độc giả.
•	Quản lý mượn/trả sách: kiểm soát được nguồn sách liên tục, kịp thời bắt kịp xu hướng để đáp ứng nhu cầu của độc giả.
•	Thống kê sách và độc giả theo khoảng thời gian được chọn một cách nhanh chóng và chính xác. 
* Hạn chế: 
•	Chương trình không hoạt động được trong trình trạng không có internet. 
•	Chương trình chưa hoạt động real time đủ tốt.
•	Chưa có các biện pháp tối ưu về mặt bảo mật.
6.2 Hướng phát triển: 
Phát triển các tính năng cho ứng dụng như sau: 
•	Tối ưu hóa bảo mật: áp dụng các biện pháp mã hóa mật khẩu, kiểm tra đầu vào để phòng chống các lỗ hổng như SQL Injection hay XSS.
•	Cải thiện hiệu năng xử lý real-time: ứng dụng công nghệ như WebSocket hoặc polling định kỳ để đảm bảo dữ liệu được đồng bộ nhanh chóng giữa các người dùng.
•	Hỗ trợ hoạt động offline: phát triển cơ chế lưu tạm và đồng bộ khi có internet, giúp chương trình hoạt động được cả trong điều kiện mất kết nối mạng.
•	Tích hợp mã QR/Barcode: giúp thủ thư quét mã sách nhanh chóng, tiết kiệm thời gian và giảm thiểu sai sót trong quá trình kiểm kê và mượn/trả sách.
•	Tích hợp thông báo tự động qua email hoặc app: thông báo cho độc giả khi sắp đến hạn trả sách, sách đặt trước đã có, hoặc các thông báo quan trọng từ thư viện.
•	Mở rộng báo cáo thống kê: thêm các biểu đồ trực quan để hỗ trợ việc ra quyết định của quản lý.
•	Xây dựng app di động: giúp độc giả tra cứu sách, đăng ký mượn, xem lịch sử mượn/trả dễ dàng hơn qua điện thoại.





 
DANH MỤC TÀI LIỆU THAM KHẢO 
1.	Đoàn Thanh Nghị, Phạm Hữu Dũng, Nguyễn Thị Mỹ Truyền (2023). Giáo trình Lập trình Java căn bản. NXB Đại học Quốc gia TP.HCM.
2.	Microsoft. (2024). Tài liệu hướng dẫn sử dụng SQL Server. https://learn.microsoft.com/vi-vn/sql/sql-server
3.	The Apache Software Foundation. (2024). Tài liệu hướng dẫn Apache Tomcat 10. https://tomcat.apache.org/tomcat-10.0-doc
4.	Oracle. (2024). Tài liệu JDBC (Java Database Connectivity). https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc
5.	Spring Team. (2024). Tài liệu Spring Boot cơ bản. https://spring.io/projects/spring-boot

