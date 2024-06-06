package com.poly.service;

import java.util.List;

import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.poly.entity.Category;
import com.poly.entity.Drink;

/**
 * Giao diện định nghĩa các phương thức cung cấp dịch vụ liên quan đến đồ uống.
 */
public interface DrinkService {

	/**
	 * Xóa một đối tượng đồ uống.
	 * 
	 * @param entity đối tượng đồ uống cần xóa
	 */
	void delete(Drink entity);

	/**
	 * Xóa một đối tượng đồ uống dựa trên ID.
	 * 
	 * @param id ID của đối tượng đồ uống cần xóa
	 */
	void deleteById(Integer id);

	/**
	 * Tìm kiếm và trả về đối tượng đồ uống dựa trên ID.
	 * 
	 * @param id ID của đối tượng đồ uống cần tìm kiếm
	 * @return đối tượng đồ uống tìm thấy hoặc null nếu không tìm thấy
	 */
	Drink findById(Integer id);

	/**
	 * Trả về danh sách tất cả các đối tượng đồ uống.
	 * 
	 * @return danh sách tất cả các đối tượng đồ uống
	 */
	List<Drink> findAll();

	/**
	 * Trả về một trang các đối tượng đồ uống.
	 * 
	 * @param pageable thông tin về trang và kích thước trang
	 * @return trang các đối tượng đồ uống
	 */
	Page<Drink> findAll(Pageable pageable);

	/**
	 * Trả về danh sách tất cả các đối tượng đồ uống được sắp xếp.
	 * 
	 * @param sort thông tin về cách sắp xếp
	 * @return danh sách tất cả các đối tượng đồ uống được sắp xếp
	 */
	List<Drink> findAll(Sort sort);

	/**
	 * Lưu một đối tượng đồ uống.
	 * 
	 * @param entity đối tượng đồ uống cần lưu
	 * @return đối tượng đồ uống đã được lưu
	 */
	Drink save(Drink entity);

	/**
	 * Tìm kiếm và trả về danh sách các đối tượng đồ uống dựa trên danh mục.
	 * 
	 * @param category danh mục đồ uống
	 * @return danh sách các đối tượng đồ uống thuộc danh mục đã cho
	 */
	List<Drink> findByCategory(Category category);

	/**
	 * Tìm kiếm và trả về danh sách các đối tượng đồ uống liên quan dựa trên danh
	 * mục, ID, trạng thái và giới hạn.
	 * 
	 * @param category danh mục đồ uống
	 * @param id       ID của đồ uống hiện tại
	 * @param active   trạng thái hoạt động của đồ uống
	 * @param limit    giới hạn số lượng đồ uống trả về
	 * @return danh sách các đối tượng đồ uống liên quan
	 */
	List<Drink> findRelatedDrink(Category category, Integer id, Boolean active, Limit limit);

	/**
	 * Tìm kiếm và trả về danh sách các đối tượng đồ uống nhiều hơn dựa trên giới
	 * hạn.
	 * 
	 * @param limit giới hạn số lượng đồ uống trả về
	 * @return danh sách các đối tượng đồ uống nhiều hơn
	 */
	List<Drink> findMore(Limit limit);

	/**
	 * Tìm kiếm và trả về danh sách các đối tượng đồ uống dựa trên danh mục và trạng
	 * thái hoạt động.
	 * 
	 * @param category danh mục đồ uống
	 * @param active   trạng thái hoạt động của đồ uống
	 * @return danh sách các đối tượng đồ uống thuộc danh mục và trạng thái hoạt
	 *         động đã cho
	 */
	List<Drink> findByCategoryAndActive(Category category, Boolean active);

	/**
	 * Tìm kiếm và trả về danh sách các đối tượng đồ uống dựa trên trạng thái hoạt
	 * động và giới hạn.
	 * 
	 * @param active trạng thái hoạt động của đồ uống
	 * @param limit  giới hạn số lượng đồ uống trả về
	 * @return danh sách các đối tượng đồ uống dựa trên trạng thái hoạt động và giới
	 *         hạn
	 */
	List<Drink> findAllByActive(Boolean active, Limit limit);

	/**
	 * Tìm kiếm và trả về một trang các đối tượng đồ uống dựa trên từ khóa.
	 * 
	 * @param keyword  từ khóa tìm kiếm
	 * @param pageable thông tin về trang và kích thước trang
	 * @return trang các đối tượng đồ uống dựa trên từ khóa
	 */
	Page<Drink> searchByKeyword(String keyword, Pageable pageable);
}
