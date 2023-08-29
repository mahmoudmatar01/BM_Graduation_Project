package com.example.bm_project.service;


import com.example.bm_project.logger.LoggerSingleton;
import com.example.bm_project.models.Currency;
import com.example.bm_project.services.CurrenciesInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.bm_project.constant.ProjectConstants.currencyDtoList;
import static com.example.bm_project.constant.StringConstants.SuccessfulTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

@SpringBootTest
public class CurrenciesInfoServiceTest {
    LoggerSingleton logger = LoggerSingleton.getInstance();


    @Autowired
    CurrenciesInfoService currenciesInfoService;


    @Test
    void getCurrencies(){
        List<Currency>currencyInfos=currenciesInfoService.getAllCurrenciesInfo();
        assertEquals(currencyDtoList,currencyInfos);
        logger.logInfo(this.getClass(),"getCurrencies "+SuccessfulTest);

    }
}
