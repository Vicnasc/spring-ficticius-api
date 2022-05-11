package com.totvs.ficticius.carsapi.domain.cars.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "car_names")
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class CarName {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long car_name_id;

    @Column
    private String car_name_name;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;

    @ManyToOne(targetEntity = CarBrand.class, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private CarBrand car_name_brand;

    public CarName(String car_name_name) {
        this.car_name_name = car_name_name;
    }

    public CarName(String car_name_name, CarBrand car_name_brand) {
        this.car_name_name = car_name_name;
        this.car_name_brand = car_name_brand;
    }
}
