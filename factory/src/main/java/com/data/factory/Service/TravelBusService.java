//package com.data.factory.Service;
//
//import com.data.factory.Model.TravelBus;
//import com.data.factory.Repository.TravelBusRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class TravelBusService {
//
//    @Autowired
//    private TravelBusRepository travelBusRepository;
//
//    public TravelBusService(final TravelBusRepository travelBusRepository) {
//        this.travelBusRepository = travelBusRepository;
//    }
//
//    //SAVE METHOD
//    public TravelBus saveTravelBus(TravelBus travelBus) {
//
//        travelBus = travelBusRepository.save(travelBus);
//        return travelBus;
//    }
//
//    //PULL METHOD
//    public List<TravelBus> getAllTravel() {
//        return travelBusRepository.findAll();
//    }
//
//}
