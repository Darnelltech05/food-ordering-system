# Research Day 01 - Category CRUD

## Q1. What does CRUD stand for?
CRUD stands for Create, Read, Update, and Delete. These are the four basic operations performed on data in most applications.

## Q2. Difference between HTTP methods POST, PUT, PATCH, DELETE?
POST - Used to create a new resource. For example, creating a new category.

PUT - Used to update an existing resource by replacing its data with new values.

PATCH - Used to partially update a resource by changing only specific fields.

DELETE - Used to remove a resource from the system.

## Q3. HTTP Status Codes:
a. A new category was created:201 Created The request was successful and a new resource was created.

b. A category was deleted successfully:204 No Content The resource was deleted successfully and no response body is needed.

c. The id requested does not exist:404 Not Found The requested resource could not be found.

d. The request body is missing a required field:400 Bad Request The request contains invalid or incomplete data

e. User logged in but not allowed:403 Forbidden The user is authenticated but does not have permission to perform the action.

## Q4. Difference between @RequestBody, @RequestParam, @PathVariable
@RequestBody: Used to receive data from the request body. @PostMapping
public CategoryDto create(@RequestBody CategoryDto dto) {
return service.addCategory(dto);
}

@RequestParam: Used to receive values from query parameters.@GetMapping
public String search(@RequestParam String name) {
return name;
}

@PathVariable: Used to receive values directly from the URL path.@GetMapping("/{id}")
public CategoryDto getById(@PathVariable Long id) {
return service.getCategoryById(id);
}

## Q5. What is Jakarta Bean Validation?
@Valid:Triggers validation on an object before it is passed to the service layer.

@NotBlank:Ensures that a field is not null, empty, or only spaces.

@Size:Restricts the minimum and maximum length of a field.

## Q6. Why return a DTO and not the entity itself? Give 2 reasons.
Reason 1:DTOs help hide sensitive or unnecessary data from API users.

Reason 2:DTOs allow developers to control exactly what data is sent to clients without exposing the internal database structure.

## Q7. What is Optional<T>? Why does findById return Optional?
Optional<T> is a container object that may contain a value or may be empty.

findById() returns Optional because the requested record may not exist in the database. Using Optional helps prevent NullPointerException and forces developers to handle missing data properly.

## Self-Quiz Answers:
### Q1. Why ResponseEntity instead of returning the object?
ResponseEntity gives full control over the HTTP response, including status codes, headers, and response body.
### Q2. What status should a successful DELETE return? Why?
A successful DELETE should return 204 No Content because the resource was removed successfully and there is no data to return.
### Q3. Update only one field - PUT or PATCH? Defend your answer.
PATCH is more appropriate because it is designed for partial updates. PUT is generally used when replacing the entire resource.
### Q4. What happens if you forget @Valid on the controller?
Validation annotations such as @NotBlank and @Size will not be executed, allowing invalid data to be accepted by the application.
### Q5. Why must update/delete have {id} in the URL but create does not?
Update and delete operations need to know which specific resource should be modified or removed. Create does not require an id because the database generates a new id when the resource is created.