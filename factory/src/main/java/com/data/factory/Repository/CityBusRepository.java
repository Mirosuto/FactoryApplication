package com.data.factory.Repository;

import com.data.factory.Model.CityBus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityBusRepository extends CrudRepository<CityBus, Integer> {

    CityBus findByIdNumber(int idNumber);

    List<CityBus> findAll();
}
