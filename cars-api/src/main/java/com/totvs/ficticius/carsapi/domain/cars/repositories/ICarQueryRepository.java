package com.totvs.ficticius.carsapi.domain.cars.repositories;

import com.totvs.ficticius.carsapi.domain.cars.dtos.CarResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public interface ICarQueryRepository extends JpaRepository<CarResponse, Long> {
    @Modifying
    @Transactional
    @Query(value = "SELECT " +
            "c.id, cn.car_name_name, cb.brand_name, cm.car_model_name, c.fabricacao, c.consumoCidade, c.consumoRodovia " +
            "FROM Car c INNER JOIN CarModel cm ON cm.car_model_car_name = c.modelo INNER JOIN CarName cn ON cn.car_name_brand = cm.car_model_name INNER JOIN CarBrand cb ON cb.brand_name = cn.car_name_brand")
    List<Object> listAllCarsWithJoins() throws SQLException;
}
