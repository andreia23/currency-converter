package com.jaya.challenge.api.currency.converter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jaya.challenge.api.currency.converter.model.entity.Transaction;
import com.jaya.challenge.api.currency.converter.repository.TransactionRepository;

/**
 * @author andreia
 *
 */
public class TransactionService {
	
	private TransactionRepository transactionRepository;

	@Autowired
	public TransactionService(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	public List<Transaction> findALL() {
		return transactionRepository.findAll();
	}

}
