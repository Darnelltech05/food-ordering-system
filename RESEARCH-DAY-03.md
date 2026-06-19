# Research Day 03 - Menu Feature

## Q1. What is JPA? What is Hibernate? How are they related?

JPA (Java Persistence API) is a specification for managing data in Java applications. Hibernate is a framework that implements JPA. JPA defines the rules, while Hibernate provides the actual implementation.

## Q2. What is the difference between @Entity and @Table?

`@Entity` marks a class as a JPA entity that can be stored in a database. `@Table` specifies the database table name that the entity maps to. `@Entity` is required, while `@Table` is optional if the table name matches the class name.

## Q3. What is a foreign key? What is @ManyToOne? Give 2 real-world examples.

A foreign key is a column that links one table to another. `@ManyToOne` represents a relationship where many records belong to one parent record.

Examples:

1. Many Menu Items belong to one Category.
2. Many Employees belong to one Department.

## Q4. What does @JoinColumn(name = "category_id") do?

It specifies the foreign key column used to create the relationship between two entities. In this case, `category_id` links a menu item to its category.

## Q5. Why store price as BigDecimal and not double?

`BigDecimal` provides precise decimal calculations and avoids rounding errors. `double` can produce inaccurate results for financial values such as prices.

## Q6. What does FetchType LAZY vs EAGER mean? What is the default for @ManyToOne?

LAZY loads related data only when needed. EAGER loads related data immediately with the entity. The default fetch type for `@ManyToOne` is EAGER.

## Q7. What is the N+1 query problem?

The N+1 query problem occurs when one query retrieves a list of records, and then additional queries are executed for each record to fetch related data, causing performance issues.

## Q8. What is dependency injection? Constructor injection vs field injection - which is preferred and why?

Dependency injection is a design pattern where objects receive their dependencies from Spring instead of creating them manually. Constructor injection is preferred because it makes dependencies explicit, supports immutability, and is easier to test.

## Q9. What does @RequiredArgsConstructor (Lombok) do?

`@RequiredArgsConstructor` automatically generates a constructor for all `final` fields and fields marked with `@NonNull`, reducing boilerplate code.

## Q10. What is the role of the SERVICE layer? Why must it be separate from the controller?

The Service layer contains business logic and application rules. It should be separate from the controller to keep code organized, reusable, maintainable, and easier to test.

## Q11. Why MUST you validate that categoryId exists before saving a menu?

Validation ensures that the category exists before creating the menu item. This prevents invalid foreign key references and maintains data integrity.

## Q12. Difference between save() and saveAndFlush()?

`save()` stores the entity and waits for Hibernate to synchronize changes later. `saveAndFlush()` saves the entity and immediately writes the changes to the database.

## Q13. Why write private mapper methods (entity <-> dto)?

Private mapper methods convert entities to DTOs and DTOs to entities. This keeps conversion logic centralized, avoids code duplication, and improves maintainability.
