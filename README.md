# ForumHub 📚💻

ForumHub is a backend challenge project to create a REST API using Spring Boot. The API focuses on managing topics and provides endpoints for authentication and CRUD operations on topics.

## Features 🌟

- **Create a new topic** 📝
- **Show all created topics** 📋
- **Show a specific topic** 🔍
- **Update a topic** ✏️
- **Delete a topic** 🗑️
- **User authentication** 🔐

## Requirements 🛠️

- Java 8+ ☕
- Maven 📦
- Spring Boot 🌱

## Getting Started 🚀

### Clone the Repository 📂

```bash
git clone https://github.com/renansouza12/forum-hub.git
cd forum-hub
```
#


# API Endpoints 🔗
## Authentication Endpoints 🔐
### POST /login - Authenticate a user and generate a JWT token

#### Request Body

```bash
{
  "login": "user_login",
  "password": "user_password"
}

```

#### Response

```bash
{
  "token": "jwt_token"
}

```

## Topic Endpoints 📋
### POST /topicos - Create a new topic 📝

#### Request Body

```bash
{
  "title": "Topic Title",
  "message": "Topic Message",
  "create_at": "2024-07-15T10:00:00Z",
  "author": "Author Name",
  "course": "Course Name",
  "state": "Topic State"
}

```

## GET /topicos - List all topics 📋

### GET /topicos/{id} - Get a specific topic by ID 🔍

### PUT /topicos/{id} - Update a topic by ID ✏️

#### Request Body

```bash
{
  "title": "Updated Title",
  "message": "Updated Message",
  "create_at": "2024-07-15T10:00:00Z",
  "author": "Updated Author",
  "course": "Updated Course",
  "state": "Updated State"
}
```

### DELETE /topicos/{id} - Delete a topic by ID 🗑️

## Database 🗄️
#### The project uses a relational database to persist data.

##Authentication and Authorization 🔒
#### The API includes an authentication endpoint that generates a JWT token, which is used to restrict access to various endpoints.

## Best Practices 🌐
### The API follows RESTful principles and includes validations according to business rules.

