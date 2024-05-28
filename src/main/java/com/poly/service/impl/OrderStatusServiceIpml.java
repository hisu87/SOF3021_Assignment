package com.poly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.OrderStatusDAO;
import com.poly.service.OrderStatusService;

@Service
public class OrderStatusServiceIpml implements OrderStatusService {
	@Autowired
	OrderStatusDAO orderStatusDAO;
}
