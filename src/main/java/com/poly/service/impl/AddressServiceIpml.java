package com.poly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.AddressDAO;
import com.poly.service.AddressService;

@Service
public class AddressServiceIpml implements AddressService {
	@Autowired
	AddressDAO addressDAO;

}
