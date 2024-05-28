package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Drink;
import com.poly.entity.ShoppingCart;
import com.poly.entity.User;
import com.poly.service.DrinkService;
import com.poly.service.ShoppingCartService;
import com.poly.service.UserService;
import com.poly.utils.SessionService;

@Controller
public class CartController {

	@Autowired
	UserService userService;

	@Autowired
	DrinkService drinkService;

	@Autowired
	ShoppingCartService cartService;

	@Autowired
	SessionService sessionService;

	@GetMapping("cart")
	public String getCart(Model model) {

		User currentUser = sessionService.getAttribute("currentUser");

		if (currentUser == null) {
			return "redirect:/account/login";
		}

		User user = userService.findById(currentUser.getId());

		ShoppingCart cart = user.getCart();

		model.addAttribute("cart", cart);
		
		sessionService.setAttribute("totalItems", cart.getTotalItems());

		return "user/cart";
	}

	@GetMapping("cart/add/{id}")
	public String addCartItem(Model model, @PathVariable("id") Integer id) {

		Drink drink = drinkService.findById(id);

		User currentUser = sessionService.getAttribute("currentUser");
		User user = userService.findById(currentUser.getId());
		
		ShoppingCart cart = cartService.addItemToCart(drink, 1, user);
		model.addAttribute("cart", cart);

		return "redirect:/cart";
	}
	
	@PostMapping("cart/update")
	public String updateCartItem(Model model, @RequestParam("id") Integer id, @RequestParam("quantity") Integer quantity) {

		Drink drink = drinkService.findById(id);

		User currentUser = sessionService.getAttribute("currentUser");
		User user = userService.findById(currentUser.getId());
		
		ShoppingCart cart = cartService.updateCart(drink, quantity, user);
		model.addAttribute("cart", cart);
		
		return "redirect:/cart";
	}

	@GetMapping("cart/delete/{id}")
	public String deleteCartItem(Model model, @PathVariable("id") Integer id) {

		Drink drink = drinkService.findById(id);

		User currentUser = sessionService.getAttribute("currentUser");
		User user = userService.findById(currentUser.getId());
		
		ShoppingCart cart = cartService.deleteItemFromCart(drink, user);
		model.addAttribute("cart", cart);
		
		return "redirect:/cart";
	}

	@GetMapping("cart/clear")
	public String clearCart() {

		return "redirect:/cart";
	}

	
}
