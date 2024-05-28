//package com.poly.interceptor;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class AuthInterConfig implements WebMvcConfigurer {
//	@Autowired
//	AuthInterceptor authInterceptor;
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(authInterceptor).addPathPatterns("/account/**", "/admin/**", "/cart/**", "/order/**")
//				.excludePathPatterns("/assets/**", "/account/login", "/account/register");
//	}
//}
