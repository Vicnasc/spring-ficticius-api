package com.totvs.ficticius.carsapi.domain.cars.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarDTO {
    private String nome;
    private String marca;
    private String modelo;
    private Integer fabricacao;
    private Double consumoCidade;
    private Double consumoRodovia;
}
