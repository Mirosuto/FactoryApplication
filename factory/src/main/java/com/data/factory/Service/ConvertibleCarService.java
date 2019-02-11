package com.data.factory.Service;

import com.data.factory.Model.ConvertibleCar;
import com.data.factory.Model.Parking;
import com.data.factory.Model.Vehicle;
import com.data.factory.Repository.ConvertibleCarRepository;
import com.data.factory.enums.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class ConvertibleCarService {

    private ConvertibleCarRepository convertibleCarRepository;

    @Autowired
    public ConvertibleCarService(final ConvertibleCarRepository convertibleCarRepository) {
        this.convertibleCarRepository = convertibleCarRepository;
    }

    //SAVE METHOD
    public ConvertibleCar saveConvertibleCar(ConvertibleCar convertibleCar) {

        convertibleCar = convertibleCarRepository.save(convertibleCar);
        return convertibleCar;
    }

    //PULL METHOD
    public List<ConvertibleCar> getAllConvertible() {
        return convertibleCarRepository.findAll();
    }


//    public List<Vehicle> getListOfVehicles(VehicleType vehicleType, String subType) {
//
//        Parking parking = new Parking();
//
//        List<Vehicle> listaSvihVozilaIzBaze = parking.getVehicleList();
//        List<Vehicle> listaVozila = new ArrayList<>();
//        Stream<Vehicle> vehicleStream = listaSvihVozilaIzBaze.stream()
//                .filter(vehicle -> vehicle.getVehicleType().equals(vehicleType))
//                .map(ConvertibleCar.class::cast);
//
//        if (subType.equals("CONVERTIBLE_CAR"))
//        listaVozila = vehicleStream.collect(Collectors.toList());
//
//        return listaVozila;
//    }
}
