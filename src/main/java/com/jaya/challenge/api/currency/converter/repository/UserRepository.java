package com.jaya.challenge.api.currency.converter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaya.challenge.api.currency.converter.model.entity.User;

/**
 * @author andreia
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
