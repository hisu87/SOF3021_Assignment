package com.poly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.DrinkSizeDAO;
import com.poly.service.DrinkSizeService;

@Service
public class DrinkSizeServiceIpml implements DrinkSizeService{
	@Autowired
	DrinkSizeDAO drinkSizeDAO;
}
