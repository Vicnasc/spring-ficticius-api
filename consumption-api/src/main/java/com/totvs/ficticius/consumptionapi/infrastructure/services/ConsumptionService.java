package com.totvs.ficticius.consumptionapi.infrastructure.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.totvs.ficticius.consumptionapi.domain.consumptions.dtos.ConsumptionDTO;
import com.totvs.ficticius.consumptionapi.domain.consumptions.entities.Consumption;
import com.totvs.ficticius.consumptionapi.domain.consumptions.services.IConsumptionService;
import com.totvs.ficticius.consumptionapi.domain.shared.entities.BaseResponse;
import com.totvs.ficticius.consumptionapi.domain.shared.entities.Car;
import com.totvs.ficticius.consumptionapi.domain.shared.entities.CarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ConsumptionService implements IConsumptionService {
    private final WebClient webClient;
    @Value("${service.url}")
    private String baseURL;

    @Autowired
    public ConsumptionService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }
    public Consumption[] consumptionReport(ConsumptionDTO consumptionDTO) {
         CarResponse jsonResponse = webClient
                .get()
                .uri(baseURL.concat("/cars"))
                .retrieve()
                .bodyToMono( CarResponse.class)
                .block();

        assert jsonResponse != null;
        Car[] responseData = jsonResponse.getData();

        List<Consumption> consumptionList = new ArrayList<>();
        for (Car car : responseData) {
            Double wastedCityFuel = car.getConsumoCidade() / consumptionDTO.getKmCidade();
            Double cityFuelCost = wastedCityFuel * consumptionDTO.getPrecoGasolina();
            Double wastedRoadFuel = car.getConsumoRodovia() / consumptionDTO.getKmRodovia();
            Double roadFuelCost = wastedRoadFuel * consumptionDTO.getPrecoGasolina();

            Double totalFuel = new BigDecimal(wastedCityFuel + wastedRoadFuel)
                    .setScale(2, RoundingMode.FLOOR)
                    .doubleValue();
            Double totalFuelCost = new BigDecimal(cityFuelCost + roadFuelCost)
                    .setScale(2, RoundingMode.CEILING)
                    .doubleValue();

            consumptionList.add(new Consumption(car.getNome(), car.getMarca(), car.getModelo(), car.getFabricacao(), totalFuel, totalFuelCost));
        }
        return consumptionList.toArray(new Consumption[consumptionList.size()]);
    }
}
