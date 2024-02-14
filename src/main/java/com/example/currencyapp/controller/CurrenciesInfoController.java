package com.example.currencyapp.controller;

import com.example.currencyapp.logger.Logger;
import com.example.currencyapp.models.ResponseModel;
import com.example.currencyapp.services.CurrenciesInfoService;
import com.example.currencyapp.services.impl.CurrenciesInfoServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.currencyapp.constant.ApiConstant.CurrenciesInfoUrl;
import static com.example.currencyapp.constant.StringConstants.*;

@RestController
@RequestMapping(CurrenciesInfoUrl)
@CrossOrigin(origins = "*", maxAge= 3600)
public class CurrenciesInfoController {
    private final Logger logger ;
    private  final CurrenciesInfoService currenciesInfoServices;

    @Autowired
    public CurrenciesInfoController(CurrenciesInfoServicesImpl currenciesInfoServices) {
        this.currenciesInfoServices = currenciesInfoServices;
        this.logger= Logger.getInstance();

    }

    @GetMapping("/currencies")
    ResponseEntity<?>getAllCurrencies(){
        logger.logInfo(this.getClass(),SuccessfulControllerResponse);
        var response =ResponseModel.builder()
                .status(SuccessMessage)
                .data(currenciesInfoServices.getAllCurrenciesInfo())
                .build();
        return  ResponseEntity.ok(response);
    }
}
