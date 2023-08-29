package com.example.bm_project.services;


import com.example.bm_project.dto.response.CurrencyExchangeRateResponseDto;

public interface CurrencyExchangeRateService {
    CurrencyExchangeRateResponseDto getBaseCurrencyExchangeRate(String baseCurrency);
}
