package com.example.currency_conversion_app.exception;

public class NotFoundCurrencyCodeException extends GlobalException{
    public NotFoundCurrencyCodeException(String message) {
        super(message);
    }
}
