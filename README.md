# Privacy Impact Assessment Tool# Privacy Impact Assessment Tool

## 📌 Overview

This is a Spring Boot-based backend application for managing privacy impact assessments.
It provides REST APIs to create, retrieve, and manage assessment data.

---

## 🏗️ Architecture

* Backend: Spring Boot (Java)
* Database: MySQL (Docker)
* Containerization: Docker & Docker Compose

Flow:
Client → Controller → Service → Repository → Database

---

## ⚙️ Prerequisites

* Java 17+
* Maven
* Docker & Docker Compose

---

## 🚀 Setup Steps

### 1. Clone the repo

git clone <your-repo-url>

### 2. Go to project folder

cd privacy-impact-assessment-tool

### 3. Run using Docker

docker compose up --build

---

## 🌐 API Endpoints

### Get all assessments

GET /assessments/list

### Add assessment

POST /assessments/add

Example JSON:
{
"name": "Test Assessment"
}

---

## 🔧 Environment Variables

| Variable    | Description        |
| ----------- | ------------------ |
| DB_URL      | MySQL database URL |
| DB_USERNAME | Database username  |
| DB_PASSWORD | Database password  |

---

## 📊 Sample Output

[
{"id":1,"name":"Assessment 1"},
{"id":2,"name":"Assessment 2"}
]

---

## 👩‍💻 Author

Raksha V Kadagi
