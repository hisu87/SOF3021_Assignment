package com.poly.controller.admin;

import java.net.http.HttpRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Category;
import com.poly.entity.Report;
import com.poly.model.CreateDate;
import com.poly.service.CategoryService;
import com.poly.service.OrderService;
import com.poly.service.ReportService;
import com.poly.utils.ExcelService;
import com.poly.utils.SessionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class ReportController {
	
	@Autowired
	ReportService reportService;
	@Autowired
	OrderService orderService;
	@Autowired
	SessionService session;
	
	Pageable pageable = PageRequest.of(0, 10);
	
	@RequestMapping("/admin/report/index")
	public String index(Model model) {
		
		List<String> days = orderService.findDays();
		List<String> months = orderService.findMonths();
		List<String> years = orderService.findYears();
		
		model.addAttribute("days", days);
		model.addAttribute("months", months);
		model.addAttribute("years", years);
		
		return "admin/report-management";
	}
	
	@RequestMapping("/admin/report")
	public String get(Model model, @ModelAttribute("createDate") CreateDate cd) {
		//model.addAttribute("counts", reportService.findByDrink(fromDate, toDate, pageable));
		model.addAttribute("pages", reportService.findAll(pageable));
		model.addAttribute("printExcel", false);
		return "forward:/admin/report/index";
	}

	@PostMapping("/admin/report/search")
	public String search(Model model, HttpServletRequest request,
			@ModelAttribute("createDate") CreateDate createDate) {
		
		String day1 = createDate.getCreateDate1().getDay();
		String day2 = createDate.getCreateDate2().getDay();
		String month1 = createDate.getCreateDate1().getMonth();
		String month2 = createDate.getCreateDate2().getMonth();
		String year1 = createDate.getCreateDate1().getYear();
		String year2 = createDate.getCreateDate2().getYear();
		
		StringBuilder date = new StringBuilder();
		date.append(year1).append(" ").append(month1).append(" ").append(day1).toString();
		if (day1.equals("1") && month1.equals("1") && year1.equals("1") && day2.equals("1") && month2.equals("1") && year2.equals("1")) {
			model.addAttribute("pages", reportService.findAll(pageable));
			model.addAttribute("isDrink", false);
		} else if (!day2.equals("1") || !month2.equals("1") || !year2.equals("1")) {
			date.append(year2).append(" ").append(month2).append(" ").append(day2).toString();
			LocalDate fromDate = LocalDate.of(Integer.parseInt(year1), Integer.parseInt(month1), Integer.parseInt(day1));
			LocalDate toDate = LocalDate.of(Integer.parseInt(year2), Integer.parseInt(month2), Integer.parseInt(day2));
			model.addAttribute("pages", reportService.findByDrink(fromDate, toDate, pageable));
			model.addAttribute("isDrink", true);
		} else {
			if (!day1.equals("1") && !month1.equals("1") && !year1.equals("1"))
				model.addAttribute("pages", reportService.findByDayAndMonthAndYear(day1, month1, year1, pageable));
			else if (!month1.equals("1") && !year1.equals("1"))
				model.addAttribute("pages", reportService.findByMonthAndYear(month1, year1, pageable));
			else if (!year1.equals("1"))
				model.addAttribute("pages", reportService.findByYear(year1, pageable));
			else if (!month1.equals("1"))
				model.addAttribute("pages", reportService.findByMonth(month1, pageable));
			else if (!day1.equals("1"))
				model.addAttribute("pages", reportService.findByDay(day1, pageable));
			model.addAttribute("isDrink", false);
		}
		
		Page<Report> pages = (Page<Report>) model.getAttribute("pages");
		boolean isDrink = (boolean) model.getAttribute("isDrink");
		
		ExcelService.exportReportExcel(date.toString(), pages.getContent(), isDrink); 
		
		session.setAttribute("day1", day1);
		session.setAttribute("day2", day2);
		session.setAttribute("month1", month1);
		session.setAttribute("month2", month2);
		session.setAttribute("year1", year1);
		session.setAttribute("year2", year2);
		
		model.addAttribute("printExcel", true);
		return "forward:/admin/report/index";
	}
	
	@GetMapping("/admin/report/page")
	public String page(Model model, @ModelAttribute("createDate") CreateDate createDate,
			@RequestParam("p") Optional<Integer> p) {
		String day1 = session.getAttribute("day1");
		String day2 = session.getAttribute("day2");
		String month1 = session.getAttribute("month1");
		String month2 = session.getAttribute("month2");
		String year1 = session.getAttribute("year1");
		String year2 = session.getAttribute("year2");
		pageable = PageRequest.of(p.orElse(0), 10);
		
		if (day1 == null && month1 == null && year1 == null)
			model.addAttribute("pages", reportService.findAll(pageable));
		else if (day1.equals("1") && month1.equals("1") && year1.equals("1"))
			model.addAttribute("pages", reportService.findAll(pageable));
		else {
			if (!day1.equals("1") && !month1.equals("1") && !year1.equals("1"))
				model.addAttribute("pages", reportService.findByDayAndMonthAndYear(day1, month1, year1, pageable));
			else if (!month1.equals("1") && !year1.equals("1"))
				model.addAttribute("pages", reportService.findByMonthAndYear(month1, year1, pageable));
			else if (!year1.equals("1"))
				model.addAttribute("pages", reportService.findByYear(year1, pageable));
			else if (!month1.equals("1"))
				model.addAttribute("pages", reportService.findByMonth(month1, pageable));
			else if (!day1.equals("1"))
				model.addAttribute("pages", reportService.findByDay(day1, pageable));
		}
		
		return "forward:/admin/report/index";
	}
	
	@PostMapping("/admin/report/count")
	public String count(Model model, @RequestParam("isDrink") String isDrink, @ModelAttribute("createDate") CreateDate cd) {
		boolean count = isDrink.equals("true") ? false : true;
		model.addAttribute("isDrink", count);
		
		model.addAttribute("pages", (count ? reportService.findByDrink(pageable) 
											: reportService.findAll(pageable)));
		
		session.setAttribute("day", 1);
		session.setAttribute("month", 1);
		session.setAttribute("year", 1);
		return "forward:/admin/report/index";
	}
	
}