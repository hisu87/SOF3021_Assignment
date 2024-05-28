package com.poly.controller.admin;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Role;
import com.poly.entity.User;
import com.poly.service.RoleService;
import com.poly.service.UserService;
import com.poly.utils.ParamService;

import jakarta.validation.Valid;


@Controller
public class UserManagementController {

	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	ParamService paramService;
	
	boolean edit = false;
	
	@GetMapping("admin/user")
	public String getUserManagement(Model model) {

		User user = new User();
		model.addAttribute("user", user);

		List<User> users = userService.findAll();
		model.addAttribute("users", users);

		edit = false;
		model.addAttribute("edit", edit);

		return "admin/user-management";
	}
	
	@ModelAttribute("users")
	public List<User> getUser(){
		return userService.findAll();
	}
	
	@PostMapping("admin/user")
	public String save(Model model, @Valid @ModelAttribute("user") User user, 
			BindingResult result) {

		if (result.hasErrors()) {
			model.addAttribute("message", result.toString());
			System.out.println(result.hasErrors());
		} else {
			User updatedUser = userService.findById(user.getId());
			
			updatedUser.setActive(user.getActive());
			
			boolean admin = paramService.getBoolean("admin", false);
			
			if (admin == true && !updatedUser.isAdmin()) {
				updatedUser = roleService.assignUserToRole(updatedUser.getId(), 1);
			} else if (admin == false && updatedUser.isAdmin()) {
				updatedUser = roleService.removeUserFromRole(updatedUser.getId(), 1);
			}

			updatedUser = userService.save(updatedUser);

			user = new User();
			model.addAttribute("user", user);
			model.addAttribute("message", "Update user successfully");
		}

		List<User> users = userService.findAll();
		model.addAttribute("users", users);

		edit = false;
		model.addAttribute("edit", edit);

		return "admin/user-management";
	}
	
	@GetMapping(value = "admin/user", params = "btnEdit")
	public String edit(Model model, @RequestParam("id") Long id) {
		User user = userService.findById(id);
		model.addAttribute("user", user);

		edit = true;
		model.addAttribute("edit", edit);

		return "admin/user-management";
	}
	
	@PostMapping("admin/user/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		userService.deleteById(id);

		return "redirect:/admin/user";
	}

	@GetMapping(value = "admin/user", params = "btnDel")
	public String deleteInline(@RequestParam("username") Long username) {
		userService.deleteById(username);

		return "redirect:/admin/user";
	}
	

}
