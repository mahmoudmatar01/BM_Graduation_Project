package com.example.currencyapp.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class CurrencyCompareDto{

    private String baseCode;
    private Map<String, Double> conversionRates;

}
