package com.example.currency_conversion_app.services;


import com.example.currency_conversion_app.dto.request.CurrenciesCompareRequestDto;
import com.example.currency_conversion_app.dto.response.CurrencyCompareDto;

public interface CurrenciesCompareService {
    CurrencyCompareDto getCurrenciesCompareRate(CurrenciesCompareRequestDto currenciesCompareRequestDto);
}
