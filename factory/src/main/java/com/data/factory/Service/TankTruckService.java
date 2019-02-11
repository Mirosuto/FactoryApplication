package com.data.factory.Service;

import com.data.factory.Model.TankTruck;
import com.data.factory.Repository.TankTruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TankTruckService {

    @Autowired
    private TankTruckRepository tankTruckRepository;

    public TankTruckService(final TankTruckRepository tankTruckRepository) {
        this.tankTruckRepository = tankTruckRepository;
    }

    //SAVE METHOD
    public TankTruck saveTankTruck(TankTruck tankTruck) {

        tankTruck = tankTruckRepository.save(tankTruck);
        return tankTruck;
    }

    //PULL METHOD
    public List<TankTruck> getAllTank() {
        return tankTruckRepository.findAll();
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
//        if (subType.equals("TANK_TRUCK"))
//        listaVozila = vehicleStream.map(TankTruck.class::cast).collect(Collectors.toList());
//
//        return listaVozila;
//    }
}
