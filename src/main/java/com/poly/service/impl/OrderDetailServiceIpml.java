package com.poly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.OrderDetailDAO;
import com.poly.service.OrderDetailService;

@Service
public class OrderDetailServiceIpml implements OrderDetailService {
	@Autowired
	OrderDetailDAO orderDetailDAO;
}
