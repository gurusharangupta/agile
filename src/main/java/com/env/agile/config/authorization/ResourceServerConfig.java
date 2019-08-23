package com.env.agile.config.authorization;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
private static final String RESOURCE_ID = "resource_id";

@Autowired
private DataSource dataSource;
 
/*@Autowired
private CustomUserDetailsService userDetailsService;


@Autowired
public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService)
            .passwordEncoder(encoder());
}
*/
@Override
public void configure(HttpSecurity http) throws Exception {
    http
    		
            .csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll()     
        	.antMatchers("/projects/**").authenticated()
        	.and().headers().frameOptions().sameOrigin();
   
}

@Bean
public TokenStore tokenStore() {
	return new JdbcTokenStore(dataSource);
}

@Bean
public BCryptPasswordEncoder encoder(){
    return new BCryptPasswordEncoder();
}

}
