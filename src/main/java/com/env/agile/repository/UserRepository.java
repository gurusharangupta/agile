package com.env.agile.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.env.agile.model.Role;
import com.env.agile.model.User;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long>, CustomizedUserRepository {
	UserDetails findOneByUsername(String username);
}
