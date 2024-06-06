package com.poly.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.poly.entity.Category;
import com.poly.entity.Drink;
import com.poly.service.CategoryService;
import com.poly.service.DrinkService;
import com.poly.utils.UploadService;

import jakarta.validation.Valid;

@Controller
public class DrinkManagementController {

	@Autowired
	DrinkService drinkService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	UploadService uploadService;

	boolean edit = false;

	/**
	 * Phương thức này trả về trang quản lý đồ uống cho quản trị viên.
	 * 
	 * @param model đối tượng Model để truyền dữ liệu cho view.
	 * @param page  tham số tùy chọn để xác định trang hiện tại.
	 * @return tên của view hiển thị trang quản lý đồ uống cho quản trị viên.
	 */
	@GetMapping("admin/drink")
	public String getDrinkManagement(Model model, @RequestParam("page") Optional<Integer> page) {

		Drink drink = new Drink();
		model.addAttribute("drink", drink);

		edit = false;
		model.addAttribute("edit", edit);

		return "admin/drink-management";
	}

	/**
	 * Phương thức này trả về một trang danh sách các đối tượng Drink dựa trên các
	 * tham số đầu vào.
	 * 
	 * @param page    Số trang hiện tại (tùy chọn)
	 * @param keyword Từ khóa tìm kiếm (tùy chọn)
	 * @return Trang danh sách các đối tượng Drink
	 */
	@ModelAttribute("drinks")
	public Page<Drink> getDrinks(@RequestParam("page") Optional<Integer> page,
			@RequestParam("srch-term") Optional<String> keyword) {
		Pageable pageable = PageRequest.of(page.orElse(0), 5);

		Page<Drink> drinks = drinkService.searchByKeyword(keyword.orElse(""), pageable);

		return drinks;
	}

	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryService.findAll();
	}

	/**
	 * Phương thức save được sử dụng để lưu thông tin về đồ uống vào cơ sở dữ liệu.
	 * 
	 * @param model   đối tượng Model để truyền dữ liệu giữa Controller và View.
	 * @param drink   đối tượng Drink chứa thông tin về đồ uống cần lưu.
	 * @param result  đối tượng BindingResult để kiểm tra lỗi nhập liệu.
	 * @param photo   đối tượng MultipartFile chứa ảnh đồ uống.
	 * @param page    đối tượng Optional<Integer> chứa số trang hiện tại.
	 * @param keyword đối tượng Optional<String> chứa từ khóa tìm kiếm.
	 * @return chuỗi "admin/drink-management" để chuyển hướng đến trang quản lý đồ
	 *         uống.
	 */
	@PostMapping("admin/drink")
	public String save(Model model, @Valid @ModelAttribute("drink") Drink drink, BindingResult result,
			@RequestPart("photo") MultipartFile photo, @RequestParam("page") Optional<Integer> page,
			@RequestParam("srch-term") Optional<String> keyword) {

		if (result.hasErrors() || photo.isEmpty()) {
			model.addAttribute("errorFile", "Please choose Image");
		} else {

			String fileName = photo.getOriginalFilename();
			uploadService.save(photo, "/images/");
			drink.setDrinkImage(fileName);

			Category category = categoryService.findById(drink.getCategory().getId());
			drink.setCategory(category);

			if (drink.getId() == null) {
				model.addAttribute("message", "Add new drink successfully");
			} else {
				model.addAttribute("message", "Update drink successfully");
			}

			drink = drinkService.save(drink);

			drink = new Drink();
			model.addAttribute("drink", drink);
		}

		getDrinks(page, keyword);

		edit = false;
		model.addAttribute("edit", edit);

		return "admin/drink-management";
	}

	/**
	 * Phương thức này được sử dụng để chỉnh sửa thông tin một đối tượng Drink trong
	 * hệ thống.
	 * 
	 * @param model đối tượng Model để truyền dữ liệu giữa Controller và View.
	 * @param id    mã định danh của đối tượng Drink cần chỉnh sửa.
	 * @return tên của trang View để hiển thị thông tin chỉnh sửa đối tượng Drink.
	 */
	@GetMapping(value = "admin/drink", params = "btnEdit")
	public String edit(Model model, @RequestParam("id") Integer id) {
		Drink drink = drinkService.findById(id);
		model.addAttribute("drink", drink);

		edit = true;
		model.addAttribute("edit", edit);

		return "admin/drink-management";
	}

	@PostMapping("admin/delete/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		drinkService.deleteById(id);

		return "redirect:/admin/drink";
	}

	@GetMapping(value = "admin/drink", params = "btnDel")
	public String deleteInline(@RequestParam("id") Integer id) {
		drinkService.deleteById(id);

		return "redirect:/admin/drink";
	}

}
