# Banking & Loan Management System

A RESTful Banking & Loan Management System developed using Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL. The application enables users to manage banking accounts, apply for loans, repay loans, track loan status, and perform complete CRUD operations through REST APIs.

---

## Features

### User Management

* Create User
* Get User Details
* Update User Details
* Delete User
* Search User By Name

### Account Management

* Create Account
* Get Account Details
* Update Account Information
* Delete Account
* View All Accounts Associated With A User

### Loan Management

* Apply For Loan
* Get Loan Details
* Update Loan Information
* Delete Loan
* View All Loans Associated With A User

### Loan Repayment

* Repay Loan Amount
* Automatically Update Remaining Balance
* Track Loan Status (Active / Repaid)

### Validation & Exception Handling

* Bean Validation using Jakarta Validation
* Global Exception Handling
* Custom Not Found Exception Handling

---

## Technologies Used

### Backend

* Java
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate

### Database

* MySQL

### Tools

* Maven
* Postman
* Git
* GitHub
* Eclipse IDE

---

## Architecture

The application follows a layered architecture:

Controller Layer

↓

Service Layer

↓

Repository Layer

↓

Entity Layer

↓

MySQL Database

This architecture improves maintainability, scalability, and separation of concerns.

---

## Database Entities

### User

* User ID
* Name
* Email
* Password

### Account

* Account ID
* Account Number
* Account Balance

### Loan

* Loan ID
* Loan Amount
* Apply Date
* Approval Date
* Disbursement Date
* Outstanding Balance
* Loan Status

---

## Entity Relationships

### User ↔ Account

One User can have Multiple Accounts.

Implemented using:

* @OneToMany
* @ManyToOne

### User ↔ Loan

One User can have Multiple Loans.

Implemented using:

* @OneToMany
* @ManyToOne

---

## REST API Endpoints

### User APIs

| Method | Endpoint      | Description         |
| ------ | ------------- | ------------------- |
| POST   | /users        | Create User         |
| GET    | /users/{id}   | Get User By ID      |
| PUT    | /users/{id}   | Update User         |
| DELETE | /users/{id}   | Delete User         |
| GET    | /users/search | Search User By Name |

---

### Account APIs

| Method | Endpoint                            | Description       |
| ------ | ----------------------------------- | ----------------- |
| POST   | /user/{userId}/accounts             | Create Account    |
| GET    | /user/{userId}/accounts             | Get All Accounts  |
| GET    | /user/{userId}/accounts/{accountId} | Get Account By ID |
| PUT    | /user/{userId}/accounts/{accountId} | Update Account    |
| DELETE | /user/{userId}/accounts/{accountId} | Delete Account    |

---

### Loan APIs

| Method | Endpoint                                      | Description       |
| ------ | --------------------------------------------- | ----------------- |
| POST   | /users/{userId}/loans                         | Apply Loan        |
| GET    | /users/{userId}/loans                         | Get All Loans     |
| GET    | /users/{userId}/loans/{loanId}                | Get Loan By ID    |
| PUT    | /users/{userId}/loans/{loanId}                | Update Loan       |
| DELETE | /users/{userId}/loans/{loanId}                | Delete Loan       |
| POST   | /users/{userId}/loans/{loanId}/repay/{amount} | Repay Loan        |
| GET    | /users/{userId}/loans/{loanId}/status         | Check Loan Status |

---

## Key Concepts Implemented

* Object-Oriented Programming (OOP)
* RESTful Web Services
* CRUD Operations
* Spring Boot Development
* Spring Data JPA
* Hibernate ORM
* One-to-Many Mapping
* Many-to-One Mapping
* Bean Validation
* Exception Handling
* Layered Architecture
* Dependency Injection
* Repository Pattern

---

## Testing

* REST API testing performed using Postman.
* Validation and exception scenarios tested using custom requests.

---

## Future Enhancements

* Spring Security
* JWT Authentication
* Fund Transfer Between Accounts
* Transaction History Module
* Role-Based Access Control
* Online Banking Dashboard
* Email Notifications

---

## Author

Prabhakar S

GitHub:
https://github.com/sprabhu7333

LinkedIn:
https://linkedin.com/in/prabhakar-senthilmurugan
