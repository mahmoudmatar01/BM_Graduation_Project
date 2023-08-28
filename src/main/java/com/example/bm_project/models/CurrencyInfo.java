package com.example.bm_project.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyInfo {
    private String name;
    private String currencyCode;
    private String flagUrl;
}
