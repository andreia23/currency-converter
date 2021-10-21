package com.jaya.challenge.api.currency.converter.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jaya.challenge.api.currency.converter.model.dto.TransactionDTO;
import com.jaya.challenge.api.currency.converter.model.entity.Transaction;
import com.jaya.challenge.api.currency.converter.service.TransactionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author andreia
 *
 */
@Api(value = "Transaction")
@RestController
public class TransactionController {

	private TransactionService transactionService;

	private Logger logger = LoggerFactory.getLogger(TransactionController.class);

	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@ApiOperation(value = "Get all transactions")
	@GetMapping(value = "/v1/all-transactions")
	public ResponseEntity<List<TransactionDTO>> findAll() {
		logger.info("Listing all transactions");
		List<TransactionDTO> listDto = new ArrayList<TransactionDTO>();
		List<Transaction> list = transactionService.findAll();
		for (Transaction transaction : list) {
			listDto.add(new TransactionDTO(transaction));
		}
		return ResponseEntity.ok().body(listDto);

	}

	@ApiOperation(value = "Get all transactions from a user via id")
	@GetMapping(value = "/v1/transactions-by-user")
	public ResponseEntity<List<TransactionDTO>> transactionsByUser(@Valid @RequestParam Long idUser) {
		logger.info("Searching transactions from user " + idUser);
		List<TransactionDTO> listDto = new ArrayList<TransactionDTO>();
		List<Transaction> list = transactionService.transactionsByUser(idUser);
		for (Transaction transaction : list) {
			listDto.add(new TransactionDTO(transaction));
		}
		return ResponseEntity.ok().body(listDto);

	}

}
