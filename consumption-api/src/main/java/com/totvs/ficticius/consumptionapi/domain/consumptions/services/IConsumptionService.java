package com.totvs.ficticius.consumptionapi.domain.consumptions.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.totvs.ficticius.consumptionapi.domain.consumptions.dtos.ConsumptionDTO;
import com.totvs.ficticius.consumptionapi.domain.consumptions.entities.Consumption;

import java.util.List;

public interface IConsumptionService {
    Consumption[] consumptionReport(ConsumptionDTO consumptionDTO) throws JsonProcessingException;
}
