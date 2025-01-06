# Automobile Data Model

The **Automobile Data Model** project demonstrates entity modeling and the relationships between `Car` and `Engine` entities using JPA (Java Persistence API). It emphasizes the use of Hibernate as a JPA provider and showcases core concepts like persistence, transaction management, and object-relational mapping.

## Project Overview

The project is built around a one-to-one relationship between two entities:

- **Car**: Represents a car with attributes like registration number, model, manufacturer, and production year.
- **Engine**: Represents an engine with details such as engine number, type, horsepower, displacement, and manufacturer.

The `Car` entity contains a reference to the `Engine` entity, illustrating a tightly coupled relationship. This model is suitable for applications that involve automobile management systems or inventory tracking.

## Project Structure

1. **Entities**
   - `Car`: Defines the properties and annotations required to map a `Car` to a database table.
   - `Engine`: Defines the engine's properties and its association with the `Car`.

2. **Persistence Configuration**
   - Uses a `persistence.xml` file to define the persistence unit and database properties.

3. **Core Logic**
   - Includes Java classes for persisting and managing entities using `EntityManager`.
   - Manages database transactions with `EntityTransaction`.

4. **Lombok Integration**
   - Uses Lombok annotations like `@Data`, `@NoArgsConstructor`, and `@AllArgsConstructor` to reduce boilerplate code.

## Code Examples

```java
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // Create an EntityManagerFactory for the persistence unit "jpa-hibernate-automobile-data-model"
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-hibernate-automobile-data-model");

        // Create an EntityManager from the factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Retrieve the EntityTransaction from the EntityManager
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            // Begin a new transaction
            entityTransaction.begin();

            // Create a new Engine entity
            Engine engine = new Engine("ENG12345", "Petrol", 150, 2.0, "Honda");

            // Create a new Car entity and associate it with the Engine
            Car car = new Car("CAR56789", "Civic", "Honda", 2022, engine);

            // Persist the Car entity (and associated Engine due to CascadeType.ALL)
            entityManager.persist(car);

            // Commit the transaction
            entityTransaction.commit();
        } catch (Exception e) {
            // Rollback the transaction in case of an error
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close the EntityManager and Factory
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
```

```java
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String engineNumber;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private int horsepower;

    @Column(nullable = false)
    private double displacement;

    @Column(nullable = false)
    private String manufacturer;
}
```

```java
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String registrationNumber;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private int year;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "engine_id", referencedColumnName = "id")
    private Engine engine;
}
```
