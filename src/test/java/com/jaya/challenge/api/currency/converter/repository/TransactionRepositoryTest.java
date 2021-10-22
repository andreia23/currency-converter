package com.jaya.challenge.api.currency.converter.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jaya.challenge.api.currency.converter.CurrencyConverterApplication;
import com.jaya.challenge.api.currency.converter.model.entity.Transaction;
import com.jaya.challenge.api.currency.converter.model.entity.User;

/**
 * @author andreia
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CurrencyConverterApplication.class)
public class TransactionRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	private Optional<User> user;

	@Before
	public void setUp() throws Exception {
		User user = userRepository.save(new User("Andréia", "Berto"));
		this.user = Optional.of(user);
	}

	@Test
	public void transactionsByUser() {
		List<Transaction> list = transactionRepository.transactionsByUser(user.get());
		assertEquals(0, list.size());

	}
}
