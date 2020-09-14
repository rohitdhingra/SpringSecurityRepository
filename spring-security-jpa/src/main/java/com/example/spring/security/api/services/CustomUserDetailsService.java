package com.example.spring.security.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.spring.security.api.model.CustomUserDetails;
import com.example.spring.security.api.model.User;
import com.example.spring.security.api.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository UserRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = UserRepository.findByUserName(userName);
		CustomUserDetails customUserDetails = null;
		if(user!=null) {
			customUserDetails = new CustomUserDetails();
			customUserDetails.setUser(user);
		}else
		{
			throw new UsernameNotFoundException("User not existed with name"+userName);
		}
		return customUserDetails;
	}

}
