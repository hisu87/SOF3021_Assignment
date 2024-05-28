package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Long> {
	@Query("SELECT DISTINCT day(o.createDate) "
			+ "FROM Order o "
			+ "GROUP BY o.createDate ")
	List<String> findDays();
	
	@Query("SELECT DISTINCT month(o.createDate) "
			+ "FROM Order o "
			+ "GROUP BY o.createDate ")
	List<String> findMonths();
	
	@Query("SELECT DISTINCT year(o.createDate) "
			+ "FROM Order o "
			+ "GROUP BY o.createDate ")
	List<String> findYears();
}