package com.example.currency_conversion_app.service;


import com.example.currency_conversion_app.logger.Logger;
import com.example.currency_conversion_app.models.Currency;
import com.example.currency_conversion_app.services.CurrenciesInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.currency_conversion_app.constant.ProjectConstants.currencyDtoList;
import static com.example.currency_conversion_app.constant.StringConstants.SuccessfulTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

@SpringBootTest
public class CurrenciesInfoServiceTest {
    private Logger logger ;

    private CurrenciesInfoService currenciesInfoService;



    @Autowired
    public CurrenciesInfoServiceTest(CurrenciesInfoService currenciesInfoService) {
        this.logger = logger.getInstance();
        this.currenciesInfoService=currenciesInfoService;
    }





    @Test
    void getCurrencies(){
        List<Currency>currencyInfos=currenciesInfoService.getAllCurrenciesInfo();
        assertEquals(currencyDtoList,currencyInfos);
        logger.logInfo(this.getClass(),"getCurrencies "+SuccessfulTest);

    }
}
