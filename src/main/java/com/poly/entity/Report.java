package com.poly.entity;

import java.time.Instant;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Report {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime createDate;
	private Long quantity;
	private Double totalPrice;
	private String drinkName;
	
	
	public Report(LocalDateTime createDate, Long quantity, Double totalPrice) {
		super();
		this.createDate = createDate;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	
	public Report(Integer year, Long quantity, Double totalPrice) {
		super();
		this.createDate = LocalDateTime.of(year, 1, 1, 0, 0);
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	
	public Report(String drinkName, Long quantity, Double totalPrice) {
		super();
		this.drinkName = drinkName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
}