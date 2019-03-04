package com.poc.secureapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.secureapp.entities.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	 User findByUsername(String username);
}
