package com.example.bm_project.service;
import com.example.bm_project.dto.request.CurrenciesCompareRequestDto;
import com.example.bm_project.dto.response.CurrencyCompareResponseDto;
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
        CurrencyCompareResponseDto responseDto= currenciesCompareService.getCurrenciesCompareRate(currenciesCompareRequestDto);
        Map<String,Double> map =new HashMap<>();
        map.put("AED",10.0);
        map.put("BHD",1.024);
        map.put("EUR",2.522);
        map.put("GBP",2.164);
        map.put("JPY",398.20799999999997);
        map.put("KWD",0.8399);
        map.put("OMR",1.047);
        map.put("QAR",9.911999999999999);
        map.put("SAR",10.210999999999999);
        map.put("USD",2.723);
        map.put("EGP", 100.8789);
        assertEquals(map.keySet(),responseDto.getConversionRates().keySet());
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
