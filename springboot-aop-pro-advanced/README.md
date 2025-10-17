# Spring Boot AOP Advanced Example

**Author:** Shrikant Kale  
**Date:** 17 Oct 2025

---

## 📘 Table of Contents
1. [Project Overview](#project-overview)
2. [Features Implemented](#features-implemented)
3. [Project Structure](#project-structure)
4. [Setup & Run](#setup--run)
5. [Testing the Application](#testing-the-application)
6. [How AOP Works Here](#how-aop-works-here)
7. [Security Aspect](#security-aspect)
8. [Auditing Aspect](#auditing-aspect)
9. [Logging Aspect](#logging-aspect)
10. [Transaction Aspect](#transaction-aspect)
11. [Conclusion](#conclusion)

---

## 🧩 Project Overview

This is a **Spring Boot 3** application demonstrating advanced **Aspect-Oriented Programming (AOP)** features, including:

- Logging method execution
- Auditing actions
- Security checks
- Transaction simulation
- Execution tracking

We simulate a `CustomerService` that can **add** and **find** customers, while AOP handles cross-cutting concerns.

---

## 🚀 Features Implemented

- `@TrackExecution` → Measures method execution time
- `@Audit(action = "...")` → Logs audit info before, after, and finally
- `@SecureAction(role = "...")` → Role-based access control
- **Transaction Aspect** → Simulates transactions
- **Logging Aspect** → Logs method start, end, exceptions

---

## 🗂️ Project Structure

```text
src/main/java
└── com.kaleshrikant.springboot.aop
    ├── SpringbootAopProAdvancedApplication.java
    ├── model
    │   └── Customer.java
    ├── service
    │   └── CustomerService.java
    ├── controller
    │   └── CustomerController.java
    ├── annotation
    │   ├── TrackExecution.java
    │   ├── Audit.java
    │   └── SecureAction.java
    └── aspect
        ├── LoggingAspect.java
        ├── AuditAspect.java
        ├── SecurityAspect.java
        └── TransactionAspect.java
```

---

## ⚙️ Setup & Run

1. **Clone the repository**

```bash
git clone <repo-url>
cd springboot-aop-pro-advanced
```

2. **Build the project**

```bash
./gradlew build
```

3. **Run the application**

```bash
./gradlew bootRun
```

---

## 🧪 Testing the Application

### 1️⃣ Add a Customer (POST)

```bash
curl -X POST http://localhost:8080 \
     -H "Content-Type: application/json" \
     -d '{"name":"Shrikant Kale","email":"shrikant@example.com"}'
```

📥 Response:

```json
{
  "name": "Shrikant Kale",
  "email": "shrikant@example.com"
}
```

---

### 2️⃣ Find a Customer (GET)

✅ With proper role (`USER`):

```bash
curl -X GET "http://localhost:8080/Shrikant%20Kale" -H "X-Role: USER"
```

📥 Response:

```json
{
  "name": "Shrikant Kale",
  "email": "shrikantkale@example.com"
}
```

❌ With wrong role (`ADMIN`):

```bash
curl -X GET "http://localhost:8080/Shrikant%20Kale" -H "X-Role: ADMIN"
```

📥 Response:

```json
{
  "timestamp": "...",
  "status": 500,
  "error": "Internal Server Error",
  "path": "/Shrikant Kale"
}
```

🔒 Access denied by `SecurityAspect`.

---

## 🧠 How AOP Works Here

We applied custom annotations to methods in `CustomerService`:

- `@TrackExecution` → Around advice measures method execution time
- `@Audit` → Logs audit messages:
    - Before method start
    - After method completes
    - After throwing exception
    - Finally
- `@SecureAction` → Checks role from request header `X-Role`

---

## 🔐 Security Aspect

- Reads `X-Role` from request header
- Compares with required role from `@SecureAction`
- Throws `SecurityException` if access is denied

```java
@SecureAction(role = "USER")
public Customer findCustomer(String name) { ... }
```

---

## 📝 Auditing Aspect

- Logs start, completion, and result of each action
- Always runs `finally` block regardless of exceptions

🧾 Example:

```
[AUDIT] Action: Find Customer started
[AUDIT] Action: Find Customer completed
[AUDIT] (Finally) Action: Find Customer
```

---

## 📋 Logging Aspect

- Logs method execution time
- Logs returned value or exception

🧾 Example:

```
[LOG] CustomerService.addCustomer executed in 206 ms
[LOG] Returned: Customer(name=Shrikant Kale, email=shrikant@example.com)
```

---

## 🔄 Transaction Aspect

Simulates transactional boundaries:

```
[TX] Beginning transaction...
[TX] Transaction committed.
[TX] Transaction scope ended.
```

---

## 🏁 Conclusion

This project demonstrates how to:

- Use Spring AOP to implement cross-cutting concerns
- Apply custom annotations for audit, security, transaction, and logging
- Simulate role-based security using headers
- Track execution and log important method information