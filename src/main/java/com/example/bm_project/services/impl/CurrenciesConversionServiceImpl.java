package com.example.bm_project.services.impl;


import com.example.bm_project.client.BaseCurrenciesConversionClient;
import com.example.bm_project.dto.response.CurrenciesConversionDto;
import com.example.bm_project.logger.LoggerSingleton;
import com.example.bm_project.models.CurrenciesConversionResponse;
import com.example.bm_project.exception.NotFoundCurrencyCodeException;
import com.example.bm_project.helper.Helper;
import com.example.bm_project.mapper.IMapper;
import com.example.bm_project.mapper.Mapper;
import com.example.bm_project.services.CurrenciesConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static com.example.bm_project.constant.StringConstants.*;


@CacheConfig(cacheNames = "CurrenciesConversionCaching")
@Service
public class CurrenciesConversionServiceImpl implements CurrenciesConversionService {

    LoggerSingleton logger = LoggerSingleton.getInstance();
    private  final BaseCurrenciesConversionClient currenciesConversionClient;
    private final IMapper mapper;
    private Helper helper;

    @Autowired
    public CurrenciesConversionServiceImpl(BaseCurrenciesConversionClient currenciesConversionRepo, Mapper mapper) {
        this.currenciesConversionClient = currenciesConversionRepo;
        this.mapper=mapper;
        this.helper = helper.getInstance();
        logger.logInfo(this.getClass(),"Client"+ DataReceivedFromApiSuccessfully +"CurrencyConversion API");
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
            logger.logError(this.getClass(),CurrencyNotFountExceptionMessage);
            throw new NotFoundCurrencyCodeException(CurrencyNotFountExceptionMessage);
        }
        // receives data from data client and map it and then return response data
        logger.logInfo(this.getClass(),DataConvertedToDTO);
        return mapper.convertCurrenciesConversionResponseToCurrenciesConversionDto(
                currenciesConversionClient.currenciesConversion(baseCurrency.toUpperCase(),
                        targetCurrency.toUpperCase(),
                        amount)
        );
    }
}
