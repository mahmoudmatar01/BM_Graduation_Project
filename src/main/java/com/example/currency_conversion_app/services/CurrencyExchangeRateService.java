package com.example.currency_conversion_app.services;


import com.example.currency_conversion_app.models.CurrencyRate;

import java.util.List;

public interface CurrencyExchangeRateService {
    List<CurrencyRate> getBaseCurrencyExchangeRate(String baseCurrency);
}
