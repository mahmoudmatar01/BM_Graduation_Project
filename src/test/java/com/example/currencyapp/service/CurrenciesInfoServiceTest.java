package com.example.currencyapp.service;


import com.example.currencyapp.logger.Logger;
import com.example.currencyapp.models.Currency;
import com.example.currencyapp.services.CurrenciesInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.currencyapp.constant.ProjectConstants.currencyDtoList;
import static com.example.currencyapp.constant.StringConstants.SuccessfulTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

@SpringBootTest
public class CurrenciesInfoServiceTest {
    private final Logger logger ;
    private final CurrenciesInfoService currenciesInfoService;

    @Autowired
    public CurrenciesInfoServiceTest(CurrenciesInfoService currenciesInfoService) {
        this.logger = Logger.getInstance();
        this.currenciesInfoService=currenciesInfoService;
    }

    @Test
    void getCurrencies(){
        List<Currency>currencyInfos=currenciesInfoService.getAllCurrenciesInfo();
        assertEquals(currencyDtoList,currencyInfos);
        logger.logInfo(this.getClass(),"getCurrencies "+SuccessfulTest);
    }
}
