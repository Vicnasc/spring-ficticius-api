package com.totvs.ficticius.consumptionapi.domain.shared.entities;

import lombok.Data;

@Data
public class CarResponse {
    private Integer statusCode = 200;
    private String message = "success";
    private Integer page = 1;
    private Integer totalPages = 1;
    private Integer itemsPerPage = 1;
    private Object[] errors = new Object[]{};
    private Car[] data = new Car[]{};
}
