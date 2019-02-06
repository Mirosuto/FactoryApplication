package com.data.factory.Repository;

import com.data.factory.Model.TankTrunk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TankTruckRepository extends CrudRepository<TankTrunk, Integer> {
    TankTrunk findByIdNumber(Integer idNumber);

    List<TankTrunk> findAll();
}
