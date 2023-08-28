package com.example.bm_project.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrenciesConversionResponseDto {

    private String baseCode;
    private String targetCode;
    private String conversionRate;
    private String conversionResult;

}
