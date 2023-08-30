package com.example.currencyapp.services;


import com.example.currencyapp.models.CurrencyRate;

import java.util.List;

public interface CurrencyExchangeRateService {
    List<CurrencyRate> getBaseCurrencyExchangeRate(String baseCurrency);
}
