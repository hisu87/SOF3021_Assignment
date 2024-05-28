package com.poly.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.poly.entity.User;

public interface UserService {

	void delete(User entity);

	void deleteById(Long id);

	User findById(Long id);

	List<User> findAll();
	
	Page<User> findAll(Pageable pageable);

	List<User> findAll(Sort sort);

	User save(User entity);
	
	User findByEmail(String email);
	
}
