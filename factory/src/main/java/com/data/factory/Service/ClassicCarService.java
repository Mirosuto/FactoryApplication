package com.data.factory.Service;

import com.data.factory.Model.ClassicCar;
import com.data.factory.Model.Parking;
import com.data.factory.Model.TravelBus;
import com.data.factory.Model.Vehicle;
import com.data.factory.Repository.ClassicCarRepository;
import com.data.factory.enums.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ClassicCarService {

    private ClassicCarRepository classicCarRepository;

    @Autowired
    public ClassicCarService(final ClassicCarRepository classicCarRepository) {
        this.classicCarRepository = classicCarRepository;
    }

    //SAVE METHOD
    public ClassicCar saveClassicCar(ClassicCar classicCar) {

        classicCar = classicCarRepository.save(classicCar);
        return classicCar;
    }

    //PULL METHOD
    public List<ClassicCar> getAllClassic() {
        return classicCarRepository.findAll();
    }


//    public List<Vehicle> getListOfVehicles(VehicleType vehicleType, String subType) {
//
//        Parking parking = new Parking();
//
//        List<Vehicle> listaSvihVozilaIzBaze = parking.getVehicleList();
//        List<Vehicle> listaVozila = new ArrayList<>();
//        Stream<Vehicle> vehicleStream = listaSvihVozilaIzBaze.stream()
//                .filter(vehicle -> vehicle.getVehicleType().equals(vehicleType))
//                .map(ClassicCar.class::cast);
////                .collect(Collectors.toList());
//
//        if (subType.equals("CLASSIC_CAR"))
//        listaVozila = vehicleStream.collect(Collectors.toList());
//
//        return listaVozila;
//    }
}


