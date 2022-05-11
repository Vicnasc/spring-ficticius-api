package com.totvs.ficticius.consumptionapi.infrastructure.repositories;

import com.totvs.ficticius.consumptionapi.domain.consumptions.repositories.IConsumptionRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class ConsumptionRepository implements IConsumptionRepository {
    private WebClient webClient;

    public ConsumptionRepository(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Object getCars() {
        return null;
    }
}
