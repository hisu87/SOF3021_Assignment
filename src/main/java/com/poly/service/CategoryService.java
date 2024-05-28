package com.poly.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.poly.entity.Category;

public interface CategoryService {

	void deleteById(Integer id);

	Category findById(Integer id);

	List<Category> findAll();

	Category saveAndFlush(Category entity);

	Page<Category> findAll(Pageable pageable);

	List<Category> findAll(Sort sort);

	Category save(Category entity);

}
