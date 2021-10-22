package com.jaya.challenge.api.currency.converter.repository;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jaya.challenge.api.currency.converter.CurrencyConverterApplication;
import com.jaya.challenge.api.currency.converter.model.entity.User;

/**
 * @author andreia
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CurrencyConverterApplication.class)
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	private Optional<User> user;

	@Before
	public void setUp() throws Exception {
		User user = userRepository.save(new User("Andréia", "Berto"));
		this.user = Optional.of(user);
	}

	@Test
	public void findById() {
		Optional<User> userResponse = userRepository.findById(user.get().getIdUser());
		assertEquals(userResponse.get().getUserName(), user.get().getUserName());
		assertEquals(userResponse.get().getUserLastName(), user.get().getUserLastName());
	}
}
