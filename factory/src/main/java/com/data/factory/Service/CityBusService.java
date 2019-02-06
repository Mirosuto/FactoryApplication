package com.data.factory.Service;

import com.data.factory.Model.CityBus;
import com.data.factory.Model.Vehicle;
import com.data.factory.Repository.CityBusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityBusService {

    private CityBusRepository CityBusRepository;

    @Autowired
    public CityBusService(final CityBusRepository CityBusRepository) {
        this.CityBusRepository = CityBusRepository;
    }

    //SAVE METHOD
    public CityBus saveCityBus(CityBus cityBus) {

        cityBus = CityBusRepository.save(cityBus);
        return cityBus;
    }

    //PULL METHOD
    public List<CityBus> getAllCity() {
        List<CityBus> list = CityBusRepository.findAll();
        return list;
    }

    public List<Vehicle> getAllBusses(){

        List<Vehicle> listaAutobusa = new ArrayList<>();

        return listaAutobusa ;
    }

}


