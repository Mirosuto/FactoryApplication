//package com.data.factory.Model;
//
//import javax.persistence.*;
//
//@Entity @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//public abstract class Car extends Vehicle {
//
//    @Column
//    public int seatNbr;
//    @Column
//    public String equipment;
//    @Column
//    public CarTypes carTypes;
//
//    public Car(String marka, String boja, int parking, int seatNbr, String equipment) {
//        super(marka, boja, parking);
//        this.seatNbr = seatNbr;
//        this.equipment = equipment;
//        this.setVehicleType(VehicleType.CAR);
//    }
//
//    public Car(String marka, String boja, int seatNbr, String equipment, double height) {
//        super(marka, boja, height);
//        this.seatNbr = seatNbr;
//        this.equipment = equipment;
//        this.setVehicleType(VehicleType.CAR);
//    }
//
//    public Car() {
//    }
//
//    public CarTypes getCarTypes() {
//        return carTypes;
//    }
//
//    public void setCarTypes(CarTypes carTypes) {
//        this.carTypes = carTypes;
//    }
//}
