package com.poly.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Role;

public interface RoleDAO extends JpaRepository<Role, Integer> {

	Optional<Role> findByName(String name);

}
