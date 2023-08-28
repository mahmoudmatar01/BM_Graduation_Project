package com.example.bm_project.services.impl;


import com.example.bm_project.client.BaseCurrencyCompareClient;
import com.example.bm_project.dto.request.CurrenciesCompareRequestDto;
import com.example.bm_project.dto.response.CurrencyCompareResponseDto;
import com.example.bm_project.exception.NotFoundCurrencyCodeException;
import com.example.bm_project.helper.Helper;
import com.example.bm_project.helper.IHelper;
import com.example.bm_project.mapper.IMapper;
import com.example.bm_project.mapper.Mapper;
import com.example.bm_project.services.CurrenciesCompareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.bm_project.constant.StringConstants.CurrencyNotFountExceptionMessage;

@Service
public class CurrenciesCompareServiceImpl implements CurrenciesCompareService {

    private  final BaseCurrencyCompareClient currencyCompareClient;
    private final IMapper mapper;
    private final IHelper helper;


    @Autowired
    public CurrenciesCompareServiceImpl(BaseCurrencyCompareClient currencyCompareClient, Mapper mapper, Helper helper) {
        this.currencyCompareClient = currencyCompareClient;
        this.mapper=mapper;
        this.helper = helper;
    }

    @Override
    public CurrencyCompareResponseDto getCurrenciesCompareRate(CurrenciesCompareRequestDto currenciesCompareRequestDto) {


        /* Check if base currency and target currencies are valid or not
           if it is not valid the project will throw not found currency exception and
           if amount is positive and numeric or not if an amount is not valid
                 the project will throw an invalid amount exception
         */
        if(!helper.currencyIsExist(currenciesCompareRequestDto.getFirstTargetCode().toUpperCase())||!helper.currencyIsExist(currenciesCompareRequestDto.getSecondTargetCode().toUpperCase())){
            throw new NotFoundCurrencyCodeException(CurrencyNotFountExceptionMessage);
        }
        helper.throwException(currenciesCompareRequestDto.getBaseCode(),String.valueOf(currenciesCompareRequestDto.getAmount()));

        // if everything is valid will return response model with response data
        return mapper
                .convertCurrencyExchangeResponseToCurrencyCompareResponseDto(
                        currencyCompareClient
                                .getBaseCurrencyExchangeRate(
                                        currenciesCompareRequestDto
                                                .getBaseCode()
                                                .toUpperCase()
                                ),
                        currenciesCompareRequestDto
                                .getAmount()
                );
    }
}
