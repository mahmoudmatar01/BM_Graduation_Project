package com.example.currencyapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyCompareResponse {

    @JsonProperty("base_code")
    private String baseCode;
    @JsonProperty("conversion_rates")
    private Map<String, Double> conversionRates;

}
