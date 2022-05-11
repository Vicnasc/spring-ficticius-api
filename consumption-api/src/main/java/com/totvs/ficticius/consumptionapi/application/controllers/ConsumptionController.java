package com.totvs.ficticius.consumptionapi.application.controllers;

import com.totvs.ficticius.consumptionapi.domain.consumptions.dtos.ConsumptionDTO;
import com.totvs.ficticius.consumptionapi.domain.consumptions.entities.Consumption;
import com.totvs.ficticius.consumptionapi.domain.consumptions.services.IConsumptionService;
import com.totvs.ficticius.consumptionapi.domain.shared.entities.BaseResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/consumptions")
public class ConsumptionController {
    private final Logger logger = LogManager.getLogger(ConsumptionController.class);
    private IConsumptionService consumptionService;

    public ConsumptionController(IConsumptionService consumptionService) {
        this.consumptionService = consumptionService;
    }

    @PostMapping
    public BaseResponse generateReport(@RequestBody ConsumptionDTO consumptionDTO) {
        logger.info("POST /consumptions ".concat(consumptionDTO.toString()));

        BaseResponse response = new BaseResponse();
        try {
            Consumption[] consumptionList = consumptionService.consumptionReport(consumptionDTO);
            response.setData(consumptionList);

            return response;
        } catch (Exception e) {
            response.setErrors(new Object[] {e.getMessage()});
            response.setMessage("error");
            response.setStatusCode(500);

            return response;
        }
    }
}
