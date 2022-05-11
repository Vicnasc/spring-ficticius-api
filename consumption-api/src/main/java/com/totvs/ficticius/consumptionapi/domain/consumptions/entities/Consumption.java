package com.totvs.ficticius.consumptionapi.domain.consumptions.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Consumption {
    private String nome;
    private String marca;
    private String modelo;
    private Integer ano;
    private Double combustivelGasto;
    private Double valorTotalCombustivel;
}
