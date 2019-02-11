package com.data.factory.Model;

import javax.persistence.*;

@Entity
public class TravelBus extends Bus{

    @Column
    private int trunkCapacity;
    @Transient
    public static final  double height = 4.2;
    @Transient
    public final  int povrsina = 15;


    public TravelBus(String marka, String boja,  int parking, int numberOfSeats, int numberOfStanding, int trunkCapacity){
        super(marka, boja, parking, numberOfStanding, numberOfSeats);
        this.numberOfStanding = numberOfStanding;
        this.numberOfSeats = numberOfSeats;
        this.trunkCapacity = trunkCapacity;
        this.setBusTypes(busTypes.TRAVEL_BUS);
    }

    public TravelBus(String marka, String boja, int numberOfSeats, int numberOfStanding, int trunkCapacity){
        super(marka, boja, numberOfStanding, numberOfSeats, height);
        this.numberOfStanding = numberOfStanding;
        this.numberOfSeats = numberOfSeats;
        this.trunkCapacity = trunkCapacity;
        this.setBusTypes(busTypes.TRAVEL_BUS);
    }

    public TravelBus() {
    }

    @Override
    public String getMyType() {
        return getBusTypes().toString();
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

    public int getTrunkCapacity() {
        return trunkCapacity;
    }

    public void setTrunkCapacity(int trunkCapacity) {
        this.trunkCapacity = trunkCapacity;
    }

    public double getHeight() {
        return height;
    }

    public String toString() {
        return "ID: " + this.getIdNumber();
    }
}
