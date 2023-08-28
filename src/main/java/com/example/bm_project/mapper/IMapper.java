package com.example.bm_project.mapper;


import com.example.bm_project.dto.response.CurrenciesConversionResponseDto;
import com.example.bm_project.dto.response.CurrencyCompareResponseDto;
import com.example.bm_project.dto.response.CurrencyExchangeRateResponseDto;

import java.util.Map;

public interface IMapper {

    CurrencyExchangeRateResponseDto convertExchangeRateResponseToListCurrencyExchangeRateDto(CurrencyExchangeRateResponseDto response);
    CurrenciesConversionResponseDto convertCurrenciesConversionResponseToCurrenciesConversionDto(Map<String,Object> response);

    CurrencyCompareResponseDto convertCurrencyExchangeResponseToCurrencyCompareResponseDto(CurrencyCompareResponseDto currencyCompareResponseDto , double amount);
}
