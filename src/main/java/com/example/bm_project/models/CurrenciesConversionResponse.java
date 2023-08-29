package com.example.bm_project.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrenciesConversionResponse {

    @JsonProperty(value = "base_code")
    private String baseCode;
    @JsonProperty(value = "target_code")
    private String targetCode;
    @JsonProperty(value = "conversion_rate")
    private String conversionRate;
    @JsonProperty(value = "conversion_result")
    private String conversionResult;

}
