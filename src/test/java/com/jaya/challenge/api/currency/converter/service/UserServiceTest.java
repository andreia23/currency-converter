package com.jaya.challenge.api.currency.converter.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jaya.challenge.api.currency.converter.CurrencyConverterApplication;
import com.jaya.challenge.api.currency.converter.model.dto.UserDTO;
import com.jaya.challenge.api.currency.converter.model.request.UserRequest;

/**
 * @author andreia
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CurrencyConverterApplication.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;

	private UserRequest userRequest;

	@Before
	public void setUp() throws Exception {
		UserRequest userRequest = new UserRequest("Andreia", "Lima");
		this.userRequest = userRequest;
	}

	@Test
	public void saveUser() {
		UserDTO userDTO = userService.saveUser(userRequest);
		assertEquals(userRequest.getUserName(), userDTO.getUserName());
		assertEquals(userRequest.getUserLastName(), userDTO.getUserLastName());
	}
}
