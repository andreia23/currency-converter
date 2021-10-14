package com.jaya.challenge.api.currency.converter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaya.challenge.api.currency.converter.model.entity.Transaction;

/**
 * @author andreia
 *
 */
public interface TransactionRepository extends JpaRepository<Transaction, Integer>  {

}
