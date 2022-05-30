package com.totvs.ficticius.carsapi.domain.cars.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "brands")
@Getter
@NoArgsConstructor
public class CarBrand {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brand_id;

    @Column
    private String brand_name;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;

    public CarBrand(String brand_name) {
        this.brand_name = brand_name;
    }
}
