package com.env.agile.repository;

import com.env.agile.model.Role;
import com.env.agile.model.User;


public interface CustomUserRepository{

	public User findUserByEmail(String email);
	public User login(User user);
	public Role getRoleByName(String name);
	public void saveUser(User user);
}
