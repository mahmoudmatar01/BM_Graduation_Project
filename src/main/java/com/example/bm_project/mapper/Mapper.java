package com.example.bm_project.mapper;


import com.example.bm_project.dto.response.CurrenciesConversionResponseDto;
import com.example.bm_project.dto.response.CurrencyCompareResponseDto;
import com.example.bm_project.dto.response.CurrencyExchangeRateResponseDto;
import com.example.bm_project.models.CurrencyInfo;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.example.bm_project.constant.ProjectConstants.currencyDtoList;

@Component
public class Mapper implements IMapper{

    @Override
    public CurrencyExchangeRateResponseDto convertExchangeRateResponseToListCurrencyExchangeRateDto(CurrencyExchangeRateResponseDto response) {

        response.getConversionRates().entrySet()
                .removeIf(entry -> !currencyDtoList
                        .stream().map(CurrencyInfo::getCurrencyCode)
                        .toList()
                        .contains(entry.getKey()));
        return response;
    }


    @Override
    public CurrenciesConversionResponseDto convertCurrenciesConversionResponseToCurrenciesConversionDto(Map<String, Object> response) {
        CurrenciesConversionResponseDto currencyConversionDto= CurrenciesConversionResponseDto.builder()
                .conversionRate(String.valueOf(response.get("conversion_rate")))
                .baseCode(String.valueOf(response.get("base_code")))
                .conversionResult(String.valueOf(response.get("conversion_result")))
                .targetCode(String.valueOf(response.get("target_code")))
                .build();
        return currencyConversionDto;
    }



    // Currency Compare Response Mapper
    @Override
    public CurrencyCompareResponseDto convertCurrencyExchangeResponseToCurrencyCompareResponseDto(CurrencyCompareResponseDto currencyCompareResponseDto, double amount) {
        if (currencyCompareResponseDto.getConversionRates() != null) {
            for (Map.Entry<String, Double> entry : currencyCompareResponseDto.getConversionRates().entrySet()) {
                entry.setValue(entry.getValue() * amount);
            }
            currencyCompareResponseDto
                    .getConversionRates().entrySet()
                    .removeIf(entry -> !currencyDtoList
                    .stream().map(CurrencyInfo::getCurrencyCode)
                    .toList()
                    .contains(entry.getKey()));
        }
        return currencyCompareResponseDto;
    }


}
