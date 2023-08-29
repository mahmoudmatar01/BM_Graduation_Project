package com.example.currency_conversion_app.services.impl;


import com.example.currency_conversion_app.logger.Logger;
import com.example.currency_conversion_app.models.Currency;
import com.example.currency_conversion_app.services.CurrenciesInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.currency_conversion_app.constant.ProjectConstants.currencyDtoList;
import static com.example.currency_conversion_app.constant.StringConstants.DataReceivedFromApiSuccessfully;

//@CacheConfig(cacheNames = "currenciesCache")
@Service
public class CurrenciesInfoServicesImpl implements CurrenciesInfoService {
    private Logger logger ;

    @Autowired
    public CurrenciesInfoServicesImpl(){
        this.logger= logger.getInstance();
    }

    // return static currencies info list
//    @Cacheable(value = "currenciesInfoCache")
    @Override
    public List<Currency> getAllCurrenciesInfo() {
        logger.logInfo(this.getClass(),"Client"+ DataReceivedFromApiSuccessfully +"CurrencyInfo API");
        return currencyDtoList;
    }
}
