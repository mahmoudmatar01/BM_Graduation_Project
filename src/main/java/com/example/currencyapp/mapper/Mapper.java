package com.example.currencyapp.mapper;


import com.example.currencyapp.dto.response.CurrenciesConversionDto;
import com.example.currencyapp.dto.response.CurrencyCompareDto;
import com.example.currencyapp.models.CurrenciesConversionResponse;
import com.example.currencyapp.models.CurrencyCompareResponse;
import com.example.currencyapp.models.CurrencyExchangeRateResponse;
import com.example.currencyapp.models.Currency;
import com.example.currencyapp.models.CurrencyRate;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.currencyapp.constant.ProjectConstants.currencyDtoList;

@Component
public class Mapper implements IMapper{

    @Override
    public List<CurrencyRate> convertExchangeRateResponseToListCurrencyExchangeRateDto(CurrencyExchangeRateResponse response) {

        response.getConversionRates().entrySet()
                .removeIf(entry -> !currencyDtoList
                        .stream().map(Currency::getCurrencyCode)
                        .toList()
                        .contains(entry.getKey()));
        // Map the response data from only object contain all keys and values to list<CurrencyRate> model
        List<CurrencyRate> currencyRates = new ArrayList<>();

        //to handle decimal format to have only two digits after the decimal point
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for (Map.Entry<String, Double> entry : response.getConversionRates().entrySet()) {
            CurrencyRate currencyRate = new CurrencyRate();
            currencyRate.setCode(entry.getKey());
            currencyRate.setRate(Double.parseDouble(decimalFormat.format(entry.getValue())));
            currencyRates.add(currencyRate);
        }
        return currencyRates;
    }


    @Override
    public CurrenciesConversionDto convertCurrenciesConversionResponseToCurrenciesConversionDto(CurrenciesConversionResponse response) {

        //to handle decimal format to have only three digits after the decimal point
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        response.setConversionResult(decimalFormat.format(Double.parseDouble(response.getConversionResult())));
        response.setConversionRate(decimalFormat.format(Double.parseDouble(response.getConversionRate())));

        //handle and update conversion rate and conversion result to have only three digits after the decimal point
        CurrenciesConversionDto currencyConversionDto= CurrenciesConversionDto.builder()
                .conversionRate(String.valueOf(response.getConversionRate()))
                .baseCode(String.valueOf(response.getBaseCode()))
                .conversionResult(String.valueOf(response.getConversionResult()))
                .targetCode(String.valueOf(response.getTargetCode()))
                .build();
        return currencyConversionDto;
    }



    // Currency Compare Response Mapper
    @Override
    public CurrencyCompareDto convertCurrencyExchangeResponseToCurrencyCompareResponseDto(CurrencyCompareResponse currencyCompareResponse, double amount) {
        if (currencyCompareResponse.getConversionRates() != null) {
            for (Map.Entry<String, Double> entry : currencyCompareResponse.getConversionRates().entrySet()) {
                entry.setValue(entry.getValue() * amount);
            }
            currencyCompareResponse
                    .getConversionRates().entrySet()
                    .removeIf(entry -> !currencyDtoList
                    .stream().map(Currency::getCurrencyCode)
                    .toList()
                    .contains(entry.getKey()));

        }
        return CurrencyCompareDto
                .builder()
                .conversionRates(currencyCompareResponse.getConversionRates())
                .baseCode(currencyCompareResponse.getBaseCode())
                .build();
    }


}
