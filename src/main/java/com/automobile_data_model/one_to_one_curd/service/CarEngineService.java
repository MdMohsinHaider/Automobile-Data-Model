package com.automobile_data_model.one_to_one_curd.service;

import com.automobile_data_model.one_to_one_curd.dao.CarEngineDao;
import com.automobile_data_model.one_to_one_curd.entity.Car;

public class CarEngineService {

    CarEngineDao dao = new CarEngineDao();

    public boolean saveCarEngineService(Car car){
        return dao.saveCarEngineDao(car);
    }
}
