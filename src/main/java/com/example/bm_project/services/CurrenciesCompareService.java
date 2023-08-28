package com.example.bm_project.services;


import com.example.bm_project.dto.request.CurrenciesCompareRequestDto;
import com.example.bm_project.dto.response.CurrencyCompareResponseDto;

public interface CurrenciesCompareService {
    CurrencyCompareResponseDto getCurrenciesCompareRate(CurrenciesCompareRequestDto currenciesCompareRequestDto);
}
