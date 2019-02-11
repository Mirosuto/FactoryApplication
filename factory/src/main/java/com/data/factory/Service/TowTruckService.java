package com.data.factory.Service;

import com.data.factory.Model.Parking;
import com.data.factory.Model.TowTruck;
import com.data.factory.Model.Vehicle;
import com.data.factory.Repository.TowTruckRepository;
import com.data.factory.enums.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class TowTruckService {

    @Autowired
    private TowTruckRepository towTruckRepository;

    public TowTruckService(final TowTruckRepository towTruckRepository) {
        this.towTruckRepository = towTruckRepository;
    }

    //SAVE METHOD
    public TowTruck saveTowTruck(TowTruck towTruck) {

        towTruck = towTruckRepository.save(towTruck);
        return towTruck;
    }

    //PULL METHOD
    public List<TowTruck> getAllTow() {
        return towTruckRepository.findAll();
    }


//    public List<Vehicle> getListOfVehicles(VehicleType vehicleType, String subType) {
//
//        Parking parking = new Parking();
//
//        List<Vehicle> listaSvihVozilaIzBaze = parking.getVehicleList();
//        List<Vehicle> listaVozila = new ArrayList<>();
//        Stream<Vehicle> vehicleStream = listaSvihVozilaIzBaze.stream()
//                .filter(vehicle -> vehicle.getVehicleType().equals(vehicleType));
//
//        if (subType.equals("TOW_TRUCK"))
//        listaVozila = vehicleStream.map(TowTruck.class::cast).collect(Collectors.toList());
//
//        return listaVozila;
//    }
}
