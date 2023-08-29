package com.example.bm_project.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class CurrencyExchangeRateDto {
    private Map<String, Double> conversionRates;

}
