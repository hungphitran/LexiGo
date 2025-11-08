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

## Lessons (Client)
Prefix: `/api/v1/lessons`

### Vocab
- GET `/vocab/topics?level=Beginner|Intermediate|Advanced`
  - Returns list of topics (client-facing)
- GET `/vocab/lessons?topic={topic_id}&level=...`
  - Returns vocabulary for a topic
- GET `/vocab/quizzes?topic={topic_id}&level=...`
  - Returns quiz questions for a topic

Examples:
```bash
# Topics
curl -X GET http://localhost:8000/api/v1/lessons/vocab/topics

# Vocab by topic
curl -X GET "http://localhost:8000/api/v1/lessons/vocab/lessons?topic=66f2a3bd1a2b4c0f1d2e3a45"

# Quizzes by topic
curl -X GET "http://localhost:8000/api/v1/lessons/vocab/quizzes?topic=66f2a3bd1a2b4c0f1d2e3a45"
```

### Grammar
- GET `/grammar?level=Beginner|Intermediate|Advanced`
  - List grammar lessons
- GET `/grammar/{id}`
  - Get grammar lesson detail
- GET `/grammar/exercises?grammar_id={id}`
  - List exercises for a grammar lesson
- POST `/grammar/exercises`
  - Create an exercise
- PUT `/grammar/exercises/{exercise_id}`
  - Update an exercise

### Vocab Quizzes
- GET `/vocab/quizzes?topic_id={id}&level=...`
  - List quizzes by topic
- POST `/vocab/quizzes`
  - Create a quiz
- PUT `/vocab/quizzes/{quiz_id}`
  - Update a quiz

Examples:
```bash
# Grammar list
curl -X GET http://localhost:8000/api/v1/lessons/grammar

# Grammar detail
curl -X GET http://localhost:8000/api/v1/lessons/grammar/66f2a3bd1a2b4c0f1d2e3a45

# Grammar exercises
curl -X GET "http://localhost:8000/api/v1/lessons/grammar/exercises?grammar_id=66f2a3bd1a2b4c0f1d2e3a45"

# Create exercise
curl -X POST http://localhost:8000/api/v1/lessons/grammar/exercises \
  -H "Content-Type: application/json" \
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
  -d '{
    "question": "I ___ to school yesterday.",
    "answer": "went",
    "level": "Intermediate"
  }'

# List quizzes by topic
curl -X GET "http://localhost:8000/api/v1/lessons/vocab/quizzes?topic_id=66f2a3bd1a2b4c0f1d2e3a45"

# Create quiz
curl -X POST http://localhost:8000/api/v1/lessons/vocab/quizzes \
  -H "Content-Type: application/json" \
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
  -d '{
    "question": "Choose the plural of 'child'",
    "options": ["childs", "children", "childes"],
    "correct_option": 1,
    "level": "Intermediate"
  }'
```

## Notes
- Optional `level` filter supported where indicated: `Beginner|Intermediate|Advanced`.
- IDs are MongoDB ObjectId strings.


