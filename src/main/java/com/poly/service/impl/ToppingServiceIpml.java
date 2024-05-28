package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.poly.dao.ToppingDAO;
import com.poly.entity.Topping;
import com.poly.service.ToppingService;

@Service
public class ToppingServiceIpml implements ToppingService{
	@Autowired
	ToppingDAO toppingDAO;

	@Override
	public Topping save(Topping entity) {
		return toppingDAO.save(entity);
	}

	@Override
	public List<Topping> findAll(Sort sort) {
		return toppingDAO.findAll(sort);
	}

	@Override
	public Page<Topping> findAll(Pageable pageable) {
		return toppingDAO.findAll(pageable);
	}

	@Override
	public List<Topping> findAll() {
		return toppingDAO.findAll();
	}

	@Override
	public Topping findById(Integer id) {
		return toppingDAO.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		Topping topping = findById(id);
		topping.setActive(false);
		save(topping);
	}
	
	
}
