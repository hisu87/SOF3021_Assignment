package com.poly.service;

import com.poly.entity.Drink;
import com.poly.entity.ShoppingCart;
import com.poly.entity.User;

/**
 * Giao diện đại diện cho dịch vụ giỏ hàng.
 */
public interface ShoppingCartService {

	/**
	 * Thêm một món đồ uống vào giỏ hàng của người dùng.
	 *
	 * @param drink    đồ uống cần thêm vào giỏ hàng
	 * @param quantity số lượng đồ uống cần thêm
	 * @param user     người dùng sở hữu giỏ hàng
	 * @return giỏ hàng sau khi đã thêm món đồ uống
	 */
	ShoppingCart addItemToCart(Drink drink, Integer quantity, User user);

	/**
	 * Cập nhật số lượng một món đồ uống trong giỏ hàng của người dùng.
	 *
	 * @param drink    đồ uống cần cập nhật
	 * @param quantity số lượng mới của đồ uống
	 * @param user     người dùng sở hữu giỏ hàng
	 * @return giỏ hàng sau khi đã cập nhật
	 */
	ShoppingCart updateCart(Drink drink, Integer quantity, User user);

	/**
	 * Xóa một món đồ uống khỏi giỏ hàng của người dùng.
	 *
	 * @param drink đồ uống cần xóa
	 * @param user  người dùng sở hữu giỏ hàng
	 * @return giỏ hàng sau khi đã xóa món đồ uống
	 */
	ShoppingCart deleteItemFromCart(Drink drink, User user);

	/**
	 * Xóa giỏ hàng theo ID.
	 *
	 * @param id ID của giỏ hàng cần xóa
	 */
	void deleteCartById(Long id);

	/**
	 * Tạo một giỏ hàng mới cho người dùng.
	 *
	 * @param user người dùng sở hữu giỏ hàng
	 * @return giỏ hàng mới được tạo
	 */
	ShoppingCart createNewShoppingcart(User user);
}
