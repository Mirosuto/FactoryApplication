package com.data.factory.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ClassicCar extends Car{


    @Column
    private int roofCarryCapacity;

    @JsonIgnore
    @Transient
    public static final double height = 2.4;

    @JsonIgnore
    @Transient
    public final int povrsina = 8;


    public ClassicCar(String marka, String boja, int parking, int seatNbr, String equipment, int roofCarryCapacity){
        super(marka, boja, parking, seatNbr, equipment);
        this.roofCarryCapacity = roofCarryCapacity;
        this.setCarTypes(carTypes.CLASSIC_CAR);
    }

    public ClassicCar(String marka, String boja, int seatNbr, String equipment, int roofCarryCapacity){
        super(marka, boja, seatNbr, equipment, height);
        this.roofCarryCapacity = roofCarryCapacity;
        this.setCarTypes(carTypes.CLASSIC_CAR);
    }

    public ClassicCar() {
    }



    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public int getRoofCarryCapacity() {
        return roofCarryCapacity;
    }

    public void setRoofCarryCapacity(int roofCarryCapacity) {
        this.roofCarryCapacity = roofCarryCapacity;
    }

    public int getPovrsina() {
        return povrsina;
    }

    public double getHeight() {
        return height;
    }

    public String toString() {
        return "ID: " + this.getIdNumber();
    }
}
