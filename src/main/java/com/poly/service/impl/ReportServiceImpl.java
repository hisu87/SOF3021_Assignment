package com.poly.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.poly.dao.ReportDAO;
import com.poly.entity.Report;
import com.poly.service.ReportService;

/**
 * Lớp ReportServiceImpl là một implementation của interface ReportService.
 * Đây là lớp dùng để thực hiện các phương thức của ReportService.
 */
@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	ReportDAO reportDAO;

	/**
	 * Phương thức này được sử dụng để lấy danh sách các báo cáo theo trang.
	 *
	 * @param pageable thông tin về trang và kích thước trang
	 * @return danh sách các báo cáo theo trang
	 */
	@Override
	public Page<Report> findAll(Pageable pageable) {
		return reportDAO.findAll(pageable);
	}

	/**
	 * Phương thức này được sử dụng để lấy danh sách các báo cáo theo ngày.
	 *
	 * @param day      ngày cần tìm kiếm
	 * @param pageable thông tin về trang và kích thước trang
	 * @return danh sách các báo cáo theo ngày và trang
	 */
	@Override
	public Page<Report> findByDay(String day, Pageable pageable) {
		return reportDAO.findByDay(day, pageable);
	}

	/**
	 * Phương thức này được sử dụng để lấy danh sách các báo cáo theo tháng.
	 *
	 * @param month    tháng cần tìm kiếm
	 * @param pageable thông tin về trang và kích thước trang
	 * @return danh sách các báo cáo theo tháng và trang
	 */
	@Override
	public Page<Report> findByMonth(String month, Pageable pageable) {
		return reportDAO.findByMonth(month, pageable);
	}

	/**
	 * Phương thức này được sử dụng để lấy danh sách các báo cáo theo năm.
	 *
	 * @param year     năm cần tìm kiếm
	 * @param pageable thông tin về trang và kích thước trang
	 * @return danh sách các báo cáo theo năm và trang
	 */
	@Override
	public Page<Report> findByYear(String year, Pageable pageable) {
		return reportDAO.findByYear(year, pageable);
	}

	/**
	 * Phương thức này được sử dụng để lấy danh sách các báo cáo theo tháng và năm.
	 *
	 * @param month    tháng cần tìm kiếm
	 * @param year     năm cần tìm kiếm
	 * @param pageable thông tin về trang và kích thước trang
	 * @return danh sách các báo cáo theo tháng, năm và trang
	 */
	public Page<Report> findByDrink(Pageable pageable) {
		return reportDAO.findByDrink(pageable);
	}

	@Override
	public Page<Report> findByDayAndMonthAndYear(String day, String month, String year, Pageable pageable) {
		return reportDAO.findByDayAndMonthAndYear(day, month, year, pageable);
	}

	@Override
	public Page<Report> findByMonthAndYear(String month, String year, Pageable pageable) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findByMonthAndYear'");
	}

	@Override
	public Page<Report> findByDrink(LocalDate fromDate, LocalDate toDate, Pageable pageable) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findByDrink'");
	}
}