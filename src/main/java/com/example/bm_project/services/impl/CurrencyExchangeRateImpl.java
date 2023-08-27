package com.example.bm_project.services.impl;


import com.example.bm_project.client.BaseCurrencyExchangeRateClient;
import com.example.bm_project.exception.NotFoundCurrencyCodeException;
import com.example.bm_project.helper.IHelper;
import com.example.bm_project.helper.Helper;
import com.example.bm_project.mapper.IMapper;
import com.example.bm_project.mapper.Mapper;
import com.example.bm_project.services.CurrencyExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.bm_project.dto.response.CurrencyExchangeRateResponseDto;

import static com.example.bm_project.constant.StringConstants.CurrencyNotFountExceptionMessage;

@Service
public class CurrencyExchangeRateImpl implements CurrencyExchangeRateService {

    private final BaseCurrencyExchangeRateClient currencyExchangeRateClient;
    private final IMapper mapper;
    private final IHelper helper;

    @Autowired
    public CurrencyExchangeRateImpl(BaseCurrencyExchangeRateClient baseCurrencyExchangeRateRepo, Mapper mapper, Helper helper) {
        this.currencyExchangeRateClient = baseCurrencyExchangeRateRepo;
        this.mapper=mapper;
        this.helper = helper;
    }

    @Override
    //@Cacheable(cacheNames = "exchangeRateCache", key = "#baseCurrencyCode")
    public CurrencyExchangeRateResponseDto getBaseCurrencyExchangeRate(String baseCurrency) {

        /* Check if base currency and target currencies are valid or not
             if it is not valid the project will throw not found currency exception  */

        if(!helper.currencyIsExist(baseCurrency.toUpperCase())){
            throw new NotFoundCurrencyCodeException(CurrencyNotFountExceptionMessage);
        }

        // receives data from client and map it and then return response data
        var response= currencyExchangeRateClient.getBaseCurrencyExchangeRate(baseCurrency.toUpperCase());
        return mapper.convertExchangeRateResponseToListCurrencyExchangeRateDto(response);
    }
}
