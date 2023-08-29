package com.example.currency_conversion_app.mapper;


import com.example.currency_conversion_app.dto.response.CurrenciesConversionDto;
import com.example.currency_conversion_app.dto.response.CurrencyCompareDto;
import com.example.currency_conversion_app.models.CurrenciesConversionResponse;
import com.example.currency_conversion_app.models.CurrencyCompareResponse;
import com.example.currency_conversion_app.models.CurrencyExchangeRateResponse;
import com.example.currency_conversion_app.models.CurrencyRate;

import java.util.List;

public interface IMapper {

    List<CurrencyRate> convertExchangeRateResponseToListCurrencyExchangeRateDto(CurrencyExchangeRateResponse response);
    CurrenciesConversionDto convertCurrenciesConversionResponseToCurrenciesConversionDto(CurrenciesConversionResponse response);

    CurrencyCompareDto convertCurrencyExchangeResponseToCurrencyCompareResponseDto(CurrencyCompareResponse currencyCompareResponseDto , double amount);
}
