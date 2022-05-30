package com.totvs.ficticius.carsapi.domain.cars.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Table(name = "models")
@Entity
@NoArgsConstructor
public class CarModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long car_model_id;

    @Column
    private String car_model_name;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;

    @ManyToOne(targetEntity = CarName.class, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "car_name_id", nullable = false)
    private CarName car_model_car_name;

    public CarModel(String car_model_name) {
        this.car_model_name = car_model_name;
    }

    public CarModel(String car_model_name, CarName car_model_car_name) {
        this.car_model_name = car_model_name;
        this.car_model_car_name = car_model_car_name;
    }
}
