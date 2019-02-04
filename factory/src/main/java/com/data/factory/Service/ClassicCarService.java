//package com.data.factory.Service;
//
//import com.data.factory.Model.ClassicCar;
//import com.data.factory.Repository.ClassicCarRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ClassicCarService {
//
//    private ClassicCarRepository classicCarRepository;
//
//    @Autowired
//    public ClassicCarService(final ClassicCarRepository classicCarRepository) {
//        this.classicCarRepository = classicCarRepository;
//    }
//
//    //SAVE METHOD
//    public ClassicCar saveClassicCar(ClassicCar classicCar) {
//
//        classicCar = classicCarRepository.save(classicCar);
//        return classicCar;
//    }
//
//    //PULL METHOD
//    public List<ClassicCar> getAllClassic() {
//        return classicCarRepository.findAll();
//    }
//
//}
//
//
