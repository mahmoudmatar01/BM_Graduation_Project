package com.example.bm_project.client;

import com.example.bm_project.dto.response.CurrencyExchangeRateResponseDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.example.bm_project.constant.ApiConstant.ClientAPIKEY;
import static com.example.bm_project.constant.ApiConstant.ClientBASEURL;


@FeignClient(value="feign-exchange-rate",url = ClientBASEURL +"/"+ ClientAPIKEY)
public interface BaseCurrencyExchangeRateClient {
   // @Cacheable(cacheNames = "exchangeRateCache", key = "exchangeCacheKey")

    @GetMapping("/latest/{baseCurrencyCode}")
    CurrencyExchangeRateResponseDto getBaseCurrencyExchangeRate(@PathVariable String baseCurrencyCode);
}
