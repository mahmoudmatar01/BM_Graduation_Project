package com.example.bm_project.exception;

import com.example.bm_project.logger.LoggerSingleton;

public class GlobalException extends RuntimeException {
    public GlobalException(String message){
        super(message);
    }
}
