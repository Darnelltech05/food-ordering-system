# Food Ordering System - Spring Boot Assignment

# Part 4: Research Questions

### 1. What is Spring Boot?

Spring Boot is a Java framework that simplifies the development of web applications and APIs by providing preconfigured settings and tools. It reduces setup time and allows developers to focus on writing business logic.

### 2. What is Maven?

Maven is a build and dependency management tool for Java projects. It automates project building, testing, packaging, and dependency downloads.

### 3. What is the purpose of pom.xml?

This file tells Maven what your project needs. It lists all the dependencies like Spring Web, MySQL Driver, the Java version, and how to build the project.

### 4. What is the purpose of application.properties?

The application.properties file stores application configuration such as database connection details, server ports, and environment settings.

### 5. What does @SpringBootApplication do?

@SpringBootApplication is the main annotation that enables Spring Boot features, component scanning, and automatic configuration.

### 6. Why do developers use dependency management tools such as Maven?

So you don't have to manually download JAR files, worry about versions, or manage classpaths. Maven handles everything automatically and makes sure all dependencies work together.

### 7. What is a REST API?

A REST API is a web service that allows applications to communicate over HTTP using methods such as GET, POST, PUT, and DELETE.

### 8. What is JSON?

JSON (JavaScript Object Notation) is a lightweight text format used to exchange data between systems.

### 9. What is Dependency Injection?

Dependency Injection is a design pattern where objects receive their dependencies from a framework rather than creating them themselves, improving flexibility and maintainability.

## Part 5: Package Structure

### Purpose of each package:

| Package    | Purpose                                                              |
|------------|----------------------------------------------------------------------|
| controller | Handles incoming HTTP requests and returns responses.                |
| service    | Contains business logic and processing rules.                        |
| repository | Communicates with the database using JPA.                            |
| entity     | Contains classes that represent database tables.                     |
| dto        | Contains Data Transfer Objects used to transfer data between layers. |
| config     | Stores configuration classes and application settings.               |
| exception  | Contains custom exceptions and error handling logic.                 |