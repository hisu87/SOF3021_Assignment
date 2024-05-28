package com.poly.service;

import com.poly.entity.Drink;
import com.poly.entity.ShoppingCart;
import com.poly.entity.User;

public interface ShoppingCartService {

	ShoppingCart addItemToCart(Drink drink, Integer quantity, User user);
	
	ShoppingCart updateCart(Drink drink, Integer quantity, User user);
	
	ShoppingCart deleteItemFromCart(Drink drink, User user);
	
	void deleteCartById(Long id);
	
	ShoppingCart createNewShoppingcart(User user);
}
