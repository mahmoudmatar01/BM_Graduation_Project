package com.example.bm_project.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class CurrencyCompareDto {

    private String baseCode;
    private Map<String, Double> conversionRates;

}
