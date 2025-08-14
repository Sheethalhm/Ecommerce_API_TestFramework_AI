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
````
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
````
---
## ⚙️ Setup & Installation

### **1. Prerequisites**
- **Java 8+**
- **Maven**
- **Git**

### **2. Clone the repository**
```
git clone https://github.com/Sheethalhm/Ecommerce_API_TestFramework_AI.git
cd Ecommerce_API_TestFramework_AI
```
### **3. Install dependencies**
If using Maven:
````
mvn clean install
````
▶️ Running the Tests
Run all tests:
````
mvn test
````

Run only Login API tests:
````
mvn -Dtest=LoginApiTest test
````

## 🧪 Test Cases Implemented
## **1. Login API**

### **1.1 Positive case**
- Valid username & Base64-encoded password → returns token.

### **1.2 Negative cases**
- Invalid username
- Wrong password
- Empty fields

The framework detects JSON and plain text responses and extracts the token accordingly.

## 📜 Example API Request
- POST /login
````
{
"username": "testuser@example.com",
"password": "ZGVtbzEyMw=="
}
````
## 📊 Reports
After execution, TestNG generates an HTML report:
````
target/surefire-reports/index.html
````
## ✨ Future Enhancements
### **1. Add test coverage for below APIs:**
- /check
- /view
- /addtocart
- /viewcart
- /deletecart

### ***2. Integrate with Allure Reports**
- Integrate with CI/CD pipeline (GitHub Actions)

## 📄 License

This project is open-source and available under the MIT License.


