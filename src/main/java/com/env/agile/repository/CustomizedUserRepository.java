package com.env.agile.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.env.agile.model.Role;
import com.env.agile.model.User;

@Repository
@Transactional
public interface CustomizedUserRepository{

	public User findUserByEmail(String email);
	public User login(User user);
	public Role getRoleByName(String name);
	public void saveUser(User user);
}
