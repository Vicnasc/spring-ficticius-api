package com.totvs.ficticius.carsapi.domain.cars.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cars")
@JsonPropertyOrder("id")
@Getter
public class Car {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = CarModel.class, cascade = CascadeType.ALL)
    @JoinColumn
    private CarModel modelo;

    @Column
    private Integer fabricacao;

    @Column
    private Double consumoCidade;

    @Column
    private Double consumoRodovia;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;

    public Car() {
    }

    public Car(Integer fabricacao, Double consumoCidade, Double consumoRodovia) {
        this.fabricacao = fabricacao;
        this.consumoCidade = consumoCidade;
        this.consumoRodovia = consumoRodovia;
    }

    public Car(CarModel modelo, Integer fabricacao, Double consumoCidade, Double consumoRodovia) {
        this.modelo = modelo;
        this.fabricacao = fabricacao;
        this.consumoCidade = consumoCidade;
        this.consumoRodovia = consumoRodovia;
    }
}

