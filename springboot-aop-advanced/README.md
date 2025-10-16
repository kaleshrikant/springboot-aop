# 🌟 Spring Boot AOP Advanced Example — Multi-Aspect & Custom Annotations

> **Goal:** Learn how to implement multiple aspects in Spring Boot using **custom annotations** for **logging, auditing, and security**.

---

## 🧠 What is AOP?

**Aspect-Oriented Programming (AOP)** allows you to separate **cross-cutting concerns** from business logic:

- **Logging**
- **Security checks**
- **Performance monitoring**
- **Auditing**

Instead of repeating code, aspects **wrap your methods** and execute additional logic automatically.

---

## ⚙️ Core Concepts

| Term | Meaning | Example |
|------|--------|---------|
| **Aspect** | Class containing cross-cutting logic | `LogExecutionTimeAspect` |
| **Advice** | Action performed by an aspect | `@Before`, `@AfterReturning`, `@Around` |
| **JoinPoint** | A point in execution where advice is applied | Calling `addProduct()` |
| **Pointcut** | Expression defining which methods are intercepted | `@annotation(LogExecutionTime)` |
| **Custom Annotation** | Marks methods to trigger aspects | `@Audit`, `@SecureAction` |

---

## 🧩 Project Flow

### 1️⃣ Layers
│
Service → ProductService
│
Aspects → AuditAspect, SecurityAspect, LogExecutionTimeAspect

### 2️⃣ Execution Flow Example

Calling:
GET /product/add?name=MacBook

**Console Output:**
[AUDIT] Starting action: Add New Product | Method: addProduct
[SECURITY] Access granted for role: ADMIN
[AOP] String ProductService.addProduct(String) executed in 500 ms
[AUDIT] Completed action: Add New Product | Result: Product 'MacBook' added successfully.


**Explanation:**
1. **AuditAspect @Before** → Logs start of action
2. **SecurityAspect @Before** → Checks user role
3. **LogExecutionTimeAspect @Around** → Measures execution time
4. **Service Method Executes** → Business logic (sleep 500ms)
5. **AuditAspect @AfterReturning** → Logs action completion

---

## 🧩 Custom Annotations

| Annotation | Purpose |
|------------|---------|
| `@LogExecutionTime` | Measure method execution duration |
| `@Audit(action="...")` | Log audit info before & after method |
| `@SecureAction(role="...")` | Check if current user has required role |
---

## 🔧 Key Configuration
```java
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@SpringBootApplication
public class SpringbootAopAdvancedApplication { ... }
```

Enables AspectJ auto-proxying for Spring beans

proxyTargetClass = true → Use class-based proxies

exposeProxy = true → Optional for self-invocation within proxied beans
🧩 Aspect Summary
| Aspect                   | Advice                    | Annotation        | Purpose                              |
| ------------------------ | ------------------------- | ----------------- | ------------------------------------ |
| `AuditAspect`            | @Before / @AfterReturning | @Audit            | Logs method start & completion       |
| `SecurityAspect`         | @Before                   | @SecureAction     | Validates user role before execution |
| `LogExecutionTimeAspect` | @Around                   | @LogExecutionTime | Measures and logs execution duration |

🔍 Key Learnings

AOP separates cross-cutting concerns from business logic

Multiple aspects can apply simultaneously to the same method

@Around wraps the method execution; @Before / @AfterReturning run outside it

Custom annotations make aspects clean, reusable, and configurable

🧭 When to Use
| Use Case     | Example                            |
| ------------ | ---------------------------------- |
| Logging      | Request/Response or execution time |
| Auditing     | Track user activity & method calls |
| Security     | Role-based access checks           |
| Metrics      | Performance & monitoring           |
| Transactions | Apply rollback behavior            |

🔗 Flow Diagram 
HTTP Request: /product/add?name=MacBook
           │
           ▼
   [AuditAspect @Before] → Logs action start
           │
   [SecurityAspect @Before] → Checks role
           │
   [LogExecutionTimeAspect @Around] → Start timer
           │
   ProductService.addProduct() → Business logic
           │
   [LogExecutionTimeAspect @Around] → Stop timer, log duration
           │
   [AuditAspect @AfterReturning] → Logs completion & result
           │
           ▼
       Response → Product 'MacBook' added successfully

✅ Summary

Spring Boot AOP allows clean separation of cross-cutting concerns

Custom annotations make it easy to apply aspects to specific methods

Multi-aspect execution order is predictable: @Before → @Around → method → @AfterReturning

Console logs provide insight into security, auditing, and performance

© 2025 — Shrikant Kale
Simplified Conceptual Guide for Spring Boot AOP with Multi-Aspect Custom Annotations