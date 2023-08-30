package com.example.currencyapp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ErrorResponse {
    private String status;
    private String errorCode;
    private String message;

}
