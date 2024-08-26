package com.shop.ecomm.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Size {

	private String name;
	private int quantity;

	public Size() {
		// Default constructor
	}

	public Size(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Size{" + "name='" + name + '\'' + ", quantity=" + quantity + '}';
	}
}

// ############################### Original ######################### //
//package com.shop.ecomm.model;
//
//public class Size {
//
//	private String name;
//	private int quantity;
//
//	public Size() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
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
//}
