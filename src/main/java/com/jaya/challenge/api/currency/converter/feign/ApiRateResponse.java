package com.jaya.challenge.api.currency.converter.feign;

import java.math.BigDecimal;
import java.util.Map;

import com.jaya.challenge.api.currency.converter.commons.Currency;

/**
 * @author andreia
 *
 */
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
