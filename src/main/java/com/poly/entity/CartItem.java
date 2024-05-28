package com.poly.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart_items")
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "shopping_cart_id", referencedColumnName = "id")
	private ShoppingCart cart;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "drink_id", referencedColumnName = "id")
	private Drink drink;

	private Integer quantity;

	private Double unitPrice;

	@Override
	public String toString() {
		return "CartItem{" + "id=" + id + ", cart=" + cart.getId() + ", drink=" + drink.getName() + ", quantity="
				+ quantity + ", unitPrice=" + unitPrice + ", totalPrice=" + '}';
	}
}
