package com.example.bm_project.helper;

import com.example.bm_project.exception.InvalidAmountException;
import com.example.bm_project.exception.NotFoundCurrencyCodeException;
import com.example.bm_project.models.CurrencyInfo;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.example.bm_project.constant.ProjectConstants.currencyDtoList;
import static com.example.bm_project.constant.StringConstants.CurrencyNotFountExceptionMessage;
import static com.example.bm_project.constant.StringConstants.InvalidAmountValueException;

@Component
public class Helper implements IHelper{
    @Override
    public boolean isNumericAndPositive(String str) {
        try {
            double numericValue = Double.parseDouble(str);
            return numericValue >= 0;
        } catch (NumberFormatException e) {
            return false; // Not a numeric value
        }
    }

    @Override
    public boolean currencyIsExist(String baseCurrencyCode) {
        Optional<CurrencyInfo> baseCurrencyDto = currencyDtoList.stream()
                .filter(currencyDto -> currencyDto.getCurrencyCode().equals(baseCurrencyCode))
                .findFirst();
        if(baseCurrencyDto.isPresent()){
            return true;
        }
        return false;
    }

    @Override
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
