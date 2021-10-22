package com.jaya.challenge.api.currency.converter.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaya.challenge.api.currency.converter.model.request.UserRequest;
import com.jaya.challenge.api.currency.converter.repository.UserRepository;

/**
 * @author andreia
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void mustRegisterUser() throws Exception {
		UserRequest userRequest = new UserRequest("Andréia", "Lima");
		mockMvc.perform(MockMvcRequestBuilders.post("/v1/register-user").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(userRequest)).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
		assertTrue(userRepository.existsById(1L));
	}

	@Test
	public void mustNotRegisterUser() throws Exception {
		UserRequest userRequest = new UserRequest(null, "Lima");
		mockMvc.perform(MockMvcRequestBuilders.post("/v1/register-user").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(userRequest)).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
		assertFalse(userRepository.existsById(1L));
	}
}
