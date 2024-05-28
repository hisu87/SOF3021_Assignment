package com.poly.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.CartItemDAO;
import com.poly.dao.ShoppingCartDAO;
import com.poly.entity.CartItem;
import com.poly.entity.Drink;
import com.poly.entity.ShoppingCart;
import com.poly.entity.User;
import com.poly.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingCartDAO shoppingCartDAO;

	@Autowired
	private CartItemDAO cartItemDAO;

	@Override
	public ShoppingCart addItemToCart(Drink drink, Integer quantity, User user) {

		ShoppingCart cart = user.getCart();

		if (cart == null) {
			cart = new ShoppingCart();
		}

		Set<CartItem> cartItems = cart.getCartItems();

		CartItem cartItem = findCartItem(cartItems, drink.getId());

		int itemQuantity = 0;

		if (cartItems == null) {
			cartItems = new HashSet<CartItem>();

			if (cartItem == null) {
				cartItem = new CartItem();
				cartItem.setDrink(drink);
				cartItem.setUnitPrice(drink.getPrice());
				cartItem.setQuantity(quantity);
				cartItem.setCart(cart);

				cartItems.add(cartItem);

				cartItemDAO.save(cartItem);
			} else {
				itemQuantity = cartItem.getQuantity() + quantity;
				cartItem.setQuantity(itemQuantity);
				cartItemDAO.save(cartItem);
			}
		} else {
			if (cartItem == null) {
				cartItem = new CartItem();
				cartItem.setDrink(drink);
				cartItem.setUnitPrice(drink.getPrice());
				cartItem.setQuantity(quantity);
				cartItem.setCart(cart);

				cartItems.add(cartItem);

				cartItemDAO.save(cartItem);
			} else {
				itemQuantity = cartItem.getQuantity() + quantity;
				cartItem.setQuantity(itemQuantity);
				cartItemDAO.save(cartItem);
			}
		}

		cart.setCartItems(cartItems);

		double totalPrice = totalPrice(cart.getCartItems());
		int totalItems = totalItems(cart.getCartItems());

		cart.setTotalPrice(totalPrice);
		cart.setTotalItems(totalItems);
		cart.setUser(user);

		return shoppingCartDAO.save(cart);
	}

	@Override
	public ShoppingCart updateCart(Drink drink, Integer quantity, User user) {

		ShoppingCart cart = user.getCart();

		Set<CartItem> cartItems = cart.getCartItems();

		CartItem cartItem = findCartItem(cartItems, drink.getId());

		cartItem.setQuantity(quantity);

		cartItemDAO.save(cartItem);

		int totalItems = totalItems(cartItems);
		double totalPrice = totalPrice(cartItems);

		cart.setTotalItems(totalItems);
		cart.setTotalPrice(totalPrice);

		return shoppingCartDAO.save(cart);
	}

	@Override
	public ShoppingCart deleteItemFromCart(Drink drink, User user) {

		ShoppingCart cart = user.getCart();

		Set<CartItem> cartItems = cart.getCartItems();

		CartItem cartItem = findCartItem(cartItems, drink.getId());
		
		cartItems.remove(cartItem);
		cartItemDAO.delete(cartItem);
		
		int totalItems = totalItems(cartItems);
		double totalPrice = totalPrice(cartItems);
		
		cart.setCartItems(cartItems);
		cart.setTotalItems(totalItems);
		cart.setTotalPrice(totalPrice);

		return shoppingCartDAO.save(cart);
	}
	
	@Override
	public void deleteCartById(Long id) {
		ShoppingCart cart = shoppingCartDAO.findById(id).get();
		
		Set<CartItem> cartItems = cart.getCartItems();
		
		cartItemDAO.deleteAll(cartItems);
		
		cartItems.clear();
		
		cart.setCartItems(cartItems);
		
		shoppingCartDAO.save(cart);
		
	}

	private CartItem findCartItem(Set<CartItem> cartItems, Integer drinkId) {
		if (cartItems == null) {
			return null;
		}

		CartItem cartItem = null;

		for (CartItem item : cartItems) {
			if (item.getDrink().getId() == drinkId) {
				cartItem = item;
				break;
			}
		}

		return cartItem;
	}

	private int totalItems(Set<CartItem> cartItems) {
		int totalItems = 0;

		for (CartItem item : cartItems) {
			totalItems += item.getQuantity();
		}

		return totalItems;
	}

	private double totalPrice(Set<CartItem> cartItems) {
		double totalPrice = 0.0;

		for (CartItem item : cartItems) {
			totalPrice += item.getQuantity() * item.getUnitPrice();
		}

		return totalPrice;
	}

	@Override
	public ShoppingCart createNewShoppingcart(User user) {
		ShoppingCart cart = new ShoppingCart();
		cart.setUser(user);
		return shoppingCartDAO.save(cart);
	}

	

}
