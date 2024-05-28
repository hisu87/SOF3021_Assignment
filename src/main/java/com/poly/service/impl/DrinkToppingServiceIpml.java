package com.poly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.DrinkToppingDAO;
import com.poly.service.DrinkToppingService;

@Service
public class DrinkToppingServiceIpml implements DrinkToppingService {
	@Autowired
	DrinkToppingDAO drinkToppingDAO;
	
}
