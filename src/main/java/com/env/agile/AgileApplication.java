package com.env.agile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableJpaRepositories("com.env.agile.repository")
@ComponentScan({"com.env.agile"})
@EntityScan("com.env.agile.model")
public class AgileApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgileApplication.class, args);
	}

}
