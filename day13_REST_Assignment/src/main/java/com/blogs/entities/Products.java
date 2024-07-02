package com.blogs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "products")
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Products extends BaseEntity{
	
	@Column(name="product_name", length=20)
	private String name;
	
	@Column(name="product_price")
	private Double price;
	
	@Column(name="product_quantity")
	private int quantity;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private Categories category;

	public Products(String name, Double price, int quantity, Categories category) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}
	
	
}


