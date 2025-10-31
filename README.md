# LexiGo - Ứng dụng Học Tiếng Anh

Ứng dụng mobile Android giúp người dùng học tiếng Anh hiệu quả với giao diện thân thiện và các tính năng đa dạng.

## 📱 Tính năng

### 1. Màn hình Đăng nhập / Đăng ký (AuthActivity)
- Tab Layout với 2 tab: Đăng nhập và Đăng ký
- Form đăng nhập với email và mật khẩu
- Form đăng ký với họ tên, email, mật khẩu và xác nhận mật khẩu
- Validation đầy đủ cho các trường input
- Tính năng quên mật khẩu
- Giao diện hiện đại với logo và slogan

### 2. Màn hình Trang chủ (HomeActivity)
- Thanh tiêu đề với logo và nút "Tài khoản"
- Card hiển thị tiến độ học tập:
  - Số bài đã hoàn thành
  - Mục tiêu hàng ngày
  - Progress bar trực quan
- RecyclerView hiển thị các mục học:
  - Học từ vựng
  - Ngữ pháp
  - Luyện nghe
  - Luyện đọc
- Floating Action Button để mở nhanh "Từ điển"

### 3. Màn hình Thông tin cá nhân (ProfileActivity)
- Header với:
  - Ảnh đại diện (avatar)
  - Tên người dùng
  - Email
  - Chip hiển thị cấp độ (Beginner/Intermediate/Advanced) với màu sắc khác nhau
- Card thống kê tiến độ:
  - Số bài đã học
  - Progress bar
  - Tổng số bài
- Các nút chức năng:
  - Cập nhật thông tin
  - Đặt mục tiêu học tập
  - Thống kê chi tiết
  - Đăng xuất

## 🎨 Thiết kế

### Material Design
- Tuân theo nguyên tắc Material Design 3
- Sử dụng Material Components (CardView, Button, TextInputLayout, v.v.)
- Màu sắc nhất quán và thân thiện với người dùng

### Color Palette
- **Primary**: #2196F3 (Blue)
- **Primary Dark**: #1976D2
- **Accent**: #FF5722 (Deep Orange)
- **Background**: #F5F5F5
- **Beginner**: #4CAF50 (Green)
- **Intermediate**: #FF9800 (Orange)
- **Advanced**: #F44336 (Red)

### Layout
- ConstraintLayout và LinearLayout được sử dụng linh hoạt
- CoordinatorLayout cho hiệu ứng cuộn mượt mà
- RecyclerView cho danh sách hiệu quả

## 🏗️ Cấu trúc dự án

```
app/src/main/
├── java/com/ptithcm/lexigo/
│   ├── activities/
│   │   ├── AuthActivity.java          # Màn hình đăng nhập/đăng ký
│   │   ├── HomeActivity.java          # Màn hình trang chủ
│   │   └── ProfileActivity.java       # Màn hình thông tin cá nhân
│   ├── fragments/
│   │   ├── LoginFragment.java         # Fragment đăng nhập
│   │   └── RegisterFragment.java      # Fragment đăng ký
│   ├── adapters/
│   │   └── LearningCategoryAdapter.java  # Adapter cho RecyclerView
│   ├── models/
│   │   └── LearningCategory.java      # Model cho mục học tập
│   └── MainActivity.java              # Activity chính (ban đầu)
├── res/
│   ├── layout/
│   │   ├── activity_auth.xml          # Layout màn hình xác thực
│   │   ├── activity_home.xml          # Layout trang chủ
│   │   ├── activity_profile.xml       # Layout profile
│   │   ├── fragment_login.xml         # Layout fragment đăng nhập
│   │   ├── fragment_register.xml      # Layout fragment đăng ký
│   │   └── item_learning_category.xml # Layout item RecyclerView
│   ├── values/
│   │   ├── colors.xml                 # Màu sắc
│   │   ├── strings.xml                # Chuỗi văn bản
│   │   ├── dimens.xml                 # Kích thước
│   │   └── themes.xml                 # Theme ứng dụng
│   └── drawable/
│       └── lexigo_logo.png            # Logo ứng dụng
└── AndroidManifest.xml
```

## 📦 Dependencies

```gradle
- androidx.appcompat:appcompat:1.7.1
- com.google.android.material:material:1.13.0
- androidx.constraintlayout:constraintlayout:2.2.1
- androidx.recyclerview:recyclerview:1.3.2
- androidx.coordinatorlayout:coordinatorlayout:1.2.0
```

**Lưu ý:** ViewPager đã được bao gồm trong Material Components, không cần dependency riêng.

## 🚀 Cài đặt và Chạy

1. Clone repository:
```bash
git clone https://github.com/yourusername/LexiGo.git
```

2. Mở project trong Android Studio

3. Sync Gradle files:
   - Click "Sync Project with Gradle Files" hoặc
   - File → Sync Project with Gradle Files

4. Chạy ứng dụng:
   - Kết nối thiết bị Android hoặc khởi động emulator
   - Click nút "Run" hoặc Shift+F10

## 📝 Lưu ý

- Ứng dụng hiện tại sử dụng dữ liệu mẫu (mock data)
- Các chức năng backend chưa được implement
- Các TODO comments đánh dấu phần cần phát triển thêm:
  - Tích hợp Firebase Authentication
  - Kết nối với backend API
  - Implement từ điển
  - Thêm các màn hình chi tiết cho từng mục học
  - Lưu trữ dữ liệu local với SharedPreferences/Room

## 🔧 Phát triển tiếp

### Tính năng cần thêm:
- [ ] Tích hợp Firebase Authentication
- [ ] Màn hình chi tiết cho từng mục học (Vocabulary, Grammar, Listening, Reading)
- [ ] Chức năng từ điển nội bộ
- [ ] Quiz và bài kiểm tra
- [ ] Thống kê chi tiết với biểu đồ
- [ ] Notification nhắc nhở học tập
- [ ] Dark mode support
- [ ] Đa ngôn ngữ (i18n)

### Cải thiện:
- [ ] Thêm animations và transitions
- [ ] Optimize performance
- [ ] Unit tests và UI tests
- [ ] Error handling tốt hơn
- [ ] Offline mode

## 👥 Tác giả

Phát triển bởi nhóm LexiGo

## 📄 License

MIT License - Xem file LICENSE để biết thêm chi tiết

---

**Chúc bạn học tiếng Anh vui vẻ với LexiGo! 🎉**

