package com.bank.mts.web;

import org.springframework.stereotype.Component;

@Component
public class TxrResponse {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
