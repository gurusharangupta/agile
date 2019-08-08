package com.env.agile.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.env.agile.model.Role;
import com.env.agile.model.User;
import com.env.agile.model.UserToken;
import com.env.agile.repository.UserRepository;
import com.env.agile.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User userLogin(User registerUser) {

		return this.userRepository.login(registerUser);
	}

	@Override
	public UserToken signup(User registerUser) {
		Role role = new Role();
		role = this.userRepository.getRoleByName("ROLE_CLIENT");
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		User user = this.userRepository.findUserByEmail(registerUser.getUsername());
		UserToken _token = new UserToken();
		if (user == null) {
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
		}else{
			_token.setEmail(null);
		}
		return _token;

	}
}
