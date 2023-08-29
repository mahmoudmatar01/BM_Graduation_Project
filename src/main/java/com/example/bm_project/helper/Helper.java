package com.example.bm_project.helper;

import com.example.bm_project.exception.InvalidAmountException;
import com.example.bm_project.exception.NotFoundCurrencyCodeException;
import com.example.bm_project.mapper.Mapper;
import com.example.bm_project.models.CurrencyInfo;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.example.bm_project.constant.ProjectConstants.currencyDtoList;
import static com.example.bm_project.constant.StringConstants.CurrencyNotFountExceptionMessage;
import static com.example.bm_project.constant.StringConstants.InvalidAmountValueException;

@Component
public class Helper {

    // singleton design patterns to use same object in memory every time i use Mapper class
    private Helper(){}

    public static Helper getInstance(){

        // check if there is an instance in memory or not
        if(helper==null){
            helper=new Helper();
        }
        return helper;
    }

    private static Helper helper=null;


    public boolean isNumericAndPositive(String str) {
        try {
            double numericValue = Double.parseDouble(str);
            return numericValue >= 0;
        } catch (NumberFormatException e) {
            return false; // Not a numeric value
        }
    }

    public boolean currencyIsExist(String baseCurrencyCode) {
        Optional<CurrencyInfo> baseCurrencyDto = currencyDtoList.stream()
                .filter(currencyDto -> currencyDto.getCurrencyCode().equals(baseCurrencyCode))
                .findFirst();
        if(baseCurrencyDto.isPresent()){
            return true;
        }
        return false;
    }

    public void throwException(String baseCurrency,String amount) {
        if(!currencyIsExist(baseCurrency.toUpperCase())){
            throw new NotFoundCurrencyCodeException(CurrencyNotFountExceptionMessage);
        }

              /* Check if amount is positive and numeric or not if an amount is not valid
                 the project will throw an invalid amount exception  */
        if(!isNumericAndPositive(String.valueOf(amount))){
            throw new InvalidAmountException(InvalidAmountValueException);
        }
    }
}
