package com.data.factory.Service;

import com.data.factory.Model.ClassicCar;
import com.data.factory.Model.Parking;
import com.data.factory.Model.Vehicle;
import com.data.factory.Repository.ClassicCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

@Service
public class ClassicCarService {

    private ClassicCarRepository classicCarRepository;

    @Autowired
    public ClassicCarService(final ClassicCarRepository classicCarRepository) {
        this.classicCarRepository = classicCarRepository;
    }

    //SAVE METHOD
    public ClassicCar saveClassicCar(ClassicCar classicCar) {

        classicCar = classicCarRepository.save(classicCar);
        Parking.listOfAllVehiclesAddedToDataBase.add(classicCar);
        return classicCar;
    }

    //PULL METHOD
    public List<ClassicCar> getAllClassic() {
        return classicCarRepository.findAll();
    }

    //DELETE
    public Iterator<Vehicle> deleteClassicCar(Integer idNumberOfVehicle) throws SQLException, ClassNotFoundException {

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
                        "DELETE FROM test.classic_car where id_number=?");

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


