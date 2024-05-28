//package com.poly.interceptor;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class InterceptorConfig implements WebMvcConfigurer {
//	@Autowired
//	GlobalInterceptor global;
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(global)
//		.addPathPatterns("/**")
//		.excludePathPatterns("/assets/**");//ngoại trừ URI assets
//	}
//
//}