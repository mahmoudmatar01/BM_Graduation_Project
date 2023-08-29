package com.example.bm_project.exception;

import com.example.bm_project.logger.LoggerSingleton;

public class InvalidAmountException extends GlobalException{

    public InvalidAmountException(String message) {
        super(message);
    }
}
