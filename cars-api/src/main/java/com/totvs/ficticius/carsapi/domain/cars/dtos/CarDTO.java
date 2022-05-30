package com.totvs.ficticius.carsapi.domain.cars.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarDTO {
    private String nome;
    private String marca;
    private String modelo;
    private int fabricacao;
    private double consumoCidade;
    private double consumoRodovia;
}
