package com.poly.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.poly.entity.Category;

/**
 * Giao diện định nghĩa các phương thức cho việc quản lý danh mục.
 */
public interface CategoryService {

	/**
	 * Xóa danh mục theo ID.
	 *
	 * @param id ID của danh mục cần xóa
	 */
	void deleteById(Integer id);

	/**
	 * Tìm kiếm danh mục theo ID.
	 *
	 * @param id ID của danh mục cần tìm kiếm
	 * @return Đối tượng Category tương ứng với ID được tìm thấy, hoặc null nếu
	 *         không tìm thấy
	 */
	Category findById(Integer id);

	/**
	 * Lấy danh sách tất cả danh mục.
	 *
	 * @return Danh sách các danh mục
	 */
	List<Category> findAll();

	/**
	 * Lưu và cập nhật danh mục.
	 *
	 * @param entity Đối tượng Category cần lưu và cập nhật
	 * @return Đối tượng Category đã được lưu và cập nhật
	 */
	Category saveAndFlush(Category entity);

	/**
	 * Lấy danh sách tất cả danh mục theo trang.
	 *
	 * @param pageable Thông tin về trang và số lượng danh mục trên mỗi trang
	 * @return Danh sách các danh mục trên trang được chỉ định
	 */
	Page<Category> findAll(Pageable pageable);

	/**
	 * Lấy danh sách tất cả danh mục theo thứ tự sắp xếp.
	 *
	 * @param sort Thông tin về thứ tự sắp xếp của danh mục
	 * @return Danh sách các danh mục được sắp xếp theo thứ tự chỉ định
	 */
	List<Category> findAll(Sort sort);

	/**
	 * Lưu danh mục.
	 *
	 * @param entity Đối tượng Category cần lưu
	 * @return Đối tượng Category đã được lưu
	 */
	Category save(Category entity);

}
