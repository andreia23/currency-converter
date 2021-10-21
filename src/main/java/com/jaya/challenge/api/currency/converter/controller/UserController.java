package com.jaya.challenge.api.currency.converter.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jaya.challenge.api.currency.converter.model.dto.UserDTO;
import com.jaya.challenge.api.currency.converter.model.request.UserRequest;
import com.jaya.challenge.api.currency.converter.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author andreia
 *
 */
@Api(value="User")
@RestController
public class UserController {

	private UserService userService;

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@ApiOperation(value = "Register a user with first name and last name")
	@PostMapping(value = "/v1/register-user")
	public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserRequest userRequest) {
		UserDTO userDTO = userService.saveUser(userRequest);
		logger.info("Registering user " + userDTO.getUserName() + " " + userDTO.getUserLastName());
		return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
	}

}
