package com.example.bm_project.service;


import com.example.bm_project.dto.response.CurrenciesConversionResponseDto;
import com.example.bm_project.exception.InvalidAmountException;
import com.example.bm_project.exception.NotFoundCurrencyCodeException;
import com.example.bm_project.services.CurrenciesConversionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CurrenciesConversionServiceTest {


    @Autowired
    private CurrenciesConversionService currenciesConversionService;

    @Test
    void currencyExchangeRateSuccessTestCase() {
        CurrenciesConversionResponseDto currenciesConversionRate= currenciesConversionService.getCurrenciesConversionRate("JPY","KWD","12.3");
        CurrenciesConversionResponseDto currenciesConversionResponseDto=CurrenciesConversionResponseDto
                .builder()
                .conversionRate("0.00211")
                .baseCode("JPY")
                .targetCode("KWD")
                .conversionResult("0.025953")
                .build();
        assertEquals(currenciesConversionResponseDto, currenciesConversionRate);

    }

    @Test
    void currencyConversionBaseCurrencyInvalidTestCase() {
        assertThrows(NotFoundCurrencyCodeException.class, () -> {
            currenciesConversionService.getCurrenciesConversionRate("df","KWD","12.3");
        });
    }
    @Test
    void currencyConversionAmountInvalidTestCase() {
        assertThrows(InvalidAmountException.class, () -> {
            currenciesConversionService.getCurrenciesConversionRate("JPY","KWD","-12.3");
        });
    }
    @Test
    void currencyConversionAmountInvalidSecondTestCase() {
        assertThrows(InvalidAmountException.class, () -> {
            currenciesConversionService.getCurrenciesConversionRate("JPY","KWD","fd");
        });
    }
}
