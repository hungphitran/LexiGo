# 📱 API Client - LexiGo

Base URL: `https://lexigo-api.fly.dev` (Prod) · `http://localhost:8000` (Dev)

All responses follow StandardResponse:
```json
{
  "success": true,
  "message": "",
  "data": {}
}
```

## Auth & Profile
- POST `/auth/register`
- POST `/auth/login`
- GET `/auth/profile`
- POST `/auth/change-password`
- POST `/auth/forgot-password`
- POST `/auth/verify-otp`
- POST `/auth/reset-password`

## User
- GET `/user/info/{user_id}`
- PUT `/user/update` (requires auth)

## Progress
- GET `/progress/{user_id}`
- GET `/progress/summary/{user_id}`
- POST `/progress/update` (requires auth)

## Chat (AI Conversation Practice)
- POST `/chat/start` (requires auth)
  - Start a new conversation with a random topic or specified topic
  - Body: `{ topic_id?: string }` (optional - if not provided, random topic will be selected)
  - Returns: `{ conversation_id, topic: { id, name, description }, initial_message }`
- POST `/chat/message` (requires auth)
  - Send a message in an active conversation
  - Body: `{ conversation_id: string, message: string }`
  - Returns: `{ response: string, conversation_id: string }`
- POST `/chat/end` (requires auth)
  - End and save a conversation
  - Body: `{ conversation_id: string }`
  - Returns: `{ conversation_id: string, total_messages: number }`
- GET `/chat/history?limit=10&offset=0` (requires auth)
  - Get conversation history for the current user
  - Query params: `limit?` (1-100, default 10), `offset?` (default 0)
  - Returns: `{ conversations: [...], total: number }`

Examples:
```bash
# Start a conversation with random topic
curl -X POST http://localhost:8000/chat/start \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <TOKEN>" \
  -d '{}'

# Start a conversation with specific topic
curl -X POST http://localhost:8000/chat/start \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <TOKEN>" \
  -d '{"topic_id": "507f1f77bcf86cd799439012"}'

# Send a message
curl -X POST http://localhost:8000/chat/message \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <TOKEN>" \
  -d '{
    "conversation_id": "507f1f77bcf86cd799439011",
    "message": "I wake up at 7 AM every day"
  }'

# End conversation
curl -X POST http://localhost:8000/chat/end \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <TOKEN>" \
  -d '{"conversation_id": "507f1f77bcf86cd799439011"}'

# Get conversation history
curl -X GET "http://localhost:8000/chat/history?limit=10&offset=0" \
  -H "Authorization: Bearer <TOKEN>"
```

## Lessons (Client)
Prefix: `/api/v1/lessons`

> ⚠️ Các endpoint tạo/cập nhật/xoá dữ liệu (bao gồm import Excel) yêu cầu Bearer token của tài khoản admin.

### Vocab
- GET `/vocab/topics?level=Beginner|Intermediate|Advanced`
  - Returns list of topics (client-facing)
- GET `/vocab/lessons?topic={topic_id}&level=...`
  - Returns vocabulary for a topic (mỗi record bao gồm `audio_url` - presigned URL có hạn 3600s)
- GET `/vocab/quizzes?topic={topic_id}&level=...`
  - Returns quiz questions for a topic
  - Query params: `topic` (required), `level?` (optional)
- POST `/vocab/import`
  - Upload Excel (`.xlsx`) to bulk import vocabulary
  - Required columns: `topic_name`, `word`, `meaning` (or `mean`)
  - Optional columns: `example`, `image_url`, `level` (Beginner/Intermediate/Advanced)
  - Note: `topic_name` must exist in topics collection. The system will look up the topic by name.
  - Each successful row generates an MP3 pronunciation via Edge TTS (`en-US-GuyNeural`) and uploads it to Cloudflare R2 (`vocab/{slug}.mp3`). Failed TTS/upload rows are logged and returned in `errors`.
  - Requires admin token

Examples:
```bash
# Topics
curl -X GET http://localhost:8000/api/v1/lessons/vocab/topics

# Vocab by topic
curl -X GET "http://localhost:8000/api/v1/lessons/vocab/lessons?topic=66f2a3bd1a2b4c0f1d2e3a45"
# -> data[].audio_url = presigned Cloudflare R2 URL (hết hạn sau 1h)

# Quizzes by topic
curl -X GET "http://localhost:8000/api/v1/lessons/vocab/quizzes?topic=66f2a3bd1a2b4c0f1d2e3a45"

# Bulk import vocab from Excel
curl -X POST http://localhost:8000/api/v1/lessons/vocab/import \
  -H "Content-Type: multipart/form-data" \
  -H "Authorization: Bearer <ADMIN_TOKEN>" \
  -F "file=@./vocab.xlsx"
```

### Grammar
- GET `/grammar?level=Beginner|Intermediate|Advanced`
  - List grammar lessons
  - Query params: `level?` (optional)
- GET `/grammar/{grammar_id}`
  - Get grammar lesson detail by ID
- GET `/grammar/exercises?grammar_id={grammar_id}`
  - List exercises for a grammar lesson
  - Query params: `grammar_id` (required)
- POST `/grammar/exercises`
  - Create an exercise (requires admin token)
  - Body: `{ type: "fill_blank" | "true_false", question, answer, grammar_id, level? }`
- POST `/grammar/exercises/import`
  - Upload Excel (`.xlsx`) to bulk import grammar exercises (requires admin token)
  - Required columns: `grammar_title` (or `grammar_id`), `type`, `question`, `answer`
  - Optional columns: `level`
  - Note: `grammar_title` must exist in grammar_lessons collection. `type` must be `fill_blank` or `true_false`
  - Returns detailed response with inserted count, skipped count, and error list
- PUT `/grammar/exercises/{exercise_id}`
  - Update an exercise (requires admin token)
  - Body: partial update `{ type?, question?, answer?, level? }`
- POST `/grammar/import`
  - Upload Excel (`.xlsx`) to bulk import grammar lessons (requires admin token)
  - Required columns: `title`, `explanation`
  - Optional columns: `examples` (separated by newline, `;` or `|`), `level`
  - Returns detailed response with inserted count, skipped count, and error list

### Vocab Quizzes
- GET `/vocab/quizzes?topic={topic_id}&level=...`  
  - List quizzes by topic
  - Query params: `topic` (required), `level?` (optional)
- POST `/vocab/quizzes`
  - Create a quiz (requires admin token)
  - Body: `{ question, options[], correct_option, topic_id, level? }`
- POST `/vocab/quizzes/import`
  - Upload Excel (`.xlsx`) to bulk import vocab quizzes (requires admin token)
  - Required columns: `topic_name` (or `topic_id`), `question`, `options` (separated by `;` or `|`), `correct_option`
  - Optional columns: `level`
  - Note: `topic_name` must exist in topics collection. `correct_option` must be integer from 0 to (number of options - 1)
  - Returns detailed response with inserted count, skipped count, and error list
- PUT `/vocab/quizzes/{quiz_id}`
  - Update a quiz (requires admin token)
  - Body: partial update `{ question?, options?, correct_option?, level? }`

Examples:
```bash
# Grammar list
curl -X GET http://localhost:8000/api/v1/lessons/grammar

# Grammar detail
curl -X GET http://localhost:8000/api/v1/lessons/grammar/66f2a3bd1a2b4c0f1d2e3a45

# Grammar exercises
curl -X GET "http://localhost:8000/api/v1/lessons/grammar/exercises?grammar_id=66f2a3bd1a2b4c0f1d2e3a45"

# Bulk import grammar from Excel
curl -X POST http://localhost:8000/api/v1/lessons/grammar/import \
  -H "Content-Type: multipart/form-data" \
  -H "Authorization: Bearer <ADMIN_TOKEN>" \
  -F "file=@./grammar.xlsx"

# Create exercise
curl -X POST http://localhost:8000/api/v1/lessons/grammar/exercises \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <ADMIN_TOKEN>" \
  -d '{
    "type": "fill_blank",
    "question": "I ___ a book yesterday.",
    "answer": "read",
    "grammar_id": "66f2a3bd1a2b4c0f1d2e3a45",
    "level": "Beginner"
  }'

# Update exercise
curl -X PUT http://localhost:8000/api/v1/lessons/grammar/exercises/66f2a3bd1a2b4c0f1d2e3a46 \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <ADMIN_TOKEN>" \
  -d '{
    "question": "I ___ to school yesterday.",
    "answer": "went",
    "level": "Intermediate"
  }'

# Bulk import grammar exercises
curl -X POST http://localhost:8000/api/v1/lessons/grammar/exercises/import \
  -H "Content-Type: multipart/form-data" \
  -H "Authorization: Bearer <ADMIN_TOKEN>" \
  -F "file=@./grammar_exercises.xlsx"

# List quizzes by topic
curl -X GET "http://localhost:8000/api/v1/lessons/vocab/quizzes?topic=66f2a3bd1a2b4c0f1d2e3a45"

# Create quiz
curl -X POST http://localhost:8000/api/v1/lessons/vocab/quizzes \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <ADMIN_TOKEN>" \
  -d '{
    "question": "What is the plural of 'child'?",
    "options": ["childs", "children", "childes"],
    "correct_option": 1,
    "topic_id": "66f2a3bd1a2b4c0f1d2e3a45",
    "level": "Beginner"
  }'

# Update quiz
curl -X PUT http://localhost:8000/api/v1/lessons/vocab/quizzes/66f2a3bd1a2b4c0f1d2e3a55 \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <ADMIN_TOKEN>" \
  -d '{
    "question": "Choose the plural of 'child'",
    "options": ["childs", "children", "childes"],
    "correct_option": 1,
    "level": "Intermediate"
  }'

# Bulk import vocab quizzes
curl -X POST http://localhost:8000/api/v1/lessons/vocab/quizzes/import \
  -H "Content-Type: multipart/form-data" \
  -H "Authorization: Bearer <ADMIN_TOKEN>" \
  -F "file=@./vocab_quizzes.xlsx"
```

### Listening
- GET `/listening/scripts?level=Beginner|Intermediate|Advanced&source=...&limit=...&skip=...`
  - List scripts available for listening exercises
  - Query params: `level?` (optional), `source?` (optional), `limit?` (1-1000, default 100), `skip?` (default 0)
  - Returns: List of scripts with script_id, content, source, level
- GET `/listening/exercise?script_id={script_id}&path=...&expires_in=...`
  - Get listening exercise: audio file URL and script with one random word replaced by "___"
  - Query params: `script_id` (required), `path?` (optional), `expires_in?` (60-604800 seconds, default 3600)
  - Returns: `{ "audio_url": str, "script_with_blank": str, "answer": str, "script_id": str, "expires_in": int }`

Examples:
```bash
# List listening scripts by level
curl -X GET "http://localhost:8000/api/v1/lessons/listening/scripts?level=Intermediate"

# List listening scripts with filters
curl -X GET "http://localhost:8000/api/v1/lessons/listening/scripts?level=Advanced&source=Les%20Misérables&limit=50&skip=0"

# Get listening exercise
curl -X GET "http://localhost:8000/api/v1/lessons/listening/exercise?script_id=1624-168623-0002"

# Get listening exercise with custom path and expiration
curl -X GET "http://localhost:8000/api/v1/lessons/listening/exercise?script_id=1624-168623-0002&path=audio/custom/path.mp3&expires_in=7200"
```

## Script
Prefix: `/api/v1/script`

### Script
- GET `/script/{script_id}`
  - Get script by script_id
- GET `/script?level=Beginner|Intermediate|Advanced&source=...&limit=...&skip=...`
  - List scripts with filters
- POST `/script/import`
  - Upload Excel (`.xlsx`) để bulk import / cập nhật script
  - Required columns: `script_id`, `content`
  - Optional columns: `source`, `level`
  - Requires admin token

Examples:
```bash
# Get script by script_id
curl -X GET http://localhost:8000/api/v1/script/1624-168623-0000

# List scripts with filters
curl -X GET "http://localhost:8000/api/v1/script?level=Advanced&source=Les%20Misérables&limit=50&skip=0"

# Bulk import script from Excel
curl -X POST http://localhost:8000/api/v1/script/import \
  -H "Content-Type: multipart/form-data" \
  -H "Authorization: Bearer <ADMIN_TOKEN>" \
  -F "file=@./script.xlsx"
```

## Audio
Prefix: `/api/v1/audio`

### Audio Files
- GET `/mp3/{script_id}`
  - Get .mp3 audio file from Cloudflare R2 by script_id
  - Query params: `path?` (optional) - Custom path in bucket
  - Default path: `{script_id}.mp3` in bucket
  - Returns: Audio file with content-type `audio/mpeg`
- GET `/mp3/{script_id}/exists`
  - Check if .mp3 file exists in R2
  - Query params: `path?` (optional)
  - Returns: `{ "exists": bool, "path": str, "script_id": str }`
- GET `/mp3/{script_id}/url`
  - Get presigned URL to access .mp3 file
  - Query params: `path?` (optional), `expires_in?` (60-604800 seconds, default 3600)
  - Returns: `{ "url": str, "expires_in": int, "path": str, "script_id": str }`
- GET `/listening/{script_id}`
  - Get listening exercise: audio file URL and script with one random word replaced by "___"
  - Query params: `path?` (optional), `expires_in?` (60-604800 seconds, default 3600)
  - Returns: `{ "audio_url": str, "script_with_blank": str, "answer": str, "script_id": str, "expires_in": int }`

Examples:
```bash
# Get .mp3 file
curl -X GET http://localhost:8000/api/v1/audio/mp3/1624-168623-0000

# Get .mp3 file with custom path
curl -X GET "http://localhost:8000/api/v1/audio/mp3/1624-168623-0000?path=audio/custom/path.mp3"

# Check if file exists
curl -X GET http://localhost:8000/api/v1/audio/mp3/1624-168623-0000/exists

# Get presigned URL (expires in 1 hour)
curl -X GET http://localhost:8000/api/v1/audio/mp3/1624-168623-0000/url

# Get presigned URL (expires in 24 hours)
curl -X GET "http://localhost:8000/api/v1/audio/mp3/1624-168623-0000/url?expires_in=86400"

# Get listening exercise
curl -X GET http://localhost:8000/api/v1/audio/listening/1624-168623-0000

# Get listening exercise with custom path and expiration
curl -X GET "http://localhost:8000/api/v1/audio/listening/1624-168623-0000?path=audio/custom/path.mp3&expires_in=7200"
```

## Notes
- Optional `level` filter supported where indicated: `Beginner|Intermediate|Advanced`.
- IDs are MongoDB ObjectId strings (except script_id which is a custom string identifier).
- Audio files are stored in Cloudflare R2. Default file path format: `{script_id}.mp3`.
- Vocabulary pronunciations are stored at `vocab/{slug}.mp3`, generated automatically during Excel import via Edge TTS.


