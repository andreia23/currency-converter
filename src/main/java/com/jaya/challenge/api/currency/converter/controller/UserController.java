package com.jaya.challenge.api.currency.converter.controller;

import com.jaya.challenge.api.currency.converter.model.dto.UserDTO;
import com.jaya.challenge.api.currency.converter.model.request.UserRequest;
import com.jaya.challenge.api.currency.converter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author andreia
 *
 */
@RestController
public class UserController {

	private UserService userService;

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/v1/register-user", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserRequest userRequest) {
		UserDTO userDTO = userService.saveUser(userRequest);
		logger.info("Registering user " + userDTO.getUserName() + " " + userDTO.getUserLastName());
		return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
	}

}
