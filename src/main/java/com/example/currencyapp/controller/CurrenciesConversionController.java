package com.example.currencyapp.controller;
import com.example.currencyapp.logger.Logger;
import com.example.currencyapp.models.ResponseModel;
import com.example.currencyapp.services.CurrenciesConversionService;
import com.example.currencyapp.services.impl.CurrenciesConversionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.currencyapp.constant.ApiConstant.CurrencyConversionUrl;
import static com.example.currencyapp.constant.StringConstants.*;


@RestController
@RequestMapping(CurrencyConversionUrl)
@CrossOrigin(origins = "*", maxAge= 3600)
public class CurrenciesConversionController {

    private final Logger logger ;
    private final CurrenciesConversionService currenciesConversionService;

    @Autowired
    public CurrenciesConversionController(CurrenciesConversionServiceImpl currenciesConversionService) {
        this.currenciesConversionService = currenciesConversionService;
        this.logger= Logger.getInstance();

    }


    @GetMapping("/currency-conversion/{baseCurrency}/{targetCurrency}/{amount}")
    ResponseEntity<?> getAllCurrencyCodes(@PathVariable  String baseCurrency, @PathVariable String targetCurrency, @PathVariable String amount){
        logger.logInfo(this.getClass(),SuccessfulControllerResponse);
        var response=ResponseModel.builder()
                .status(SuccessMessage)
                .data( currenciesConversionService
                        .getCurrenciesConversionRate(baseCurrency,targetCurrency,amount))
                .build();
        return ResponseEntity.ok(response);
    }
}
