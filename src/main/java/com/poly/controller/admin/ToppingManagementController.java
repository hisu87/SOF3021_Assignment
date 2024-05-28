package com.poly.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Topping;
import com.poly.service.ToppingService;

import jakarta.validation.Valid;

@Controller
public class ToppingManagementController {

	@Autowired
	ToppingService toppingService;

	boolean edit = false;

	@GetMapping("admin/topping")
	public String getToppingManagement(Model model) {

		Topping topping = new Topping();
		model.addAttribute("topping", topping);

		edit = false;
		model.addAttribute("edit", edit);

		return "admin/topping-management";
	}

	@ModelAttribute("toppings")
	public List<Topping> getToppings() {
		return toppingService.findAll();
	}

	@PostMapping("admin/topping")
	public String save(Model model, @Valid @ModelAttribute("topping") Topping topping, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println(result.toString());
		} else {

			if (topping.getId() == null) {
				model.addAttribute("message", "Add new topping successfully");
			} else {
				model.addAttribute("message", "Update topping successfully");
			}

			toppingService.save(topping);

			topping = new Topping();
			model.addAttribute("topping", topping);
		}

		List<Topping> toppings = toppingService.findAll();
		model.addAttribute("toppings", toppings);

		edit = false;
		model.addAttribute("edit", edit);

		return "admin/topping-management";
	}

	@GetMapping(value = "admin/topping", params = "btnEdit")
	public String edit(Model model, @RequestParam("id") Integer id) {

		Topping topping = toppingService.findById(id);
		model.addAttribute("topping", topping);

		edit = true;
		model.addAttribute("edit", edit);

		return "admin/topping-management";
	}

	@PostMapping("admin/topping/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {

		toppingService.deleteById(id);

		return "redirect:/admin/topping";
	}

	@GetMapping(value = "admin/topping", params = "btnDel")
	public String deleteInline(@RequestParam("id") Integer id, Model model) {

		toppingService.deleteById(id);

		return "redirect:/admin/topping";
	}
}
