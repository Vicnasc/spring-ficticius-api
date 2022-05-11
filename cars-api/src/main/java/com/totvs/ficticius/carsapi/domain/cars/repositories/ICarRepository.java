package com.totvs.ficticius.carsapi.domain.cars.repositories;

import com.totvs.ficticius.carsapi.domain.cars.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarRepository extends JpaRepository<Car, Long> {
}
