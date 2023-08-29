package com.example.bm_project.client;


import com.example.bm_project.models.CurrencyCompareResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.example.bm_project.constant.ApiConstant.ClientAPIKEY;
import static com.example.bm_project.constant.ApiConstant.ClientBASEURL;

@FeignClient(value="feign-currency-compare",url = ClientBASEURL +"/"+ ClientAPIKEY)

public interface BaseCurrencyCompareClient {
    @GetMapping("/latest/{baseCurrencyCode}")
    CurrencyCompareResponse getBaseCurrencyExchangeRate(@PathVariable String baseCurrencyCode);
}
