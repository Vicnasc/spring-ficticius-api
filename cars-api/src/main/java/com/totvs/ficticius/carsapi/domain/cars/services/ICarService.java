package com.totvs.ficticius.carsapi.domain.cars.services;

import com.totvs.ficticius.carsapi.domain.cars.dtos.CarDTO;
import com.totvs.ficticius.carsapi.domain.cars.dtos.CarResponse;
import com.totvs.ficticius.carsapi.domain.shared.errors.CarNotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface ICarService {

    List<CarResponse> listALlCars() throws SQLException;

    CarResponse listCarById(Long id) throws SQLException, IllegalArgumentException, CarNotFoundException;

    CarResponse insertCar(CarDTO car) throws SQLException;
}
