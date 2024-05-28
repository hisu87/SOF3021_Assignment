package com.poly.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "nvarchar(150)")
	@NotEmpty(message = "{NotEmpty.address.streetnumber}")
	private String streetnumber;
	
	@Column(columnDefinition = "nvarchar(150)")
	@NotEmpty(message = "{NotEmpty.address.ward}")
	private String ward;
	
	@Column(columnDefinition = "nvarchar(150)")
	@NotEmpty(message = "{NotEmpty.address.district}")
	private String district;
	
	@Column(columnDefinition = "nvarchar(150)")
	@NotEmpty(message = "{NotEmpty.address.province}")
	private String province;
	
	@JsonIgnore
	@OneToMany(mappedBy = "address")
	private List<UserAddress> userAddresses;
	
	@JsonIgnore
	@OneToMany(mappedBy = "address")
	private List<Order> orders;
}
