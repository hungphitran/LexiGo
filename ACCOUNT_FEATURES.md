# LexiGo - Tài liệu Tính năng Tài khoản

## Tổng quan
Tài liệu này mô tả các tính năng tài khoản đã được hoàn thiện cho ứng dụng LexiGo.

## Các tính năng đã triển khai

### 1. ProfileActivity (Màn hình Hồ sơ)
**File**: `app/src/main/java/com/ptithcm/lexigo/activities/ProfileActivity.java`

**Chức năng**:
- Hiển thị thông tin cá nhân người dùng (tên, email, cấp độ)
- Hiển thị thống kê bài học đã hoàn thành
- Cung cấp các nút điều hướng đến:
  - Cập nhật thông tin cá nhân
  - Đặt mục tiêu học tập
  - Xem thống kê chi tiết
  - Đăng xuất

**Tính năng chính**:
- Tự động tải thông tin người dùng từ API khi mở màn hình
- Cache thông tin người dùng trong SharedPreferences
- Tự động cập nhật khi quay lại từ màn hình cập nhật thông tin (onResume)
- Hiển thị progress bar cho số bài học đã hoàn thành
- Xử lý đăng xuất và chuyển về màn hình đăng nhập

### 2. UpdateProfileActivity (Cập nhật Thông tin)
**File**: `app/src/main/java/com/ptithcm/lexigo/activities/UpdateProfileActivity.java`
**Layout**: `app/src/main/res/layout/activity_update_profile.xml`

**Chức năng**:
- Cho phép người dùng cập nhật:
  - Tên
  - Cấp độ (Beginner, Intermediate, Advanced)
  - Mục tiêu số từ vựng mỗi ngày (1-100 từ)
  - Mục tiêu số bài học mỗi ngày (1-20 bài)

**Validation**:
- Tên không được để trống
- Cấp độ phải được chọn
- Số từ vựng phải từ 1-100
- Số bài học phải từ 1-20

**Tính năng**:
- Tự động load thông tin hiện tại của người dùng
- Sử dụng Dropdown menu cho việc chọn cấp độ
- Cập nhật cache sau khi lưu thành công
- Loading indicator khi đang xử lý
- Tự động quay về màn hình Profile sau khi cập nhật

### 3. DetailedStatisticsActivity (Thống kê Chi tiết)
**File**: `app/src/main/java/com/ptithcm/lexigo/activities/DetailedStatisticsActivity.java`
**Layout**: `app/src/main/res/layout/activity_detailed_statistics.xml`

**Chức năng**:
- Hiển thị thống kê bài học:
  - Tổng số bài hoàn thành
  - Bài từ vựng hoàn thành
  - Bài ngữ pháp hoàn thành
  - Bài nghe hoàn thành
  - Bài đọc hoàn thành
  - Progress bar cho từng loại

- Hiển thị tiến độ học tập:
  - Tổng số bài học
  - Số bài hoàn thành
  - Số bài đang học
  - Tổng số quiz
  - Số quiz đã hoàn thành
  - Điểm trung bình
  - Chuỗi ngày học liên tiếp (streak)

**Tính năng**:
- Sử dụng CardView để tổ chức thông tin
- Progress bar cho mỗi loại bài học
- GridLayout để hiển thị các thống kê
- Hiển thị thời gian cập nhật cuối

### 4. SetGoalsDialog (Dialog Đặt Mục tiêu)
**File**: `app/src/main/java/com/ptithcm/lexigo/dialogs/SetGoalsDialog.java`
**Layout**: `app/src/main/res/layout/dialog_set_goals.xml`

**Chức năng**:
- Dialog cho phép người dùng nhanh chóng đặt mục tiêu học tập
- Cập nhật số từ vựng mỗi ngày
- Cập nhật số bài học mỗi ngày

**Tính năng**:
- Interface callback để thông báo khi cập nhật thành công
- Validation giống như UpdateProfileActivity
- Helper text gợi ý phạm vi giá trị
- Loading indicator khi đang xử lý

## Cấu trúc API đã sử dụng

### Endpoints đã tích hợp:

1. **GET /auth/profile**
   - Lấy thông tin profile người dùng hiện tại
   - Yêu cầu: JWT token
   - Response: User object

2. **PUT /user/update**
   - Cập nhật thông tin người dùng
   - Yêu cầu: JWT token, UserUpdateRequest
   - Response: User object đã cập nhật

3. **GET /user/statistics/{user_id}**
   - Lấy thống kê bài học của người dùng
   - Response: Statistics object

4. **GET /progress/summary/{user_id}**
   - Lấy tóm tắt tiến độ học tập
   - Response: ProgressSummary object

## Models đã cập nhật

### ProgressSummary.java
Đã thêm các trường mới:
- `totalLessons`: Tổng số bài học
- `completedLessons`: Số bài đã hoàn thành
- `inProgressLessons`: Số bài đang học
- `totalQuizzes`: Tổng số quiz
- `completedQuizzes`: Số quiz đã hoàn thành
- `averageScore`: Điểm trung bình
- `currentStreak`: Chuỗi ngày học liên tiếp

## Resources đã thêm

### Colors (colors.xml)
```xml
<color name="vocab_color">#2196F3</color>
<color name="grammar_color">#9C27B0</color>
<color name="listening_color">#FF9800</color>
<color name="reading_color">#4CAF50</color>
```

### Drawable
- `ic_back.xml`: Icon mũi tên quay lại cho toolbar

### Layouts
1. `activity_update_profile.xml`: Layout cho màn hình cập nhật profile
2. `activity_detailed_statistics.xml`: Layout cho màn hình thống kê chi tiết
3. `dialog_set_goals.xml`: Layout cho dialog đặt mục tiêu

## AndroidManifest.xml
Đã đăng ký 2 activities mới:
```xml
<activity android:name=".activities.UpdateProfileActivity" />
<activity android:name=".activities.DetailedStatisticsActivity" />
```

## Luồng hoạt động

### Luồng cập nhật thông tin:
1. User mở ProfileActivity
2. Nhấn nút "Cập nhật thông tin"
3. Mở UpdateProfileActivity
4. Điền thông tin và nhấn "Lưu"
5. Gọi API cập nhật
6. Cập nhật cache
7. Quay về ProfileActivity
8. ProfileActivity tự động reload dữ liệu (onResume)

### Luồng đặt mục tiêu:
1. User mở ProfileActivity
2. Nhấn nút "Đặt mục tiêu"
3. Hiển thị SetGoalsDialog
4. Điền mục tiêu và nhấn "Lưu"
5. Gọi API cập nhật
6. Callback thông báo thành công
7. Đóng dialog

### Luồng xem thống kê:
1. User mở ProfileActivity
2. Nhấn nút "Thống kê chi tiết"
3. Mở DetailedStatisticsActivity
4. Tự động load:
   - Statistics từ API
   - ProgressSummary từ API
5. Hiển thị dữ liệu với charts và progress bars

## Xử lý lỗi
- Tất cả các API calls đều có error handling
- Hiển thị Toast message khi có lỗi
- Fallback hiển thị dữ liệu từ cache khi offline
- Loading indicators cho tất cả operations bất đồng bộ

## Token Management
- TokenManager lưu trữ JWT token trong SharedPreferences
- Tự động thêm token vào header của tất cả API requests
- Kiểm tra login status trước khi load dữ liệu
- Auto-redirect về AuthActivity nếu chưa đăng nhập

## Best Practices đã áp dụng
1. **Material Design 3**: Sử dụng Material Components
2. **Repository Pattern**: Tách riêng logic API calls
3. **Callback Pattern**: Xử lý async operations
4. **Error Handling**: Try-catch và null checks
5. **Loading States**: Progress indicators
6. **Cache Strategy**: SharedPreferences cho offline support
7. **Lifecycle Awareness**: onResume để reload data
8. **Validation**: Input validation cho forms

## Hướng dẫn Test

### Test ProfileActivity:
1. Đăng nhập vào ứng dụng
2. Điều hướng đến ProfileActivity
3. Kiểm tra hiển thị thông tin user
4. Kiểm tra hiển thị thống kê
5. Kiểm tra các nút chức năng

### Test UpdateProfileActivity:
1. Từ ProfileActivity, nhấn "Cập nhật thông tin"
2. Thử thay đổi tên
3. Thử thay đổi cấp độ
4. Thử thay đổi mục tiêu
5. Nhấn "Lưu" và kiểm tra cập nhật thành công
6. Kiểm tra validation với dữ liệu không hợp lệ

### Test DetailedStatisticsActivity:
1. Từ ProfileActivity, nhấn "Thống kê chi tiết"
2. Kiểm tra hiển thị tất cả số liệu
3. Kiểm tra progress bars
4. Kiểm tra grid layout

### Test SetGoalsDialog:
1. Từ ProfileActivity, nhấn "Đặt mục tiêu"
2. Nhập mục tiêu mới
3. Nhấn "Lưu" và kiểm tra cập nhật
4. Kiểm tra validation

## Các điểm cần lưu ý
1. Đảm bảo API server đang chạy
2. Token phải hợp lệ khi test
3. User ID phải tồn tại trong database
4. Network connection cần ổn định cho các API calls

## Tương lai có thể mở rộng
1. Thêm upload ảnh avatar
2. Thêm change password
3. Thêm delete account
4. Thêm export statistics
5. Thêm social sharing
6. Thêm achievements/badges
7. Thêm leaderboard
8. Thêm notification settings

