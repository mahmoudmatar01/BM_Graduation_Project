package com.example.bm_project.services.impl;
import com.example.bm_project.client.BaseCurrencyExchangeRateClient;
import com.example.bm_project.exception.NotFoundCurrencyCodeException;
import com.example.bm_project.helper.Helper;
import com.example.bm_project.mapper.IMapper;
import com.example.bm_project.mapper.Mapper;
import com.example.bm_project.models.CurrencyRate;
import com.example.bm_project.services.CurrencyExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.bm_project.constant.StringConstants.CurrencyNotFountExceptionMessage;

@CacheConfig(cacheNames = "exchangeCache")
@Service
public class CurrencyExchangeRateImpl implements CurrencyExchangeRateService {

    private final BaseCurrencyExchangeRateClient currencyExchangeRateClient;
    private final IMapper mapper;
    private Helper helper;

    @Autowired
    public CurrencyExchangeRateImpl(BaseCurrencyExchangeRateClient baseCurrencyExchangeRateRepo, Mapper mapper) {
        this.currencyExchangeRateClient = baseCurrencyExchangeRateRepo;
        this.mapper=mapper;
        this.helper = helper.getInstance();
    }

    @Cacheable(value = "currenciesExchangeRateCache", key = "#baseCurrency")
    @Override
    public List<CurrencyRate> getBaseCurrencyExchangeRate(String baseCurrency) {

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
