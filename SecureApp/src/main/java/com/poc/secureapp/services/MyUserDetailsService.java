package com.poc.secureapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.poc.secureapp.entities.User;
import com.poc.secureapp.entities.UserPrincipal;
import com.poc.secureapp.repositories.UserRepository;
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = userRepo.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User 404");
		}
		
		return new UserPrincipal(user);
	}

}
