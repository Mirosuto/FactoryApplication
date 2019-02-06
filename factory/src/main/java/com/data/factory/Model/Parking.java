package com.data.factory.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parking")
@Indexed
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer parking_id;

    @Column
    private double prostor;

    @Column
    private String tip;

    @Column
    private double visina;

    @OneToMany(mappedBy = "parking", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public static List<Vehicle> vehicleList = new ArrayList<>();



    public Integer getParking_id() {
        return parking_id;
    }

    public void setParking_id(Integer parking_id) {
        this.parking_id = parking_id;
    }

    public double getProstor() {
        return prostor;
    }

    public void setProstor(double prostor) {
        this.prostor = prostor;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public double getVisina() {
        return visina;
    }

    public void setVisina(double visina) {
        this.visina = visina;
    }

    @JsonIgnore
    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    @JsonIgnore
    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public String toString() {
        return "ID: " + this.getParking_id() + "| Tip :" +this.getTip()+ "| Prostor: " +this.getProstor()+ "| Visina: " +this.getVisina();
    }
}
