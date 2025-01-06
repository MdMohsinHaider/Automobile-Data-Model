package com.automobile_data_model.one_to_one_curd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    /**
     * Primary Key:
     * @Id and @GeneratedValue(strategy = GenerationType. IDENTITY) for a unique identifier.
     * Properties:
     * registrationNumber: Unique for each car (e.g., license plate).
     * Model: Specify the model name (e.g., Civic, Corolla).
     * Manufacturer: The company that made the car (e.g., Toyota, Honda).
     * Year: The year the car was manufactured.
     * Relationship:
     * @OneToOne: Defines the one-to-one relationship with the Engine entity.
     * @JoinColumn: Links the engine field to the Engine table’s id column.
     * CascadeType.ALL: Ensures changes in the Car entity propagate to the associated Engine.
     * Lombok Annotations:
     * @Data: Generates getters, setters, toString, equals, and hashCode.
     * @NoArgsConstructor: Creates a no-arguments constructor.
     * @AllArgsConstructor: Creates an all-arguments constructor.
     */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registrationNumber; // Unique identifier for the car (e.g., license plate)
    private String model; // Model name of the car
    private String manufacturer; // Manufacturer of the car
    private int year; // Manufacturing year of the car

    @OneToOne(cascade = CascadeType.ALL) // Establishing one-to-one relationship
    @JoinColumn(name = "engine_id", referencedColumnName = "id")
    private Engine engine; // Associated engine for the car
}
