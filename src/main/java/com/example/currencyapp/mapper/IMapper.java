package com.example.currencyapp.mapper;


import com.example.currencyapp.dto.response.CurrenciesConversionDto;
import com.example.currencyapp.dto.response.CurrencyCompareDto;
import com.example.currencyapp.models.CurrenciesConversionResponse;
import com.example.currencyapp.models.CurrencyCompareResponse;
import com.example.currencyapp.models.CurrencyExchangeRateResponse;
import com.example.currencyapp.models.CurrencyRate;

import java.util.List;

public interface IMapper {

    List<CurrencyRate> convertExchangeRateResponseToListCurrencyExchangeRateDto(CurrencyExchangeRateResponse response);
    CurrenciesConversionDto convertCurrenciesConversionResponseToCurrenciesConversionDto(CurrenciesConversionResponse response);

    CurrencyCompareDto convertCurrencyExchangeResponseToCurrencyCompareResponseDto(CurrencyCompareResponse currencyCompareResponseDto , double amount);
}
