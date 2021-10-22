package com.jaya.challenge.api.currency.converter.service;

import com.jaya.challenge.api.currency.converter.model.dto.UserDTO;
import com.jaya.challenge.api.currency.converter.model.entity.User;
import com.jaya.challenge.api.currency.converter.model.request.UserRequest;
import com.jaya.challenge.api.currency.converter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author andreia
 */
@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public UserDTO saveUser(UserRequest userRequest) {
		User userEntity = userRequest.toModel();
		userEntity = userRepository.save(userEntity);
		return new UserDTO(userEntity);
	}

}
