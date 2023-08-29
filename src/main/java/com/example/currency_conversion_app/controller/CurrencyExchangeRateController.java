package com.example.currency_conversion_app.controller;


import com.example.currency_conversion_app.logger.Logger;
import com.example.currency_conversion_app.models.CurrencyRate;
import com.example.currency_conversion_app.models.ResponseModel;
import com.example.currency_conversion_app.services.CurrencyExchangeRateService;
import com.example.currency_conversion_app.services.impl.CurrencyExchangeRateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.currency_conversion_app.constant.ApiConstant.ExchangeRateUrl;
import static com.example.currency_conversion_app.constant.StringConstants.*;

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
