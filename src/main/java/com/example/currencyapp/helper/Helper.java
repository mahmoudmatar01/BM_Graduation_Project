package com.example.currencyapp.helper;

import com.example.currencyapp.exception.InvalidAmountException;
import com.example.currencyapp.exception.NotFoundCurrencyCodeException;
import com.example.currencyapp.models.Currency;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.example.currencyapp.constant.ProjectConstants.currencyDtoList;
import static com.example.currencyapp.constant.StringConstants.CurrencyNotFountExceptionMessage;
import static com.example.currencyapp.constant.StringConstants.InvalidAmountValueException;

@Component
public class Helper {
    // singleton design patterns to use same object in memory every time I use Mapper class
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
        Optional<Currency> baseCurrencyDto = currencyDtoList.stream()
                .filter(currencyDto -> currencyDto.getCurrencyCode().equals(baseCurrencyCode))
                .findFirst();
        return baseCurrencyDto.isPresent();
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
