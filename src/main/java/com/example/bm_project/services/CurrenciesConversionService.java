package com.example.bm_project.services;


import com.example.bm_project.dto.response.CurrenciesConversionResponseDto;

public interface CurrenciesConversionService {
    CurrenciesConversionResponseDto getCurrenciesConversionRate(String baseCurrency, String targetCurrency, String amount);
}
