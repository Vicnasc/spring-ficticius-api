package com.totvs.ficticius.carsapi.infrastructure.services;

import com.totvs.ficticius.carsapi.domain.cars.dtos.CarDTO;
import com.totvs.ficticius.carsapi.domain.cars.dtos.CarResponse;
import com.totvs.ficticius.carsapi.domain.cars.entities.Car;
import com.totvs.ficticius.carsapi.domain.cars.entities.CarBrand;
import com.totvs.ficticius.carsapi.domain.cars.entities.CarModel;
import com.totvs.ficticius.carsapi.domain.cars.entities.CarName;
import com.totvs.ficticius.carsapi.domain.cars.repositories.IBrandRepository;
import com.totvs.ficticius.carsapi.domain.cars.repositories.ICarRepository;
import com.totvs.ficticius.carsapi.domain.cars.repositories.IModelRepository;
import com.totvs.ficticius.carsapi.domain.cars.repositories.INameRepository;
import com.totvs.ficticius.carsapi.domain.cars.services.ICarService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CarService implements ICarService {
    private final ICarRepository carRepository;
    private final IBrandRepository brandRepository;
    private final INameRepository nameRepository;
    private final IModelRepository modelRepository;

    public CarService(
            ICarRepository carRepository,
            IBrandRepository brandRepository,
            INameRepository nameRepository,
            IModelRepository modelRepository
    ) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
        this.nameRepository = nameRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public List<CarResponse> listALlCars() {
        List<Car> cars = carRepository.findAll();
        List<CarResponse> carResponses = new ArrayList<>();

        for (Car dbCar : cars) {
            Car car = carRepository.findById(dbCar.getId()).orElse(null);
            if (Objects.nonNull(car)) carResponses.add(new CarResponse(car));
        }

        return carResponses;
    }

    @Override
    public CarResponse listCarById(Long id) throws IllegalArgumentException {
        Car car = carRepository.findById(id).orElse(null);
        return Objects.isNull(car) ? null : new CarResponse(car);
    }

    @Override
    public CarResponse insertCar(CarDTO carDTO) {
        CarBrand carBrand = new CarBrand(carDTO.getMarca());
        CarBrand savedBrand = brandRepository.save(carBrand);

        CarName carName = new CarName(carDTO.getNome(), savedBrand);
        CarName savedCarName = nameRepository.save(carName);

        CarModel carModel = new CarModel(carDTO.getModelo(), savedCarName);
        CarModel savedModel = modelRepository.save(carModel);

        Car car = new Car(savedModel, carDTO.getFabricacao(), carDTO.getConsumoCidade(), carDTO.getConsumoRodovia());
        Car savedCar = carRepository.save(car);

        return new CarResponse(savedCar);
    }
}
