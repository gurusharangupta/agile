package com.env.agile;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.env.agile.exception.ResourceNotFoundException;
import com.env.agile.model.Role;
import com.env.agile.model.User;
import com.env.agile.model.UserToken;
import com.env.agile.repository.UserRepository;


@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/signup")
	@CrossOrigin(origins = "http://localhost:4200")
	public UserToken signup(@RequestBody User registerUser) throws ResourceNotFoundException {
		System.out.println("signup method");
		Role role = new Role();
		role = this.userRepository.getRoleByName("ROLE_CLIENT");
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		User user = this.userRepository.findUserByEmail(registerUser.getUsername());
		 UserToken _token = new UserToken();
		 if(user == null) {
			 PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String hashedPassword = passwordEncoder.encode(registerUser.getPassword());
			  user = new User();			 
			 user.setUsername(registerUser.getUsername());
			 user.setPassword(hashedPassword);
			 user.setRoles(roles);
			 user.setEnabled(true);
			 this.userRepository.saveUser(user);
			 _token.setEmail(registerUser.getUsername());
			 _token.setMessage("User has been signed up");
			 return _token;
		 }else {
			 throw new ResourceNotFoundException("EMAIL_EXISTS");
		 }
		
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public UserToken login(@RequestBody User registerUser) throws ResourceNotFoundException {
		User user = this.userRepository.login(registerUser);
		 UserToken _token = new UserToken();
		 if(user != null) {
			 _token.setEmail(registerUser.getUsername());
			 _token.setMessage("User login successful");
			
			 return _token;
		 }else {
			 throw new ResourceNotFoundException("INVALID_PASSWORD");
		 }
		
	}
	
	@GetMapping("/projects")
	@CrossOrigin(origins = "http://localhost:4200")
	public String projects() {
		
		return "Projects";
	}
	

}
