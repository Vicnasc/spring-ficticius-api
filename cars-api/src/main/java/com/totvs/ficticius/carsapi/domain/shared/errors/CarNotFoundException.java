package com.totvs.ficticius.carsapi.domain.shared.errors;

public class CarNotFoundException extends Exception {
    public CarNotFoundException() {
        super("Car not found");
    }
}
