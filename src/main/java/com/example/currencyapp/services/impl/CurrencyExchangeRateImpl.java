package com.example.currencyapp.services.impl;
import com.example.currencyapp.client.BaseClient;
import com.example.currencyapp.exception.NotFoundCurrencyCodeException;
import com.example.currencyapp.helper.Helper;
import com.example.currencyapp.mapper.IMapper;
import com.example.currencyapp.mapper.Mapper;
import com.example.currencyapp.models.CurrencyRate;
import com.example.currencyapp.services.CurrencyExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.currencyapp.constant.StringConstants.CurrencyNotFountExceptionMessage;

@CacheConfig(cacheNames = "exchangeCache")
@Service
public class CurrencyExchangeRateImpl implements CurrencyExchangeRateService {
    //Logger LOG =LoggerFactory.getLogger(CurrencyExchangeRateImpl.class);
    private final BaseClient currencyExchangeRateClient;
    private final IMapper mapper;
    private Helper helper;

    @Autowired
    public CurrencyExchangeRateImpl(BaseClient baseCurrencyExchangeRateRepo, Mapper mapper) {
        this.currencyExchangeRateClient = baseCurrencyExchangeRateRepo;
        this.mapper=mapper;
        this.helper = helper.getInstance();
    }

    @Cacheable(value = "currenciesExchangeRateCache")
//    @CachePut(value ="currenciesExchangeRateCache" )
    @Override
    public List<CurrencyRate> getBaseCurrencyExchangeRate(String baseCurrency) {

        /* Check if base currency and target currencies are valid or not
             if it is not valid the project will throw not found currency exception  */

        if(!helper.currencyIsExist(baseCurrency.toUpperCase())){
            throw new NotFoundCurrencyCodeException(CurrencyNotFountExceptionMessage);
        }


        // receives data from client and map it and then return response data
        var response= currencyExchangeRateClient.baseCurrencyExchangeRate(baseCurrency.toUpperCase());
        return mapper.convertExchangeRateResponseToListCurrencyExchangeRateDto(response);
    }
}
