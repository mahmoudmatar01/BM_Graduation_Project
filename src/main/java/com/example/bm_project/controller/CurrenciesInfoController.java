package com.example.bm_project.controller;

import com.example.bm_project.models.ResponseModel;
import com.example.bm_project.services.CurrenciesInfoService;
import com.example.bm_project.services.impl.CurrenciesInfoServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.bm_project.constant.ApiConstant.CurrenciesInfoUrl;
import static com.example.bm_project.constant.StringConstants.SuccessMessage;

@RestController
@RequestMapping(CurrenciesInfoUrl)
@CrossOrigin(origins = "*", maxAge= 3600)

public class CurrenciesInfoController {

    private  final CurrenciesInfoService currenciesInfoServices;

    @Autowired
    public CurrenciesInfoController(CurrenciesInfoServicesImpl currenciesInfoServices) {
        this.currenciesInfoServices = currenciesInfoServices;
    }

    @GetMapping("/currencies")
    ResponseEntity<ResponseModel>getAllCurrencies(){
        return  new ResponseEntity<>(new ResponseModel(
                SuccessMessage,
                currenciesInfoServices.getAllCurrenciesInfo()
        ), HttpStatus.OK);
    }
}
