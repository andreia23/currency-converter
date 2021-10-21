package com.jaya.challenge.api.currency.converter.service;

import com.jaya.challenge.api.currency.converter.exception.UserNotFoundException;
import com.jaya.challenge.api.currency.converter.model.entity.Transaction;
import com.jaya.challenge.api.currency.converter.model.entity.User;
import com.jaya.challenge.api.currency.converter.repository.TransactionRepository;
import com.jaya.challenge.api.currency.converter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author andreia
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

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public List<Transaction> transactionsByUser(Long idUser) {
        User user = userRepository.findById(idUser).orElseThrow(
                () -> new UserNotFoundException("User not found"));
        ;
        return transactionRepository.transactionsByUser(user);
    }

}
