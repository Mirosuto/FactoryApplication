package com.data.factory.Service;

import com.data.factory.Model.*;
import com.data.factory.Repository.VehicleRepository;
import com.data.factory.enums.BusTypes;
import com.data.factory.enums.CarTypes;
import com.data.factory.enums.TruckTypes;
import com.data.factory.enums.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class VehicleService {

    private static VehicleRepository VehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository VehicleRepository) {
        VehicleService.VehicleRepository = VehicleRepository;
    }

    public List<Vehicle> getListOfVehicles(VehicleType vehicleType, String subType){

        Parking parking = new Parking();

        List<Vehicle> listaSvihVozilaIzBaze = parking.getListOfAllVehiclesAddedToDataBase();
        List<Vehicle> listaVozila = new ArrayList<>();
        List<Vehicle> vehicleStream = listaSvihVozilaIzBaze.stream()
                .filter(vehicle -> vehicle.getVehicleType().equals(vehicleType)).collect(toList());

        switch (subType) {
            case "CITY_BUS":
                listaVozila = vehicleStream.stream().filter(obj ->  obj.getMyType().equals(BusTypes.CITY_BUS.toString())).map(obj -> (CityBus) obj).collect(toList());
                break;
            case "TRAVEL_BUS":
                listaVozila = vehicleStream.stream().filter(obj -> obj.getMyType().equals(subType)).map(obj -> (TravelBus) obj).collect(toList());
                break;
            case "CLASSIC_CAR":
                listaVozila = vehicleStream.stream().filter(obj -> obj.getMyType().equals(CarTypes.CLASSIC_CAR.toString())).map(obj -> (ClassicCar) obj).collect(toList());
                break;
            case "CONVERTIBLE_CAR":
                listaVozila = vehicleStream.stream().filter(obj ->  obj.getMyType().equals(CarTypes.CONVERTIBLE_CAR.toString())).map(obj -> (ConvertibleCar) obj).collect(toList());
                break;
            case "TANK_TRUCK":
                listaVozila = vehicleStream.stream().filter(obj ->  obj.getMyType().equals(TruckTypes.TANK_TRUCK.toString())).map(obj -> (TankTruck) obj).collect(toList());
                break;
            case "TOW_TRUCK":
                listaVozila = vehicleStream.stream().filter(obj ->  obj.getMyType().equals(TruckTypes.TOW_TRUCK.toString())).map(obj -> (TowTruck) obj).collect(toList());
                break;
        }

        return listaVozila;
    }

    public List<Vehicle> getListOfVehiclesParent(String parentName){

        Parking parking = new Parking();

        List<Vehicle> listaSvihVozilaIzBaze = parking.getListOfAllVehiclesAddedToDataBase();
        List<Vehicle> vehicleStream = listaSvihVozilaIzBaze.stream()
                .filter(vehicle -> vehicle.getVehicleType().toString().equals(parentName)).collect(toList());

        return vehicleStream;
    }


}
