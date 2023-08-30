package com.example.currencyapp.controller;


import com.example.currencyapp.logger.Logger;
import com.example.currencyapp.models.CurrencyRate;
import com.example.currencyapp.models.ResponseModel;
import com.example.currencyapp.services.CurrencyExchangeRateService;
import com.example.currencyapp.services.impl.CurrencyExchangeRateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.currencyapp.constant.ApiConstant.ExchangeRateUrl;
import static com.example.currencyapp.constant.StringConstants.*;

@RestController
@RequestMapping(ExchangeRateUrl)
@CrossOrigin(origins = "*", maxAge= 3600)

public class CurrencyExchangeRateController {
    private Logger logger ;

    private final CurrencyExchangeRateService baseCurrencyExChangeRateServices;

    @Autowired
    public CurrencyExchangeRateController(CurrencyExchangeRateImpl baseCurrencyExChangeRateServices) {
        this.baseCurrencyExChangeRateServices = baseCurrencyExChangeRateServices;
        this.logger=logger.getInstance();

    }

    @GetMapping("/currency-exchangeRate/{baseCurrency}")
    ResponseEntity<ResponseModel> getBaseCurrencyExchangeRate(@PathVariable String baseCurrency){

        // get all data from service layer
        List<CurrencyRate>  response=baseCurrencyExChangeRateServices.getBaseCurrencyExchangeRate(baseCurrency);
        logger.logInfo(this.getClass(),SuccessfulControllerResponse);
        //return data response
        return new ResponseEntity<>(new ResponseModel(SuccessMessage,response), HttpStatus.OK);


    }
}
