package com.data.factory.Controller;

import com.data.factory.Model.*;
import com.data.factory.Service.*;
import com.data.factory.enums.BusTypes;
import com.data.factory.enums.CarTypes;
import com.data.factory.enums.TruckTypes;
import com.data.factory.enums.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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

    @Autowired
    private VehicleService vehicleService;

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

    @RequestMapping(value = "get-all-City-BUS", method = RequestMethod.GET)
    public List<Vehicle> getAllCityBus() {
        return vehicleService.getListOfVehicles(VehicleType.BUS, BusTypes.CITY_BUS.toString());
    }

    @RequestMapping(value = "delete-City", method = RequestMethod.POST)
    public void deleteCityBus( @RequestParam(value = "idNumber") Integer id) throws SQLException, ClassNotFoundException {
        CityBusService.deleteCityBus(id);
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

    @RequestMapping(value = "get-all-Classic-CAR", method = RequestMethod.GET)
    public List<Vehicle> getAllClassicCar() {
        return vehicleService.getListOfVehicles(VehicleType.CAR, CarTypes.CLASSIC_CAR.toString());
    }

    @RequestMapping(value = "delete-Classic", method = RequestMethod.POST)
    public void deleteClassicCar( @RequestParam(value = "idNumber") Integer id) throws SQLException, ClassNotFoundException {
        ClassicCarService.deleteClassicCar(id);
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

    @RequestMapping(value = "get-all-Convertible-CAR", method = RequestMethod.GET)
    public List<Vehicle> getAllConvertibleCar() {
        return vehicleService.getListOfVehicles(VehicleType.CAR, CarTypes.CONVERTIBLE_CAR.toString());
    }

    @RequestMapping(value = "delete-Convertible", method = RequestMethod.POST)
    public void deleteConvertibleCar( @RequestParam(value = "idNumber") Integer id) throws SQLException, ClassNotFoundException {
        ConvertibleCarService.deleteConvertibleCar(id);
    }

    //TANK TRUCK

    @RequestMapping(value = "add-Tank", method = RequestMethod.POST)
    public TankTruck addNewTankTruck(
            @RequestParam(value = "marka") String marka,
            @RequestParam(value = "boja") String boja,
            @RequestParam(value = "numberOfAxles") int numberOfAxles,
            @RequestParam(value = "tankCapacity") Double tankCapacity) {

        TankTruck tankTruck = new TankTruck(marka, boja, numberOfAxles, tankCapacity);

        parkingService.setParkingToVehicle(tankTruck);

        return TankTruckService.saveTankTruck(tankTruck);
    }

    @RequestMapping(value = "get-all-Tank", method = RequestMethod.GET)
    public List<TankTruck> getAllTank() {
        return TankTruckService.getAllTank();
    }

    @RequestMapping(value = "get-all-Tank-TRUCK", method = RequestMethod.GET)
    public List<Vehicle> getAllTankTruck() {
        return vehicleService.getListOfVehicles(VehicleType.TRUCK, TruckTypes.TANK_TRUCK.toString());
    }

    @RequestMapping(value = "delete-Tank", method = RequestMethod.POST)
    public void deleteTank( @RequestParam(value = "idNumber") Integer id) throws SQLException, ClassNotFoundException {
        TankTruckService.deleteTankTruck(id);
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

    @RequestMapping(value = "get-all-Tow-TRUCK", method = RequestMethod.GET)
    public List<Vehicle> getAllTowTruck() {
        return vehicleService.getListOfVehicles(VehicleType.TRUCK, TruckTypes.TOW_TRUCK.toString());
    }

    @RequestMapping(value = "delete-Tow", method = RequestMethod.POST)
    public void deleteTowTruck( @RequestParam(value = "idNumber") Integer id) throws SQLException, ClassNotFoundException {
        TowTruckService.deleteTowTruck(id);
    }

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

    @RequestMapping(value = "get-all-Travel-BUS", method = RequestMethod.GET)
    public List<Vehicle> getAllTravelBus() {
        return vehicleService.getListOfVehicles(VehicleType.BUS, BusTypes.TRAVEL_BUS.toString());
    }

    @RequestMapping(value = "delete-Travel", method = RequestMethod.POST)
    public void deleteTravelBus( @RequestParam(value = "idNumber") Integer id) throws SQLException, ClassNotFoundException {
        TravelBusService.deleteTravelBus(id);
    }

    //Parking

    @RequestMapping(value = "get-parking", method = RequestMethod.GET)
    public List<Vehicle> getVehiclesOnParking(@RequestParam(value = "idOfParking") String parkingNumber){
        return parkingService.getListOfVehiclesOnSpecificParking(Integer.valueOf(parkingNumber));
    }

    //List of Buses/Cars/Trucks
    @RequestMapping(value = "get-parent", method = RequestMethod.GET)
    public List<Vehicle> getAllCityBusParent( @RequestParam(value = "parentName", required=false) String parentName) {
        return vehicleService.getListOfVehiclesParent(parentName);
    }

}