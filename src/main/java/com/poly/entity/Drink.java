package com.poly.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
@Table(name = "drinks")
public class Drink implements Serializable  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "nvarchar(255)")
	@NotEmpty(message = "{NotEmpty.drink.name}")
	private String name;
	
	@Positive(message = "{Positive.drink.price}")
	@NotNull(message = "{NotEmpty.drink.price}")
	private Double price;
	
	@NotNull(message = "{NotNull.drink.active}")
	private Boolean active = true;
	
	@Column(columnDefinition = "nvarchar(MAX)")
	@NotEmpty(message = "{NotEmpty.drink.description}")
	private String description;
	
	@Column(name = "drink_image")
	private String drinkImage;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@JsonIgnore
	@OneToMany(mappedBy = "drink")
	private List<DrinkSize> drinkSizes;
	
	@JsonIgnore
	@OneToMany(mappedBy = "drink")
	private List<DrinkTopping> drinkToppings;

}
