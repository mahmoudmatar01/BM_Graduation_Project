package com.example.bm_project.services;


import com.example.bm_project.dto.response.CurrenciesConversionDto;
import com.example.bm_project.models.CurrenciesConversionResponse;

public interface CurrenciesConversionService {
    CurrenciesConversionDto getCurrenciesConversionRate(String baseCurrency, String targetCurrency, String amount);
}
