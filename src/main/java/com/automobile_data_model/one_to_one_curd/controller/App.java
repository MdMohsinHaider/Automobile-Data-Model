package com.automobile_data_model.one_to_one_curd.controller;

import com.automobile_data_model.one_to_one_curd.entity.Car;
import com.automobile_data_model.one_to_one_curd.entity.Engine;
import com.automobile_data_model.one_to_one_curd.service.CarEngineService;
import com.automobile_data_model.one_to_one_curd.service.CarService;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Project : Automobile Data Model");
        CarService service = new CarEngineService();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Save Car and Engine");
        System.out.println("2. Delete Engine by Car ID");
        System.out.println("3. Delete Car by Car ID");
        System.out.println("4. Delete Engine by Engine ID");
        System.out.println("5. Get Car by Car ID");
        System.out.println("6. Get Engine by Engine ID");
        System.out.println("7. Display All Cars");
        System.out.println("8. Display All Engines");

        byte c = scanner.nextByte();
        switch (c) {
            case 1: {
                Engine engine = new Engine("2025Jan060318am", "Petrol", 112, 2.3, "Tata Motors");
                Car car = new Car("BR06BP6294", "SUV", "Tata", 2025, engine);
                System.out.println(service.saveCarEngine(car) ? "Car and Engine saved successfully." : "Failed to save Car and Engine.");
            }
            break;
            case 2: {
                System.out.print("Enter Car ID to delete Engine: ");
                long carId = scanner.nextLong();
                System.out.println(service.deleteEngineByCarId(carId) ? "Engine deleted successfully." : "Failed to delete Engine.");
            }
            break;
            case 3: {
                System.out.print("Enter Car ID to delete: ");
                long carId = scanner.nextLong();
                System.out.println(service.deleteCarByCarId(carId) ? "Car deleted successfully." : "Failed to delete Car.");
            }
            break;
            case 4: {
                System.out.print("Enter Engine ID to delete: ");
                long engineId = scanner.nextLong();
                System.out.println(service.deleteEngineByEngineId(engineId) ? "Engine deleted successfully." : "Failed to delete Engine.");
            }
            break;
            case 5: {
                System.out.print("Enter Car ID to display: ");
                long carId = scanner.nextLong();
                Car car = service.getCarByCarId(carId);
                System.out.println(car != null ? car : "Car not found.");
            }
            break;
            case 6: {
                System.out.print("Enter Engine ID to display: ");
                long engineId = scanner.nextLong();
                Engine engine = service.getEngineByEngineId(engineId);
                System.out.println(engine != null ? engine : "Engine not found.");
            }
            break;
            case 7: {
                List<Car> cars = service.getAllCars();
                cars.forEach(System.out::println);
            }
            break;
            case 8: {
                List<Engine> engines = service.getAllEngines();
                engines.forEach(System.out::println);
            }
            break;
            default: {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
