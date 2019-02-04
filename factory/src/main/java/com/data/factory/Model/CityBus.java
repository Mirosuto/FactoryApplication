package com.data.factory.Model;

import javax.persistence.*;

@Entity
@Table(name = "CityBus")
public class CityBus extends Bus{

    @Column
    private String articular;

    @Transient
    public static final double height = 3.4;
    @Transient
    public final int povrsina = 30;


    public CityBus(String marka, String boja, int parking, int numberOfSeats, int numberOfStanding, String articular){
        super(marka, boja, parking, numberOfStanding, numberOfSeats);
        this.articular = articular;
    }

    public CityBus(String marka, String boja, int numberOfSeats, int numberOfStanding, String articular){
        super(marka, boja, numberOfStanding, numberOfSeats, height);
        this.articular = articular;
        this.setBusTypes(BusTypes.CITY_BUS);
    }

    public CityBus() {
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public String getArticular() {
        return articular;
    }

    public void setArticular(String articular) {
        this.articular = articular;
    }

    public int getPovrsina() {
        return povrsina;
    }

    public String toString() {
        return "ID: " + this.getIdNumber();
    }

}
