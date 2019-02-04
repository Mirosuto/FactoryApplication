//package com.data.factory.Service;
//
//import com.data.factory.Model.TankTrunk;
//import com.data.factory.Repository.TankTruckRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class TankTruckService {
//
//    @Autowired
//    private TankTruckRepository tankTruckRepository;
//
//    public TankTruckService(final TankTruckRepository tankTruckRepository) {
//        this.tankTruckRepository = tankTruckRepository;
//    }
//
//    //SAVE METHOD
//    public TankTrunk saveTankTruck(TankTrunk tankTruck) {
//
//        tankTruck = tankTruckRepository.save(tankTruck);
//        return tankTruck;
//    }
//
//    //PULL METHOD
//    public List<TankTrunk> getAllTank() {
//        return tankTruckRepository.findAll();
//    }
//
//}
