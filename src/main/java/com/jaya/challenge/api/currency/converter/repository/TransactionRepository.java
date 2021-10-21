package com.jaya.challenge.api.currency.converter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jaya.challenge.api.currency.converter.model.entity.Transaction;
import com.jaya.challenge.api.currency.converter.model.entity.User;

/**
 * @author andreia
 *
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query("select t from Transaction t where t.user = ?1")
	List<Transaction> transactionsByUser(User user);

}
