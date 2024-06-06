package com.poly.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.poly.entity.Topping;

/**
 * Giao diện ToppingService định nghĩa các phương thức để thao tác với đối tượng
 * Topping.
 */
public interface ToppingService {

	/**
	 * Xóa một Topping theo ID.
	 *
	 * @param id ID của Topping cần xóa
	 */
	void deleteById(Integer id);

	/**
	 * Tìm kiếm một Topping theo ID.
	 *
	 * @param id ID của Topping cần tìm kiếm
	 * @return Topping tìm được hoặc null nếu không tìm thấy
	 */
	Topping findById(Integer id);

	/**
	 * Lấy danh sách tất cả các Topping.
	 *
	 * @return Danh sách các Topping
	 */
	List<Topping> findAll();

	/**
	 * Lấy danh sách các Topping theo trang.
	 *
	 * @param pageable Thông tin về trang
	 * @return Trang chứa danh sách các Topping
	 */
	Page<Topping> findAll(Pageable pageable);

	/**
	 * Lấy danh sách các Topping được sắp xếp.
	 *
	 * @param sort Thông tin về sắp xếp
	 * @return Danh sách các Topping được sắp xếp
	 */
	List<Topping> findAll(Sort sort);

	/**
	 * Lưu một Topping.
	 *
	 * @param entity Topping cần lưu
	 * @return Topping đã được lưu
	 */
	Topping save(Topping entity);

}
