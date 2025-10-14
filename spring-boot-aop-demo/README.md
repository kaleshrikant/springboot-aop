# Spring Boot AOP Demo Project

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.4-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.java.net/)
[![Gradle](https://img.shields.io/badge/Gradle-8.x-blue.svg)](https://gradle.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

A comprehensive demonstration of **Aspect-Oriented Programming (AOP)** in Spring Boot using custom annotations, showcasing real-world use cases like logging, auditing, and validation.

## 📋 Table of Contents

- [Features](#-features)
- [Technologies Used](#-technologies-used)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
- [Custom Annotations](#-custom-annotations)
- [API Endpoints](#-api-endpoints)
- [Testing](#-testing)
- [AOP Concepts Demonstrated](#-aop-concepts-demonstrated)
- [Console Output Examples](#-console-output-examples)
- [Contributing](#-contributing)
- [License](#-license)

---

## ✨ Features

- 🎯 **Custom Annotations** for clean, declarative AOP
- 📊 **Performance Monitoring** with execution time tracking
- 📝 **Audit Logging** for all CRUD operations
- ✅ **Input Validation** using AOP aspects
- 🚀 **RESTful API** with complete CRUD operations
- 🔧 **Java 21** with modern syntax and features
- 📦 **Gradle** build system
- 🎨 **Lombok** for cleaner code
- 🐛 **Comprehensive error handling**

---

## 🛠 Technologies Used

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 21 | Programming Language |
| Spring Boot | 3.3.4 | Framework |
| Spring AOP | 3.3.4 | Aspect-Oriented Programming |
| Gradle | 8.x | Build Tool |
| Lombok | Latest | Boilerplate Reduction |
| SLF4J/Logback | Latest | Logging |

---

## 📁 Project Structure

```
spring-boot-aop-demo/
├── src/main/java/com/kaleshrikant/spring/aop/
│   ├── AopDemoApplication.java          # Main application class
│   ├── annotation/                       # Custom annotations
│   │   ├── LogExecutionTime.java
│   │   ├── Audit.java
│   │   └── ValidateInput.java
│   ├── aspect/                           # AOP aspects
│   │   ├── LoggingAspect.java
│   │   ├── AuditAspect.java
│   │   └── ValidationAspect.java
│   ├── controller/                       # REST controllers
│   │   └── ProductController.java
│   ├── service/                          # Business logic
│   │   └── ProductService.java
│   ├── model/                            # Domain models
│   │   └── Product.java
│   └── exception/                        # Custom exceptions
│       └── ValidationException.java
├── src/main/resources/
│   └── application.properties            # Configuration
├── build.gradle                          # Gradle build script
├── settings.gradle                       # Gradle settings
└── README.md                             # This file
```

---

## 🚀 Getting Started

### Prerequisites

- **Java 21** or higher
- **Gradle 8.x** or higher
- **IntelliJ IDEA** (recommended) or any Java IDE

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/kaleshrikant/spring-boot-aop-demo.git
   cd spring-boot-aop-demo
   ```

2. **Build the project**
   ```bash
   ./gradlew build
   ```

3. **Run the application**
   ```bash
   ./gradlew bootRun
   ```

   Or using Java:
   ```bash
   java -jar build/libs/spring-boot-aop-demo-1.0.0.jar
   ```

4. **Access the application**
   ```
   http://localhost:8080/api/products
   ```

### Quick Start with IntelliJ IDEA

1. Open IntelliJ IDEA
2. **File → Open** → Select project folder
3. Wait for Gradle sync to complete
4. Run `AopDemoApplication.java`
5. Open browser: `http://localhost:8080/api/products`

---

## 🎯 Custom Annotations

### 1. @LogExecutionTime

**Purpose**: Tracks method execution time and logs performance metrics

**Usage**:
```java
@LogExecutionTime(description = "Creating a new product")
public Product createProduct(Product product) {
    // Method implementation
}
```

**Output**:
```
▶️  Starting: ProductService.createProduct
   Description: Creating a new product
✅ Completed: ProductService.createProduct in 12ms
```

### 2. @Audit

**Purpose**: Creates audit trail for operations with success/failure tracking

**Usage**:
```java
@Audit(action = "CREATE", module = "PRODUCT")
public Product createProduct(Product product) {
    // Method implementation
}
```

**Output**:
```
📋 ========== AUDIT LOG ==========
   Timestamp: 2025-10-14 10:30:45
   Module: PRODUCT
   Action: CREATE
   Status: ✅ SUCCESS
=================================
```

### 3. @ValidateInput

**Purpose**: Validates method input parameters before execution

**Usage**:
```java
@ValidateInput
public Product createProduct(Product product) {
    // Method implementation
}
```

**Validation Rules**:
- Product name cannot be empty
- Product price must be greater than 0
- Product category cannot be empty

---

## 🌐 API Endpoints

### Product Management

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| `POST` | `/api/products` | Create a new product | Product JSON |
| `GET` | `/api/products` | Get all products | - |
| `GET` | `/api/products/{id}` | Get product by ID | - |
| `PUT` | `/api/products/{id}` | Update product | Product JSON |
| `DELETE` | `/api/products/{id}` | Delete product | - |
| `GET` | `/api/products/search?category={category}` | Search by category | - |

### Product JSON Schema

```json
{
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 1299.99,
  "category": "Electronics",
  "stock": 50
}
```

---

## 🧪 Testing

### Using cURL

**Create Product:**
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Laptop",
    "description": "Gaming Laptop",
    "price": 1299.99,
    "category": "Electronics",
    "stock": 50
  }'
```

**Get All Products:**
```bash
curl http://localhost:8080/api/products
```

**Get Product by ID:**
```bash
curl http://localhost:8080/api/products/1
```

**Update Product:**
```bash
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Gaming Laptop Pro",
    "description": "Updated Description",
    "price": 1499.99,
    "category": "Electronics",
    "stock": 30
  }'
```

**Delete Product:**
```bash
curl -X DELETE http://localhost:8080/api/products/1
```

**Search by Category:**
```bash
curl "http://localhost:8080/api/products/search?category=Electronics"
```

**Test Validation (Invalid Product):**
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "",
    "price": -10
  }'
```

### Using IntelliJ HTTP Client

Create a file `test-requests.http` in your project:

```http
### Create Product
POST http://localhost:8080/api/products
Content-Type: application/json

{
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 1299.99,
  "category": "Electronics",
  "stock": 50
}

### Get All Products
GET http://localhost:8080/api/products
```

---

## 📚 AOP Concepts Demonstrated

### 1. Aspect
A modular unit of cross-cutting concern (LoggingAspect, AuditAspect, ValidationAspect)

### 2. Join Point
Points in program execution where aspects can be applied (method execution)

### 3. Advice Types Used

| Advice Type | Annotation | Usage | Example |
|-------------|-----------|-------|---------|
| Around | `@Around` | Wraps method execution | LoggingAspect |
| After Returning | `@AfterReturning` | Executes after successful return | AuditAspect (success) |
| After Throwing | `@AfterThrowing` | Executes when exception occurs | AuditAspect (failure) |
| Before | `@Before` | Executes before method | ValidationAspect |

### 4. Pointcut
Expression that selects join points (methods with custom annotations)

```java
@Around("@annotation(logExecutionTime)")
public Object logExecutionTime(ProceedingJoinPoint joinPoint, LogExecutionTime logExecutionTime)
```

---

## 📊 Console Output Examples

### Successful Product Creation

```
▶️  Starting: ProductService.createProduct
   Description: Creating a new product
🔍 Validating input for method: createProduct
✅ Validation passed
✅ Completed: ProductService.createProduct in 15ms
📋 ========== AUDIT LOG ==========
   Timestamp: 2025-10-14 14:30:45
   Module: PRODUCT
   Action: CREATE
   Method: ProductService.createProduct(..)
   Arguments: [Product(id=null, name=Laptop, description=Gaming Laptop, ...)]
   Result: Product(id=1, name=Laptop, ...)
   Status: ✅ SUCCESS
=================================
```

### Validation Failure

```
▶️  Starting: ProductService.createProduct
   Description: Creating a new product
🔍 Validating input for method: createProduct
❌ Error in ProductService.createProduct: Product name cannot be empty
📋 ========== AUDIT LOG ==========
   Timestamp: 2025-10-14 14:31:20
   Module: PRODUCT
   Action: CREATE
   Status: ❌ FAILURE
   Error: Product name cannot be empty
=================================
```

### Slow Method Warning

```
▶️  Starting: ProductService.searchByCategory
   Description: Searching products by category
⚠️  SLOW METHOD: ProductService.searchByCategory took 1250ms
```

---

## 🎓 Learning Points

This project demonstrates:

1. ✅ Creating custom annotations in Java
2. ✅ Implementing AOP aspects with Spring
3. ✅ Using different advice types (@Before, @After, @Around)
4. ✅ Method interception and parameter access
5. ✅ Performance monitoring and logging
6. ✅ Audit trail implementation
7. ✅ Input validation using AOP
8. ✅ Exception handling in aspects
9. ✅ Java 21 features (records, pattern matching ready)
10. ✅ Clean architecture with separation of concerns

---

## 🔧 Configuration

### Application Properties

```properties
# Server Configuration
server.port=8080

# Application Name
spring.application.name=aop-demo

# Logging Configuration
logging.level.root=INFO
logging.level.com.kaleshrikant.spring.aop=DEBUG
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} - %msg%n
```

### Customization

**Change Server Port:**
```properties
server.port=9090
```

**Adjust Logging Levels:**
```properties
logging.level.com.kaleshrikant.spring.aop=TRACE
```

---

## 🐛 Troubleshooting

### Issue: Port 8080 already in use

**Solution:**
```properties
server.port=8081
```

### Issue: Lombok not working

**Solution:**
1. Install Lombok plugin in IDE
2. Enable annotation processing
3. Rebuild project

### Issue: AOP not intercepting methods

**Solution:**
- Ensure `@EnableAspectJAutoProxy` is present
- Verify aspect beans are in component scan path
- Check pointcut expressions are correct

---

## 📖 Additional Resources

- [Spring AOP Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#aop)
- [AspectJ Documentation](https://www.eclipse.org/aspectj/docs.php)
- [Spring Boot Reference](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Java 21 Features](https://openjdk.java.net/projects/jdk/21/)

---

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👤 Author

**Shrikant Kale**
- Package: `com.kaleshrikant.spring.aop`
- GitHub: [@kaleshrikant](https://github.com/kaleshrikant)

---

## 🙏 Acknowledgments

- Spring Framework Team for excellent AOP support
- AspectJ Team for the powerful AOP library
- Community contributors and reviewers

---

## 📞 Support

For questions and support, please open an issue in the GitHub repository.

---

**Happy Coding! 🚀**