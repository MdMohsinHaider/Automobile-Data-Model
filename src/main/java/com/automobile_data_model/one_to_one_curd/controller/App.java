package com.automobile_data_model.one_to_one_curd.controller;

import com.automobile_data_model.one_to_one_curd.entity.Car;
import com.automobile_data_model.one_to_one_curd.entity.Engine;
import com.automobile_data_model.one_to_one_curd.service.CarEngineService;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Project : Automobile Data Model");
        CarEngineService service = new CarEngineService();
        Engine engine = new Engine();
        Car car = new Car();

        Scanner scanner = new Scanner(System.in);
        byte c = scanner.nextByte();
        switch (c){
            case 1: {
                engine.setEngineNumber("2025Jan060318am");
                engine.setType("Petrol");
                engine.setHorsepower(110);
                engine.setDisplacement(1.2);
                engine.setManufacturer("Tata motors");

                car.setRegistrationNumber("BR06BP6294");
                car.setModel("SUV");
                car.setManufacturer("Tata");
                car.setYear(2025);
                car.setEngine(engine);
                System.out.println(service.saveCarEngineService(car));
            }break;
            case 2:{
                // Delete
            }break;
            case 3:{
                // Update
            }break;
            case 4:{
                // Display by Id
            }break;
            case 5:{
                // Display All
            }break;
        }
    }
}
