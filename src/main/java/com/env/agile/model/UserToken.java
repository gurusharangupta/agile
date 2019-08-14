package com.env.agile.model;

import org.springframework.http.ResponseEntity;

public class UserToken {

	private String email;
	
	private String message;
	
	private ResponseEntity<Object> response;
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseEntity<Object> getResponse() {
		return response;
	}

	public void setResponse(ResponseEntity<Object> response) {
		this.response = response;
	}


}
