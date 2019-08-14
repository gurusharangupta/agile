package com.env.agile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.env.agile.exception.ResourceNotFoundException;
import com.env.agile.model.User;
import com.env.agile.model.UserToken;
import com.env.agile.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	@CrossOrigin(origins = "http://localhost:4200")
	public UserToken signup(@RequestBody User registerUser) throws ResourceNotFoundException {

		UserToken _token = userService.signup(registerUser);
		if (_token.getEmail() != null) {
			return _token;
		} else {
			throw new ResourceNotFoundException("EMAIL_EXISTS");
		}

	}

	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public UserToken login(@RequestBody User registerUser) throws ResourceNotFoundException {
		User user = userService.userLogin(registerUser);
		UserToken _token = new UserToken();
		if (user != null) {
			_token.setEmail(registerUser.getUsername());
			_token.setMessage("User login successful");

			return _token;
		} else {
			throw new ResourceNotFoundException("INVALID_PASSWORD");
		}

	}

}
