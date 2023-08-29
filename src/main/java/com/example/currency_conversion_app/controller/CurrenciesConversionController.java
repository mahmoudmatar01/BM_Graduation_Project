package com.example.currency_conversion_app.controller;
import com.example.currency_conversion_app.logger.Logger;
import com.example.currency_conversion_app.models.ResponseModel;
import com.example.currency_conversion_app.services.CurrenciesConversionService;
import com.example.currency_conversion_app.services.impl.CurrenciesConversionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.currency_conversion_app.constant.ApiConstant.CurrencyConversionUrl;
import static com.example.currency_conversion_app.constant.StringConstants.*;


@RestController
@RequestMapping(CurrencyConversionUrl)
@CrossOrigin(origins = "*", maxAge= 3600)
public class CurrenciesConversionController {

    private Logger logger ;
    private final CurrenciesConversionService currenciesConversionService;

    @Autowired
    public CurrenciesConversionController(CurrenciesConversionServiceImpl currenciesConversionService) {
        this.currenciesConversionService = currenciesConversionService;
        this.logger=logger.getInstance();

    }


    @GetMapping("/currency-conversion/{baseCurrency}/{targetCurrency}/{amount}")
    ResponseEntity<ResponseModel> getAllCurrencyCodes(@PathVariable  String baseCurrency, @PathVariable String targetCurrency, @PathVariable String amount){
        logger.logInfo(this.getClass(),SuccessfulControllerResponse);
        return new ResponseEntity<>(new ResponseModel(
                SuccessMessage,
                currenciesConversionService
                        .getCurrenciesConversionRate(baseCurrency,targetCurrency,amount)
        ), HttpStatus.OK);
    }
}
