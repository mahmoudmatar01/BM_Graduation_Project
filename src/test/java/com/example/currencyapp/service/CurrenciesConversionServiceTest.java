package com.example.currencyapp.service;


import com.example.currencyapp.exception.InvalidAmountException;
import com.example.currencyapp.exception.NotFoundCurrencyCodeException;
import com.example.currencyapp.logger.Logger;
import com.example.currencyapp.services.CurrenciesConversionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.currencyapp.constant.StringConstants.SuccessfulTest;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CurrenciesConversionServiceTest {
    private final Logger logger ;
    private final CurrenciesConversionService currenciesConversionService;

    @Autowired
    public CurrenciesConversionServiceTest(CurrenciesConversionService currenciesConversionService) {
        this.logger = Logger.getInstance();
        this.currenciesConversionService=currenciesConversionService;
    }

    @Test
    void currencyConversionBaseCurrencyInvalidTestCase() {
        assertThrows(NotFoundCurrencyCodeException.class, () -> {
            currenciesConversionService.getCurrenciesConversionRate("df","KWD","12.3");
            logger.logInfo(this.getClass(),"currencyConversionBaseCurrencyInvalidTestCase "+SuccessfulTest);
        });
    }
    @Test
    void currencyConversionAmountInvalidTestCase() {
        assertThrows(InvalidAmountException.class, () -> {
            currenciesConversionService.getCurrenciesConversionRate("JPY","KWD","-12.3");
            logger.logInfo(this.getClass(),"currencyConversionAmountInvalidTestCase "+SuccessfulTest);
        });
    }
    @Test
    void currencyConversionAmountInvalidSecondTestCase() {
        assertThrows(InvalidAmountException.class, () -> {
            currenciesConversionService.getCurrenciesConversionRate("JPY","KWD","fd");
            logger.logInfo(this.getClass(),"currencyConversionAmountInvalidSecondTestCase "+SuccessfulTest);
        });
    }
}
