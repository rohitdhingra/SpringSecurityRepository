package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("rohit").password("{noop}test").roles("USER").and()
			.withUser("demo").password("{noop}test2").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//		.antMatchers("*/hello").hasRole("USER")
		.anyRequest()
		.fullyAuthenticated()
//		.permitAll()
		.and()
//		.addFilterBefore(customFilter(), BasicAuthenticationFilter.class)
		.httpBasic();
		http.csrf().disable();
	}

	@Bean
	public CustomFilter customFilter() {
		// TODO Auto-generated method stub
		return new CustomFilter();
	}
	
	

}
