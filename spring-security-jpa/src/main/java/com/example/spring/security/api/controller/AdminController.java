package com.example.spring.security.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.security.api.model.User;
import com.example.spring.security.api.repository.UserRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserRepository userRepo;
	
//	@Autowired
//	private BCryptPasswordEncoder encoder;
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/add")
	public String addUserByAdmin(@RequestBody User user)
	{
//		String passwd = user.getEncPassword();
//		String encPassword =encoder.encode(passwd);
//		user.setEncPassword(encPassword);
		userRepo.save(user);
		return "User Addded successfully";
	}
	
}
