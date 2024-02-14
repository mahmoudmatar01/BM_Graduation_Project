package com.example.currencyapp.enums;


import lombok.Getter;

import static com.example.currencyapp.constant.StringConstants.*;

@Getter
public enum ErrorCodeEnum {
    InValidAmount("amount#2$$", InvalidAmountValueException),
    CurrencyNotFound("currency00#%**", CurrencyNotFountExceptionMessage),
    GlobalExceptionError("invalid&%44**", SomeThingInvalid);

    private final String key;
    private final String value;

    ErrorCodeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

}
