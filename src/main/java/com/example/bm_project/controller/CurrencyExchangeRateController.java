package com.example.bm_project.controller;


import com.example.bm_project.dto.response.CurrencyExchangeRateResponseDto;
import com.example.bm_project.models.CurrencyRate;
import com.example.bm_project.models.ResponseModel;
import com.example.bm_project.services.CurrencyExchangeRateService;
import com.example.bm_project.services.impl.CurrencyExchangeRateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.bm_project.constant.ApiConstant.ExchangeRateUrl;
import static com.example.bm_project.constant.StringConstants.SuccessMessage;

@RestController
@RequestMapping(ExchangeRateUrl)
@CrossOrigin(origins = "*", maxAge= 3600)

public class CurrencyExchangeRateController {

    private final CurrencyExchangeRateService baseCurrencyExChangeRateServices;

    @Autowired
    public CurrencyExchangeRateController(CurrencyExchangeRateImpl baseCurrencyExChangeRateServices) {
        this.baseCurrencyExChangeRateServices = baseCurrencyExChangeRateServices;
    }

    @GetMapping("/currency-exchangeRate/{baseCurrency}")
    ResponseEntity<ResponseModel> getBaseCurrencyExchangeRate(@PathVariable String baseCurrency){

        // get all data from service layer
        CurrencyExchangeRateResponseDto response=baseCurrencyExChangeRateServices.getBaseCurrencyExchangeRate(baseCurrency);

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

        //return data response
        return new ResponseEntity<>(new ResponseModel(SuccessMessage,currencyRates), HttpStatus.OK);
    }
}
