package com.data.factory.Repository;

import com.data.factory.Model.ClassicCar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassicCarRepository extends CrudRepository<ClassicCar, Integer> {

    ClassicCar findByIdNumber(int idNumber);

    List<ClassicCar> findAll();
}