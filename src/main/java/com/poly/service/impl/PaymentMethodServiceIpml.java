package com.poly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.PaymentMethodDAO;
import com.poly.service.PaymentMethodService;

@Service
public class PaymentMethodServiceIpml implements PaymentMethodService {
	@Autowired
	PaymentMethodDAO paymentMethodDAO;
}
