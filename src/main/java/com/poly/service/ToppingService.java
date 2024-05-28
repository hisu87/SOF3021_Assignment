package com.poly.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.poly.entity.Topping;

public interface ToppingService {

	void deleteById(Integer id);

	Topping findById(Integer id);

	List<Topping> findAll();

	Page<Topping> findAll(Pageable pageable);

	List<Topping> findAll(Sort sort);

	Topping save(Topping entity);

}
