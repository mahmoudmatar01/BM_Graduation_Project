package com.example.bm_project.mapper;


import com.example.bm_project.dto.response.CurrenciesConversionDto;
import com.example.bm_project.dto.response.CurrencyCompareDto;
import com.example.bm_project.models.CurrenciesConversionResponse;
import com.example.bm_project.models.CurrencyCompareResponse;
import com.example.bm_project.models.CurrencyExchangeRateResponse;
import com.example.bm_project.models.CurrencyRate;

import java.util.List;

public interface IMapper {

    List<CurrencyRate> convertExchangeRateResponseToListCurrencyExchangeRateDto(CurrencyExchangeRateResponse response);
    CurrenciesConversionDto convertCurrenciesConversionResponseToCurrenciesConversionDto(CurrenciesConversionResponse response);

    CurrencyCompareDto convertCurrencyExchangeResponseToCurrencyCompareResponseDto(CurrencyCompareResponse currencyCompareResponseDto , double amount);
}
