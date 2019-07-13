package com.env.agile;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.env.agile.model.User;
import com.env.agile.model.UserToken;
import com.env.agile.repository.UserRepository;

@RestController

public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/signup")
	@CrossOrigin(origins = "http://localhost:4200")
	public UserToken signup(@RequestBody User registerUser) {
		System.out.println("signup method");
		User user = this.userRepository.findUserByEmail(registerUser.getEmail());
		 UserToken _token = new UserToken();
		 if(user == null) {
			  user = new User();			 
			 user.setEmail(registerUser.getEmail());
			 user.setActive(true);
			 user.setPassword(registerUser.getPassword());
			 this.userRepository.save(user);
			 _token.setEmail(registerUser.getEmail());
			 _token.set_token(UUID.randomUUID());
			 _token.setMessage("User has been signed up");
			 return _token;
		 }else {
			 _token.setEmail(registerUser.getEmail());
			 _token.set_token(null);
			 _token.setMessage("User already exists!");
			 return _token;
		 }
		
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public UserToken login(@RequestBody User registerUser) {
		System.out.println("login method");
		User user = this.userRepository.login(registerUser);
		 UserToken _token = new UserToken();
		 if(user != null) {
			 _token.setEmail(registerUser.getEmail());
			 _token.set_token(UUID.randomUUID());
			 _token.setMessage("User login successful");
			 return _token;
		 }else {
			 _token.setEmail(registerUser.getEmail());
			 _token.set_token(null);
			 _token.setMessage("No such user exists!");
			 return _token;
		 }
		
	}
	

}
