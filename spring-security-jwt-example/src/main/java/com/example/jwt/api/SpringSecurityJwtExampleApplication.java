package com.example.jwt.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jwt.api.entity.User;
import com.example.jwt.api.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityJwtExampleApplication {

@Autowired
private UserRepository userRepository;

	@PostConstruct
	public void initUsers()
	{
		List<User> users = Stream.of(new User(101,"rohit","password","er.rohit.dhingra@gmail.com"),
				new User(102,"rohit2","password2","er.rohit.dhingra2@gmail.com"),
				new User(103,"rohit3","password3","er.rohit.dhingra3@gmail.com"),
				new User(104,"rohit4","password4","er.rohit.dhingra4@gmail.com")
				).collect(Collectors.toList());
		
		userRepository.saveAll(users);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
	}

}
