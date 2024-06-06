package com.poly.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.poly.entity.User;

/**
 * Giao diện UserService định nghĩa các phương thức để thao tác với đối tượng
 * User.
 */
public interface UserService {

	/**
	 * Xóa một đối tượng User.
	 * 
	 * @param entity đối tượng User cần xóa.
	 */
	void delete(User entity);

	/**
	 * Xóa một đối tượng User dựa trên id.
	 * 
	 * @param id id của đối tượng User cần xóa.
	 */
	void deleteById(Long id);

	/**
	 * Tìm kiếm một đối tượng User dựa trên id.
	 * 
	 * @param id id của đối tượng User cần tìm kiếm.
	 * @return đối tượng User tìm thấy hoặc null nếu không tìm thấy.
	 */
	User findById(Long id);

	/**
	 * Lấy danh sách tất cả đối tượng User.
	 * 
	 * @return danh sách tất cả đối tượng User.
	 */
	List<User> findAll();

	/**
	 * Lấy danh sách tất cả đối tượng User theo trang.
	 * 
	 * @param pageable thông tin về phân trang.
	 * @return danh sách tất cả đối tượng User theo trang.
	 */
	Page<User> findAll(Pageable pageable);

	/**
	 * Lấy danh sách tất cả đối tượng User theo sắp xếp.
	 * 
	 * @param sort thông tin về sắp xếp.
	 * @return danh sách tất cả đối tượng User theo sắp xếp.
	 */
	List<User> findAll(Sort sort);

	/**
	 * Lưu một đối tượng User.
	 * 
	 * @param entity đối tượng User cần lưu.
	 * @return đối tượng User đã được lưu.
	 */
	User save(User entity);

	/**
	 * Tìm kiếm một đối tượng User dựa trên email.
	 * 
	 * @param email email của đối tượng User cần tìm kiếm.
	 * @return đối tượng User tìm thấy hoặc null nếu không tìm thấy.
	 */
	User findByEmail(String email);

}
