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

	/**
	 * Phương thức lấy thông tin thanh toán.
	 * 
	 * @param model đối tượng Model để truyền dữ liệu tới view.
	 * @return tên của view để hiển thị trang thanh toán.
	 */
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

	/**
	 * Phương thức checkout được sử dụng để xử lý việc thanh toán đơn hàng.
	 * 
	 * @param order         Đối tượng Order chứa thông tin về đơn hàng.
	 * @param addressString Địa chỉ giao hàng dưới dạng chuỗi.
	 * @param phoneNumber   Số điện thoại người nhận hàng.
	 * @param model         Đối tượng Model để truyền dữ liệu giữa Controller và
	 *                      View.
	 * @return Chuỗi kết quả chuyển hướng đến các trang tương ứng.
	 */
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

	/**
	 * Phương thức getOrder được sử dụng để lấy thông tin đơn hàng và hiển thị trang
	 * đơn hàng cho người dùng.
	 * 
	 * @param model đối tượng Model để truyền dữ liệu đến view.
	 * @return chuỗi "user/order" để chuyển hướng người dùng đến trang đơn hàng,
	 *         hoặc chuỗi "redirect:/account/login" để chuyển hướng người dùng đến
	 *         trang đăng nhập nếu chưa đăng nhập.
	 */
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

	/**
	 * Hàm cancelOrder dùng để hủy đơn hàng.
	 * 
	 * @param id ID của đơn hàng cần hủy
	 * @return Chuỗi ký tự "redirect:/order" để chuyển hướng đến trang đơn hàng
	 */
	@GetMapping("order/cancel/{id}")
	public String cancelOrder(@PathVariable("id") Long id) {
		orderService.cancelOrder(id);
		return "redirect:/order";
	}

	/**
	 * Phương thức này trả về danh sách các phương thức thanh toán.
	 *
	 * @return Danh sách các phương thức thanh toán.
	 */
	@ModelAttribute("paymentMethods")
	public List<PaymentMethod> getPaymentMethods() {
		return paymentMethodDAO.findAll();
	}

	/**
	 * Chuyển đổi một chuỗi địa chỉ thành một mảng các địa chỉ.
	 *
	 * @param addressString Chuỗi địa chỉ cần chuyển đổi.
	 * @return Mảng các địa chỉ đã chuyển đổi từ chuỗi địa chỉ ban đầu.
	 */
	public String[] parseStringAddressToArray(String addressString) {
		String[] arrAddress = null;
		if (addressString.length() > 0) {
			addressString = removeSpace(addressString);
			arrAddress = addressString.split(",");
		}
		return arrAddress;
	}

	/**
	 * Xóa khoảng trắng trong chuỗi.
	 *
	 * @param string chuỗi cần xóa khoảng trắng
	 * @return chuỗi đã xóa khoảng trắng
	 */
	private String removeSpace(String string) {
		return string.replaceAll(", ", ",");
	}
}
