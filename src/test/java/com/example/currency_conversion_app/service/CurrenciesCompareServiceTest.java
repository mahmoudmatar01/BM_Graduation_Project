package com.example.currency_conversion_app.service;
import com.example.currency_conversion_app.dto.request.CurrenciesCompareRequestDto;
import com.example.currency_conversion_app.dto.response.CurrencyCompareDto;
import com.example.currency_conversion_app.logger.Logger;
import com.example.currency_conversion_app.models.CurrencyCompareResponse;
import com.example.currency_conversion_app.exception.InvalidAmountException;
import com.example.currency_conversion_app.exception.NotFoundCurrencyCodeException;
import com.example.currency_conversion_app.services.CurrenciesCompareService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.currency_conversion_app.constant.StringConstants.SuccessfulTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class CurrenciesCompareServiceTest {
    private Logger logger ;
    private CurrenciesCompareService currenciesCompareService;


    @Autowired
    public CurrenciesCompareServiceTest(CurrenciesCompareService currenciesCompareService) {
        this.logger = logger.getInstance();
        this.currenciesCompareService=currenciesCompareService;
    }


    @Test
    void currencyCompareSuccessTestCase(){
        CurrenciesCompareRequestDto currenciesCompareRequestDto= CurrenciesCompareRequestDto
                .builder()
                .amount(10)
                .baseCode("AED")
                .firstTargetCode("GBP")
                .secondTargetCode("JPY")
                .build();
        CurrencyCompareDto responseDto= currenciesCompareService.getCurrenciesCompareRate(currenciesCompareRequestDto);

        Map<String,Double>map=new HashMap<>();
        map.put("firstTargetRate", 2.35876);
        map.put("secondTargetRate", 434.64949);
        CurrencyCompareResponse expectedResponse= CurrencyCompareResponse
                .builder()
                        .baseCode("AED")
                                .conversionRates(map).build();
        assertEquals(expectedResponse.getConversionRates().keySet(),responseDto.getConversionRates().keySet());
        logger.logInfo(this.getClass(),"currencyCompareSuccessTestCase "+SuccessfulTest);

    }

    @Test
    void currencyCompareAmountInvalidTestCase() {
        assertThrows(InvalidAmountException.class, () -> {
            CurrenciesCompareRequestDto currenciesCompareRequestDto=CurrenciesCompareRequestDto
                    .builder()
                    .amount(-10)
                    .baseCode("AED")
                    .firstTargetCode("GBP")
                    .secondTargetCode("JPY")
                    .build();
            currenciesCompareService.getCurrenciesCompareRate(currenciesCompareRequestDto);
            logger.logInfo(this.getClass(),"currencyCompareAmountInvalidTestCase "+SuccessfulTest);
        });
    }
    @Test
    void currencyCompareBaseCurrencyInvalidTestCase() {
        assertThrows(NotFoundCurrencyCodeException.class, () -> {
            CurrenciesCompareRequestDto currenciesCompareRequestDto=CurrenciesCompareRequestDto
                    .builder()
                    .amount(10)
                    .baseCode("dd")
                    .firstTargetCode("GBP")
                    .secondTargetCode("JPY")
                    .build();
            currenciesCompareService.getCurrenciesCompareRate(currenciesCompareRequestDto);
            logger.logInfo(this.getClass(),"currencyCompareBaseCurrencyInvalidTestCase "+SuccessfulTest);
        });
    }
    @Test
    void currencyCompareFirstTargetCurrencyInvalidTestCase() {
        assertThrows(NotFoundCurrencyCodeException.class, () -> {
            CurrenciesCompareRequestDto currenciesCompareRequestDto=CurrenciesCompareRequestDto
                    .builder()
                    .amount(10)
                    .baseCode("AED")
                    .firstTargetCode("dd")
                    .secondTargetCode("JPY")
                    .build();
            currenciesCompareService.getCurrenciesCompareRate(currenciesCompareRequestDto);
            logger.logInfo(this.getClass(),"currencyCompareFirstTargetCurrencyInvalidTestCase "+SuccessfulTest);
        });
    }
    @Test
    void currencyCompareSecondTargetCurrencyInvalidTestCase() {
        assertThrows(NotFoundCurrencyCodeException.class, () -> {
            CurrenciesCompareRequestDto currenciesCompareRequestDto=CurrenciesCompareRequestDto
                    .builder()
                    .amount(10)
                    .baseCode("AED")
                    .firstTargetCode("GBP")
                    .secondTargetCode("dd")
                    .build();
            currenciesCompareService.getCurrenciesCompareRate(currenciesCompareRequestDto);
            logger.logInfo(this.getClass(),"currencyCompareSecondTargetCurrencyInvalidTestCase "+SuccessfulTest);
        });
    }

}
