package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.ShoppingCart;

public interface ShoppingCartDAO extends JpaRepository<ShoppingCart, Long> {

}
