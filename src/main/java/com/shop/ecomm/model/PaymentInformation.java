package com.shop.ecomm.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PaymentInformation {

	@Column(name = "card_holder_name")
	private String cardHolderName;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "expiration_date")
	private LocalDate expirationDate;

	@Column(name = "cvv")
	private String cvv;

	// Default constructor
	public PaymentInformation() {
	}

	// Parameterized constructor
	public PaymentInformation(String cardHolderName, String cardNumber, LocalDate expirationDate, String cvv) {
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
	}

	// Getters and Setters
	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
}

// ################################ Original ############################# //

//package com.shop.ecomm.model;
//
//import java.time.LocalDate;
//
//import jakarta.persistence.Column;
//
//public class PaymentInformation {
//
//	@Column(name = "cardHolder_name")
//	private String cardHolderName;
//
//	@Column(name = "card_number")
//	private String cardNumber;
//
//	@Column(name = "expiration_date")
//	private LocalDate expirationDate;
//
//	@Column(name = "cvv")
//	private String cvv;
//}
