package com.data.factory.Repository;

import com.data.factory.Model.Parking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends CrudRepository<Parking, Integer> {

    @Query(value= "UPDATE veliki_parking SET current_povrsina =?1 WHERE id_number = 1", nativeQuery = true)
    Parking updateValue(int value);

    @Query(value = "SELECT current_povrsina FROM veliki_parking", nativeQuery = true)
    int getValue();

    List<Parking> findAll();
}