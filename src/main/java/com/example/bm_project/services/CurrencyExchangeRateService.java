package com.example.bm_project.services;


import com.example.bm_project.models.CurrencyRate;

import java.util.List;

public interface CurrencyExchangeRateService {
    List<CurrencyRate> getBaseCurrencyExchangeRate(String baseCurrency);
}
