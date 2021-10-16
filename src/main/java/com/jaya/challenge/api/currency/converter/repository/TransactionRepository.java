package com.jaya.challenge.api.currency.converter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jaya.challenge.api.currency.converter.model.entity.Transaction;
import com.jaya.challenge.api.currency.converter.model.entity.User;

/**
 * @author andreia
 *
 */
public interface TransactionRepository extends JpaRepository<Transaction, Integer>  {
	
	@Query("select t from Transaction t where t.idUser = ?1")
	List<Transaction> transactionsByUser(Optional<User> user);

}
