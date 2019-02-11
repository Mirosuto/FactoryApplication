package com.data.factory.Service;

import com.data.factory.Model.Parking;
import com.data.factory.Model.TravelBus;
import com.data.factory.Model.Vehicle;
import com.data.factory.Repository.TravelBusRepository;
import com.data.factory.enums.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TravelBusService {

    @Autowired
    private TravelBusRepository travelBusRepository;

    public TravelBusService(final TravelBusRepository travelBusRepository) {
        this.travelBusRepository = travelBusRepository;
    }

    //SAVE METHOD
    public TravelBus saveTravelBus(TravelBus travelBus) {

        travelBus = travelBusRepository.save(travelBus);
        return travelBus;
    }

    //PULL METHOD
    public List<TravelBus> getAllTravel() {
        return travelBusRepository.findAll();
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
//        if (subType.equals("TRAVEL_BUS"))
//        listaVozila = vehicleStream.map(TravelBus.class::cast).collect(Collectors.toList());
//
//        return listaVozila;
//    }
}
