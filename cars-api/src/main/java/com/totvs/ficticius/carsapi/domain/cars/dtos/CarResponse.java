package com.totvs.ficticius.carsapi.domain.cars.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarResponse {
    @Id
    private Long id;
    private String nome;
    private String marca;
    private String modelo;
    private Integer fabricacao;
    private Double consumoCidade;
    private Double consumoRodovia;
}
