package com.jaya.challenge.api.currency.converter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaya.challenge.api.currency.converter.model.entity.Transaction;
import com.jaya.challenge.api.currency.converter.model.entity.User;
import com.jaya.challenge.api.currency.converter.repository.TransactionRepository;
import com.jaya.challenge.api.currency.converter.repository.UserRepository;

/**
 * @author andreia
 *
 */
@Service
public class TransactionService {

	private TransactionRepository transactionRepository;

	private UserRepository userRepository;

	@Autowired
	public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository) {
		this.transactionRepository = transactionRepository;
		this.userRepository = userRepository;
	}

	public List<Transaction> findALL() {
		return transactionRepository.findAll();
	}

	public List<Transaction> transactionsByUser(Integer idUser) {

		Optional<User> user = userRepository.findById(idUser);
		return transactionRepository.transactionsByUser(user);
	}

}
