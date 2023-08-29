package com.example.bm_project.service;

import com.example.bm_project.exception.NotFoundCurrencyCodeException;
import com.example.bm_project.logger.Logger;
import com.example.bm_project.models.CurrencyRate;
import com.example.bm_project.services.CurrenciesInfoService;
import com.example.bm_project.services.CurrencyExchangeRateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.bm_project.constant.StringConstants.SuccessfulTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ExchangeCurrenciesRateServiceTest {
    private Logger logger ;

    private CurrencyExchangeRateService currencyExchangeRateService;



    @Autowired
    public ExchangeCurrenciesRateServiceTest(CurrencyExchangeRateService currencyExchangeRateService) {
        this.logger = logger.getInstance();
        this.currencyExchangeRateService=currencyExchangeRateService;
    }


    @Test
    void currencyExchangeRateSuccessTestCase(){
        List<CurrencyRate> response= currencyExchangeRateService.getBaseCurrencyExchangeRate("USD");
        List<CurrencyRate>currencyRateList=List.of(
                CurrencyRate
                        .builder()
                        .rate(1.0)
                        .code("USD")
                        .build(),
                CurrencyRate
                        .builder()
                        .rate(3.6725)
                        .code("AED")
                        .build(),
                CurrencyRate
                        .builder()
                        .rate(0.376)
                        .code("BHD")
                        .build(),
                CurrencyRate
                        .builder()
                        .rate(30.8789)
                        .code("EGP")
                        .build(),
                CurrencyRate
                        .builder()
                        .rate(0.9263)
                        .code("EUR")
                        .build(),
                CurrencyRate
                        .builder()
                        .rate(0.7946)
                        .code("GBP")
                        .build(),
                CurrencyRate
                        .builder()
                        .rate(146.2421)
                        .code("JPY")
                        .build(),
                CurrencyRate
                        .builder()
                        .rate(0.3084)
                        .code("KWD")
                        .build(),
                CurrencyRate
                        .builder()
                        .rate(0.3845)
                        .code("OMR")
                        .build(),
                CurrencyRate
                        .builder()
                        .rate(3.64)
                        .code("QAR")
                        .build(),
                CurrencyRate
                        .builder()
                        .rate(3.75)
                        .code("SAR")
                        .build()

        );

        assertEquals(currencyRateList.stream().map(currencyRate -> currencyRate.getCode()).toList(),response.stream().map(currencyRate -> currencyRate.getCode()).toList());
        logger.logInfo(this.getClass(),"currencyExchangeRateSuccessTestCase "+SuccessfulTest);
    }


    @Test
    void currencyExchangeRateBaseCurrencyInvalidTest() {
        assertThrows(NotFoundCurrencyCodeException.class, () -> {
            currencyExchangeRateService.getBaseCurrencyExchangeRate("asd");
            logger.logInfo(this.getClass(),"currencyExchangeRateBaseCurrencyInvalidTest "+SuccessfulTest);
        });
    }

}
