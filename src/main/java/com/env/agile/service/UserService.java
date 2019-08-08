package com.env.agile.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.env.agile.model.User;
import com.env.agile.model.UserToken;


public interface UserService {

	public User userLogin(User user);
	public UserToken signup(User user);
}
