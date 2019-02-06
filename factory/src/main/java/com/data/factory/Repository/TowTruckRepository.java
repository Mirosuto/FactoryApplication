package com.data.factory.Repository;

import com.data.factory.Model.TowTruck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TowTruckRepository extends CrudRepository<TowTruck, Integer> {
    TowTruck findByIdNumber(Integer idNumber);

    List<TowTruck> findAll();
}
