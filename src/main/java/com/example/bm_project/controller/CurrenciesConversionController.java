package com.example.bm_project.controller;
import com.example.bm_project.models.ResponseModel;
import com.example.bm_project.services.CurrenciesConversionService;
import com.example.bm_project.services.impl.CurrenciesConversionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.bm_project.constant.ApiConstant.CurrencyConversionUrl;
import static com.example.bm_project.constant.StringConstants.SuccessMessage;


@RestController
@RequestMapping(CurrencyConversionUrl)

public class CurrenciesConversionController {


    private final CurrenciesConversionService currenciesConversionService;

    @Autowired
    public CurrenciesConversionController(CurrenciesConversionServiceImpl currenciesConversionService) {
        this.currenciesConversionService = currenciesConversionService;
    }


    @GetMapping("/currency-conversion/{baseCurrency}/{targetCurrency}/{amount}")
    ResponseEntity<ResponseModel> getAllCurrencyCodes(@PathVariable  String baseCurrency, @PathVariable String targetCurrency, @PathVariable String amount){
        return new ResponseEntity<>(new ResponseModel(
                SuccessMessage,
                currenciesConversionService
                        .getCurrenciesConversionRate(baseCurrency,targetCurrency,amount)
        ), HttpStatus.OK);
    }
}
