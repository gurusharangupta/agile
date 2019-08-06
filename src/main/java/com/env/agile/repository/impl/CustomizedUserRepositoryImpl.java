package com.env.agile.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.env.agile.model.Role;
import com.env.agile.model.User;
import com.env.agile.repository.CustomizedUserRepository;

public class CustomizedUserRepositoryImpl implements CustomizedUserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User findUserByEmail(String email) {
		Query query = entityManager.createQuery("from User where username like :username");
		query.setParameter("username", email);

		if (query.getResultList().size() != 0) {
			return (User) query.getResultList().get(0);
		} else {
			return null;
		}
	}

	@Override
	public User login(User user) {
		Query query = entityManager.createQuery("from User where email= :email and password=:password");
		query.setParameter("email", user.getUsername());
		query.setParameter("password", user.getPassword());
		if (query.getResultList().size() != 0) {
			return (User) query.getResultList().get(0);
		} else {
			return null;
		}
	}

	@Override
	public Role getRoleByName(String name) {
		Query query = entityManager.createQuery("from Role where name= :name");
		query.setParameter("name", name);

		if (query.getResultList().size() != 0) {
			return (Role) query.getResultList().get(0);
		} else {
			return null;
		}
	}

	@Override
	public void saveUser(User user) {
		
		 entityManager.persist(user);
	}

}
