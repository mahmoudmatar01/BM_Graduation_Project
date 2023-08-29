package com.example.currency_conversion_app.controller;

import com.example.currency_conversion_app.logger.Logger;
import com.example.currency_conversion_app.models.ResponseModel;
import com.example.currency_conversion_app.services.CurrenciesInfoService;
import com.example.currency_conversion_app.services.impl.CurrenciesInfoServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.currency_conversion_app.constant.ApiConstant.CurrenciesInfoUrl;
import static com.example.currency_conversion_app.constant.StringConstants.*;

@RestController
@RequestMapping(CurrenciesInfoUrl)
@CrossOrigin(origins = "*", maxAge= 3600)

public class CurrenciesInfoController {
    private Logger logger ;
    private  final CurrenciesInfoService currenciesInfoServices;

    @Autowired
    public CurrenciesInfoController(CurrenciesInfoServicesImpl currenciesInfoServices) {
        this.currenciesInfoServices = currenciesInfoServices;
        this.logger=logger.getInstance();

    }

    @GetMapping("/currencies")
    ResponseEntity<ResponseModel>getAllCurrencies(){
        logger.logInfo(this.getClass(),SuccessfulControllerResponse);
        return  new ResponseEntity<>(new ResponseModel(
                SuccessMessage,
                currenciesInfoServices.getAllCurrenciesInfo()
        ), HttpStatus.OK);
    }
}
