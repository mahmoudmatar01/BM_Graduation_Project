package com.example.bm_project.constant;


import com.example.bm_project.enums.CurrenciesFlag;
import com.example.bm_project.models.CurrencyInfo;
import lombok.Data;

import java.util.List;

@Data
public class ProjectConstants {
    public static final String BASE_FLAG_URL="https://flagcdn.com/32x24/";
    public static final List<CurrencyInfo> currencyDtoList= List.of(
            CurrencyInfo
                    .builder()
                    .currencyCode("USD")
                    .name("US Dollar")
                    .flagUrl(BASE_FLAG_URL+ CurrenciesFlag.us+".png")
                    .build(),
            CurrencyInfo
                    .builder()
                    .currencyCode("JPY")
                    .name("Japan Yen")
                    .flagUrl(BASE_FLAG_URL+CurrenciesFlag.jp+".png")
                    .build(),
            CurrencyInfo
                    .builder()
                    .currencyCode("KWD")
                    .name("Kuwait Dinar")
                    .flagUrl(BASE_FLAG_URL+CurrenciesFlag.kw+".png")
                    .build(),
            CurrencyInfo
                    .builder()
                    .currencyCode("OMR")
                    .name("Oman Riyal")
                    .flagUrl(BASE_FLAG_URL+CurrenciesFlag.om+".png")
                    .build(),
            CurrencyInfo
                    .builder()
                    .currencyCode("QAR")
                    .name("QATARI Riyal")
                    .flagUrl(BASE_FLAG_URL+CurrenciesFlag.qa+".png")
                    .build(),
            CurrencyInfo
                    .builder()
                    .currencyCode("SAR")
                    .name("Saudi Riyal")
                    .flagUrl(BASE_FLAG_URL+CurrenciesFlag.sa+".png")
                    .build(),
            CurrencyInfo
                    .builder()
                    .currencyCode("BHD")
                    .name("Bahrain Dinar")
                    .flagUrl(BASE_FLAG_URL+CurrenciesFlag.bh+".png")
                    .build(),
            CurrencyInfo
                    .builder()
                    .currencyCode("AED")
                    .name("UAE DIRHAM")
                    .flagUrl(BASE_FLAG_URL+CurrenciesFlag.ae+".png")
                    .build(),
            CurrencyInfo
                    .builder()
                    .currencyCode("GBP")
                    .name("Sterling Pound")
                    .flagUrl(BASE_FLAG_URL+CurrenciesFlag.gb+".png")
                    .build(),
            CurrencyInfo
                    .builder()
                    .currencyCode("EUR")
                    .name("EURO")
                    .flagUrl(BASE_FLAG_URL+CurrenciesFlag.eu+".png")
                    .build()
    );

}
