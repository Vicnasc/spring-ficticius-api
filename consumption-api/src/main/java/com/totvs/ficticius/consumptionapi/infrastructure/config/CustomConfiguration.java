package com.totvs.ficticius.consumptionapi.infrastructure.config;

import com.totvs.ficticius.consumptionapi.domain.consumptions.services.IConsumptionService;
import com.totvs.ficticius.consumptionapi.infrastructure.services.ConsumptionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
class CustomConfiguration {
    @Bean
    WebClient webClient(WebClient.Builder builder) {
        return builder.build();
    }
}