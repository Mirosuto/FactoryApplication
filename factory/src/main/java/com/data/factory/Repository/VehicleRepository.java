package com.data.factory.Repository;

import com.data.factory.Model.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

    Vehicle findByIdNumber(int idNumber);

    List<Vehicle> findAll();
}