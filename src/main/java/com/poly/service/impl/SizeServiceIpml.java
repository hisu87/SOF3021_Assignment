package com.poly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.SizeDAO;
import com.poly.service.SizeService;

@Service
public class SizeServiceIpml implements SizeService{
	@Autowired
	SizeDAO sizeDAO;
}
