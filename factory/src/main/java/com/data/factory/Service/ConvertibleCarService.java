//package com.data.factory.Service;
//
//import com.data.factory.Model.ConvertibleCar;
//import com.data.factory.Repository.ConvertibleCarRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//@Service
//public class ConvertibleCarService {
//
//    private ConvertibleCarRepository convertibleCarRepository;
//
//    @Autowired
//    public ConvertibleCarService(final ConvertibleCarRepository convertibleCarRepository) {
//        this.convertibleCarRepository = convertibleCarRepository;
//    }
//
//    //SAVE METHOD
//    public ConvertibleCar saveConvertibleCar(ConvertibleCar convertibleCar) {
//
//        convertibleCar = convertibleCarRepository.save(convertibleCar);
//        return convertibleCar;
//    }
//
//    //PULL METHOD
//    public List<ConvertibleCar> getAllConvertible() {
//        return convertibleCarRepository.findAll();
//    }
//
//}
