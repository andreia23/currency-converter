package com.jaya.challenge.api.currency.converter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jaya.challenge.api.currency.converter.CurrencyConverterApplication;
import com.jaya.challenge.api.currency.converter.commons.Currency;
import com.jaya.challenge.api.currency.converter.feign.ApiRateResponse;
import com.jaya.challenge.api.currency.converter.feign.ApiRates;
import com.jaya.challenge.api.currency.converter.model.dto.ConversionDTO;
import com.jaya.challenge.api.currency.converter.model.entity.User;
import com.jaya.challenge.api.currency.converter.model.request.ConversionRequest;
import com.jaya.challenge.api.currency.converter.repository.UserRepository;

/**
 * @author andreia
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CurrencyConverterApplication.class)
public class ConversionServiceTest {

	@Value("${feign.apirates.accessKey}")
	private String accessKey;

	@Autowired
	private ApiRates apiRates;

	@Autowired
	private ConversionService conversionService;

	@Autowired
	private UserRepository userRepository;

	private User user;

	private ConversionRequest conversionRequest;

	@Before
	public void setUp() throws Exception {
		User user = userRepository.save(new User("Andréia", "Berto"));
		ConversionRequest conversionRequest = new ConversionRequest(Currency.USD, new BigDecimal(80), Currency.BRL);
		this.user = user;
		this.conversionRequest = conversionRequest;
	}

	@Test
	public void convertCurrency() {
		ConversionDTO conversionDTO = conversionService.convertCurrency(user.getIdUser(), conversionRequest);
		assertEquals(user.getIdUser(), conversionDTO.getIdUser());
		assertEquals(conversionRequest.getSourceCurrency(), conversionDTO.getSourceCurrency());
		assertEquals(conversionRequest.getSourceValue(), conversionDTO.getSourceValue());
		assertEquals(conversionRequest.getDestinationCurrency(), conversionDTO.getDestinationCurrency());
	}

	@Test
	public void calculationToConvert() {
		ApiRateResponse apiRateResponse = apiRates.getRates(accessKey);
		BigDecimal rateSourceCurrency = apiRateResponse.getRates().get(conversionRequest.getSourceCurrency());
		BigDecimal rateDestinationCurrency = apiRateResponse.getRates().get(conversionRequest.getDestinationCurrency());
		BigDecimal convertedValue = conversionService.calculationToConvert(conversionRequest.getSourceValue(),
				rateSourceCurrency, rateDestinationCurrency);
		ConversionDTO conversionDTO = conversionService.convertCurrency(user.getIdUser(), conversionRequest);
		assertEquals(conversionDTO.getDestinationValue(), convertedValue);
	}
}
