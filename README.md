# Employee Performance Management System

A backend application built with **Java**, **Spring Boot**, and **MySQL** that helps organizations manage employees, departments, tasks, attendance, leave requests, and performance reviews.

This project is being developed as part of my journey to learn enterprise backend development using Spring Boot and follows a layered architecture with RESTful APIs.

---

## 🚀 Tech Stack

* Java 21
* Spring Boot
* Spring Security
* JWT Authentication
* Spring Data JPA (Hibernate)
* MySQL
* Maven
* Postman
* Git & GitHub

---

## 📌 Features Implemented

### Employee Management

* Employee CRUD Operations
* Department Mapping
* Manager–Employee Relationship

### Department Management

* Create Department
* Update Department
* Delete Department
* Retrieve Department Details

### Task Management

* Create Tasks
* Assign Tasks to Employees
* Manager Validation
* Task Status Tracking

### Attendance Management

* Attendance Module Structure
* Attendance APIs

### Leave Management

* Apply Leave
* Leave Approval Workflow

### Security

* Spring Security Configuration
* JWT Authentication
* BCrypt Password Encryption
* Protected REST APIs

### Exception Handling

* Global Exception Handler
* Custom Exception Classes
* Standard Error Response

---

## 📂 Project Structure

```text
src
├── Controller
├── Service
├── Repository
├── Entity
├── DtoLayer
├── SecurityConfig
├── Exceptions
├── Enums
└── Config
```

---

## 🔐 Authentication

The application uses **JWT (JSON Web Token)** for stateless authentication.

Workflow:

1. User Login
2. JWT Token Generation
3. Client stores the token
4. Token is sent in the Authorization header
5. JWT Filter validates the token
6. User is authenticated before accessing secured APIs

---

## 🛠 Current Progress

✔ Database Design (ER Diagram)

✔ Entity Relationships

✔ Repository Layer

✔ Service Layer

✔ REST APIs

✔ Global Exception Handling

✔ Spring Security

✔ JWT Authentication

---

## 🚧 Upcoming Features

* Employee Dashboard
* Performance Review Module
* Analytics & Reports
* Role-Based Authorization (Admin / Manager / Employee)
* Email Notifications
* Swagger API Documentation
* Unit Testing
* Docker Deployment

---

## 📬 API Testing

All APIs have been tested using **Postman**.

---

## 🤝 Contributions

This project is currently under active development.

Suggestions, feedback, and improvements are always welcome.

---

## 👨‍💻 Developer

**Kotteeswaran V**

Aspiring Java Full Stack Developer

Building in public • Learning Spring Boot • Exploring Enterprise Backend Development

---

⭐ If you found this project helpful, consider giving it a star on GitHub!
