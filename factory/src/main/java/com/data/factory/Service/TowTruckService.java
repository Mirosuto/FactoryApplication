package com.data.factory.Service;

import com.data.factory.Model.Parking;
import com.data.factory.Model.TowTruck;
import com.data.factory.Model.Vehicle;
import com.data.factory.Repository.TowTruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;


@Service
public class TowTruckService {

    @Autowired
    private TowTruckRepository towTruckRepository;

    public TowTruckService(final TowTruckRepository towTruckRepository) {
        this.towTruckRepository = towTruckRepository;
    }

    //SAVE METHOD
    public TowTruck saveTowTruck(TowTruck towTruck) {

        towTruck = towTruckRepository.save(towTruck);
        Parking.listOfAllVehiclesAddedToDataBase.add(towTruck);
        return towTruck;
    }

    //PULL METHOD
    public List<TowTruck> getAllTow() {
        return towTruckRepository.findAll();
    }

    //DELETE
    public Iterator<Vehicle> deleteTowTruck(Integer idNumberOfVehicle) throws SQLException, ClassNotFoundException {

        Parking parking = new Parking();

        List<Vehicle> list = Parking.listOfAllVehiclesAddedToDataBase;
        Iterator<Vehicle> iterator = list.iterator();


        //Delete from DB
        if (idNumberOfVehicle != null && idNumberOfVehicle != 0) {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test","root","root");

            PreparedStatement st = null;
            try {
                st = connection.prepareStatement(
                        "DELETE FROM test.tow_truck where id_number=?");

                st.setString(1, String.valueOf(idNumberOfVehicle));

                st.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                st.close();
                connection.close();
            }
            //Delete from List
            while ( iterator.hasNext() ) {
                Vehicle vehicle = iterator.next();
                if (vehicle.getIdNumber() == idNumberOfVehicle) {
                    iterator.remove();
                }
            }

        } return iterator;
    }
}
