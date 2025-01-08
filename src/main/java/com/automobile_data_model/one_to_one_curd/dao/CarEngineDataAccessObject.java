package com.automobile_data_model.one_to_one_curd.dao;

import com.automobile_data_model.one_to_one_curd.entity.Car;
import com.automobile_data_model.one_to_one_curd.entity.Engine;

import java.util.List;


public interface CarEngineDataAccessObject {

    /**
     * Save a Car and its associated Engine.
     *
     * @param car the Car object to be saved
     * @return true if the operation is successful, false otherwise
     */
    boolean saveCarEngineDao(Car car);

    /**
     * Delete an Engine by the associated Car ID.
     *
     * @param carId the ID of the Car whose Engine is to be deleted
     * @return true if the operation is successful, false otherwise
     */
    boolean deleteEngineByCarIdDao(long carId);

    /**
     * Delete a Car by its ID.
     *
     * @param carId the ID of the Car to be deleted
     * @return true if the operation is successful, false otherwise
     */
    boolean deleteCarEngineByDao(long carId);

    /**
     * Delete an Engine by its ID.
     *
     * @param engineID the ID of the Engine to be deleted
     * @return true if the operation is successful, false otherwise
     */
    boolean deleteEngineByEngineIdDao(long engineID);

    /**
     * Delete a Car by its ID.
     *
     * @param carID the ID of the Car to be deleted
     * @return true if the operation is successful, false otherwise
     */
    boolean deleteCarByCarIdDao(long carID);

    /**
     * Retrieve a Car by its ID.
     *
     * @param carID the ID of the Car to be retrieved
     * @return the Car object if found, null otherwise
     */
    Car getCarByCarIdDao(long carID);

    /**
     * Retrieve an Engine by its ID.
     *
     * @param engineID the ID of the Engine to be retrieved
     * @return the Engine object if found, null otherwise
     */
    Engine getEngineByEngineIdDao(long engineID);

    /**
     * Retrieve all Engines.
     *
     * @return a list of all Engine objects
     */
    List<Engine> getAllEnginDao();

    /**
     * Retrieve all Cars.
     *
     * @return a list of all Car objects
     */
    List<Car> getAllCarDao();
}
