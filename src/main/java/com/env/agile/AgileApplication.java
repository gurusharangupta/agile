package com.env.agile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.env.agile.repository.UserRepository;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableJpaRepositories("com.env.agile.repository")
@ComponentScan({"com.env.agile"})
@EntityScan("com.env.agile.model")
public class AgileApplication {
	
	@Autowired
	private UserDetailsService customUserDetailsService;

	public static void main(String[] args) {
		SpringApplication.run(AgileApplication.class, args);
	}
	
/*	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repo) throws Exception {
		if(repo.count() == 0) {
			System.out.println("Not Zero Users");
		}
		builder.userDetailsService(customUserDetailsService);
			
		}*/
	}
