package com.example.bm_project.service;


import com.example.bm_project.exception.InvalidAmountException;
import com.example.bm_project.exception.NotFoundCurrencyCodeException;
import com.example.bm_project.logger.LoggerSingleton;
import com.example.bm_project.services.CurrenciesConversionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.bm_project.constant.StringConstants.SuccessfulTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CurrenciesConversionServiceTest {
    LoggerSingleton logger = LoggerSingleton.getInstance();



    @Autowired
    private CurrenciesConversionService currenciesConversionService;

//    @Test
//    void currencyExchangeRateSuccessTestCase() {
//        CurrenciesConversionResponseDto currenciesConversionRate= currenciesConversionService.getCurrenciesConversionRate("JPY","KWD","12.3");
//        CurrenciesConversionResponseDto currenciesConversionResponseDto=CurrenciesConversionResponseDto
//                .builder()
//                .conversionRate("0.002108")
//                .baseCode("JPY")
//                .targetCode("KWD")
//                .conversionResult("0.0259284")
//                .build();
//        assertEquals(currenciesConversionResponseDto, currenciesConversionRate);
//
//    }

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
