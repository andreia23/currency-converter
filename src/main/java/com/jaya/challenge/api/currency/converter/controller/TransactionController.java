package com.jaya.challenge.api.currency.converter.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jaya.challenge.api.currency.converter.model.dto.TransactionDTO;
import com.jaya.challenge.api.currency.converter.model.entity.Transaction;
import com.jaya.challenge.api.currency.converter.service.TransactionService;

/**
 * @author andreia
 *
 */
@RestController
public class TransactionController {

	private TransactionService transactionService;

	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@RequestMapping(value = "/v1/all-transactions", method = RequestMethod.GET)
	public ResponseEntity<List<TransactionDTO>> findALL() {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		List<TransactionDTO> listDto = new ArrayList<TransactionDTO>();
		List<Transaction> list = transactionService.findALL();
		for (Transaction transaction : list) {

			TransactionDTO transactionDTO = modelMapper.map(transaction, TransactionDTO.class);
			listDto.add(transactionDTO);

		}
		return ResponseEntity.ok().body(listDto);

	}

	@RequestMapping(value = "/v1/transactions-by-user", method = RequestMethod.GET)
	public ResponseEntity<List<TransactionDTO>> transactionsByUser(@Valid @RequestParam Integer idUser) {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		List<TransactionDTO> listDto = new ArrayList<TransactionDTO>();
		List<Transaction> list = transactionService.transactionsByUser(idUser);
		for (Transaction transaction : list) {
			TransactionDTO transactionDTO = modelMapper.map(transaction, TransactionDTO.class);
			listDto.add(transactionDTO);
		}

		return ResponseEntity.ok().body(listDto);

	}

}
