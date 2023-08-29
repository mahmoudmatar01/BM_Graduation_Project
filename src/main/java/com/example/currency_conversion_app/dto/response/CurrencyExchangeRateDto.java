package com.example.currency_conversion_app.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
@Builder
public class CurrencyExchangeRateDto {
    private Map<String, Double> conversionRates;

}
