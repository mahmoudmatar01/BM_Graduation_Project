package com.example.currencyapp.services.impl;


import com.example.currencyapp.models.Currency;
import com.example.currencyapp.services.CurrenciesInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.currencyapp.constant.ProjectConstants.currencyDtoList;

//@CacheConfig(cacheNames = "currenciesCache")
@Service
public class CurrenciesInfoServicesImpl implements CurrenciesInfoService {

    @Override
    public List<Currency> getAllCurrenciesInfo() {
        return currencyDtoList;
    }
}
