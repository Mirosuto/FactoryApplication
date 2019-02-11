package com.data.factory.Model;

import javax.persistence.*;

@Entity
public class TankTruck extends Truck{

    @Column
    private Double tankCapacity;

    @Transient
    public static final  double height = 4.5;
    @Transient
    public static final  int povrsina = 20;


    public TankTruck(String marka, String boja, int parking, int numberOfAxles, Double tankCapacity){
        super(marka, parking, boja,  numberOfAxles);
        this.tankCapacity = tankCapacity;
        this.setTruckTypes(truckTypes.TANK_TRUCK);
    }

    public TankTruck(String marka, String boja, int numberOfAxles, Double tankCapacity){
        super(marka, boja, numberOfAxles, height);
        this.tankCapacity = tankCapacity;
        this.setTruckTypes(truckTypes.TANK_TRUCK);
    }

    public TankTruck() {
    }

    @Override
    public String getMyType() {
         return getTruckTypes().toString();
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public  int getPovrsina() {
        return povrsina;
    }

    public Double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(Double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getHeight() {
        return height;
    }

    public String toString() {
        return "ID: " + this.getIdNumber();
    }
}
