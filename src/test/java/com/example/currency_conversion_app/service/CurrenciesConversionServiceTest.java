package com.example.currency_conversion_app.service;


import com.example.currency_conversion_app.exception.InvalidAmountException;
import com.example.currency_conversion_app.exception.NotFoundCurrencyCodeException;
import com.example.currency_conversion_app.logger.Logger;
import com.example.currency_conversion_app.services.CurrenciesConversionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.currency_conversion_app.constant.StringConstants.SuccessfulTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CurrenciesConversionServiceTest {
    private Logger logger ;

    private CurrenciesConversionService currenciesConversionService;



    @Autowired
    public CurrenciesConversionServiceTest(CurrenciesConversionService currenciesConversionService) {
        this.logger = logger.getInstance();
        this.currenciesConversionService=currenciesConversionService;
    }



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
