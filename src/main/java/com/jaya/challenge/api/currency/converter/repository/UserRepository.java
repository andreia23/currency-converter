package com.jaya.challenge.api.currency.converter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jaya.challenge.api.currency.converter.model.entity.User;

/**
 * @author andreia
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select u from User u where u.idUser = ?1")
	Optional<User> findById(Long idUser);


}
