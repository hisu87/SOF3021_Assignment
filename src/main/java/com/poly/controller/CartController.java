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

/**
 * The CartController class handles the HTTP requests related to the shopping
 * cart functionality.
 * It provides methods for adding, updating, and deleting items from the cart,
 * as well as clearing the cart.
 */
@Controller
public class CartController {

	@Autowired
	UserService userService;

	@Autowired
	DrinkService drinkService;

	@Autowired
	ShoppingCartService cartService;

	@Autowired
	/**
	 * Retrieves the user's cart and displays it on the cart page.
	 * If the user is not logged in, redirects to the login page.
	 *
	 * @param model the model object to add attributes to
	 * @return the view name for the cart page
	 */
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

	/**
	 * Adds a cart item to the shopping cart.
	 *
	 * @param model the model object for the view
	 * @param id    the ID of the drink to be added to the cart
	 * @return the redirect URL for the cart view
	 */
	@GetMapping("cart/add/{id}")
	public String addCartItem(Model model, @PathVariable("id") Integer id) {

		Drink drink = drinkService.findById(id);

		User currentUser = sessionService.getAttribute("currentUser");
		User user = userService.findById(currentUser.getId());

		ShoppingCart cart = cartService.addItemToCart(drink, 1, user);
		model.addAttribute("cart", cart);

		return "redirect:/cart";
	}

	/**
	 * Phương thức này được sử dụng để cập nhật số lượng của một mặt hàng trong giỏ
	 * hàng.
	 * 
	 * @param model    đối tượng Model để truyền dữ liệu tới view
	 * @param id       mã số của mặt hàng cần cập nhật
	 * @param quantity số lượng mới của mặt hàng
	 * @return chuỗi ký tự "redirect:/cart" để chuyển hướng tới trang giỏ hàng
	 */
	@PostMapping("cart/update")
	public String updateCartItem(Model model, @RequestParam("id") Integer id,
			@RequestParam("quantity") Integer quantity) {

		Drink drink = drinkService.findById(id);

		User currentUser = sessionService.getAttribute("currentUser");
		User user = userService.findById(currentUser.getId());

		ShoppingCart cart = cartService.updateCart(drink, quantity, user);
		model.addAttribute("cart", cart);

		return "redirect:/cart";
	}

	/**
	 * Xóa mục hàng khỏi giỏ hàng.
	 * 
	 * @param model đối tượng Model để truyền dữ liệu cho view.
	 * @param id    id của mục hàng cần xóa.
	 * @return chuỗi ký tự "redirect:/cart" để chuyển hướng đến trang giỏ hàng.
	 */
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
