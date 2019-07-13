package com.env.agile.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.env.agile.model.User;
import com.env.agile.repository.CustomizedUserRepository;

public class CustomizedUserRepositoryImpl implements CustomizedUserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User findUserByEmail(String email) {
		Query query = entityManager.createQuery("from User where email like :email");
		query.setParameter("email", email);

		if (query.getResultList().size() != 0) {
			return (User) query.getResultList().get(0);
		} else {
			return null;
		}
	}

	@Override
	public User login(User user) {
		Query query = entityManager.createQuery("from User where email= :email and password=:password");
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());

		if (query.getResultList().size() != 0) {
			return (User) query.getResultList().get(0);
		} else {
			return null;
		}
	}

}
