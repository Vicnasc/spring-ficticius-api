package com.totvs.ficticius.carsapi.domain.cars.repositories;

import com.totvs.ficticius.carsapi.domain.cars.entities.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<CarBrand, Long> {
}
