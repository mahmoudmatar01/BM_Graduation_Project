package com.example.bm_project.helper;

public interface IHelper {
    boolean isNumericAndPositive(String str);
    boolean currencyIsExist(String baseCurrencyCode);
    void throwException(String baseCurrency,String amount);
}
