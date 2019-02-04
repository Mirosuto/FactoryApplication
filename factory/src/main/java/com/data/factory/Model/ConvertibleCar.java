//package com.data.factory.Model;
//
//import javax.persistence.*;
//
//@Entity
//public class ConvertibleCar extends Car{
//
//    @Column
//    private String roof;
//    @Transient
//    public static final  double height = 2.4;
//    @Transient
//    public final  int povrsina = 8;
//
//
//    public ConvertibleCar(String marka, String boja, int parking, int seatNbr, String equipment, String roof){
//        super(marka, boja, parking, seatNbr, equipment);
//        this.roof = roof;
//        this.setCarTypes(carTypes.CONVERTIBLE_CAR);
//    }
//
//
//    public ConvertibleCar(String marka, String boja, int seatNbr, String equipment, String roof){
//        super(marka, boja, seatNbr, equipment, height);
//        this.roof = roof;
//        this.setCarTypes(carTypes.CONVERTIBLE_CAR);
//    }
//
//
//    public ConvertibleCar() {
//    }
//
//
//
//    public Integer getIdNumber() {
//        return idNumber;
//    }
//
//    public void setIdNumber(Integer idNumber) {
//        this.idNumber = idNumber;
//    }
//
//    public int getPovrsina() {
//        return povrsina;
//    }
//
//    public String getRoof() {
//        return roof;
//    }
//
//    public void setRoof(String roof) {
//        this.roof = roof;
//    }
//
//    public double getHeight() {
//        return height;
//    }
//
//    public String toString() {
//        return "ID: " + this.getIdNumber();
//    }
//
//}
