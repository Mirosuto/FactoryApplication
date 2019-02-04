//package com.data.factory;
//
//import com.data.factory.Model.CityBus;
//import com.data.factory.Model.ClassicCar;
//import com.data.factory.Model.Vehicle;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class FactoryApplicationTests {
//
//	@Test
//	public void ParkingSubtractionPartTest() {
//
//		CityBus cityBus = new CityBus("test", "black", 2, 4, 5, "yes");
//		CityBus cityBus1 = new CityBus("test1", "black", 2, 4, 5, "yes");
//		ClassicCar classicCar = new ClassicCar("ClassicCar", "red", 2, 5, "tire", 45);
//
//		int sumOfVehicleSize = 0;
//
//		List<Vehicle> listaVozila = new ArrayList<>();
//
//		listaVozila.add(cityBus);
//		listaVozila.add(cityBus1);
//		listaVozila.add(classicCar);
//
//		for (int i = 0; i < listaVozila.size(); i++){
//
//			Vehicle vehicle = listaVozila.get(i);
//
//			int valueOfVehicleSize = vehicle.getPovrsina();
//
//			sumOfVehicleSize += valueOfVehicleSize;
//		}
//
//		Assert.assertEquals(68, sumOfVehicleSize);
//
//
//	}
//
//}
//
