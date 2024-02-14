package com.example.currencyapp.services.impl;


import com.example.currencyapp.client.BaseClient;
import com.example.currencyapp.dto.response.CurrenciesConversionDto;
import com.example.currencyapp.exception.NotFoundCurrencyCodeException;
import com.example.currencyapp.helper.Helper;
import com.example.currencyapp.mapper.IMapper;
import com.example.currencyapp.mapper.Mapper;
import com.example.currencyapp.services.CurrenciesConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static com.example.currencyapp.constant.StringConstants.*;


@CacheConfig(cacheNames = "CurrenciesConversionCaching")
@Service
public class CurrenciesConversionServiceImpl implements CurrenciesConversionService {

    private  final BaseClient currenciesConversionClient;
    private final IMapper mapper;
    private final Helper helper;

    @Autowired
    public CurrenciesConversionServiceImpl(BaseClient currenciesConversionRepo, Mapper mapper) {
        this.currenciesConversionClient = currenciesConversionRepo;
        this.mapper=mapper;
        this.helper = Helper.getInstance();
    }

    @Cacheable(value = "CurrenciesConversionCache")
    @Override
    public CurrenciesConversionDto getCurrenciesConversionRate(String baseCurrency, String targetCurrency, String amount) {
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
        return mapper.convertCurrenciesConversionResponseToCurrenciesConversionDto(
                currenciesConversionClient.baseCurrenciesConversion(baseCurrency.toUpperCase(),
                        targetCurrency.toUpperCase(),
                        amount)
        );
    }
}
