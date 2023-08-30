package com.example.currencyapp.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CurrenciesConversionDto  {
    private String baseCode;
    private String targetCode;
    private String conversionRate;
    private String conversionResult;
}
