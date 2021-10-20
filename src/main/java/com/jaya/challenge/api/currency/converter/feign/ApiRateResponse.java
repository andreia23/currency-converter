package com.jaya.challenge.api.currency.converter.feign;

import com.jaya.challenge.api.currency.converter.model.request.Currency;

import java.math.BigDecimal;
import java.util.Map;

public class ApiRateResponse {

    private Currency base;

    private Map<Currency, BigDecimal> rates;

    public Currency getBase() {
        return base;
    }

    public Map<Currency, BigDecimal> getRates() {
        return rates;
    }
}
