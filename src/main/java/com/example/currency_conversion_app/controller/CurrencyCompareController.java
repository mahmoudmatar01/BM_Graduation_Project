package com.example.currency_conversion_app.controller;

import com.example.currency_conversion_app.dto.request.CurrenciesCompareRequestDto;
import com.example.currency_conversion_app.dto.response.CurrencyCompareDto;
import com.example.currency_conversion_app.logger.Logger;
import com.example.currency_conversion_app.models.ResponseModel;
import com.example.currency_conversion_app.services.CurrenciesCompareService;
import com.example.currency_conversion_app.services.impl.CurrenciesCompareServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.currency_conversion_app.constant.ApiConstant.MultiCurrencyConversion;
import static com.example.currency_conversion_app.constant.StringConstants.*;

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
