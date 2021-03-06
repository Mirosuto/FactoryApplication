package com.data.factory.Service;

import com.data.factory.Model.ConvertibleCar;
import com.data.factory.Model.Parking;
import com.data.factory.Model.Vehicle;
import com.data.factory.Repository.ConvertibleCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;


@Service
public class ConvertibleCarService {

    private ConvertibleCarRepository convertibleCarRepository;

    @Autowired
    public ConvertibleCarService(final ConvertibleCarRepository convertibleCarRepository) {
        this.convertibleCarRepository = convertibleCarRepository;
    }

    //SAVE METHOD
    public ConvertibleCar saveConvertibleCar(ConvertibleCar convertibleCar) {

        convertibleCar = convertibleCarRepository.save(convertibleCar);
        Parking.listOfAllVehiclesAddedToDataBase.add(convertibleCar);
        return convertibleCar;
    }

    //PULL METHOD
    public List<ConvertibleCar> getAllConvertible() {
        return convertibleCarRepository.findAll();
    }

    //DELETE
    public Iterator<Vehicle> deleteConvertibleCar(Integer idNumberOfVehicle) throws SQLException, ClassNotFoundException {

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
                        "DELETE FROM test.convertible_car where id_number=?");

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
