//package com.poly.interceptor;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import com.poly.entity.User;
//import com.poly.utils.SessionService;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Service
//public class AuthInterceptor implements HandlerInterceptor {
//
//	@Autowired
//	SessionService sessionService;
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//
//		String uri = request.getRequestURI();
//		User currentUser = sessionService.getAttribute("currentUser");
//		String error = "";
//
//		if (currentUser == null) { // chưa đăng nhập
//			error = "Please login!";
//		} else if (!currentUser.getAdmin() && uri.startsWith("/admin/")) {
//			error = "Access denied!";
//		}
//		
//		if (error.length() > 0) { // có lỗi
//			sessionService.setAttribute("security-uri", uri);
//			response.sendRedirect("/account/login?error=" + error);
//			return false;
//		}
//
//		return true;
//	}
//
//}
