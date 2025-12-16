# Monthly Challenge REST API

A Spring Boot REST API application to manage monthly challenges.  
This project provides CRUD operations (Create, Read, Update, Delete) for monthly challenges using RESTful endpoints.

---

## 🚀 Features
- Create a monthly challenge
- Retrieve all challenges
- Retrieve a challenge by month
- Update a challenge by ID
- Delete a challenge by ID

---

## 🛠️ Tech Stack
- Java
- Spring Boot
- Spring Web (REST APIs)
- Maven
- Embedded Tomcat

---

## 📂 Project Structure

src/main/java/com/springboot/restapis/monthlyChallengeApp
├── controller
│ └── ChallengeController.java
├── services
│ └── ChallengeService.java
└── MonthlyChallengeAppApplication.java



---

## 📌 API Endpoints

### Get all challenges


**Response**
```json
[
  {
    "id": 1,
    "month": "January",
    "description": "Learn Spring Boot"
  }
]

➤ Get challenge by month
GET /challenges/{month}

Example:
GET /challenges/January

➤ Create a challenge
create challenge

Request Body
POST /challenges
{
  "month": "January",
  "description": "Learn Spring Boot"
}

➤ Update a challenge
PUT /challenges/{id}

Request Body
request body
{
  "month": "February",
  "description": "Build REST APIs"
}

➤ Delete a challenge
DELETE /challenges/{id}

How to Run the Application:

1. Prerequisites
    Java 8 or above
    Maven

2. Steps
Clone the repository
git clone https://github.com/bipul-raj/monthly-challenge-app.git

3. Navigate to the project directory
cd monthly-challenge-app

4. Run the application
mvn spring-boot:run

The application will start on:
http://localhost:8080

---------------------------------------------------
Testing the APIs:
Postman
cURL
Browser (for GET requests)

------------------------------------------------------
Future Enhancements:
Integrate database using Spring Data JPA
Add Swagger / OpenAPI documentation
Add global exception handling
Add validation and unit tests
