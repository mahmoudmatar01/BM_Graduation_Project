package com.example.bm_project.exception;

import com.example.bm_project.logger.LoggerSingleton;

public class NotFoundCurrencyCodeException extends GlobalException{
    public NotFoundCurrencyCodeException(String message) {
        super(message);
    }
}
