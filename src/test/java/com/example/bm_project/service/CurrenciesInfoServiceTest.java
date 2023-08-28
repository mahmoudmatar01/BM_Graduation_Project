package com.example.bm_project.service;


import com.example.bm_project.models.CurrencyInfo;
import com.example.bm_project.services.CurrenciesInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.bm_project.constant.ProjectConstants.currencyDtoList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

@SpringBootTest
public class CurrenciesInfoServiceTest {


    @Autowired
    CurrenciesInfoService currenciesInfoService;


    @Test
    void getCurrencies(){
        List<CurrencyInfo>currencyInfos=currenciesInfoService.getAllCurrenciesInfo();
        assertEquals(currencyDtoList,currencyInfos);

    }
}
