package com.example.bm_project.services.impl;


import com.example.bm_project.client.BaseCurrenciesConversionClient;
import com.example.bm_project.dto.response.CurrenciesConversionResponseDto;
import com.example.bm_project.exception.NotFoundCurrencyCodeException;
import com.example.bm_project.helper.Helper;
import com.example.bm_project.mapper.IMapper;
import com.example.bm_project.mapper.Mapper;
import com.example.bm_project.services.CurrenciesConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Optional;

import static com.example.bm_project.constant.StringConstants.CurrencyNotFountExceptionMessage;


@CacheConfig(cacheNames = "CurrenciesConversionCaching")
@Service
public class CurrenciesConversionServiceImpl implements CurrenciesConversionService {

    private  final BaseCurrenciesConversionClient currenciesConversionClient;
    private final IMapper mapper;
    private Helper helper;

    @Autowired
    public CurrenciesConversionServiceImpl(BaseCurrenciesConversionClient currenciesConversionRepo, Mapper mapper) {
        this.currenciesConversionClient = currenciesConversionRepo;
        this.mapper=mapper;
        this.helper = helper.getInstance();
    }

    @Cacheable(value = "CurrenciesConversionCache")
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
        //to handle decimal format to have only three digits after the decimal point
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        // receives data from data client and map it and then return response data
        Optional<Map> response= currenciesConversionClient.currenciesConversion(baseCurrency.toUpperCase(), targetCurrency.toUpperCase(), amount);

        //handle and update conversion rate and conversion result to have only three digits after the decimal point
        CurrenciesConversionResponseDto currenciesConversionResponse=  mapper.convertCurrenciesConversionResponseToCurrenciesConversionDto(response.get());
        currenciesConversionResponse.setConversionRate(decimalFormat.format(Double.parseDouble(currenciesConversionResponse.getConversionRate())));
        currenciesConversionResponse.setConversionResult(decimalFormat.format(Double.parseDouble(currenciesConversionResponse.getConversionResult())));

                return currenciesConversionResponse;
    }
}
