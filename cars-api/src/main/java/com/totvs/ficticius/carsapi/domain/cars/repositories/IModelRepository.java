package com.totvs.ficticius.carsapi.domain.cars.repositories;

import com.totvs.ficticius.carsapi.domain.cars.entities.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IModelRepository extends JpaRepository<CarModel, Long> {
}
