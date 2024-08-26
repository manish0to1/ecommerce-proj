package com.shop.ecomm.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

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

	@Embedded
	@ElementCollection
	@Column(name = "size")
	private Set<Size> size = new HashSet<>();

	@Column(name = "image_url")
	private String imageUrl;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Rating> ratings = new ArrayList<>();

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> reviews = new ArrayList<>();

	@Column(name = "num_rating")
	private int numRating;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	private LocalDateTime createdAt;

	public Product() {
		// Default constructor
	}

	public Product(Long id, String title, String description, int price, int discountedPrice, int discountPersent,
			int quantity, String brand, String color, Set<Size> size, String imageUrl, List<Rating> ratings,
			List<Review> reviews, int numRating, Category category, LocalDateTime createdAt) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.discountedPrice = discountedPrice;
		this.discountPersent = discountPersent;
		this.quantity = quantity;
		this.brand = brand;
		this.color = color;
		this.size = size;
		this.imageUrl = imageUrl;
		this.ratings = ratings;
		this.reviews = reviews;
		this.numRating = numRating;
		this.category = category;
		this.createdAt = createdAt;
	}

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(int discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public int getDiscountPersent() {
		return discountPersent;
	}

	public void setDiscountPersent(int discountPersent) {
		this.discountPersent = discountPersent;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Set<Size> getSize() {
		return size;
	}

	public void setSize(Set<Size> size) {
		this.size = size;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public int getNumRating() {
		return numRating;
	}

	public void setNumRating(int numRating) {
		this.numRating = numRating;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}

// ########################## Original ############################# //

//package com.shop.ecomm.model;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Locale.Category;
//import java.util.Set;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.ElementCollection;
//import jakarta.persistence.Embedded;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//
//@Entity
//public class Product {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//
//	private String title;
//
//	private String description;
//
//	private int price;
//
//	@Column(name = "discounted_price")
//	private int discountedPrice;
//
//	@Column(name = "discount_persent")
//	private int discountPersent;
//
//	private int quantity;
//
//	private String brand;
//
//	private String color;
//
//	@Embedded
//	@ElementCollection
//	@Column(name = "size")
//	private Set<Size> size = new HashSet<>();
//
//	@Column(name = "image_url")
//	private String imageUrl;
//
//	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Rating> ratings = new ArrayList<>();
//
//	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Review> reviews = new ArrayList<>();
//
//	@Column(name = "num_rating")
//	private int numRating;
//
//	@ManyToOne
//	@JoinColumn(name = "category_id")
//	private Category category;
//
//	private LocalDateTime createdAt;
//
//	public Product() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Product(Long id, String title, String description, int price, int discountedPrice, int discountPersent,
//			int quantity, String brand, String color, Set<Size> size, String imageUrl, List<Rating> ratings,
//			List<Review> reviews, int numRating, Category category, LocalDateTime createdAt) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.description = description;
//		this.price = price;
//		this.discountedPrice = discountedPrice;
//		this.discountPersent = discountPersent;
//		this.quantity = quantity;
//		this.brand = brand;
//		this.color = color;
//		this.size = size;
//		this.imageUrl = imageUrl;
//		this.ratings = ratings;
//		this.reviews = reviews;
//		this.numRating = numRating;
//		this.category = category;
//		this.createdAt = createdAt;
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
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public int getPrice() {
//		return price;
//	}
//
//	public void setPrice(int price) {
//		this.price = price;
//	}
//
//	public int getDiscountedPrice() {
//		return discountedPrice;
//	}
//
//	public void setDiscountedPrice(int discountedPrice) {
//		this.discountedPrice = discountedPrice;
//	}
//
//	public int getDiscountPersent() {
//		return discountPersent;
//	}
//
//	public void setDiscountPersent(int discountPersent) {
//		this.discountPersent = discountPersent;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//	public String getBrand() {
//		return brand;
//	}
//
//	public void setBrand(String brand) {
//		this.brand = brand;
//	}
//
//	public String getColor() {
//		return color;
//	}
//
//	public void setColor(String color) {
//		this.color = color;
//	}
//
//	public Set<Size> getSize() {
//		return size;
//	}
//
//	public void setSize(Set<Size> size) {
//		this.size = size;
//	}
//
//	public String getImageUrl() {
//		return imageUrl;
//	}
//
//	public void setImageUrl(String imageUrl) {
//		this.imageUrl = imageUrl;
//	}
//
//	public List<Rating> getRatings() {
//		return ratings;
//	}
//
//	public void setRatings(List<Rating> ratings) {
//		this.ratings = ratings;
//	}
//
//	public List<Review> getReviews() {
//		return reviews;
//	}
//
//	public void setReviews(List<Review> reviews) {
//		this.reviews = reviews;
//	}
//
//	public int getNumRating() {
//		return numRating;
//	}
//
//	public void setNumRating(int numRating) {
//		this.numRating = numRating;
//	}
//
//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}
//
//	public LocalDateTime getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(LocalDateTime createdAt) {
//		this.createdAt = createdAt;
//	}
//
//}
