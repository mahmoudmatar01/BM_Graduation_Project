package com.example.currency_conversion_app.services;


import com.example.currency_conversion_app.dto.response.CurrenciesConversionDto;

public interface CurrenciesConversionService {
    CurrenciesConversionDto getCurrenciesConversionRate(String baseCurrency, String targetCurrency, String amount);
}
