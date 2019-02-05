package com.data.factory.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idNumber", insertable = false, unique = true, updatable = false, nullable = false)
    public Integer idNumber;

    @Column
    public String marka;
    @Column
    public String boja;

    @Transient
    public int povrsina;

    @Transient
    public double height;

    @Column
    public VehicleType vehicleType;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="parking_id", nullable = false)
    public Parking parking = new Parking();

    @Column(name = "parking_id", updatable = false, insertable = false)
    public int parking_id;


    public Vehicle(String marka, String boja, int parking) {
        this.marka = marka;
        this.boja = boja;
        this.parking_id = parking;
    }

    public Vehicle(String marka, String boja, double height) {
        this.marka = marka;
        this.boja = boja;
        this.height = height;
    }


    public Vehicle() {
    }

    @JsonIgnore
    public String getMarka() {
        return marka;
    }

    @JsonIgnore
    public void setMarka(String marka) {
        this.marka = marka;
    }

    @JsonIgnore
    public String getBoja() {
        return boja;
    }

    @JsonIgnore
    public void setBoja(String boja) {
        this.boja = boja;
    }

    @JsonIgnore
    public int getParkingId() {
        return parking_id;
    }

    @JsonIgnore
    public void setParkingId(int parking_id) {
        this.parking_id = parking_id;
    }

    @JsonIgnore
    public int getPovrsina() {
        return povrsina;
    }

    @JsonIgnore
    public void setPovrsina(int povrsina) {
        this.povrsina = povrsina;
    }

    @JsonIgnore
    public double getHeight() {
        return height;
    }

    @JsonIgnore
    public void setHeight(double height) {
        this.height = height;
    }

    @JsonIgnore
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @JsonIgnore
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
