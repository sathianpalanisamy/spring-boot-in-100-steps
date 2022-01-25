package com.learning.springboot.web.springbootfirstwebapplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

		authenticationManagerBuilder.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
				.withUser("sathian").password("pass").roles("USER", "ADMIN");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
		http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/", "/*toto*/**")
				.access("hasRole('USER')").and().formLogin();
		http.httpBasic();
	}

}
