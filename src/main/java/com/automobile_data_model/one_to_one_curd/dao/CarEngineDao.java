package com.automobile_data_model.one_to_one_curd.dao;

import com.automobile_data_model.one_to_one_curd.entity.Car;
import com.automobile_data_model.one_to_one_curd.entity.Engine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class CarEngineDao implements CarEngineDataAccessObject {

    /**
     * Create an EntityManagerFactory for the persistence unit "jpa-hibernate-automobile-data-model"
     *  he name must match the <persistence-unit> defined in persistence.xml
     */
    EntityManager entityManager = Persistence.createEntityManagerFactory("jpa-hibernate-automobile-data-model").createEntityManager();

    /**
     * Create an EntityManager from the factory
     * The EntityManager is responsible for managing entities and their persistence context
     */
    EntityTransaction entityTransaction = entityManager.getTransaction();

    // 1. save The Car And Engine
    @Override
    public boolean saveCarEngineDao(Car car){
        try {
            entityTransaction.begin();
            entityManager.persist(car);
            entityTransaction.commit();
            return true;
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }


    // 2. delete Engin by Car_id.
    @Override
    public boolean deleteEngineByCarIdDao(long carId){
        try {
            Car car = entityManager.find(Car.class,carId);
            if (car != null){
                Engine engine = car.getEngine();
                if (engine != null){
                    car.setEngine(null);
                    entityTransaction.begin();
                    entityManager.merge(car);
                    entityManager.remove(engine);
                    entityTransaction.commit();
                    return true;
                }else return false;
            }else return false;
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    // delete Car by EngineID
    @Override
    public boolean deleteCarEngineByDao(long carId){
        try {
            return true;
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    // 3. delete Engin by Engin_id.
    @Override
    public boolean deleteEngineByEngineIdDao(long engineID){
        try {
            return true;
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    // 4. delete Car by Car ID.
    @Override
    public boolean deleteCarByCarIdDao(long carID){
        try {
            return true;
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    // 5. Display Car By car_id.
    @Override
    public Car getCarByCarIdDao(long carID){
        return entityManager.find(Car.class,carID);
    }

    // 6. Display Engine By engine_Id.
    @Override
    public Engine getEngineByEngineIdDao(long engineID){
        return entityManager.find(Engine.class,engineID);
    }

    // 7. Display All Engine
    @Override
    public List<Engine> getAllEnginDao(){
        return entityManager.createQuery("from Engine",Engine.class).getResultList();
    }

    // 8. Display All Car
    @Override
    public List<Car> getAllCarDao(){
        return entityManager.createQuery("from Car",Car.class).getResultList();
    }
}
