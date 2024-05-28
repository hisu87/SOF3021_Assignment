package com.poly.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double totalPrice;

	private Integer totalItems;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private User user;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
	private Set<CartItem> cartItems;

	public ShoppingCart() {
		this.cartItems = new HashSet<>();
		this.totalItems = 0;
		this.totalPrice = 0.0;
	}

	@Override
	public String toString() {
		return "ShoppingCart{" + "id=" + id + ", customer=" + user.getName() + ", totalPrice=" + totalPrice
				+ ", totalItems=" + totalItems + ", cartItems=" + cartItems.size() + '}';
	}
}
