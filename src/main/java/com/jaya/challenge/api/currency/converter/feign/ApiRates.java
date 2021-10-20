package com.jaya.challenge.api.currency.converter.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="ApiRates",url = "${feign.apirates.url}")
public interface ApiRates {

    @GetMapping
    ApiRateResponse getRates(@RequestParam String access_key);
}
