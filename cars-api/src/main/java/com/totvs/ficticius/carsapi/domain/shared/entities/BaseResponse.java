package com.totvs.ficticius.carsapi.domain.shared.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BaseResponse {
    private Integer statusCode = 200;
    private String message = "success";
    private Integer page = 1;
    private Integer totalPages = 1;
    private Integer itemsPerPage = 1;
    private Object[] errors = new Object[]{};
    private Object[] data = new Object[]{};
}
