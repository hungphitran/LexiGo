# LexiGo API Integration - Hướng dẫn sử dụng

## 📁 Cấu trúc thư mục

```
api/
├── models/                          # Các model classes
│   ├── Goals.java
│   ├── User.java
│   ├── Progress.java
│   ├── ProgressSummary.java
│   ├── Statistics.java
│   ├── UserRegisterRequest.java
│   ├── UserLoginRequest.java
│   ├── UserUpdateRequest.java
│   └── ProgressUpdateRequest.java
├── responses/                       # Response wrappers
│   ├── ApiResponse.java
│   ├── LoginResponse.java
│   └── RegisterResponse.java
├── services/                        # Retrofit API interface
│   └── LexiGoApiService.java
├── repositories/                    # Repository pattern
│   └── LexiGoRepository.java
├── ApiClient.java                   # Retrofit client
├── AuthInterceptor.java             # JWT interceptor
└── TokenManager.java                # Token storage manager
```

## 🚀 Cách sử dụng

### 1. Đăng ký tài khoản

```java
// Tạo request
UserRegisterRequest request = new UserRegisterRequest(
    "Nguyễn Văn A",
    "user@example.com",
    "password123"
);

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
```

### 2. Đăng nhập

```java
// Tạo request
UserLoginRequest request = new UserLoginRequest(
    "user@example.com",
    "password123"
);

// Gọi API
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
        
        // Chuyển sang màn hình chính
        Intent intent = new Intent(context, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onError(String error) {
        Toast.makeText(context, "Đăng nhập thất bại: " + error, Toast.LENGTH_SHORT).show();
    }
});
```

### 3. Lấy profile người dùng hiện tại

```java
LexiGoRepository repository = LexiGoRepository.getInstance(context);
repository.getProfile(new LexiGoRepository.ApiCallback<User>() {
    @Override
    public void onSuccess(User user) {
        // Hiển thị thông tin user
        nameTextView.setText(user.getName());
        emailTextView.setText(user.getEmail());
        levelTextView.setText(user.getLevel());
    }

    @Override
    public void onError(String error) {
        Toast.makeText(context, "Lỗi: " + error, Toast.LENGTH_SHORT).show();
    }
});
```

### 4. Cập nhật thông tin người dùng

```java
// Tạo request với các trường muốn cập nhật
UserUpdateRequest request = new UserUpdateRequest();
request.setName("Nguyễn Văn B");
request.setLevel("Intermediate");

Goals goals = new Goals(20, 2);
request.setGoals(goals);

// Gọi API
LexiGoRepository repository = LexiGoRepository.getInstance(context);
repository.updateUser(request, new LexiGoRepository.ApiCallback<User>() {
    @Override
    public void onSuccess(User user) {
        Toast.makeText(context, "Cập nhật thành công!", Toast.LENGTH_SHORT).show();
        // Cập nhật UI
    }

    @Override
    public void onError(String error) {
        Toast.makeText(context, "Lỗi: " + error, Toast.LENGTH_SHORT).show();
    }
});
```

### 5. Lấy thống kê bài học

```java
String userId = TokenManager.getInstance(context).getUserId();

LexiGoRepository repository = LexiGoRepository.getInstance(context);
repository.getUserStatistics(userId, new LexiGoRepository.ApiCallback<Statistics>() {
    @Override
    public void onSuccess(Statistics stats) {
        totalCompletedTextView.setText(String.valueOf(stats.getTotalCompleted()));
        vocabTextView.setText(String.valueOf(stats.getVocabCompleted()));
        grammarTextView.setText(String.valueOf(stats.getGrammarCompleted()));
        listeningTextView.setText(String.valueOf(stats.getListeningCompleted()));
        readingTextView.setText(String.valueOf(stats.getReadingCompleted()));
    }

    @Override
    public void onError(String error) {
        Toast.makeText(context, "Lỗi: " + error, Toast.LENGTH_SHORT).show();
    }
});
```

### 6. Cập nhật tiến độ học

```java
// Tạo request
ProgressUpdateRequest request = new ProgressUpdateRequest();
request.setVocabCompleted(5);        // Hoàn thành thêm 5 bài vocab
request.setGrammarCompleted(2);      // Hoàn thành thêm 2 bài grammar
request.setListeningCompleted(3);    // Hoàn thành thêm 3 bài listening
request.setReadingCompleted(1);      // Hoàn thành thêm 1 bài reading

// Gọi API
LexiGoRepository repository = LexiGoRepository.getInstance(context);
repository.updateProgress(request, new LexiGoRepository.ApiCallback<Progress>() {
    @Override
    public void onSuccess(Progress progress) {
        Toast.makeText(context, "Cập nhật tiến độ thành công!", Toast.LENGTH_SHORT).show();
        // Cập nhật UI với giá trị mới
    }

    @Override
    public void onError(String error) {
        Toast.makeText(context, "Lỗi: " + error, Toast.LENGTH_SHORT).show();
    }
});
```

### 7. Lấy tiến độ học

```java
String userId = TokenManager.getInstance(context).getUserId();

LexiGoRepository repository = LexiGoRepository.getInstance(context);
repository.getProgress(userId, new LexiGoRepository.ApiCallback<Progress>() {
    @Override
    public void onSuccess(Progress progress) {
        // Hiển thị tiến độ
        vocabProgressBar.setProgress(progress.getVocabCompleted());
        grammarProgressBar.setProgress(progress.getGrammarCompleted());
        listeningProgressBar.setProgress(progress.getListeningCompleted());
        readingProgressBar.setProgress(progress.getReadingCompleted());
    }

    @Override
    public void onError(String error) {
        Toast.makeText(context, "Lỗi: " + error, Toast.LENGTH_SHORT).show();
    }
});
```

### 8. Lấy tổng hợp tiến độ (cho biểu đồ)

```java
String userId = TokenManager.getInstance(context).getUserId();

LexiGoRepository repository = LexiGoRepository.getInstance(context);
repository.getProgressSummary(userId, new LexiGoRepository.ApiCallback<ProgressSummary>() {
    @Override
    public void onSuccess(ProgressSummary summary) {
        // Dùng để vẽ biểu đồ
        int[] data = {
            summary.getTotalVocab(),
            summary.getTotalGrammar(),
            summary.getTotalListening(),
            summary.getTotalReading()
        };
        drawChart(data);
    }

    @Override
    public void onError(String error) {
        Toast.makeText(context, "Lỗi: " + error, Toast.LENGTH_SHORT).show();
    }
});
```

### 9. Kiểm tra trạng thái đăng nhập

```java
TokenManager tokenManager = TokenManager.getInstance(context);

if (tokenManager.isLoggedIn()) {
    // Đã đăng nhập, chuyển sang màn hình chính
    Intent intent = new Intent(context, HomeActivity.class);
    startActivity(intent);
} else {
    // Chưa đăng nhập, hiển thị màn hình login
    Intent intent = new Intent(context, AuthActivity.class);
    startActivity(intent);
}
```

### 10. Đăng xuất

```java
TokenManager tokenManager = TokenManager.getInstance(context);
tokenManager.clearToken();

// Chuyển về màn hình đăng nhập
Intent intent = new Intent(context, AuthActivity.class);
intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
startActivity(intent);
finish();
```

## 🔧 Lưu ý quan trọng

### 1. Chạy trên UI Thread
Tất cả các callback đều chạy trên background thread. Nếu cần cập nhật UI, sử dụng `runOnUiThread()`:

```java
@Override
public void onSuccess(User user) {
    runOnUiThread(() -> {
        nameTextView.setText(user.getName());
    });
}
```

### 2. Xử lý lỗi
Luôn xử lý lỗi trong callback:

```java
@Override
public void onError(String error) {
    Log.e("API_ERROR", error);
    Toast.makeText(context, "Có lỗi xảy ra: " + error, Toast.LENGTH_SHORT).show();
}
```

### 3. Kiểm tra token hết hạn
Nếu nhận được lỗi 401 Unauthorized, token đã hết hạn:

```java
@Override
public void onError(String error) {
    if (error.contains("401")) {
        // Token hết hạn, yêu cầu đăng nhập lại
        TokenManager.getInstance(context).clearToken();
        Intent intent = new Intent(context, AuthActivity.class);
        startActivity(intent);
        finish();
    }
}
```

### 4. Thay đổi Base URL
Để sử dụng local server, sửa trong `ApiClient.java`:

```java
private static final String BASE_URL = "http://10.0.2.2:8000/";  // Android Emulator
// hoặc
private static final String BASE_URL = "http://192.168.1.x:8000/"; // Device thật
```

## 📱 Ví dụ đầy đủ trong Activity

```java
public class LoginActivity extends AppCompatActivity {
    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    private ProgressBar progressBar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        progressBar = findViewById(R.id.progressBar);
        
        loginButton.setOnClickListener(v -> login());
    }
    
    private void login() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }
        
        // Hiển thị loading
        progressBar.setVisibility(View.VISIBLE);
        loginButton.setEnabled(false);
        
        UserLoginRequest request = new UserLoginRequest(email, password);
        LexiGoRepository repository = LexiGoRepository.getInstance(this);
        
        repository.login(request, new LexiGoRepository.ApiCallback<LoginResponse>() {
            @Override
            public void onSuccess(LoginResponse data) {
                runOnUiThread(() -> {
                    progressBar.setVisibility(View.GONE);
                    loginButton.setEnabled(true);
                    
                    // Lưu token và user info
                    TokenManager tokenManager = TokenManager.getInstance(LoginActivity.this);
                    tokenManager.saveToken(data.getAccessToken());
                    
                    User user = data.getUser();
                    tokenManager.saveUserInfo(user.getId(), user.getName(), user.getEmail());
                    
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    
                    // Chuyển sang màn hình chính
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                });
            }
            
            @Override
            public void onError(String error) {
                runOnUiThread(() -> {
                    progressBar.setVisibility(View.GONE);
                    loginButton.setEnabled(true);
                    Toast.makeText(LoginActivity.this, "Đăng nhập thất bại: " + error, Toast.LENGTH_SHORT).show();
                });
            }
        });
    }
}
```

## 🎯 Tips & Best Practices

1. **Singleton Pattern**: Luôn sử dụng `getInstance()` để lấy repository và token manager
2. **Context**: Truyền Application Context thay vì Activity Context để tránh memory leak
3. **Error Handling**: Luôn xử lý cả success và error callbacks
4. **UI Updates**: Sử dụng `runOnUiThread()` khi cần cập nhật UI từ callback
5. **Token Management**: Lưu token ngay sau khi đăng nhập thành công
6. **Logout**: Xóa token và chuyển về màn hình login
7. **Network Check**: Kiểm tra kết nối internet trước khi gọi API
8. **Loading State**: Hiển thị ProgressBar khi đang gọi API

## 🐛 Debug

Để xem log của API request/response, check Logcat với tag `OkHttp`.

## 📞 Support

Nếu có vấn đề, kiểm tra:
1. Internet permission đã được thêm vào AndroidManifest.xml
2. Base URL đúng (production hoặc development)
3. Token đã được lưu sau khi login
4. Network connection

