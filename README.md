# Task Manager API

A RESTful API built with Java and Spring Boot to manage daily tasks. This project was developed to practice and demonstrate core backend concepts, MVC architecture, and API best practices.

## Features

*   **CRUD Operations:** Create, Read, Update, and Delete tasks.
*   **Data Validation:** Prevents empty or invalid data using Spring Boot Validation (`@NotBlank`, `@Size`).
*   **Global Exception Handling:** Custom `404 Not Found` responses for invalid task IDs using `@ControllerAdvice` and custom exceptions.
*   **Interactive Documentation:** Automated API mapping using Swagger/OpenAPI.

## Tech Stack

*   **Language:** Java (Version 17/21)
*   **Framework:** Spring Boot
*   **Build Tool:** Maven
*   **API Documentation:** Springdoc OpenAPI (Swagger)

## How to Run

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/gbernalle/task-manager-api.git](https://github.com/gbernalle/task-manager-api.git)