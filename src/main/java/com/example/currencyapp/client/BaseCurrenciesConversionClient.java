//package com.example.currencyapp.client;
//
//
//import com.example.currencyapp.models.CurrenciesConversionResponse;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import static com.example.currencyapp.constant.ApiConstant.ClientAPIKEY;
//import static com.example.currencyapp.constant.ApiConstant.ClientBASEURL;
//
//@FeignClient(value="feign-currencies-conversion",url = ClientBASEURL +"/"+ ClientAPIKEY)
//public interface BaseCurrenciesConversionClient {
//    @GetMapping("/pair/{baseCurrency}/{targetCurrency}/{amount}")
//    CurrenciesConversionResponse currenciesConversion(@PathVariable String baseCurrency, @PathVariable String targetCurrency, @PathVariable String amount);
//}
