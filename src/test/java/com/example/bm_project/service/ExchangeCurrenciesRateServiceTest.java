package com.example.bm_project.service;

import com.example.bm_project.dto.response.CurrencyExchangeRateResponseDto;
import com.example.bm_project.exception.NotFoundCurrencyCodeException;
import com.example.bm_project.services.CurrencyExchangeRateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static com.example.bm_project.constant.ProjectConstants.currencyDtoList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ExchangeCurrenciesRateServiceTest {

    @Autowired
    CurrencyExchangeRateService currencyExchangeRateService;

    @Test
    void currencyExchangeRateSuccessTestCase(){
        CurrencyExchangeRateResponseDto response= currencyExchangeRateService.getBaseCurrencyExchangeRate("USD");
        Map<String,Double> map=new HashMap<>();
        map.put("USD", 1.0);
        map.put("AED", 3.6725);
        map.put("BHD", 0.376);
        map.put("EUR", 0.9263);
        map.put("GBP", 0.7946);
        map.put("JPY", 146.2421);
        map.put("KWD", 0.3084);
        map.put("OMR", 0.3845);
        map.put("QAR", 3.64);
        map.put("SAR", 3.75);
        map.put( "EGP", 30.8789);


        CurrencyExchangeRateResponseDto currencyExchangeRateResponseDto=CurrencyExchangeRateResponseDto
                .builder()
                .conversionRates(map)
                .build();
        assertEquals(currencyExchangeRateResponseDto.getConversionRates().keySet(),response.getConversionRates().keySet());
    }


    @Test
    void currencyExchangeRateBaseCurrencyInvalidTest() {
        assertThrows(NotFoundCurrencyCodeException.class, () -> {
            currencyExchangeRateService.getBaseCurrencyExchangeRate("asd");
        });
    }

}
