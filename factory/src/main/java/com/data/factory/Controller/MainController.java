package com.data.factory.Controller;

import com.data.factory.Model.CityBus;
import com.data.factory.Model.ClassicCar;
import com.data.factory.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/vehicle")
public class MainController {

    @Autowired
    private CityBusService CityBusService;

    @Autowired
    private ClassicCarService ClassicCarService;
//
//    @Autowired
//    private ConvertibleCarService ConvertibleCarService;
//
//    @Autowired
//    private TankTruckService TankTruckService;
//
//    @Autowired
//    private TowTruckService TowTruckService;
//
//    @Autowired
//    private TravelBusService TravelBusService;
//
    @Autowired
    private ParkingService parkingService;

    //CITY BUS

    @RequestMapping(value = "add-City", method = RequestMethod.POST)
    public CityBus addCityBus(
            @RequestParam(value = "name") String marka,
            @RequestParam(value = "color") String boja,
            @RequestParam(value = "numberOfSeats") int numberOfSeats,
            @RequestParam(value = "numberOfStanding") int numberOfStanding,
            @RequestParam(value = "articular") String articular) {

        CityBus cityBus = new CityBus(marka, boja, numberOfSeats, numberOfStanding, articular);

        parkingService.setParkingToVehicle(cityBus);

        return CityBusService.saveCityBus(cityBus);
    }

    @RequestMapping(value = "get-all-City", method = RequestMethod.GET)
    public List<CityBus> getAllCity() {
        return CityBusService.getAllCity();
    }


    //CLASSIC CAR

    @RequestMapping(value = "add-Classic", method = RequestMethod.POST)
    public ClassicCar addNewClassicCar(
            @RequestParam(value = "marka") String marka,
            @RequestParam(value = "boja") String boja,
            @RequestParam(value = "seatNbr") int seatNbr,
            @RequestParam(value = "equipment") String equipment,
            @RequestParam(value = "roofCarryCapacity") int roofCarryCapacity) {

        ClassicCar classicCar = new ClassicCar(marka, boja, seatNbr, equipment, roofCarryCapacity);

        parkingService.setParkingToVehicle(classicCar);

        return ClassicCarService.saveClassicCar(classicCar);
    }

    @RequestMapping(value = "get-all-Classic", method = RequestMethod.GET)
    public List<ClassicCar> getAllClassic() {
        return ClassicCarService.getAllClassic();
    }
//
//
//    //CONVERTIBLE CAR
//
//    @RequestMapping(value = "add-Convertible", method = RequestMethod.POST)
//    public ConvertibleCar addConvertibleCar(
//            @RequestParam(value = "marka") String marka,
//            @RequestParam(value = "boja") String boja,
//            @RequestParam(value = "seatNbr") int seatNbr,
//            @RequestParam(value = "equipment") String equipment,
//            @RequestParam(value = "roof") String roof) {
//
//        ConvertibleCar convertibleCar = new ConvertibleCar(marka, boja, seatNbr, equipment, roof);
//
//        parkingService.setParkingToVehicle(convertibleCar);
//
//        return ConvertibleCarService.saveConvertibleCar(convertibleCar);
//    }
//
//    @RequestMapping(value = "get-all-Convertible", method = RequestMethod.GET)
//    public List<ConvertibleCar> getAllConvertible() {
//        return ConvertibleCarService.getAllConvertible();
//    }
//
//
//    //TANK TRUCK
//
//    @RequestMapping(value = "add-Tank", method = RequestMethod.POST)
//    public TankTrunk addNewTankTruck(
//            @RequestParam(value = "marka") String marka,
//            @RequestParam(value = "boja") String boja,
//            @RequestParam(value = "numberOfAxles") int numberOfAxles,
//            @RequestParam(value = "tankCapacity") Double tankCapacity) {
//
//        TankTrunk tankTruck = new TankTrunk(marka, boja, numberOfAxles, tankCapacity);
//
//        parkingService.setParkingToVehicle(tankTruck);
//
//        return TankTruckService.saveTankTruck(tankTruck);
//    }
//
//    @RequestMapping(value = "get-all-Tank", method = RequestMethod.GET)
//    public List<TankTrunk> getAllTank() {
//        return TankTruckService.getAllTank();
//    }
//
//
//    //TOW TRUCK
//
//    @RequestMapping(value = "add-Tow", method = RequestMethod.POST)
//    public TowTruck addNewTowTruck(
//            @RequestParam(value = "marka") String marka,
//            @RequestParam(value = "boja") String boja,
//            @RequestParam(value = "numberOfAxles") int numberOfAxles,
//            @RequestParam(value = "towingCapacity") double towingCapacity) {
//
//        TowTruck towTruck = new TowTruck(marka, boja, numberOfAxles, towingCapacity);
//
//        parkingService.setParkingToVehicle(towTruck);
//
//        return TowTruckService.saveTowTruck(towTruck);
//    }
//
//    @RequestMapping(value = "get-all-Tow", method = RequestMethod.GET)
//    public List<TowTruck> getAllTow() {
//        return TowTruckService.getAllTow();
//    }
//
//
//    //TRAVEL BUS
//
//    @RequestMapping(value = "add-Travel", method = RequestMethod.POST)
//    public TravelBus addNewTravelBus(
//            @RequestParam(value = "marka") String marka,
//            @RequestParam(value = "boja") String boja,
//            @RequestParam(value = "numberOfSeats") int numberOfSeats,
//            @RequestParam(value = "numberOfStanding") int numberOfStanding,
//            @RequestParam(value = "trunkCapacity") int trunkCapacity) {
//
//        TravelBus travelBus = new TravelBus(marka, boja, numberOfSeats, numberOfStanding, trunkCapacity);
//
//        parkingService.setParkingToVehicle(travelBus);
//
//        return TravelBusService.saveTravelBus(travelBus);
//    }
//
//    @RequestMapping(value = "get-all-Travel", method = RequestMethod.GET)
//    public List<TravelBus> getAllTravel() {
//        return TravelBusService.getAllTravel();
//    }

}
