//package com.example.currencyapp.client;
//
//import com.example.currencyapp.models.CurrencyExchangeRateResponse;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import static com.example.currencyapp.constant.ApiConstant.ClientAPIKEY;
//import static com.example.currencyapp.constant.ApiConstant.ClientBASEURL;
//
//
//@FeignClient(value="feign-exchange-rate",url = ClientBASEURL +"/"+ ClientAPIKEY)
//public interface BaseCurrencyExchangeRateClient {
//    @GetMapping("/latest/{baseCurrencyCode}")
//    CurrencyExchangeRateResponse getBaseCurrencyExchangeRate(@PathVariable String baseCurrencyCode);
//
//}
