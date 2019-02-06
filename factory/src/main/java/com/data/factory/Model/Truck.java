package com.data.factory.Model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Truck extends Vehicle {

    @Column
    public int numberOfAxles;
    @Column
    public TruckTypes truckTypes;



    public Truck(String marka, int parking, String boja, int numberOfAxles) {
        super(marka, boja, parking);
        this.numberOfAxles = numberOfAxles;
        this.setVehicleType(VehicleType.TRUCK);
    }

    public Truck(String marka, String boja, int numberOfAxles, double height) {
        super(marka, boja, height);
        this.numberOfAxles = numberOfAxles;
        this.setVehicleType(VehicleType.TRUCK);
    }

    public Truck() {
    }

    public TruckTypes getTruckTypes() {
        return truckTypes;
    }

    public void setTruckTypes(TruckTypes truckTypes) {
        this.truckTypes = truckTypes;
    }
}
