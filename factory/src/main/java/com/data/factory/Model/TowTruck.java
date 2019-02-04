//package com.data.factory.Model;
//
//import javax.persistence.*;
//
//@Entity
//public class TowTruck extends Truck{
//
//    @Column
//    private Double towingCapacity;
//    @Transient
//    public final  int povrsina = 15;
//    @Transient
//    public static final  double height = 4.5;
//
//    public TowTruck(String marka, String boja,  int parking, int numberOfAxles, Double towingCapacity){
//        super(marka, parking, boja, numberOfAxles);
//        this.towingCapacity = towingCapacity;
//        this.setTruckTypes(truckTypes.TOW_TRACK);
//    }
//
//    public TowTruck(String marka, String boja, int numberOfAxles, Double towingCapacity){
//        super(marka, boja, numberOfAxles, height);
//        this.towingCapacity = towingCapacity;
//        this.setTruckTypes(truckTypes.TOW_TRACK);
//    }
//
//    public TowTruck() {
//    }
//
//    public Integer getIdNumber() {
//        return idNumber;
//    }
//
//    public void setIdNumber(Integer id) {
//        this.idNumber = idNumber;
//    }
//
//    public  int getPovrsina() {
//        return povrsina;
//    }
//
//    public Double getTowingCapacity() {
//        return towingCapacity;
//    }
//
//    public void setTowingCapacity(Double towingCapacity) {
//        this.towingCapacity = towingCapacity;
//    }
//
//    public double getHeight() {
//        return height;
//    }
//
//    public String toString() {
//        return "ID: " + this.getIdNumber();
//    }
//}
