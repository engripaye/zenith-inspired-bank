# Zenith-Inspired Bank Application 🏦

A full-stack **banking authentication system** inspired by Zenith Bank, built with a clean HTML/CSS/JavaScript frontend and a secure **Spring Boot** backend.
This project demonstrates modern authentication flow, layered backend architecture, and frontend–backend integration.

---

## 📌 Project Overview

The **Zenith-Inspired Bank Application** is a simple banking-style web application focused on **user authentication** and **dashboard access**.
It is designed for learning, portfolio presentation, and demonstrating best practices in full-stack development.

---

## 🛠️ Tech Stack

### Frontend

* **HTML5**
* **CSS3**
* **JavaScript (ES6)**
* Responsive UI design
* Client-side authentication handling

### Backend

* **Java**
* **Spring Boot**
* **Spring Security**
* RESTful APIs
* YAML-based configuration

---

## 📁 Project Structure

```
zenith-inspired-bank/
│
├── frontend/
│   ├── index.html          # Landing page
│   ├── login.html          # Login page
│   ├── dashboard.html      # User dashboard
│   ├── css/
│   │   └── style.css       # Global styles
│   └── js/
│       └── auth.js         # Authentication logic
│
└── backend/
    └── zenithbank/
        ├── src/main/java/com/example/zenithbank/
        │   ├── ZenithBankApplication.java
        │   ├── controller/
        │   │   └── AuthController.java
        │   ├── service/
        │   │   └── AuthService.java
        │   ├── security/
        │   │   └── SecurityConfig.java
        │   └── model/
        │       └── LoginRequest.java
        └── application.yml
```

---

## ✨ Features

* Secure login authentication
* Spring Security configuration
* REST API-based authentication
* Clean and simple banking UI
* Frontend–backend integration
* Modular backend architecture (Controller → Service → Model)

---

## 🚀 Getting Started

### Prerequisites

* Java 17+ (or compatible)
* Maven
* Web browser (Chrome, Edge, Firefox)
* Git

---

### 🔧 Backend Setup

1. Navigate to the backend directory:

   ```bash
   cd backend/zenithbank
   ```

2. Run the Spring Boot application:

   ```bash
   mvn spring-boot:run
   ```

3. The backend will start on the configured port (see `application.yml`).

---

### 🎨 Frontend Setup

1. Navigate to the frontend folder:

   ```bash
   cd frontend
   ```

2. Open `index.html` or `login.html` in your browser.

> ⚠️ For full functionality, ensure the backend is running before attempting to log in.

---

## 🔐 API Overview

### Authentication Endpoint

* **POST** `/auth/login`
* Accepts login credentials
* Returns authentication response

*(Endpoint naming may vary based on your configuration)*

---

## 📸 Screenshots (Optional)

*Add screenshots of the login page and dashboard here to enhance your README.*

---

## 📚 Learning Objectives

* Understanding Spring Security fundamentals
* Implementing authentication flows
* Structuring a full-stack project
* Connecting frontend JavaScript with backend APIs
* Writing clean, maintainable code

---

## 🧩 Future Improvements

* JWT-based authentication
* User registration
* Role-based authorization
* Database integration (MySQL/PostgreSQL)
* Transaction and account modules
* Improved UI/UX design

---

## 🤝 Contributing

Contributions, suggestions, and improvements are welcome.
Feel free to fork the repository and submit a pull request.

---

## 📄 License

This project is for **educational and demonstration purposes**.

---

## 👤 Author

**Olabowale Babatunde Ipaye**
Full-Stack Developer // Software Engineer

---
