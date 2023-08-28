package com.example.bm_project.services;


import com.example.bm_project.dto.response.CurrencyExchangeRateResponseDto;
import org.springframework.stereotype.Component;

@Component
public interface CurrencyExchangeRateService {
    CurrencyExchangeRateResponseDto getBaseCurrencyExchangeRate(String baseCurrency);
}
