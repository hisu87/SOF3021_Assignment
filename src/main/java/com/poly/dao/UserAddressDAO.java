package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.UserAddress;

public interface UserAddressDAO extends JpaRepository<UserAddress, Integer> {

}
