package com.example.currencyapp.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Currency {
    private String name;
    private String currencyCode;
    private String flagUrl;
}
