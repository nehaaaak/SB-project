## Customer Management & File Upload System

A backend system built with **Spring Boot**, **PostgreSQL**, and **LocalStack (AWS S3 emulation)** to manage customers and support file uploads to S3 buckets. The entire project is **containerized with Docker Compose** for seamless setup and deployment.
Built as a learning project to practice Spring Boot, React, Docker, PostgreSQL, and AWS cloud concepts.

---

## 🚀 Features
- **Customer Management APIs** – Create, read, update, and delete customer records.  
- **S3 File Uploads** – Upload and retrieve files via AWS S3 (using LocalStack for local dev).  
- **PostgreSQL Integration** – Relational database for storing customer data.
- **Dashboard UI**: React-based interface with a clean design.  
- **JWT Authentication** – Secure API endpoints.  
- **Dockerized Setup** – Backend, DB, and LocalStack run via Docker Compose.  

---

## 🛠️ Tech Stack
- **Backend:** Spring Boot (Java)  
- **Database:** PostgreSQL  
- **Storage:** AWS S3 (via LocalStack)  
- **Authentication:** JWT  
- **Containerization:** Docker & Docker Compose  

---

## ⚙️ Prerequisites
Make sure you have the following installed:
- [Docker](https://www.docker.com/)  
- [Docker Compose](https://docs.docker.com/compose/)  

---

## 🔧 Setup and Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/nehaaaak/SB-project.git
   cd SB-project
   ```
2. **Start services with Docker Compose**
   ```bash
   docker-compose up --build
   ```
3. **Verify services**
   - Backend: http://localhost:8080 
   - LocalStack UI (if enabled): http://localhost:4566

---

## 📌 API Endpoints

1. **Customer Management**
   - POST /api/v1/customers – Add a new customer
   - GET /api/v1/customers/{customerId} – Get customer by ID
   - PUT /api/v1/customers/{customerId} – Update customer details
   - DELETE /api/v1/customers/{customerId} – Remove customer

2. **Image Upload**
   - POST /api/v1/customers/{customerId}/profile-image – Upload file to S3
   - GET /api/v1/customers/{customerId}/profile-image – Retrieve file from S3

---

## 📌 Future Improvements
- Deploy backend and frontend to cloud platforms.
- Replace LocalStack with real AWS S3 bucket.
- Add role-based access control for admin vs. customer users.
