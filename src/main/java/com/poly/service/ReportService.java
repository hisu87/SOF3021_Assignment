package com.poly.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.poly.entity.Report;

/**
 * Giao diện định nghĩa các phương thức để truy vấn và trả về dữ liệu báo cáo.
 */
public interface ReportService {
	/**
	 * Truy vấn và trả về danh sách báo cáo theo trang.
	 *
	 * @param pageable thông tin về trang và kích thước trang
	 * @return danh sách báo cáo theo trang
	 */
	Page<Report> findAll(Pageable pageable);

	/**
	 * Truy vấn và trả về danh sách báo cáo theo ngày và trang.
	 *
	 * @param day      ngày cần tìm kiếm
	 * @param pageable thông tin về trang và kích thước trang
	 * @return danh sách báo cáo theo ngày và trang
	 */
	Page<Report> findByDay(String day, Pageable pageable);

	/**
	 * Truy vấn và trả về danh sách báo cáo theo tháng và trang.
	 *
	 * @param month    tháng cần tìm kiếm
	 * @param pageable thông tin về trang và kích thước trang
	 * @return danh sách báo cáo theo tháng và trang
	 */
	Page<Report> findByMonth(String month, Pageable pageable);

	/**
	 * Truy vấn và trả về danh sách báo cáo theo năm và trang.
	 *
	 * @param year     năm cần tìm kiếm
	 * @param pageable thông tin về trang và kích thước trang
	 * @return danh sách báo cáo theo năm và trang
	 */
	Page<Report> findByYear(String year, Pageable pageable);

	/**
	 * Truy vấn và trả về danh sách báo cáo theo tháng, năm và trang.
	 *
	 * @param month    tháng cần tìm kiếm
	 * @param year     năm cần tìm kiếm
	 * @param pageable thông tin về trang và kích thước trang
	 * @return danh sách báo cáo theo tháng, năm và trang
	 */
	Page<Report> findByMonthAndYear(String month, String year, Pageable pageable);

	/**
	 * Truy vấn và trả về danh sách báo cáo theo ngày, tháng, năm và trang.
	 *
	 * @param day      ngày cần tìm kiếm
	 * @param month    tháng cần tìm kiếm
	 * @param year     năm cần tìm kiếm
	 * @param pageable thông tin về trang và kích thước trang
	 * @return danh sách báo cáo theo ngày, tháng, năm và trang
	 */
	Page<Report> findByDayAndMonthAndYear(String day, String month, String year, Pageable pageable);

	/**
	 * Truy vấn và trả về danh sách báo cáo theo ngày và trang.
	 *
	 * @param fromDate ngày bắt đầu cần tìm kiếm
	 * @param toDate   ngày kết thúc cần tìm kiếm
	 * @param pageable thông tin về trang và kích thước trang
	 * @return danh sách báo cáo theo ngày và trang
	 */
	Page<Report> findByDrink(LocalDate fromDate, LocalDate toDate, Pageable pageable);
	Page<Report> findByDrink(Pageable pageable);
}