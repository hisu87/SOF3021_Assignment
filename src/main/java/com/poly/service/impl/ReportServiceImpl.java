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

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	ReportDAO reportDAO;
	
	@Override
	public Page<Report> findAll(Pageable pageable) {
		return reportDAO.findAll(pageable);
	}

	@Override
	public Page<Report> findByDay(String day, Pageable pageable) {
		return reportDAO.findByDay(day, pageable);
	}

	@Override
	public Page<Report> findByMonth(String month, Pageable pageable) {
		return reportDAO.findByMonth(month, pageable);
	}

	@Override
	public Page<Report> findByYear(String year, Pageable pageable) {
		return reportDAO.findByYear(year, pageable);
	}

	@Override
	public Page<Report> findByMonthAndYear(String month, String year, Pageable pageable) {
		return reportDAO.findByMonthAndYear(month, year, pageable);
	}

	@Override
	public Page<Report> findByDayAndMonthAndYear(String day, String month, String year, Pageable pageable) {
		return reportDAO.findByDayAndMonthAndYear(day, month, year, pageable);
	}
	
	@Override
	public Page<Report> findByDrink(Pageable pageable) {
		return reportDAO.findByDrink(pageable);
	}
	
	@Override
	public Page<Report> findByDrink(LocalDate fromDate, LocalDate toDate, Pageable pageable) {
		return reportDAO.findByDrink(fromDate, toDate, pageable);
	}
}