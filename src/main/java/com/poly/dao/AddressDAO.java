package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Address;

public interface AddressDAO extends JpaRepository<Address, Integer> {

}
