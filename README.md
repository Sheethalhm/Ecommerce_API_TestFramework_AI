# Ecommerce API Test Framework (Java + Rest Assured + TestNG)

## 📌 Overview
This project is an automated API testing framework for the [Demoblaze API](https://api.demoblaze.com) and related Ecommerce endpoints.
It is built using:
- **Java**
- **Rest Assured** for API testing
- **TestNG** for test execution & reporting
- **POJO classes** for clean request/response handling

The framework is designed for **data-driven API tests** with clear separation between:
- Models (`src/main/java`)
- Tests (`src/test/java`)

---

## 📂 Project Structure
EcommerceApiTests/

│
├── src/
│ ├── main/
│ │ └── java/com/ecommerce/api/models/
│ │ ├── LoginRequest.java # POJO for Login request body
│ │ └── LoginResponse.java # POJO for Login API JSON response
│ │
│ └── test/
│ └── java/com/ecommerce/api/tests/
│ ├── BaseTest.java # Base configuration (RestAssured setup)
│ └── LoginApiTest.java # TestNG test cases for Login API
│
└── README.md
