package com.example.currencyapp.controller;

import com.example.currencyapp.dto.request.CurrenciesCompareRequestDto;
import com.example.currencyapp.dto.response.CurrencyCompareDto;
import com.example.currencyapp.logger.Logger;
import com.example.currencyapp.models.ResponseModel;
import com.example.currencyapp.services.CurrenciesCompareService;
import com.example.currencyapp.services.impl.CurrenciesCompareServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.currencyapp.constant.ApiConstant.MultiCurrencyConversion;
import static com.example.currencyapp.constant.StringConstants.*;

@RestController
@RequestMapping(MultiCurrencyConversion)
@CrossOrigin(origins = "*", maxAge= 3600)

public class CurrencyCompareController {
    private Logger logger ;


    private final CurrenciesCompareService currenciesCompareService;

    @Autowired
    public CurrencyCompareController(CurrenciesCompareServiceImpl currenciesCompareService) {
        this.currenciesCompareService = currenciesCompareService;
        this.logger=logger.getInstance();

    }


    @PostMapping("/currencies-compare")
    ResponseEntity<ResponseModel> CurrencyCompare(@RequestBody CurrenciesCompareRequestDto currenciesCompareRequestDto) {

        //get all data from service layer
        CurrencyCompareDto response=currenciesCompareService
                .getCurrenciesCompareRate(
                        currenciesCompareRequestDto
                );
        logger.logInfo(this.getClass(),SuccessfulControllerResponse);


        return new ResponseEntity<>(
                ResponseModel
                        .builder()
                        .status(SuccessMessage)
                        .data(response)
                .build(),
                HttpStatus.OK);
    }

}
