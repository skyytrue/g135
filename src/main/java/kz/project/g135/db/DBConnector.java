//package kz.project.g135.db;
//
//import kz.project.g135.model.Car;
//import kz.project.g135.model.City;
//import org.springframework.stereotype.Component;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DBConnector {
//
//    private static Connection connection;
//    private static String url = "jdbc:postgresql://localhost:5432/test"; //база данных
//    private static String login = "postgres";
//    private static String password = "зщыепкуы";
//
//    static {
//        try {
//            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection(url, login, password);  //подключение
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static List<Car> getAllCars(){
//
//        List<Car> cars = new ArrayList<>();
//
//        try {
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cars c " +
//                    "INNER JOIN cities city " +
//                    "ON c.city_id = city.id ORDER BY c.id ASC");
//
//            ResultSet resultSet = statement.executeQuery(); //Только когда тянем данные с таблицы
//
//            while (resultSet.next()){
//                Car car = new Car();
//                car.setId(resultSet.getLong("id"));
//                car.setBrand(resultSet.getString("brand"));
//                car.setColor(resultSet.getString("color"));
//                car.setPrice(resultSet.getDouble("price"));
//                car.setModel(resultSet.getString("model"));
//                car.setEngine(resultSet.getDouble("engine"));
//                car.setDescription(resultSet.getString("description"));
//                car.setCity(car.getCity());
//
//                City city = new City();
//                city.setId(resultSet.getLong("city_id"));
//                city.setCityName(resultSet.getString("city_name"));
//                city.setCode(resultSet.getString("code"));
//                city.setTicker(resultSet.getString("ticker"));
//                car.setCity(city);
//
//                cars.add(car);
//            }
//
//            statement.close();
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return cars;
//    }
//
//    public static void addCar(Car car){
//
//        try {
//
//            PreparedStatement statement = connection.prepareStatement("INSERT INTO cars " +
//                    "(model, price, engine, color, description,city_id) VALUES (?, ?, ?, ?, ?, ?)");
//
//            statement.setString(1, car.getModel());
//            statement.setDouble(2, car.getPrice());
//            statement.setDouble(3, car.getEngine());
//            statement.setString(4, car.getColor());
//            statement.setString(5, car.getDescription());
//            statement.setLong(6, car.getCity().getId());
//
//            statement.executeUpdate();
//            statement.close();
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public static Car getCarById(long id){
//        Car car = new Car();
//
//        try {
//
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cars WHERE id=?");
//            statement.setLong(1, id);
//
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()){
//                car.setId(resultSet.getLong("id"));
//                car.setColor(resultSet.getString("color"));
//                car.setPrice(resultSet.getDouble("price"));
//                car.setModel(resultSet.getString("model"));
//                car.setEngine(resultSet.getDouble("engine"));
//                car.setDescription(resultSet.getString("description"));
//                car.setCity(car.getCity());
//
//                City city = new City();
//                city.setId(resultSet.getLong("city_id"));
//                city.setCode(resultSet.getString("code"));
//                city.setTicker(resultSet.getString("ticker"));
//                city.setCityName(resultSet.getString("city_name"));
//
//
//                car.setCity(city);
//            }
//
//            statement.close();
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return car;
//    }
//
//    public static void updateCar(Car car){
//
//        try {
//
//            PreparedStatement statement = connection.prepareStatement("UPDATE cars " +
//                    "SET color=?, description=?, price=?, model=?, engine=? WHERE id=?");
//
//            statement.setString(1, car.getColor());
//            statement.setString(2, car.getDescription());
//            statement.setDouble(3, car.getPrice());
//            statement.setString(4, car.getModel());
//            statement.setDouble(5, car.getEngine());
//            statement.setLong(6, car.getId());
//
//            statement.executeUpdate();
//            statement.close();
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
//
//    public static void deleteCar(long id){
//
//        try {
//
//            PreparedStatement statement = connection.prepareStatement("DELETE FROM cars WHERE id=?");
//            statement.setLong(1, id);
//
//            statement.executeUpdate();
//            statement.close();
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//}