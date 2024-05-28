package com.poly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Drink;
import com.poly.entity.ShoppingCart;
import com.poly.entity.User;
import com.poly.service.DrinkService;
import com.poly.service.UserService;
import com.poly.utils.SessionService;

@Controller
public class HomeController {
	
	@Autowired
	SessionService sessionService;
	
	@Autowired
	DrinkService drinkService;
	
	@Autowired
	UserService userService;

	@GetMapping("home")
	public String getIndex() {
		
		sessionService.setAttribute("security-uri", null);
		
		User currentUser = sessionService.getAttribute("currentUser");

		if (currentUser != null) {
			User user = userService.findById(currentUser.getId());
			ShoppingCart cart = user.getCart();
			sessionService.setAttribute("totalItems", cart.getTotalItems());
		} else {
			sessionService.setAttribute("totalItems", 0);
		}

		return "user/index";
	}
	
	@ModelAttribute("drinks")
	public List<Drink> getDrinks() {
		List<Drink> drinks = drinkService.findAllByActive(true, Limit.of(12));
		return drinks;
	}
	
}
