package com.poly.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.poly.entity.Report;

public interface ReportService {
	Page<Report> findAll(Pageable pageable);
	Page<Report> findByDay(String day, Pageable pageable);
	Page<Report> findByMonth(String month, Pageable pageable);
	Page<Report> findByYear(String year, Pageable pageable);
	Page<Report> findByMonthAndYear(String month, String year, Pageable pageable);
	Page<Report> findByDayAndMonthAndYear(String day, String month, String year, Pageable pageable);
	Page<Report> findByDrink(Pageable pageable);
	Page<Report> findByDrink(LocalDate fromDate, LocalDate toDate, Pageable pageable);
}