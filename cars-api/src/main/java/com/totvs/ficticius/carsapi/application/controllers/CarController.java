package com.totvs.ficticius.carsapi.application.controllers;

import com.totvs.ficticius.carsapi.domain.cars.dtos.CarDTO;
import com.totvs.ficticius.carsapi.domain.cars.dtos.CarResponse;
import com.totvs.ficticius.carsapi.domain.cars.services.ICarService;
import com.totvs.ficticius.carsapi.domain.shared.entities.BaseResponse;
import com.totvs.ficticius.carsapi.domain.shared.errors.CarNotFoundException;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Tag(name = "Cars", description = "Endpoint to insert new cars")
@RestController
@RequestMapping(value = "api/v1/cars", produces = "application/json")
public class CarController {
    private final Logger logger = LogManager.getLogger(CarController.class);
    private final ICarService carService;

    public CarController(ICarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<BaseResponse> getCars() {
        logger.info("GET /cars");

        BaseResponse response = new BaseResponse();
        try {
            List<CarResponse> carsList = carService.listALlCars();
            logger.info("Cars fetch with SUCCESS");

            response.setData(carsList.toArray());
            response.setItemsPerPage(carsList.size());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (SQLException e) {
            logger.error("Fetch ERROR: ".concat(e.getMessage()));

            response.setStatusCode(400);
            response.setErrors(new Object[]{e.getMessage()});
            response.setMessage("error");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Unexpected ERROR: ".concat(e.getMessage()));

            response.setStatusCode(500);
            response.setErrors(new Object[]{e.getMessage()});
            response.setMessage("error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getCar(@PathVariable Long id) {
        logger.info("GET /cars");

        BaseResponse response = new BaseResponse();
        try {
            CarResponse car = carService.listCarById(id);
            logger.trace("Cars fetch with SUCCESS");

            response.setData(new CarResponse[]{car});
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (CarNotFoundException e) {
            logger.error(e.getClass().getSimpleName().concat(e.getMessage()));

            response.setStatusCode(404);
            response.setErrors(new Object[]{e.getMessage()});
            response.setMessage("error");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (SQLException e) {
            logger.error(e.getClass().getSimpleName().concat(e.getMessage()));

            response.setStatusCode(400);
            response.setErrors(new Object[]{e.getMessage()});
            response.setMessage("error");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error(e.getClass().getSimpleName().concat(e.getMessage()));

            response.setStatusCode(500);
            response.setErrors(new Object[]{e.getMessage()});
            response.setMessage("error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<BaseResponse> insertCar(@RequestBody CarDTO car) {
        logger.info("POST /cars " + car);

        BaseResponse response = new BaseResponse();

        try {
            CarResponse newCar = carService.insertCar(car);

            response.setData(new CarResponse[]{newCar});
            response.setStatusCode(201);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (SQLException e) {
            logger.error("Fetch ERROR: ".concat(e.getMessage()));

            response.setStatusCode(400);
            response.setErrors(new Object[]{e.getMessage()});
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Unexpected ERROR: ".concat(e.getMessage()));

            response.setStatusCode(500);
            response.setErrors(new Object[]{e.getMessage()});
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}