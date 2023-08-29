package com.example.bm_project.controller;

import com.example.bm_project.dto.request.CurrenciesCompareRequestDto;
import com.example.bm_project.dto.response.CurrencyCompareDto;
import com.example.bm_project.models.CurrencyCompareResponse;
import com.example.bm_project.models.ResponseModel;
import com.example.bm_project.services.CurrenciesCompareService;
import com.example.bm_project.services.impl.CurrenciesCompareServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.bm_project.constant.ApiConstant.MultiCurrencyConversion;
import static com.example.bm_project.constant.StringConstants.SuccessMessage;

@RestController
@RequestMapping(MultiCurrencyConversion)
@CrossOrigin(origins = "*", maxAge= 3600)

public class CurrencyCompareController {

    private final CurrenciesCompareService currenciesCompareService;

    @Autowired
    public CurrencyCompareController(CurrenciesCompareServiceImpl currenciesCompareService) {
        this.currenciesCompareService = currenciesCompareService;
    }


    @PostMapping("/currencies-compare")
    ResponseEntity<ResponseModel> CurrencyCompare(@RequestBody CurrenciesCompareRequestDto currenciesCompareRequestDto) {

        //get all data from service layer
        CurrencyCompareDto response=currenciesCompareService
                .getCurrenciesCompareRate(
                        currenciesCompareRequestDto
                );

        return new ResponseEntity<>(
                ResponseModel
                        .builder()
                        .status(SuccessMessage)
                        .data(response)
                .build(),
                HttpStatus.OK);
    }

}
