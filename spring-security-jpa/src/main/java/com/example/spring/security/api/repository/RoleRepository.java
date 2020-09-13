package com.example.spring.security.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.security.api.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
