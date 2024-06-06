package com.poly.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.poly.entity.Order;
import com.poly.entity.ShoppingCart;

/**
 * Giao diện định nghĩa các phương thức liên quan đến quản lý đơn hàng.
 */
public interface OrderService {

	/**
	 * Lưu đơn hàng vào cơ sở dữ liệu.
	 * 
	 * @param cart  giỏ hàng chứa các sản phẩm
	 * @param order đơn hàng cần lưu
	 */
	void saveOrder(ShoppingCart cart, Order order);

	/**
	 * Hủy đơn hàng dựa trên ID.
	 * 
	 * @param id ID của đơn hàng cần hủy
	 */
	void cancelOrder(Long id);

	/**
	 * Lấy danh sách các đơn hàng của một người dùng dựa trên ID người dùng.
	 * 
	 * @param id ID của người dùng
	 * @return danh sách các đơn hàng của người dùng
	 */
	List<Order> findAllByUsername(Long id);

	/**
	 * Lấy danh sách tất cả các đơn hàng.
	 * 
	 * @return danh sách tất cả các đơn hàng
	 */
	List<Order> findAll();

	/**
	 * Lưu đơn hàng vào cơ sở dữ liệu.
	 * 
	 * @param order đơn hàng cần lưu
	 * @return đơn hàng đã được lưu
	 */
	Order save(Order order);

	/**
	 * Xóa đơn hàng dựa trên ID.
	 * 
	 * @param id ID của đơn hàng cần xóa
	 */
	void deleteById(Long id);

	/**
	 * Tìm kiếm đơn hàng dựa trên ID.
	 * 
	 * @param id ID của đơn hàng cần tìm
	 * @return đơn hàng tìm thấy hoặc null nếu không tìm thấy
	 */
	Order findById(Long id);

	/**
	 * Lấy danh sách các đơn hàng phân trang.
	 * 
	 * @param pageable thông tin về phân trang
	 * @return danh sách các đơn hàng phân trang
	 */
	Page<Order> findAll(Pageable pageable);

	/**
	 * Lấy danh sách các đơn hàng được sắp xếp.
	 * 
	 * @param sort thông tin về sắp xếp
	 * @return danh sách các đơn hàng được sắp xếp
	 */
	List<Order> findAll(Sort sort);

	/**
	 * Lấy danh sách các ngày trong tháng mà có đơn hàng.
	 * 
	 * @return danh sách các ngày trong tháng mà có đơn hàng
	 */
	List<String> findDays();

	/**
	 * Lấy danh sách các tháng mà có đơn hàng.
	 * 
	 * @return danh sách các tháng mà có đơn hàng
	 */
	List<String> findMonths();

	/**
	 * Lấy danh sách các năm mà có đơn hàng.
	 * 
	 * @return danh sách các năm mà có đơn hàng
	 */
	List<String> findYears();
}