//package com.totvs.ficticius.carsapi.infrastructure.services;
//
//import com.totvs.ficticius.carsapi.domain.cars.dtos.CarDTO;
//import com.totvs.ficticius.carsapi.domain.cars.entities.Car;
//import com.totvs.ficticius.carsapi.domain.cars.repositories.ICarRepository;
//import com.totvs.ficticius.carsapi.domain.cars.services.ICarService;
//import com.totvs.ficticius.carsapi.domain.shared.errors.CarNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class CarServiceJdbc implements ICarService {
//    private final ICarRepository carRepository;
//
//    public CarServiceJdbc(ICarRepository carRepository) {
//        this.carRepository = carRepository;
//    }
//
//    public List<Car> listALlCars() throws SQLException {
//        List<Car> resultList = new ArrayList<>();
//        ResultSet resultSet = carRepository
//                .select(
//                        "c.car_id AS id, cn.car_name_name AS nome, b.brand_name AS marca, m.model_name AS modelo, c.car_fabrication_date AS fabricacao, c.car_city_consumption AS consumoCidade, c.car_road_consumption AS consumoRodovia",
//                        "cars c INNER JOIN models m ON c.car_model = m.model_id INNER JOIN car_names cn ON m.model_car_name = cn.car_name_id INNER JOIN brands b ON cn.car_name_brand = b.brand_id"
//                );
//
//        while (resultSet.next()) {
//            Car car = new Car(
//                    resultSet.getString("nome"),
//                    resultSet.getString("marca"),
//                    resultSet.getString("modelo"),
//                    resultSet.getInt("fabricacao"),
//                    resultSet.getDouble("consumoCidade"),
//                    resultSet.getDouble("consumoRodovia"),
//                    UUID.fromString(resultSet.getString("id")
//                    ));
//            resultList.add(car);
//        }
//        return resultList;
//    }
//
//    public Car listCarById(String id) throws SQLException, IllegalArgumentException, CarNotFoundException {
//        UUID uuid = UUID.fromString(id);
//
//        ResultSet resultSet = carRepository
//                .select(
//                        "c.car_id AS id, cn.car_name_name AS nome, b.brand_name AS marca, m.model_name AS modelo, c.car_fabrication_date AS fabricacao, c.car_city_consumption AS consumoCidade, c.car_road_consumption AS consumoRodovia",
//                        "cars c INNER JOIN models m ON c.car_model = m.model_id INNER JOIN car_names cn ON m.model_car_name = cn.car_name_id INNER JOIN brands b ON cn.car_name_brand = b.brand_id",
//                        "WHERE car_id = '" + uuid + "'"
//                );
//
//        if (!(resultSet.next())) {
//            throw new CarNotFoundException();
//        }
//
////        resultSet.next();
//        Car car = new Car(resultSet.getString("nome"), resultSet.getString("marca"), resultSet.getString("modelo"), resultSet.getInt("fabricacao"), resultSet.getDouble("consumoCidade"), resultSet.getDouble("consumoRodovia"), UUID.fromString(resultSet.getString("id")));
//        return car;
//    }
//
//    public Car insertCar(CarDTO car) throws SQLException {
//        ResultSet brandResultSet = carRepository
//                .select("*", "brands", "WHERE brand_name = '" + car.getMarca() + "'");
//        String brandId = !(brandResultSet.next())
//                ? carRepository
//                .save("brands", "brand_name", new String[]{car.getMarca()}).getString(1)
//                : brandResultSet.getString(1);
//
//        ResultSet carNameResultSet = carRepository.select("*", "car_names", "WHERE car_name_name = '" + car.getNome() + "'");
//        String carNameId = !(carNameResultSet.next())
//                ? carRepository
//                .save("car_names", "car_name_name, car_name_brand", new String[]{car.getNome(), brandId}).getString(1)
//                : carNameResultSet.getString(1);
//
//        ResultSet modelResultSet = carRepository.select("*", "models", "WHERE model_name = '" + car.getModelo() + "'");
//        String modelId = (!(modelResultSet.next()))
//                ? carRepository.save(
//                "models",
//                "model_name, model_car_name",
//                new String[]{car.getModelo(), carNameId}).getString(1)
//                : modelResultSet.getString("model_id");
//
//        String carId = carRepository.save(
//                "cars",
//                "car_model, car_fabrication_date, car_city_consumption, car_road_consumption",
//                new String[]{modelId, car.getFabricacao().toString(), car.getConsumoCidade().toString(), car.getConsumoRodovia().toString()}).getString(1);
//
//        Car newCar = new Car(
//                car.getNome(),
//                car.getMarca(),
//                car.getModelo(),
//                car.getFabricacao(),
//                car.getConsumoCidade(),
//                car.getConsumoCidade(),
//                UUID.fromString(carId));
//        return newCar;
//    }
//}
