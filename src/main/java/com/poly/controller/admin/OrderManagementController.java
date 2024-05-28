package com.poly.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.OrderStatusDAO;
import com.poly.dao.PaymentMethodDAO;
import com.poly.entity.Order;
import com.poly.entity.OrderStatus;
import com.poly.entity.PaymentMethod;
import com.poly.service.OrderService;

@Controller
public class OrderManagementController {

	@Autowired
	OrderService orderService;

	@Autowired
	OrderStatusDAO orderStatusDAO;

	@Autowired
	PaymentMethodDAO paymentMethodDAO;

	boolean edit = false;

	@GetMapping("admin/order")
	public String getOrderManagement(Model model) {

		Order order = new Order();
		model.addAttribute("order", order);

		List<Order> orders = orderService.findAll();
		model.addAttribute("orders", orders);

		edit = false;
		model.addAttribute("edit", edit);

		return "admin/order-management";
	}

	@GetMapping(value = "admin/order", params = "btnEdit")
	public String edit(Model model, @RequestParam("id") Long id) {
		Order order = orderService.findById(id);
		model.addAttribute("order", order);

		edit = true;
		model.addAttribute("edit", edit);

		return "admin/order-management";
	}

	@PostMapping("admin/order")
	public String save(Model model, @ModelAttribute("order") Order order) {
		Order updatedOrder = orderService.findById(order.getId());

		PaymentMethod paymentMethod = paymentMethodDAO.findById(order.getPaymentMethod().getId()).get();
		updatedOrder.setPaymentMethod(paymentMethod);
		
		updatedOrder.setPaymentStatus(order.getPaymentStatus());

		OrderStatus orderStatus = orderStatusDAO.findById(order.getOrderStatus().getId()).get();
		updatedOrder.setOrderStatus(orderStatus);

		

		orderService.save(updatedOrder);
		model.addAttribute("message", "Update order successfully");

		List<Order> orders = orderService.findAll();
		model.addAttribute("orders", orders);

		order = new Order();
		model.addAttribute("order", order);

		edit = false;
		model.addAttribute("edit", edit);

		return "admin/order-management";
	}

	@ModelAttribute("orders")
	public List<Order> getOrders() {
		return orderService.findAll();
	}

	@ModelAttribute("orderStatuses")
	public List<OrderStatus> getOrderStatuses() {
		return orderStatusDAO.findAll();
	}

	@ModelAttribute("paymentMethods")
	public List<PaymentMethod> getPaymentMethods() {
		return paymentMethodDAO.findAll();
	}
}