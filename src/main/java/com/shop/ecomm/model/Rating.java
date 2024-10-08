package com.shop.ecomm.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@Column(name = "rating")
	private double rating;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	public Rating() {
		// Default constructor
	}

	public Rating(Long id, User user, Product product, double rating, LocalDateTime createdAt) {
		this.id = id;
		this.user = user;
		this.product = product;
		this.rating = rating;
		this.createdAt = createdAt;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}

// ####################### Original ######################### //
//package com.shop.ecomm.model;
//
//import java.time.LocalDateTime;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//
//@Entity
//public class Rating {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	@ManyToOne
//	@JoinColumn(name = "user_id", nullable = false)
//	private User user;
//
//	@JsonIgnore
//	@ManyToOne
//	@JoinColumn(name = "product_id", nullable = false)
//	private Product product;
//
//	@Column(name = "rating")
//	private double rating;
//
//	private LocalDateTime creatAt;
//
//	public Rating() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Rating(Long id, User user, Product product, double rating, LocalDateTime creatAt) {
//		super();
//		this.id = id;
//		this.user = user;
//		this.product = product;
//		this.rating = rating;
//		this.creatAt = creatAt;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//
//	public double getRating() {
//		return rating;
//	}
//
//	public void setRating(double rating) {
//		this.rating = rating;
//	}
//
//	public LocalDateTime getCreatAt() {
//		return creatAt;
//	}
//
//	public void setCreatAt(LocalDateTime creatAt) {
//		this.creatAt = creatAt;
//	}
//
//}
