package com.poly.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.poly.entity.Order;
import com.poly.entity.ShoppingCart;

public interface OrderService {
	
	void saveOrder(ShoppingCart cart, Order order);
	
	void cancelOrder(Long id);
	
	List<Order> findAllByUsername(Long id);
	
	List<Order> findAll();
	
	Order save(Order order);

	void deleteById(Long id);

	Order findById(Long id);

	Page<Order> findAll(Pageable pageable);

	List<Order> findAll(Sort sort);
	
	List<String> findDays();
	
	List<String> findMonths();
	
	List<String> findYears();
}