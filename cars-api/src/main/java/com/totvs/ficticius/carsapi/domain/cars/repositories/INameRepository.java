package com.totvs.ficticius.carsapi.domain.cars.repositories;

import com.totvs.ficticius.carsapi.domain.cars.entities.CarName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INameRepository extends JpaRepository<CarName, Long> {
}
