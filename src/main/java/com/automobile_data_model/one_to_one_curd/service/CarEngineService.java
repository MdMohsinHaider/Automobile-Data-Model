package com.automobile_data_model.one_to_one_curd.service;

import com.automobile_data_model.one_to_one_curd.dao.CarEngineDao;
import com.automobile_data_model.one_to_one_curd.dao.CarEngineDataAccessObject;
import com.automobile_data_model.one_to_one_curd.entity.Car;
import com.automobile_data_model.one_to_one_curd.entity.Engine;

import java.util.List;

public class CarEngineService implements CarService {

    CarEngineDataAccessObject dao = new CarEngineDao();

    @Override
    public boolean saveCarEngine(Car car) {
        if (car == null) return false;
        return dao.saveCarEngineDao(car);
    }

    @Override
    public boolean deleteEngineByCarId(long carId) {
        return dao.deleteEngineByCarIdDao(carId);
    }

    @Override
    public boolean deleteCarByCarId(long carId) {
        return dao.deleteCarByCarIdDao(carId);
    }

    @Override
    public boolean deleteEngineByEngineId(long engineId) {
        return dao.deleteEngineByEngineIdDao(engineId);
    }

    @Override
    public Car getCarByCarId(long carId) {
        return dao.getCarByCarIdDao(carId);
    }

    @Override
    public Engine getEngineByEngineId(long engineId) {
        return dao.getEngineByEngineIdDao(engineId);
    }

    @Override
    public List<Engine> getAllEngines() {
        return dao.getAllEnginDao();
    }

    @Override
    public List<Car> getAllCars() {
        return dao.getAllCarDao();
    }
}
