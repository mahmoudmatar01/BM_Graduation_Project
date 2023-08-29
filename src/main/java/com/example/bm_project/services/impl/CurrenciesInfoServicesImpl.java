package com.example.bm_project.services.impl;


import com.example.bm_project.logger.LoggerSingleton;
import com.example.bm_project.models.Currency;
import com.example.bm_project.services.CurrenciesInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.bm_project.constant.ProjectConstants.currencyDtoList;
import static com.example.bm_project.constant.StringConstants.DataReceivedFromApiSuccessfully;

//@CacheConfig(cacheNames = "currenciesCache")
@Service
public class CurrenciesInfoServicesImpl implements CurrenciesInfoService {
    LoggerSingleton logger = LoggerSingleton.getInstance();

    // return static currencies info list
//    @Cacheable(value = "currenciesInfoCache")
    @Override
    public List<Currency> getAllCurrenciesInfo() {
        logger.logInfo(this.getClass(),"Client"+ DataReceivedFromApiSuccessfully +"CurrencyInfo API");
        return currencyDtoList;
    }
}
