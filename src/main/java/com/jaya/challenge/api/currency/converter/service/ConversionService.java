package com.jaya.challenge.api.currency.converter.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jaya.challenge.api.currency.converter.commons.Currency;
import com.jaya.challenge.api.currency.converter.exception.UserNotFoundException;
import com.jaya.challenge.api.currency.converter.feign.ApiRateResponse;
import com.jaya.challenge.api.currency.converter.feign.ApiRates;
import com.jaya.challenge.api.currency.converter.model.dto.ConversionDTO;
import com.jaya.challenge.api.currency.converter.model.entity.Transaction;
import com.jaya.challenge.api.currency.converter.model.entity.User;
import com.jaya.challenge.api.currency.converter.model.request.ConversionRequest;
import com.jaya.challenge.api.currency.converter.repository.TransactionRepository;
import com.jaya.challenge.api.currency.converter.repository.UserRepository;

/**
 * @author andreia
 *
 */
@Service
public class ConversionService {

	@Value("${feign.apirates.accessKey}")
	private String accessKey;

	private ApiRates apiRates;

	private TransactionRepository transactionRepository;

	private UserRepository userRepository;

	@Autowired
	public ConversionService(ApiRates apiRates, TransactionRepository transactionRepository,
			UserRepository userRepository) {
		this.apiRates = apiRates;
		this.transactionRepository = transactionRepository;
		this.userRepository = userRepository;
	}

	/**
	 * @param idUser
	 * @param conversionRequest
	 * @return
	 */
	public ConversionDTO convertCurrency(Long idUser, ConversionRequest conversionRequest) {

		User user = userRepository.findById(idUser).orElseThrow(() -> new UserNotFoundException("User not found"));

		Currency sourceCurrency = conversionRequest.getSourceCurrency();
		Currency destinationCurrency = conversionRequest.getDestinationCurrency();
		BigDecimal sourceValue = conversionRequest.getSourceValue();

		ApiRateResponse apiRateResponse = apiRates.getRates(accessKey);
		BigDecimal rateSourceCurrency = apiRateResponse.getRates().get(sourceCurrency);
		BigDecimal rateDestinationCurrency = apiRateResponse.getRates().get(destinationCurrency);
		BigDecimal finalValue = calculationToConvert(sourceValue, rateSourceCurrency, rateDestinationCurrency);

		Transaction transaction = new Transaction(user, sourceCurrency, sourceValue, destinationCurrency,
				rateDestinationCurrency);
		transaction = transactionRepository.save(transaction);

		return new ConversionDTO(transaction.getIdTransaction(), idUser, sourceCurrency, sourceValue,
				destinationCurrency, finalValue, rateDestinationCurrency);
	}

	/**
	 * @param sourceValue
	 * @param rateSourceCurrency
	 * @param rateDestinationCurrency
	 * @return
	 */
	public BigDecimal calculationToConvert(BigDecimal sourceValue, BigDecimal rateSourceCurrency,
			BigDecimal rateDestinationCurrency) {
		return sourceValue.divide(rateSourceCurrency, 4, RoundingMode.HALF_UP).multiply(rateDestinationCurrency,
				new MathContext(4, RoundingMode.HALF_UP));
	}
}
