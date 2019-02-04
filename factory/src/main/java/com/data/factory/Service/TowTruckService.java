//package com.data.factory.Service;
//
//import com.data.factory.Model.TowTruck;
//import com.data.factory.Repository.TowTruckRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//@Service
//public class TowTruckService {
//
//    @Autowired
//    private TowTruckRepository towTruckRepository;
//
//    public TowTruckService(final TowTruckRepository towTruckRepository) {
//        this.towTruckRepository = towTruckRepository;
//    }
//
//    //SAVE METHOD
//    public TowTruck saveTowTruck(TowTruck towTruck) {
//
//        towTruck = towTruckRepository.save(towTruck);
//        return towTruck;
//    }
//
//    //PULL METHOD
//    public List<TowTruck> getAllTow() {
//        return towTruckRepository.findAll();
//    }
//
//}
