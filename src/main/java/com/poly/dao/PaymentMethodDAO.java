package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.PaymentMethod;

public interface PaymentMethodDAO extends JpaRepository<PaymentMethod, Integer> {

}
