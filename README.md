# Task Manager API

A RESTful API built with Java and Spring Boot to manage daily tasks. This project was developed to practice and demonstrate core backend concepts, MVC architecture, secure data management, and infrastructure provisioning.

## Features

*   **CRUD Operations:** Create, Read, Update, and Delete tasks.
*   **DTO Pattern:** Implementation of Data Transfer Objects to decouple the database layer from the API and secure data exposure.
*   **Data Validation:** Prevents empty or invalid data using Spring Boot Validation (`@NotBlank`, `@Size`).
*   **Global Exception Handling:** Custom `404 Not Found` responses for invalid task IDs using custom exceptions.
*   **Secure Configuration:** Hides database credentials using `.env` files and native Spring Boot configuration imports.
*   **Containerized Database:** Automated database provisioning using Docker and Docker Compose.
*   **Interactive Documentation:** Automated API mapping using Swagger/OpenAPI.

## Tech Stack

*   **Language:** Java 17
*   **Framework:** Spring Boot 3
*   **Database:** PostgreSQL
*   **Infrastructure:** Docker & Docker Compose
*   **Build Tool:** Maven
*   **API Documentation:** Springdoc OpenAPI (Swagger)

## How to Run

### Prerequisites
Make sure you have Java 17, Docker, and Docker Compose installed on your machine.

### 1. Clone the repository
```bash
git clone [https://github.com/gbernalle/task-manager-api.git](https://github.com/gbernalle/task-manager-api.git)
cd task-manager-api
```

### 2. Environment Setup
Create a file named .env in the root directory of the project and define your database credentials:

```bash
DB_NAME=task_manager_db
DB_USER=your_postgres_username
DB_PASSWORD=your_postgres_password
```

### 3. Start the Database
Run the following command to start the PostgreSQL container in the background:

```bash
docker-compose up -d
```

### 4. Run the Application
You can run the application using your IDE (like Eclipse or IntelliJ) or via the terminal using Maven wrapper:

```bash
./mvnw spring-boot:run
```

### 5. Access the API Documentation
Once the application is running, you can test the endpoints directly from your browser via Swagger UI:

```bash
URL: http://localhost:8080/swagger-ui.html