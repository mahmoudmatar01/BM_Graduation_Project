package com.example.bm_project.services;


import com.example.bm_project.dto.request.CurrenciesCompareRequestDto;
import com.example.bm_project.dto.response.CurrencyCompareDto;
import com.example.bm_project.models.CurrencyCompareResponse;

public interface CurrenciesCompareService {
    CurrencyCompareDto getCurrenciesCompareRate(CurrenciesCompareRequestDto currenciesCompareRequestDto);
}
