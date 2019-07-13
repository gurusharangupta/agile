package com.env.agile.model;

import java.util.UUID;

public class UserToken {

	private String email;

	private UUID _token;
	
	private String message;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UUID get_token() {
		return _token;
	}

	public void set_token(UUID _token) {
		this._token = _token;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
