package com.data.factory.Repository;

import com.data.factory.Model.TankTruck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TankTruckRepository extends CrudRepository<TankTruck, Integer> {
    TankTruck findByIdNumber(Integer idNumber);

    List<TankTruck> findAll();
}
