package com.data.factory.Model;

import javax.persistence.*;

//@MappedSuperclass
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

    @ManyToOne
    @JoinColumn(name="parking_id", nullable = false)
    public Parking parking;

    @Column(name = "parking_id", updatable = false, insertable = false)
    private int parking_id;


    public Vehicle(String marka, String boja, int parking_id) {
        this.marka = marka;
        this.boja = boja;
        this.parking_id = parking_id;
    }

    public Vehicle(String marka, String boja, double height) {
        this.marka = marka;
        this.boja = boja;
        this.height = height;
    }


    public Vehicle() {
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
