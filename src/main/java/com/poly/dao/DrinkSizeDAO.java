package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.DrinkSize;

public interface DrinkSizeDAO extends JpaRepository<DrinkSize, Integer> {

}
