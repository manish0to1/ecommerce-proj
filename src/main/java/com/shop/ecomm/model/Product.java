package com.shop.ecomm.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;

	private String description;

	private int price;

	@Column(name = "discounted_price")
	private int discountedPrice;

	@Column(name = "discount_persent")
	private int discountPersent;

	private int quantity;

	private String brand;

	private String color;

	private Set<Size> size = new HashSet<>();

}
