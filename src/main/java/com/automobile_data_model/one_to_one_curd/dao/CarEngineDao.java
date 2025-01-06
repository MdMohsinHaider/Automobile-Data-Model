package com.automobile_data_model.one_to_one_curd.dao;

import com.automobile_data_model.one_to_one_curd.entity.Car;
import com.automobile_data_model.one_to_one_curd.entity.Engine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * 1. EntityManagerFactory:
 * Created for the specified persistence unit (jpa-hibernate-automobile-data-model).
 * Manages the lifecycle of environmental instances.
 * 2. EntityManager:
 * Responsible for entity lifecycle operations (persist, find, merge, etc.).
 * Bound to the persistence context.
 * 3. EntityTransaction:Used to begin, commit, or rollback a database transaction.
 * Ensures atomicity and consistency of database operations.
 * 4. Error Handling:
 * Exceptions during a transaction cause a rollback to prevent partial or inconsistent updates.
 * 5. Resource Cleanup:
 * Closing EntityManager and EntityManagerFactory ensures proper resource management.
 */

public class CarEngineDao {

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

    public boolean deleteCarEngineDao(long id){
        try {
            Car car = entityManager.find(Car.class,id);
            if (car != null){
                Engine engine = new Engine();
                if (engine!=null){
                    
                }
            }
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }
}
