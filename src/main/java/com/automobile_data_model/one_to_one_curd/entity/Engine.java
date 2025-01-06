package com.automobile_data_model.one_to_one_curd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

        /**
         * Key Lombok Annotations Used:
         * @Data: A combination of @Getter, @Setter, @ToString, @EqualsAndHashCode, and @RequiredArgsConstructor. It simplifies your code significantly.
         * @NoArgsConstructor: Generates a no-arguments constructor.
         * @AllArgsConstructor: Generates an all-arguments constructor.
         * @Column(unique = true): Ensures the engineNumber is unique in the database.
         * Benefits of Using Lombok:
         * Reduces Boilerplate Code: No need to manually write getters, setters, toString, equals, or hashCode methods.
         * Improves Readability: Makes the entity easier to read and maintain.
         * Time-Saving: Speeds up development.
         */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String engineNumber; // Unique identifier for the engine
    private String type; // e.g., Petrol, Diesel, Electric
    private int horsepower; // Horsepower of the engine
    private double displacement; // Engine displacement in liters (e.g., 2.0L)
    private String manufacturer; // Manufacturer of the engine
}
