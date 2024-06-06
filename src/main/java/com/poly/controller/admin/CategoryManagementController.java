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

import com.poly.entity.Category;
import com.poly.service.CategoryService;

import jakarta.validation.Valid;

@Controller
public class CategoryManagementController {

	@Autowired
	CategoryService categoryService;

	boolean edit = false;

	/**
	 * Phương thức getCategoryManagement được sử dụng để lấy thông tin về quản lý
	 * danh mục.
	 * 
	 * @param model đối tượng Model để truyền dữ liệu giữa Controller và View.
	 * @return chuỗi "admin/category-management" để chuyển hướng đến trang quản lý
	 *         danh mục.
	 */
	@GetMapping("admin/category")
	public String getCategoryManagement(Model model) {

		Category category = new Category();
		model.addAttribute("category", category);

		edit = false;
		model.addAttribute("edit", edit);

		return "admin/category-management";
	}

	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryService.findAll();
	}

	/**
	 * Phương thức save được sử dụng để lưu thông tin của một đối tượng Category vào
	 * cơ sở dữ liệu.
	 * 
	 * @param model    đối tượng Model để truyền dữ liệu giữa Controller và View.
	 * @param category đối tượng Category được truyền từ form để lưu vào cơ sở dữ
	 *                 liệu.
	 * @param result   đối tượng BindingResult để kiểm tra lỗi nhập liệu.
	 * @return tên của view được hiển thị sau khi thực hiện lưu thông tin.
	 */
	@PostMapping("admin/category")
	public String save(Model model, @Valid @ModelAttribute("category") Category category, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println(result.toString());
		} else {

			if (category.getId() == null) {
				model.addAttribute("message", "Add new category successfully");
			} else {
				model.addAttribute("message", "Update category successfully");
			}

			categoryService.save(category);

			category = new Category();
			model.addAttribute("category", category);
		}

		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);

		edit = false;
		model.addAttribute("edit", edit);

		return "admin/category-management";
	}

	/**
	 * Phương thức edit được sử dụng để chỉnh sửa thông tin của một danh mục.
	 * 
	 * @param model đối tượng Model để truyền dữ liệu giữa Controller và View.
	 * @param id    id của danh mục cần chỉnh sửa.
	 * @return chuỗi đường dẫn tới trang quản lý danh mục.
	 */
	@GetMapping(value = "admin/category", params = "btnEdit")
	public String edit(Model model, @RequestParam("id") Integer id) {
		Category category = categoryService.findById(id);
		model.addAttribute("category", category);

		edit = true;
		model.addAttribute("edit", edit);

		return "/admin/category-management";
	}

	/**
	 * Xóa một danh mục dựa trên ID.
	 * 
	 * @param id ID của danh mục cần xóa
	 * @return chuỗi chuyển hướng đến trang quản lý danh mục
	 */
	@PostMapping("admin/category/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {

		categoryService.deleteById(id);

		return "redirect:/admin/category";
	}

	/**
	 * Xóa một danh mục theo ID và chuyển hướng về trang quản lý danh mục.
	 * 
	 * @param id    ID của danh mục cần xóa
	 * @param model đối tượng Model để truyền dữ liệu cho view
	 * @return chuỗi ký tự "redirect:/admin/category" để chuyển hướng về trang quản
	 *         lý danh mục
	 */
	@GetMapping(value = "admin/category", params = "btnDel")
	public String deleteInline(@RequestParam("id") Integer id, Model model) {
		categoryService.deleteById(id);

		return "redirect:/admin/category";
	}
}
