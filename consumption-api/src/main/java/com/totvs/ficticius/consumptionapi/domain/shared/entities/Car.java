package com.totvs.ficticius.consumptionapi.domain.shared.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
@JsonPropertyOrder("id")
public class Car {
    private final String nome;
    private final String marca;
    private final String modelo;
    private final Integer fabricacao;
    private final Double consumoCidade;
    private final Double consumoRodovia;
    private final Long id;
}
