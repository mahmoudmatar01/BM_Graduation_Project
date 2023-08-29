package com.example.bm_project.service;
import com.example.bm_project.dto.request.CurrenciesCompareRequestDto;
import com.example.bm_project.dto.response.CurrencyCompareDto;
import com.example.bm_project.models.CurrencyCompareResponse;
import com.example.bm_project.exception.InvalidAmountException;
import com.example.bm_project.exception.NotFoundCurrencyCodeException;
import com.example.bm_project.services.CurrenciesCompareService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class CurrenciesCompareServiceTest {

    @Autowired
    CurrenciesCompareService currenciesCompareService;

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
        });
    }

}
