package com.poly.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.poly.dao.CartItemDAO;
import com.poly.dao.OrderDAO;
import com.poly.dao.OrderDetailDAO;
import com.poly.dao.OrderStatusDAO;
import com.poly.dao.PaymentMethodDAO;
import com.poly.dao.ShoppingCartDAO;
import com.poly.dao.UserDAO;
import com.poly.entity.CartItem;
import com.poly.entity.Order;
import com.poly.entity.OrderDetail;
import com.poly.entity.ShoppingCart;
import com.poly.entity.User;
import com.poly.service.OrderService;
import com.poly.service.ShoppingCartService;

@Service
public class OrderServiceIpml implements OrderService {
	@Autowired
	OrderDAO orderDAO;

	@Autowired
	OrderDetailDAO orderDetailDAO;

	@Autowired
	OrderStatusDAO orderStatusDAO;

	@Autowired
	PaymentMethodDAO paymentMethodDAO;

	@Autowired
	CartItemDAO cartItemDAO;

	@Autowired
	ShoppingCartDAO cartDAO;

	@Autowired
	UserDAO userDAO;

	@Autowired
	ShoppingCartService cartService;


	@Override
	public void saveOrder(ShoppingCart cart, Order order) {
		order.setOrderStatus(orderStatusDAO.findById(1).get());
		order.setCreateDate(LocalDateTime.now());
		order.setUser(cart.getUser());
		order.setTotalPrice(cart.getTotalPrice());

		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		Set<CartItem> cartItems = cart.getCartItems();
		for (CartItem item : cartItems) {
			OrderDetail orderDetail = new OrderDetail();

			orderDetail.setOrder(order);
			orderDetail.setQuantity(item.getQuantity());
			orderDetail.setDrink(item.getDrink());
			orderDetail.setUnitPrice(item.getUnitPrice());

			orderDetailDAO.save(orderDetail);
			orderDetails.add(orderDetail);
		}

		order.setOrderDetails(orderDetails);

		cartService.deleteCartById(cart.getId());

		orderDAO.save(order);
	}

	@Override
	public void cancelOrder(Long id) {
		Order order = orderDAO.findById(id).get();
		order.setOrderStatus(orderStatusDAO.findById(6).get());
		orderDAO.save(order);
	}

	@Override
	public List<Order> findAllByUsername(Long id) {
		User user = userDAO.findById(id).get();
		List<Order> orders = user.getOrders();
		return orders;
	}

	@Override
	public List<Order> findAll() {
		return orderDAO.findAll();
	}

	@Override
	public Order save(Order order) {
		return orderDAO.save(order);
	}

	@Override
	public List<Order> findAll(Sort sort) {
		return orderDAO.findAll(sort);
	}

	@Override
	public Page<Order> findAll(Pageable pageable) {
		return orderDAO.findAll(pageable);
	}

	@Override
	public Order findById(Long id) {
		return orderDAO.findById(id).get();
	}

	@Override
	public void deleteById(Long id) {
		Order order = findById(id);
		order.setOrderStatus(orderStatusDAO.findById(6).get());
		save(order);
	}

	@Override
	public List<String> findDays() {
		return orderDAO.findDays();
	}

	@Override
	public List<String> findMonths() {
		return orderDAO.findMonths();
	}

	@Override
	public List<String> findYears() {
		return orderDAO.findYears();
	}
	
	
}