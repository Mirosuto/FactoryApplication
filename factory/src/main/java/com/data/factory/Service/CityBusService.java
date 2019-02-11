package com.data.factory.Service;

import com.data.factory.Model.CityBus;
import com.data.factory.Model.Parking;
import com.data.factory.Model.Vehicle;
import com.data.factory.Repository.CityBusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class CityBusService {

    private CityBusRepository CityBusRepository;

    @Autowired
    public CityBusService(final CityBusRepository CityBusRepository) {
        this.CityBusRepository = CityBusRepository;
    }

    //SAVE
    public CityBus saveCityBus(CityBus cityBus) {

        cityBus = CityBusRepository.save(cityBus);
        Parking.listOfAllVehiclesAddedToDataBase.add(cityBus);
        return cityBus;
    }

    //PULL
    public List<CityBus> getAllCity() {
        List<CityBus> list = CityBusRepository.findAll();
        return list;
    }

    //DELETE
    public Iterator<Vehicle> deleteCity(Integer id) {
        List<Vehicle> list = Parking.listOfAllVehiclesAddedToDataBase;

        Iterator<Vehicle> iterator = list.iterator();
        if (id != null && id != 0) {
            CityBusRepository.delete(CityBusRepository.findByIdNumber(id));

            while ( iterator.hasNext() ) {
                Vehicle vehicle = iterator.next();
                if (vehicle.getIdNumber() == id) {
                    iterator.remove();
                }
            }


        } return iterator;
    }
}


