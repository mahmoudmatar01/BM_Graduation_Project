package com.example.currency_conversion_app.client;


import com.example.currency_conversion_app.models.CurrenciesConversionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.example.currency_conversion_app.constant.ApiConstant.ClientAPIKEY;
import static com.example.currency_conversion_app.constant.ApiConstant.ClientBASEURL;

@FeignClient(value="feign-currencies-conversion",url = ClientBASEURL +"/"+ ClientAPIKEY)
public interface BaseCurrenciesConversionClient {
    @GetMapping("/pair/{baseCurrency}/{targetCurrency}/{amount}")
    CurrenciesConversionResponse currenciesConversion(@PathVariable String baseCurrency, @PathVariable String targetCurrency, @PathVariable String amount);
}
