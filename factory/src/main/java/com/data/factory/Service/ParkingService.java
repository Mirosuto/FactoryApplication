package com.data.factory.Service;

import com.data.factory.Model.Parking;
import com.data.factory.Model.Vehicle;
import com.data.factory.Repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingService {

    private static ParkingRepository ParkingRepository;

    @Autowired
    public ParkingService(ParkingRepository ParkingRepository) {
        ParkingService.ParkingRepository = ParkingRepository;
    }

    int zbirPovrsinaVozila = 0;

    public Vehicle test(Vehicle vozilo) {

        vozilo.setParkingId(2);

        return vozilo;
    }


    public Vehicle setParkingToVehicle(Vehicle vozilo) {

        List<Parking> parkings = ParkingRepository.findAll();

        for(Parking parking : parkings) {
            List<Vehicle> vehiclesInParking = parking.getVehicleList();

            vehiclesInParking.forEach((vehicle) -> {
                zbirPovrsinaVozila += vehicle.getPovrsina();
            });

            double freeParkingSpace = parking.getProstor() - zbirPovrsinaVozila;

            if (parking.getVisina() > vozilo.getHeight() && freeParkingSpace > vozilo.getPovrsina()) {
                vozilo.setParkingId(parking.getParking_id());
                break;
            }
        }
        return vozilo;
    }
}




