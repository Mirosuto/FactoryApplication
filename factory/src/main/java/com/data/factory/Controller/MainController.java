package com.data.factory.Controller;

import com.data.factory.Model.*;
import com.data.factory.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.sax.SAXSource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/vehicle")
public class MainController {

    @Autowired
    private CityBusService CityBusService;

    @Autowired
    private ClassicCarService ClassicCarService;

    @Autowired
    private ConvertibleCarService ConvertibleCarService;

    @Autowired
    private TankTruckService TankTruckService;

    @Autowired
    private TowTruckService TowTruckService;

    @Autowired
    private TravelBusService TravelBusService;

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

    @RequestMapping(value = "get-all-City-Bus", method = RequestMethod.GET)
    public List<Vehicle> getAllCityBus() {
        String equalsString = "com.data.factory.Model.CityBus";

        return getListOfVehicles(equalsString);
    }

    @RequestMapping(value = "get-all-Bus", method = RequestMethod.GET)
    public List<Vehicle> getAllCityBusParent() {
        String equalsString = "com.data.factory.Model.Bus";
        return getListOfVehiclesParent(equalsString);
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

    @RequestMapping(value = "get-all-Classic-Car", method = RequestMethod.GET)
    public List<Vehicle> getAllClassicCar() {
        String equalsString = "com.data.factory.Model.ClassicCar";
        return getListOfVehicles(equalsString);
    }

    @RequestMapping(value = "get-all-Car", method = RequestMethod.GET)
    public List<Vehicle> getAllClassicCarParent() {
        String equalsString = "com.data.factory.Model.Car";
        return getListOfVehiclesParent(equalsString);
    }


    //CONVERTIBLE CAR

    @RequestMapping(value = "add-Convertible", method = RequestMethod.POST)
    public ConvertibleCar addConvertibleCar(
            @RequestParam(value = "marka") String marka,
            @RequestParam(value = "boja") String boja,
            @RequestParam(value = "seatNbr") int seatNbr,
            @RequestParam(value = "equipment") String equipment,
            @RequestParam(value = "roof") String roof) {

        ConvertibleCar convertibleCar = new ConvertibleCar(marka, boja, seatNbr, equipment, roof);

        parkingService.setParkingToVehicle(convertibleCar);

        return ConvertibleCarService.saveConvertibleCar(convertibleCar);
    }

    @RequestMapping(value = "get-all-Convertible", method = RequestMethod.GET)
    public List<ConvertibleCar> getAllConvertible() {
        return ConvertibleCarService.getAllConvertible();
    }

    @RequestMapping(value = "get-all-Convertible-Car", method = RequestMethod.GET)
    public List<Vehicle> getAllConvertibleCar() {
        String equalsString = "com.data.factory.Model.ConvertibleCar";
        return getListOfVehicles(equalsString);
    }

//    @RequestMapping(value = "get-all-Car", method = RequestMethod.GET)
//    public List<Vehicle> getAllConvertibleCarParent() {
//        String equalsString = "com.data.factory.Model.Car";
//        return getListOfVehiclesParent(equalsString);
//    }



    //TANK TRUCK

    @RequestMapping(value = "add-Tank", method = RequestMethod.POST)
    public TankTrunk addNewTankTruck(
            @RequestParam(value = "marka") String marka,
            @RequestParam(value = "boja") String boja,
            @RequestParam(value = "numberOfAxles") int numberOfAxles,
            @RequestParam(value = "tankCapacity") Double tankCapacity) {

        TankTrunk tankTruck = new TankTrunk(marka, boja, numberOfAxles, tankCapacity);

        parkingService.setParkingToVehicle(tankTruck);

        return TankTruckService.saveTankTruck(tankTruck);
    }

    @RequestMapping(value = "get-all-Tank", method = RequestMethod.GET)
    public List<TankTrunk> getAllTank() {
        return TankTruckService.getAllTank();
    }

    @RequestMapping(value = "get-all-Tank-Truck", method = RequestMethod.GET)
    public List<Vehicle> getAllTankTruck() {
        String equalsString = "com.data.factory.Model.TankTruck";
        return getListOfVehicles(equalsString);
    }

    @RequestMapping(value = "get-all-Truck", method = RequestMethod.GET)
    public List<Vehicle> getAllTankTruckParent() {
        String equalsString = "com.data.factory.Model.Truck";
        return getListOfVehiclesParent(equalsString);
    }



    //TOW TRUCK

    @RequestMapping(value = "add-Tow", method = RequestMethod.POST)
    public TowTruck addNewTowTruck(
            @RequestParam(value = "marka") String marka,
            @RequestParam(value = "boja") String boja,
            @RequestParam(value = "numberOfAxles") int numberOfAxles,
            @RequestParam(value = "towingCapacity") double towingCapacity) {

        TowTruck towTruck = new TowTruck(marka, boja, numberOfAxles, towingCapacity);

        parkingService.setParkingToVehicle(towTruck);

        return TowTruckService.saveTowTruck(towTruck);
    }

    @RequestMapping(value = "get-all-Tow", method = RequestMethod.GET)
    public List<TowTruck> getAllTow() {
        return TowTruckService.getAllTow();
    }

    @RequestMapping(value = "get-all-Tow-Truck", method = RequestMethod.GET)
    public List<Vehicle> getAllTowTruck() {
        String equalsString = "com.data.factory.Model.TowTruck";
        return getListOfVehicles(equalsString);
    }

//    @RequestMapping(value = "get-all-Truck", method = RequestMethod.GET)
//    public List<Vehicle> getAllTowTruckParent() {
//        String equalsString = "com.data.factory.Model.Truck";
//        return getListOfVehiclesParent(equalsString);
//    }



    //TRAVEL BUS

    @RequestMapping(value = "add-Travel", method = RequestMethod.POST)
    public TravelBus addNewTravelBus(
            @RequestParam(value = "marka") String marka,
            @RequestParam(value = "boja") String boja,
            @RequestParam(value = "numberOfSeats") int numberOfSeats,
            @RequestParam(value = "numberOfStanding") int numberOfStanding,
            @RequestParam(value = "trunkCapacity") int trunkCapacity) {

        TravelBus travelBus = new TravelBus(marka, boja, numberOfSeats, numberOfStanding, trunkCapacity);

        parkingService.setParkingToVehicle(travelBus);

        return TravelBusService.saveTravelBus(travelBus);
    }

    @RequestMapping(value = "get-all-Travel", method = RequestMethod.GET)
    public List<TravelBus> getAllTravel() {
        return TravelBusService.getAllTravel();
    }

    @RequestMapping(value = "get-all-Travel-Bus", method = RequestMethod.GET)
    public List<Vehicle> getAllTravelBus() {
        String equalsString = "com.data.factory.Model.TravelBus";
        return getListOfVehicles(equalsString);
    }

//    @RequestMapping(value = "get-all-Bus", method = RequestMethod.GET)
//    public List<Vehicle> getAllTravelBusParent() {
//        String equalsString = "com.data.factory.Model.Bus";
//        return getListOfVehiclesParent(equalsString);
//    }


    //Methods

    public List<Vehicle> getListOfVehicles(String equalsString){

        Parking parking = new Parking();

        List<Vehicle> listaSvihVozilaIzBaze = parking.getVehicleList();
        List<Vehicle> listaVozila = new ArrayList<>();
        listaSvihVozilaIzBaze.forEach(vehicle -> {

            if (vehicle.getClass().getName().equals(equalsString)){
                listaVozila.add(vehicle);
            }

        });

        return listaVozila;
    }

    public List<Vehicle> getListOfVehiclesParent(String equalsString){

        Parking parking = new Parking();

        List<Vehicle> listaSvihVozilaIzBaze = parking.getVehicleList();
        List<Vehicle> listaVozila = new ArrayList<>();
        listaSvihVozilaIzBaze.forEach(vehicle -> {

            if (vehicle.getClass().getSuperclass().getName().equals(equalsString)){
                listaVozila.add(vehicle);
            }

        });

        return listaVozila;
    }

}