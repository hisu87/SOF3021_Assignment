package com.poly.controller.admin;

import java.time.LocalDateTime;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.poly.entity.Category;
import com.poly.entity.Report;
import com.poly.entity.User;
import com.poly.service.CategoryService;
import com.poly.service.OrderService;
import com.poly.service.ReportService;
import com.poly.utils.ExcelService;
import com.poly.utils.SessionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class OrderManagementController2 {
	
	@Autowired
	OrderService orderService;
	@Autowired
	SessionService session;
	
	Page<User> pages = null;
	Pageable pageable = PageRequest.of(0, 2);
	
	@RequestMapping("admin/order2/index")
	public String index() {
		return "admin/order2-management";
	}
	
	@GetMapping("admin/order2")
	public String get(Model model) {

		model.addAttribute("pages", pages);		
		model.addAttribute("user", pages.getContent().get(0));
		
		return "forward:/admin/order2/index";
	}

	@PostMapping("admin/order2/search")
	public String search(Model model, HttpServletRequest request,
			@RequestParam("keyword") String keyword) {
		pageable = PageRequest.of(0, 2);
		
		session.setAttribute("keyword", keyword);
		model.addAttribute("pages", pages);
		model.addAttribute("user", pages.getContent().get(0));
		
		return "forward:/admin/order2/index";
	}
	
	@GetMapping("admin/order2/page")
	public String page(Model model,
			@RequestParam("p") Optional<Integer> p) {
		String keyword = session.getAttribute("keyword");
		pageable = PageRequest.of(p.orElse(0), 2);
		
		
		
		
		model.addAttribute("pages", pages);
		model.addAttribute("user", pages.getContent().get(0));
		
		return "forward:/admin/order2/index";
	}
	
	@GetMapping("admin/order2/edit")
	public String edit(Model model,
			@RequestParam("username") String username) {	
		
		model.addAttribute("edit", true);
		model.addAttribute("pages", pages);
		
		return "forward:/admin/order2/index";
	}
	
	@PostMapping("admin/order2/{crud}")
	public String save(Model model,
			@ModelAttribute("user") User user, BindingResult result) {
		
		
		model.addAttribute("pages", pages);
		model.addAttribute("user", user);
		
		return "forward:/admin/order2/index";
	}
}
