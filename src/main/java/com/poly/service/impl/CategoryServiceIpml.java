package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.poly.dao.CategoryDAO;
import com.poly.entity.Category;
import com.poly.service.CategoryService;

@Service
public class CategoryServiceIpml implements CategoryService {
	@Autowired
	CategoryDAO categoryDAO;

	@Override
	public Category save(Category entity) {
		return categoryDAO.save(entity);
	}

	@Override
	public List<Category> findAll(Sort sort) {
		return categoryDAO.findAll(sort);
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryDAO.findAll(pageable);
	}

	@Override
	public Category saveAndFlush(Category entity) {
		return categoryDAO.saveAndFlush(entity);
	}

	@Override
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}

	@Override
	public Category findById(Integer id) {
		return categoryDAO.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		categoryDAO.deleteById(id);
	}

}
