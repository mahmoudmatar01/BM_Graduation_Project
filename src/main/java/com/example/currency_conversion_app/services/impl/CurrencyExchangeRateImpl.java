package com.example.currency_conversion_app.services.impl;
import com.example.currency_conversion_app.client.BaseCurrencyExchangeRateClient;
import com.example.currency_conversion_app.exception.NotFoundCurrencyCodeException;
import com.example.currency_conversion_app.helper.Helper;
import com.example.currency_conversion_app.logger.Logger;
import com.example.currency_conversion_app.mapper.IMapper;
import com.example.currency_conversion_app.mapper.Mapper;
import com.example.currency_conversion_app.models.CurrencyRate;
import com.example.currency_conversion_app.services.CurrencyExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.currency_conversion_app.constant.StringConstants.CurrencyNotFountExceptionMessage;
import static com.example.currency_conversion_app.constant.StringConstants.DataReceivedFromApiSuccessfully;

@CacheConfig(cacheNames = "exchangeCache")
@Service
public class CurrencyExchangeRateImpl implements CurrencyExchangeRateService {
    private Logger logger ;
    //Logger LOG =LoggerFactory.getLogger(CurrencyExchangeRateImpl.class);
    private final BaseCurrencyExchangeRateClient currencyExchangeRateClient;
    private final IMapper mapper;
    private Helper helper;

    @Autowired
    public CurrencyExchangeRateImpl(BaseCurrencyExchangeRateClient baseCurrencyExchangeRateRepo, Mapper mapper) {
        this.currencyExchangeRateClient = baseCurrencyExchangeRateRepo;
        this.mapper=mapper;
        this.helper = helper.getInstance();
        this.logger=logger.getInstance();
    }

    @Cacheable(value = "currenciesExchangeRateCache")
    @Override
    public List<CurrencyRate> getBaseCurrencyExchangeRate(String baseCurrency) {

        /* Check if base currency and target currencies are valid or not
             if it is not valid the project will throw not found currency exception  */

        if(!helper.currencyIsExist(baseCurrency.toUpperCase())){
            logger.logError(this.getClass(),CurrencyNotFountExceptionMessage);
            throw new NotFoundCurrencyCodeException(CurrencyNotFountExceptionMessage);
        }


        // receives data from client and map it and then return response data
        var response= currencyExchangeRateClient.getBaseCurrencyExchangeRate(baseCurrency.toUpperCase());
        logger.logInfo(this.getClass(),"Client"+DataReceivedFromApiSuccessfully+"from ExchangeRate API");
        return mapper.convertExchangeRateResponseToListCurrencyExchangeRateDto(response);
    }
}
