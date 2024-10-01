package com.shop.ecomm.response;

public class ApiResponse {

	private String message;
	private boolean status;

	public ApiResponse() {
		super();
		// Auto-generated constructor stub
	}

	public ApiResponse(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean b) {
		this.status = b;
	}

}
