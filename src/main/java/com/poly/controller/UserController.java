package com.poly.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.auth.UserRoot;
import com.poly.dto.RegisterUserDTO;
import com.poly.entity.User;
import com.poly.service.ShoppingCartService;
import com.poly.service.UserService;
import com.poly.utils.CookieService;
import com.poly.utils.ParamService;
import com.poly.utils.SessionService;

import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	ParamService paramService;

	@Autowired
	CookieService cookieService;

	@Autowired
	SessionService sessionService;

	@Autowired
	UserService userService;

	@Autowired
	ShoppingCartService cartService;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	/**
	 * Phương thức này trả về chuỗi "user/login" để hiển thị trang đăng nhập.
	 *
	 * @param model đối tượng Model để truyền dữ liệu tới view.
	 * @return chuỗi "user/login" để hiển thị trang đăng nhập.
	 */
	@GetMapping("account/login")
	public String getLogin(Model model) {

		User user = new User();

		model.addAttribute("user", user);

		return "user/login";
	}

	/**
	 * Xử lý yêu cầu đăng nhập từ phương thức POST.
	 * 
	 * @param model Đối tượng Model để truyền dữ liệu cho view.
	 * @param user  Đối tượng User chứa thông tin người dùng đăng nhập.
	 * @return Tên view để hiển thị sau khi xử lý yêu cầu đăng nhập.
	 */
	@PostMapping("account/login")
	public String postLogin(Model model, @ModelAttribute("user") User user) {

		for (User u : userService.findAll())
			if (u.getName().equals(user.getName()) && passwordEncoder.matches(user.getPassword(), u.getPassword())) {
				sessionService.setAttribute("currentUser", u);
				return "user/login";
			}

		model.addAttribute("message", "Invalid information!");
		return "user/login";
	}

	/**
	 * Xử lý khi đăng nhập thành công.
	 * 
	 * @param auth Đối tượng Authentication chứa thông tin về người dùng đã xác
	 *             thực.
	 * @return Chuỗi ký tự "redirect:/home" để chuyển hướng đến trang chủ.
	 */
	@RequestMapping("account/login/success")
	public String handleLoginSuccess(Authentication auth) {
		UserRoot userRoot = (UserRoot) auth.getPrincipal();

		User user = userService.findByEmail(userRoot.getUsername());

		if (user.getCart() == null) {
			cartService.createNewShoppingcart(user);
		}

		sessionService.setAttribute("currentUser", user);

		return "redirect:/home";
	}

	/**
	 * Xử lý khi đăng nhập thất bại.
	 * 
	 * @param model  đối tượng Model để truyền dữ liệu cho View.
	 * @param user   đối tượng RegisterUserDTO chứa thông tin người dùng đăng nhập.
	 * @param result đối tượng BindingResult để kiểm tra lỗi nhập liệu.
	 * @return tên của View để hiển thị trang đăng nhập.
	 */
	@RequestMapping("account/login/failure")
	public String handleLoginFailure(Model model, @Valid @ModelAttribute("user") RegisterUserDTO user,
			BindingResult result) {

		if (result.hasFieldErrors("email") || result.hasFieldErrors("password")) {
			System.out.println("Has errors: " + result.toString());
			model.addAttribute("message", "Username or password is invalid!");
		}

		return "user/login";
	}

	/**
	 * Xử lý khi người dùng không có quyền truy cập.
	 * 
	 * @param model đối tượng Model để truyền dữ liệu tới view.
	 * @return tên view "user/login".
	 */
	@RequestMapping("account/accessDenied")
	public String handleAccessDenied(Model model) {
		model.addAttribute("message", "Please login with admin role!");
		model.addAttribute("user", new User());
		return "user/login";
	}

	/**
	 * Phương thức logout được sử dụng để đăng xuất người dùng hiện tại.
	 * 
	 * @return chuỗi ký tự "redirect:/home" để chuyển hướng người dùng đến trang
	 *         chủ.
	 */
	@GetMapping("account/logout")
	public String logout() {
		sessionService.removeAttribute("currentUser");
		return "redirect:/home";
	}

	/**
	 * Phương thức này trả về tên của trang hiển thị thông tin người dùng.
	 * 
	 * @param model đối tượng Model để truyền dữ liệu cho view
	 * @return tên của trang hiển thị thông tin người dùng
	 */
	@GetMapping("account/profile")
	public String getProfile(Model model) {

		User currentUser = sessionService.getAttribute("currentUser");
		model.addAttribute("user", currentUser);

		return "user/profile";
	}

	/**
	 * Phương thức updateProfile được sử dụng để cập nhật thông tin người dùng.
	 * 
	 * @param model  đối tượng Model để truyền dữ liệu giữa Controller và View.
	 * @param user   đối tượng RegisterUserDTO chứa thông tin người dùng cần cập
	 *               nhật.
	 * @param result đối tượng BindingResult để kiểm tra lỗi nhập liệu.
	 * @return chuỗi "user/profile" để chuyển hướng đến trang profile của người
	 *         dùng.
	 */
	@PostMapping("account/profile")
	public String updateProfile(Model model, @Valid @ModelAttribute("user") RegisterUserDTO user,
			BindingResult result) {

		if (result.hasFieldErrors("name") || result.hasFieldErrors("phoneNumber")
				|| result.hasFieldErrors("email")) {
			System.out.println("Has errors: " + result.toString());
		} else {
			User currentUser = sessionService.getAttribute("currentUser");

			User updatedUser = userService.findById(currentUser.getId());

			updatedUser.setName(user.getName());
			updatedUser.setPhoneNumber(user.getPhoneNumber());

			userService.save(updatedUser);

			model.addAttribute("message", "Update profile successfully!");

			sessionService.setAttribute("currentUser", updatedUser);
		}

		return "user/profile";
	}

	/**
	 * Phương thức này trả về chuỗi "user/register" để hiển thị trang đăng ký người
	 * dùng.
	 * 
	 * @param model đối tượng Model để truyền dữ liệu cho view.
	 * @return chuỗi "user/register" để hiển thị trang đăng ký người dùng.
	 */
	@GetMapping("account/register")
	public String getRegister(Model model) {
		model.addAttribute("registerUser", new User());

		return "user/register";
	}

	/**
	 * Phương thức đăng ký người dùng.
	 * 
	 * @param model             Đối tượng Model để truyền dữ liệu giữa Controller và
	 *                          View.
	 * @param registerUserDTO   Đối tượng RegisterUserDTO chứa thông tin người dùng
	 *                          đăng ký.
	 * @param result            Đối tượng BindingResult để kiểm tra lỗi nhập liệu.
	 * @param confirmedPassword Chuỗi chứa mật khẩu xác nhận.
	 * @return Chuỗi chứa tên view để hiển thị kết quả đăng ký.
	 */
	@PostMapping("account/register")
	public String register(Model model, @Valid @ModelAttribute("registerUser") RegisterUserDTO registerUserDTO,
			BindingResult result,
			@RequestParam("confirmedPassword") String confirmedPassword) {

		if (result.hasErrors() && confirmedPassword.equals("")) {
			model.addAttribute("confirmedPasswordErrorMessage", "Please enter Confirmed Password");
		} else if (userService.findByEmail(registerUserDTO.getEmail()) != null) {
			model.addAttribute("errorMessage", "Email is already registerd, please choose another email");
		} else {

			if (registerUserDTO.getPassword().equals(confirmedPassword)) {
				try {
					userService.save(User.builder()
							.name(registerUserDTO.getName())
							.email(registerUserDTO.getEmail())
							.phoneNumber(registerUserDTO.getPhoneNumber())
							.password(passwordEncoder.encode(registerUserDTO.getPassword()))
							.build());

					return "redirect:/account/login";
				} catch (Exception e) {
					e.printStackTrace();
					model.addAttribute("confirmedPassword", confirmedPassword);
				}

			} else {
				model.addAttribute("confirmedPassword", confirmedPassword);
				model.addAttribute("confirmedPasswordErrorMessage", "Confirmed passoword is invalid");
			}

		}

		return "user/register";
	}

	/**
	 * Phương thức này trả về trang đổi mật khẩu của người dùng.
	 * 
	 * @param model đối tượng Model để truyền dữ liệu cho view.
	 * @return tên của view "user/change-password".
	 */
	@GetMapping("acount/change-password")
	public String getChangePassword(Model model) {
		User user = sessionService.getAttribute("currentUser");
		model.addAttribute("user", user);
		return "user/change-password";
	}

	/**
	 * Phương thức changePassword được sử dụng để thay đổi mật khẩu người dùng.
	 * 
	 * @param model             đối tượng Model để truyền dữ liệu giữa Controller và
	 *                          View.
	 * @param user              đối tượng User chứa thông tin người dùng.
	 * @param password          mật khẩu hiện tại của người dùng.
	 * @param newPassword       mật khẩu mới của người dùng.
	 * @param confirmedPassword mật khẩu xác nhận của người dùng.
	 * @return tên của view để hiển thị kết quả.
	 */
	@PostMapping("account/change-password")
	public String changePassword(Model model, @ModelAttribute("user") User user,
			@RequestParam("password") String password, @RequestParam("newPassword") String newPassword,
			@RequestParam("confirmedPassword") String confirmedPassword) {

		model.addAttribute("password", password);
		model.addAttribute("newPassword", newPassword);
		model.addAttribute("confirmedPassword", confirmedPassword);

		if (password.equals("")) {
			model.addAttribute("passwordErrorMessage", "Please enter Password");
		} else if (newPassword.equals("")) {
			model.addAttribute("newPasswordErrorMessage", "Please enter New Password");
		} else if (confirmedPassword.equals("")) {
			model.addAttribute("confirmedPasswordErrorMessage", "Please enter Confirmed Password");
		} else {
			user = userService.findByEmail(user.getEmail());

			if (passwordEncoder.matches(password, user.getPassword())) {

				if (newPassword.equals(confirmedPassword)) {
					try {
						user.setPassword(passwordEncoder.encode(newPassword));

						user = userService.save(user);

						sessionService.setAttribute("currentUser", user);

						model.addAttribute("password", null);
						model.addAttribute("newPassword", null);
						model.addAttribute("confirmedPassword", null);

						model.addAttribute("message", "Change Password successfully");
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {

					model.addAttribute("confirmedPasswordErrorMessage", "Confirmed password is invalid");
				}

			} else {
				model.addAttribute("passwordErrorMessage", "Password is invalid");
			}
		}

		return "user/change-password";
	}
}
