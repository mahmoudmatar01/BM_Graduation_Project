package com.example.currencyapp.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrenciesCompareRequestDto {
    private String baseCode;
    private String firstTargetCode;
    private String secondTargetCode;
    private double amount;
}
