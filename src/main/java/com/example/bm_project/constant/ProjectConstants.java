package com.example.bm_project.constant;


import com.example.bm_project.enums.CurrenciesFlag;
import com.example.bm_project.models.Currency;
import lombok.Data;

import java.util.List;

@Data
public class ProjectConstants {
    public static final String BASE_FLAG_URL="https://wise.com/public-resources/assets/flags/rectangle/";
    public static final List<Currency> currencyDtoList= List.of(
            Currency
                    .builder()
                    .currencyCode("EGP")
                    .name("Egyptian Pound")
                    .flagUrl(BASE_FLAG_URL+CurrenciesFlag.egp+".png")
            .build(),
            Currency
                    .builder()
                    .currencyCode("USD")
                    .name("US Dollar")
                    .flagUrl(BASE_FLAG_URL+ CurrenciesFlag.usd+".png")
                    .build(),
            Currency
                    .builder()
                    .currencyCode("JPY")
                    .name("Japan Yen")
                    .flagUrl(BASE_FLAG_URL+CurrenciesFlag.jpy+".png")
                    .build(),
            Currency
                    .builder()
                    .currencyCode("KWD")
                    .name("Kuwait Dinar")
                    .flagUrl(BASE_FLAG_URL+CurrenciesFlag.kwd+".png")
                    .build(),
            Currency
                    .builder()
                    .currencyCode("OMR")
                    .name("Oman Riyal")
                    .flagUrl(BASE_FLAG_URL+CurrenciesFlag.omr+".png")
                    .build(),
            Currency
                    .builder()
                    .currencyCode("QAR")
                    .name("QATARI Riyal")
                    .flagUrl(BASE_FLAG_URL+CurrenciesFlag.qar+".png")
                    .build(),
            Currency
                    .builder()
                    .currencyCode("SAR")
                    .name("Saudi Riyal")
                    .flagUrl(BASE_FLAG_URL+CurrenciesFlag.sar+".png")
                    .build(),
            Currency
                    .builder()
                    .currencyCode("BHD")
                    .name("Bahrain Dinar")
                    .flagUrl(BASE_FLAG_URL+CurrenciesFlag.bhd+".png")
                    .build(),
            Currency
                    .builder()
                    .currencyCode("AED")
                    .name("UAE DIRHAM")
                    .flagUrl(BASE_FLAG_URL+CurrenciesFlag.aed+".png")
                    .build(),
            Currency
                    .builder()
                    .currencyCode("GBP")
                    .name("Sterling Pound")
                    .flagUrl(BASE_FLAG_URL+CurrenciesFlag.gbp+".png")
                    .build(),
            Currency
                    .builder()
                    .currencyCode("EGP")
                    .name("Egyptian Pound")
                    .flagUrl(BASE_FLAG_URL+CurrenciesFlag.eur+".png")
                    .build()
    );

}
