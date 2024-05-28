package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.OrderStatus;

public interface OrderStatusDAO extends JpaRepository<OrderStatus, Integer> {

}
