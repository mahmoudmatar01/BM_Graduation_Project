package com.example.bm_project.services.impl;


import com.example.bm_project.client.BaseCurrenciesConversionClient;
import com.example.bm_project.dto.response.CurrenciesConversionResponseDto;
import com.example.bm_project.exception.NotFoundCurrencyCodeException;
import com.example.bm_project.helper.Helper;
import com.example.bm_project.helper.IHelper;
import com.example.bm_project.mapper.IMapper;
import com.example.bm_project.mapper.Mapper;
import com.example.bm_project.services.CurrenciesConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

import static com.example.bm_project.constant.StringConstants.CurrencyNotFountExceptionMessage;


@Service
public class CurrenciesConversionServiceImpl implements CurrenciesConversionService {

    private  final BaseCurrenciesConversionClient currenciesConversionClient;
    private final IMapper mapper;
    private final IHelper helper;

    @Autowired
    public CurrenciesConversionServiceImpl(BaseCurrenciesConversionClient currenciesConversionRepo, Mapper mapper, Helper helper) {
        this.currenciesConversionClient = currenciesConversionRepo;
        this.mapper=mapper;
        this.helper = helper;
    }

    @Override
    public CurrenciesConversionResponseDto getCurrenciesConversionRate(String baseCurrency, String targetCurrency, String amount) {

                /* Check if base currency and target currencies are valid or not
        if it is not valid the project will throw not found currency exception  */
         /* Check if base currency and target currencies are valid or not
           if it is not valid the project will throw not found currency exception and
           if amount is positive and numeric or not if an amount is not valid
                 the project will throw an invalid amount exception
         */

        helper.throwException(baseCurrency,amount);
        if(!helper.currencyIsExist(targetCurrency.toUpperCase())){
            throw new NotFoundCurrencyCodeException(CurrencyNotFountExceptionMessage);
        }

        // receives data from data client and map it and then return response data
        Optional<Map> response= currenciesConversionClient.currenciesConversion(baseCurrency.toUpperCase(), targetCurrency.toUpperCase(), amount);
        CurrenciesConversionResponseDto currenciesConversionResponse=  mapper.convertCurrenciesConversionResponseToCurrenciesConversionDto(response.get());
                return currenciesConversionResponse;
    }
}
