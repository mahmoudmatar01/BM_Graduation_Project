package com.example.currencyapp.controller;

import com.example.currencyapp.dto.request.CurrenciesCompareRequestDto;
import com.example.currencyapp.logger.Logger;
import com.example.currencyapp.models.ResponseModel;
import com.example.currencyapp.services.CurrenciesCompareService;
import com.example.currencyapp.services.impl.CurrenciesCompareServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.currencyapp.constant.ApiConstant.MultiCurrencyConversion;
import static com.example.currencyapp.constant.StringConstants.*;

@RestController
@RequestMapping(MultiCurrencyConversion)
@CrossOrigin(origins = "*", maxAge= 3600)

public class CurrencyCompareController {
    private final Logger logger ;
    private final CurrenciesCompareService currenciesCompareService;

    @Autowired
    public CurrencyCompareController(CurrenciesCompareServiceImpl currenciesCompareService) {
        this.currenciesCompareService = currenciesCompareService;
        this.logger= Logger.getInstance();

    }


    @PostMapping("/currencies-compare")
    ResponseEntity<?> CurrencyCompare(@RequestBody CurrenciesCompareRequestDto currenciesCompareRequestDto) {

        //get all data from service layer
        logger.logInfo(this.getClass(),SuccessfulControllerResponse);
        var response=ResponseModel
                .builder()
                .status(SuccessMessage)
                .data(currenciesCompareService.getCurrenciesCompareRate(currenciesCompareRequestDto))
                .build();
        return ResponseEntity.ok(response);
    }

}
