package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.poly.entity.Category;
import com.poly.entity.Drink;
import com.poly.service.CategoryService;
import com.poly.service.DrinkService;

@Controller
public class MenuController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	DrinkService drinkService;
	
	@GetMapping("menu")
	public String getMenu() {
		
		return "user/menu";
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryService.findAll();
	}
	
	@ModelAttribute("drinks")
	public List<Drink> getDrinks() {
		return drinkService.findAllByActive(true, Limit.of(20));
	}
	
	@GetMapping("menu/category/{id}")
	public String getDrinkByCategory(@PathVariable("id") Integer id, Model model) {
		
		Category category = categoryService.findById(id);
		List<Drink> drinks = drinkService.findByCategoryAndActive(category, true);
		model.addAttribute("drinks", drinks);
		
		return "user/menu";
	}
}
