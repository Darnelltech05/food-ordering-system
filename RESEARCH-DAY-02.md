# Research Day 02 - Standard Response Wrapper

## Q1. What is a Java generic type? Why is `<T>` useful?

A Java generic type allows classes and methods to work with different data types while maintaining type safety. `<T>` acts as a placeholder for a data type, making code reusable and reducing the need for type casting.

## Q2. What does Lombok `@Builder` generate behind the scenes?

`@Builder` generates a Builder class, a `builder()` method, setter-like methods for each field, and a `build()` method that creates the final object.

## Q3. What is the Builder design pattern? When to use it?

The Builder pattern is a design pattern used to create complex objects step by step. It is useful when a class has many fields, optional parameters, or when constructors become too large and difficult to read.

## Q4. What is `LocalDateTime`? How is it different from `Date`?

`LocalDateTime` is a Java 8 date and time class that represents both date and time without a time zone. Unlike `Date`, it is immutable, thread-safe, and easier to work with.

## Q5. Why does a consistent response format matter to frontend developers?

A consistent response format makes APIs predictable, simplifies error handling, improves debugging, and allows frontend developers to process responses more easily.

## Q6. What does `@JsonInclude(JsonInclude.Include.NON_NULL)` do?

It prevents fields with `null` values from being included in the JSON response, resulting in cleaner and smaller JSON output.

## Q7. What is a static factory method? Why use `Response.success(...)` instead of `new Response<>()`?

A static factory method is a static method that creates and returns objects. `Response.success(...)` is preferred because it improves readability, reduces duplicate code, and ensures consistent object creation.

## Self-Quiz Answers

### Q1. Why use generic `<T>` instead of `Object` for data field?

`<T>` provides type safety, avoids manual type casting, and allows the compiler to detect type errors at compile time.

### Q2. Difference between `Response<T>` and `ResponseEntity<T>`? Can you have both at once?

`Response<T>` is a custom class that structures API response data. `ResponseEntity<T>` is a Spring class that controls HTTP responses, including status codes and headers. Yes, they can be used together.

### Q3. If a request fails, what `statusCode` does `Response` hold?

It usually holds an error status code such as 400 (Bad Request), 401 (Unauthorized), 404 (Not Found), or 500 (Internal Server Error), depending on the failure.

### Q4. Why add a timestamp?

A timestamp records when the response was generated, helping with debugging, logging, auditing, and tracking requests.
