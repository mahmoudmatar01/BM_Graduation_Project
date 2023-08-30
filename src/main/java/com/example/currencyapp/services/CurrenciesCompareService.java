package com.example.currencyapp.services;


import com.example.currencyapp.dto.request.CurrenciesCompareRequestDto;
import com.example.currencyapp.dto.response.CurrencyCompareDto;

public interface CurrenciesCompareService {
    CurrencyCompareDto getCurrenciesCompareRate(CurrenciesCompareRequestDto currenciesCompareRequestDto);
}
