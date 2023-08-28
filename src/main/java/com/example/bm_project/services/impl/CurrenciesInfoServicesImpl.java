package com.example.bm_project.services.impl;


import com.example.bm_project.models.CurrencyInfo;
import com.example.bm_project.services.CurrenciesInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.bm_project.constant.ProjectConstants.currencyDtoList;

@Service
public class CurrenciesInfoServicesImpl implements CurrenciesInfoService {



    // return static currencies info list
    @Override
    public List<CurrencyInfo> getAllCurrenciesInfo() {
        return currencyDtoList;
    }
}
