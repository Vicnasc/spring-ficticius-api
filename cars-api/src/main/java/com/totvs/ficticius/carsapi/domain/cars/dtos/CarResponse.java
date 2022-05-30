package com.totvs.ficticius.carsapi.domain.cars.dtos;

import com.totvs.ficticius.carsapi.domain.cars.entities.Car;
import lombok.Getter;

@Getter
public class CarResponse {
    private final Long id;
    private final String nome;
    private final String marca;
    private final String modelo;
    private final int fabricacao;
    private final double consumoCidade;
    private final double consumoRodovia;

    public CarResponse(Car car) {
        this.id = car.getId();
        this.nome = car.getModelo().getCar_model_car_name().getCar_name_name();
        this.marca = car.getModelo().getCar_model_car_name().getCar_name_brand().getBrand_name();
        this.modelo = car.getModelo().getCar_model_name();
        this.fabricacao = car.getFabricacao();
        this.consumoCidade = car.getConsumoCidade();
        this.consumoRodovia = car.getConsumoRodovia();
    }
}
