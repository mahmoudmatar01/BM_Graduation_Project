package com.example.currencyapp.client;

import com.example.currencyapp.models.CurrenciesConversionResponse;
import com.example.currencyapp.models.CurrencyCompareResponse;
import com.example.currencyapp.models.CurrencyExchangeRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.example.currencyapp.constant.ApiConstant.ClientAPIKEY;
import static com.example.currencyapp.constant.ApiConstant.ClientBASEURL;

@FeignClient(value="feign-currencies",url = ClientBASEURL +"/"+ ClientAPIKEY)
public interface BaseClient {

    @GetMapping("/pair/{baseCurrency}/{targetCurrency}/{amount}")
    CurrenciesConversionResponse baseCurrenciesConversion(@PathVariable String baseCurrency, @PathVariable String targetCurrency, @PathVariable String amount);

    @GetMapping("/latest/{baseCurrencyCode}")
    CurrencyCompareResponse baseCurrencyCompare(@PathVariable String baseCurrencyCode);

    @GetMapping("/latest/{baseCurrencyCode}")
    CurrencyExchangeRateResponse baseCurrencyExchangeRate(@PathVariable String baseCurrencyCode);
}
