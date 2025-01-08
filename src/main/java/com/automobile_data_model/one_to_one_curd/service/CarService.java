package com.automobile_data_model.one_to_one_curd.service;

import com.automobile_data_model.one_to_one_curd.entity.Car;
import com.automobile_data_model.one_to_one_curd.entity.Engine;

import java.util.List;

public interface CarService {

    /**
     * Save a Car and its associated Engine.
     *
     * @param car the Car object to be saved
     * @return true if the operation is successful, false otherwise
     */
    boolean saveCarEngine(Car car);

    /**
     * Delete an Engine by the associated Car ID.
     *
     * @param carId the ID of the Car whose Engine is to be deleted
     * @return true if the operation is successful, false otherwise
     */
    boolean deleteEngineByCarId(long carId);

    /**
     * Delete a Car by its ID.
     *
     * @param carId the ID of the Car to be deleted
     * @return true if the operation is successful, false otherwise
     */
    boolean deleteCarByCarId(long carId);

    /**
     * Delete an Engine by its ID.
     *
     * @param engineId the ID of the Engine to be deleted
     * @return true if the operation is successful, false otherwise
     */
    boolean deleteEngineByEngineId(long engineId);

    /**
     * Retrieve a Car by its ID.
     *
     * @param carId the ID of the Car to be retrieved
     * @return the Car object if found, null otherwise
     */
    Car getCarByCarId(long carId);

    /**
     * Retrieve an Engine by its ID.
     *
     * @param engineId the ID of the Engine to be retrieved
     * @return the Engine object if found, null otherwise
     */
    Engine getEngineByEngineId(long engineId);

    /**
     * Retrieve all Engines.
     *
     * @return a list of all Engine objects
     */
    List<Engine> getAllEngines();

    /**
     * Retrieve all Cars.
     *
     * @return a list of all Car objects
     */
    List<Car> getAllCars();
}

