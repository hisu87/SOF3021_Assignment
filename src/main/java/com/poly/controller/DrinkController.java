package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.poly.entity.Category;
import com.poly.entity.Drink;
import com.poly.service.CategoryService;
import com.poly.service.DrinkService;

@Controller
public class DrinkController {

	@Autowired
	DrinkService drinkService;

	@Autowired
	CategoryService categoryService;

	/**
	 * Phương thức này trả về chi tiết sản phẩm đồ uống dựa trên id.
	 * 
	 * @param id    id của sản phẩm đồ uống
	 * @param model đối tượng Model để truyền dữ liệu đến view
	 * @return tên của view để hiển thị chi tiết sản phẩm đồ uống
	 */
	@GetMapping("drink/{id}")
	public String getProductDetail(@PathVariable("id") Integer id, Model model) {

		Drink drink = drinkService.findById(id);
		model.addAttribute("drink", drink);

		Category category = categoryService.findById(drink.getCategory().getId());
		List<Drink> drinks = drinkService.findRelatedDrink(category, id, true, Limit.of(3));
		model.addAttribute("drinks", drinks);

		return "user/detail";
	}

}
