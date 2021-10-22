package com.jaya.challenge.api.currency.converter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jaya.challenge.api.currency.converter.CurrencyConverterApplication;
import com.jaya.challenge.api.currency.converter.commons.Currency;
import com.jaya.challenge.api.currency.converter.model.entity.Transaction;
import com.jaya.challenge.api.currency.converter.model.entity.User;
import com.jaya.challenge.api.currency.converter.model.request.ConversionRequest;
import com.jaya.challenge.api.currency.converter.repository.UserRepository;

/**
 * @author andreia
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CurrencyConverterApplication.class)
public class TransactionServiceTest {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ConversionService conversionService;

	@Autowired
	private TransactionService transactionService;

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
	public void findAll() {
		conversionService.convertCurrency(user.getIdUser(), conversionRequest);
		List<Transaction> list = transactionService.findAll();
		assertEquals(2, list.size());

	}

	@Test
	public void transactionsByUser() {
		conversionService.convertCurrency(user.getIdUser(), conversionRequest);
		List<Transaction> list = transactionService.findAll();
		assertEquals(user.getIdUser(), list.get(0).getUser().getIdUser());

	}
}
