//package kz.project.g135.services;
//
//import kz.project.g135.model.Car;
//import lombok.*;
//import lombok.Getter;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CarStorage {
//
//    @Getter
//    private List<Car> cars=new ArrayList<>();
//
//    public CarStorage() {
//
//        Car c1 = Car
//                .builder()
//                .id(1L)
//                .model("BMW")
//                .price(2000)
//                .engine(20)
//                .color("red")
//                .description("automot")
//                .build();
//
//        cars.add(c1);
//
//        Car c2 = Car.builder().id(2L)
//                .model("LEXUS")
//                .price(100).
//                engine(10).
//                color("blue")
//                .description("SAUSAGE")
//                .build();
//
//        cars.add(c2);
//    }
//
//    public void addCar(Car car) {
//        car.setId(cars.size()+1L);
//        cars.add(car);
//    }
//
//    public void removeCar(long id) {
//        cars.stream().filter((c->c.getId()==id)).findFirst().ifPresent(c->cars.remove(c));
//    }
//    public void UpdateCar(long id, Car car) {
//        for(int i=0; i<cars.size(); i++){
//            if(cars.get(i).getId()==id){
//                cars.set(i, car);
//                break;
//            }
//        }
//
//    }
//
//}
