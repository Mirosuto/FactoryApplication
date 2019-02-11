package com.data.factory.Model;

import com.data.factory.enums.BusTypes;
import com.data.factory.enums.VehicleType;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Bus extends Vehicle {

    @Column
    public int numberOfSeats;
    @Column
    public int numberOfStanding;

    @Column
    public BusTypes busTypes;

    public Bus(String marka, String boja, int parking, int numberOfStanding, int numberOfSeats) {
        super(marka, boja, parking);
        this.numberOfStanding = numberOfStanding;
        this.numberOfSeats = numberOfSeats;
        this.setVehicleType(VehicleType.BUS);
    }

    public Bus(String marka, String boja, int numberOfStanding, int numberOfSeats, double height) {
        super(marka, boja, height);
        this.numberOfStanding = numberOfStanding;
        this.numberOfSeats = numberOfSeats;
        this.setVehicleType(VehicleType.BUS);
    }

    public Bus() {
    }

    public String getMyType(){
        return busTypes.toString();
    }

    public BusTypes getBusTypes() {
        return busTypes;
    }

    public void setBusTypes(BusTypes busTypes) {
        this.busTypes = busTypes;
    }
}
