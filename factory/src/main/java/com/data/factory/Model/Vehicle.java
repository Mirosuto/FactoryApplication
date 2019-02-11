package com.data.factory.Model;

import com.data.factory.enums.VehicleType;

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
    public Parking parking;


    @Column(name = "parking_id", updatable = false, insertable = false, nullable = false)
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


    public abstract String getMyType();

    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public int getParkingId() {
        return parking_id;
    }

    public void setParkingId(int parking_id) {
        this.parking_id = parking_id;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public int getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(int povrsina) {
        this.povrsina = povrsina;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
