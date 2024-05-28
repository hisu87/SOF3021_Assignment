package com.poly.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.User;

public interface UserDAO extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
