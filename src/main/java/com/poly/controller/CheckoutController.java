package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.AddressDAO;
import com.poly.dao.PaymentMethodDAO;
import com.poly.entity.Address;
import com.poly.entity.Order;
import com.poly.entity.PaymentMethod;
import com.poly.entity.ShoppingCart;
import com.poly.entity.User;
import com.poly.service.OrderService;
import com.poly.service.UserService;
import com.poly.utils.SessionService;

@Controller
public class CheckoutController {

	@Autowired
	UserService userService;

	@Autowired
	OrderService orderService;

	@Autowired
	PaymentMethodDAO paymentMethodDAO;

	@Autowired
	AddressDAO addressDAO;

	@Autowired
	SessionService sessionService;

	@GetMapping("checkout")
	public String getCheckout(Model model) {
		User currentUser = sessionService.getAttribute("currentUser");

		if (currentUser == null) {
			return "redirect:/account/login";
		}

		User user = userService.findById(currentUser.getId());
		model.addAttribute("user", user);

		ShoppingCart cart = user.getCart();
		
		if (cart.getCartItems().isEmpty()) {
			return "redirect:/home";
		}

		model.addAttribute("cart", cart);

		Order order = new Order();

		order.setUser(user);

		model.addAttribute("order", order);

		return "user/checkout";
	}

	@PostMapping("checkout")
	public String checkout(@ModelAttribute("order") Order order, @RequestParam("addressString") String addressString,
			@RequestParam("phoneNumber") String phoneNumber,
			Model model) {
		
		if (phoneNumber.equals("")) {
			return "redirect:/account/profile";
		}

		if (addressString.equals("")) {
			model.addAttribute("addressErrorMessage", "Please enter delivery address");

			User currentUser = sessionService.getAttribute("currentUser");

			if (currentUser == null) {
				return "redirect:/account/login";
			}

			User user = userService.findById(currentUser.getId());
			model.addAttribute("user", user);

			ShoppingCart cart = user.getCart();

			model.addAttribute("cart", cart);

			order = new Order();

			order.setUser(user);

			model.addAttribute("order", order);

			return "user/checkout";
		} else {
			User currentUser = sessionService.getAttribute("currentUser");

			if (currentUser == null) {
				return "redirect:/account/login";
			}

			User user = userService.findById(currentUser.getId());
			model.addAttribute("user", user);

			ShoppingCart cart = user.getCart();

			PaymentMethod paymentMethod = paymentMethodDAO.findById(order.getPaymentMethod().getId()).get();
			order.setPaymentMethod(paymentMethod);

			String[] arrAddress = parseStringAddressToArray(addressString);

			Address address = new Address();

			address.setStreetnumber(arrAddress[0]);
			address.setWard(arrAddress[1]);
			address.setDistrict(arrAddress[2]);
			address.setProvince(arrAddress[3]);

			address = addressDAO.saveAndFlush(address);

			order.setAddress(address);

			orderService.saveOrder(cart, order);
			
			if (paymentMethod.getId() == 7) {
				return "redirect:/payment/create_payment";
			}
		}

		return "redirect:/order";
	}

	@GetMapping("order")
	public String getOrder(Model model) {
		User currentUser = sessionService.getAttribute("currentUser");

		if (currentUser == null) {
			return "redirect:/account/login";
		}

		User user = userService.findById(currentUser.getId());

		ShoppingCart cart = user.getCart();
		sessionService.setAttribute("totalItems", cart.getTotalItems());

		List<Order> orders = orderService.findAllByUsername(user.getId());
		
		orders.forEach(order -> System.out.println(order.toString()));
		
		model.addAttribute("orders", orders);

		return "user/order";
	}

	@GetMapping("order/cancel/{id}")
	public String cancelOrder(@PathVariable("id") Long id) {
		orderService.cancelOrder(id);
		return "redirect:/order";
	}

	@ModelAttribute("paymentMethods")
	public List<PaymentMethod> getPaymentMethods() {
		return paymentMethodDAO.findAll();
	}

	public String[] parseStringAddressToArray(String addressString) {
		String[] arrAddress = null;
		if (addressString.length() > 0) {
			addressString = removeSpace(addressString);
			arrAddress = addressString.split(",");
		}
		return arrAddress;
	}

	private String removeSpace(String string) {
		return string.replaceAll(", ", ",");
	}
}
