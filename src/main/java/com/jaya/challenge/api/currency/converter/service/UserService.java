package com.jaya.challenge.api.currency.converter.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaya.challenge.api.currency.converter.model.dto.UserDTO;
import com.jaya.challenge.api.currency.converter.model.entity.User;
import com.jaya.challenge.api.currency.converter.repository.UserRepository;

/**
 * @author andreia
 *
 */
@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public UserDTO saveUser(UserDTO userDTO) {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		User userEntity = modelMapper.map(userDTO, User.class);

		userRepository.save(userEntity);

		UserDTO returnValue = modelMapper.map(userEntity, UserDTO.class);

		return returnValue;
	}

}
