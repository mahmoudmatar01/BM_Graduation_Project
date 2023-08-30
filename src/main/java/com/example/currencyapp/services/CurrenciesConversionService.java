package com.example.currencyapp.services;


import com.example.currencyapp.dto.response.CurrenciesConversionDto;

public interface CurrenciesConversionService {
    CurrenciesConversionDto getCurrenciesConversionRate(String baseCurrency, String targetCurrency, String amount);
}
