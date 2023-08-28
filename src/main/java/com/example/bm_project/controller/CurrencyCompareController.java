package com.example.bm_project.controller;

import com.example.bm_project.dto.request.CurrenciesCompareRequestDto;
import com.example.bm_project.dto.response.CurrencyCompareResponseDto;
import com.example.bm_project.models.ResponseModel;
import com.example.bm_project.services.CurrenciesCompareService;
import com.example.bm_project.services.impl.CurrenciesCompareServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.bm_project.constant.ApiConstant.MultiCurrencyConversion;
import static com.example.bm_project.constant.StringConstants.SuccessMessage;

@RestController
@RequestMapping(MultiCurrencyConversion)
public class CurrencyCompareController {

    private final CurrenciesCompareService currenciesCompareService;

    @Autowired
    public CurrencyCompareController(CurrenciesCompareServiceImpl currenciesCompareService) {
        this.currenciesCompareService = currenciesCompareService;
    }


    @PostMapping("/currencies-compare")
    ResponseEntity<ResponseModel> CurrencyCompare(@RequestBody CurrenciesCompareRequestDto currenciesCompareRequestDto) {

        //save target currencies in list to filter response to only currencies that in tthis list
        List<String> targetList=List.of(
        currenciesCompareRequestDto.getFirstTargetCode(),
        currenciesCompareRequestDto.getSecondTargetCode()
        );

        //get all data from service layer
        CurrencyCompareResponseDto response=currenciesCompareService
                .getCurrenciesCompareRate(
                        currenciesCompareRequestDto
                );

        // map response data to filter it to have only target currencies
        Map<String, Double> filteredConversionRates = new HashMap<>();
        for (String currency : targetList) {
            if (response.getConversionRates().containsKey(currency)) {
                filteredConversionRates.put(currency, response.getConversionRates().get(currency));
            }
        }

        // update conversion rate object in my response to new filtered object
        response.setConversionRates(filteredConversionRates);

        // map new filtered object to change keys into static keys  (FirstTargetRate,SecondTargetRate)
        /*
        {
            "FirstTargetRate": 12.3,
            "SecondTargetRate":10.343,
        }
        */
        Map<String, Double> map = new HashMap<>();
        map.put("firstTargetRate",response.getConversionRates().get(currenciesCompareRequestDto.getFirstTargetCode()));
        map.put("secondTargetRate",response.getConversionRates().get(currenciesCompareRequestDto.getSecondTargetCode()));
        response.setConversionRates(map);
        return new ResponseEntity<>(
                ResponseModel
                        .builder()
                        .status(SuccessMessage)
                        .data(response)
                .build(),
                HttpStatus.OK);
    }

}
