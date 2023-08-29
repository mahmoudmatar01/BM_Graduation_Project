package com.example.bm_project.controller;


import com.example.bm_project.models.CurrencyRate;
import com.example.bm_project.models.ResponseModel;
import com.example.bm_project.services.CurrencyExchangeRateService;
import com.example.bm_project.services.impl.CurrencyExchangeRateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        List<CurrencyRate>  response=baseCurrencyExChangeRateServices.getBaseCurrencyExchangeRate(baseCurrency);
        //return data response
        return new ResponseEntity<>(new ResponseModel(SuccessMessage,response), HttpStatus.OK);
    }
}
