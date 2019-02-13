package com.data.factory.Service;

import com.data.factory.Model.CityBus;
import com.data.factory.Model.ConvertibleCar;
import com.data.factory.Model.Parking;
import com.data.factory.Model.Vehicle;
import com.data.factory.Repository.CityBusRepository;
import com.data.factory.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityBusService {

    private CityBusRepository CityBusRepository;

    private VehicleRepository vehicleRepository;

    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    public CityBusService(final CityBusRepository CityBusRepository) {
        this.CityBusRepository = CityBusRepository;
    }





    //SAVE
    public CityBus saveCityBus(CityBus cityBus) {

        cityBus = CityBusRepository.save(cityBus);
        Parking.listOfAllVehiclesAddedToDataBase.add(cityBus);
        return cityBus;
    }

    //PULL
    public List<CityBus> getAllCity() {
        List<CityBus> list = CityBusRepository.findAll();
        return list;
    }

    //DELETE
    public Iterator<Vehicle> deleteCityBus(Integer idNumberOfVehicle) throws SQLException, ClassNotFoundException {

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
                        "DELETE FROM test.city_bus where id_number=?");

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





//            Optional<Vehicle> v = list.stream()
//                    .filter(item -> item.getIdNumber() == idNumberOfVehicle)
//                    .findFirst();
//            if(v.isPresent()){
//                Vehicle vv = v.get();
//                vv.getParking().getVehicleList().remove(vv);
//                vv.setParking(parking);
//                vv = vehicleRepository.save(vv);
//                CityBusRepository.delete(CityBusRepository.findByIdNumber(idNumberOfVehicle));
//            }

//            for (Vehicle vehicle1 : list) {
//                System.out.println("enter");
//                if (vehicle1.getIdNumber() == idNumberOfVehicle) {
//
//                    break;
//                }
//                System.out.println("exit");
//            }





