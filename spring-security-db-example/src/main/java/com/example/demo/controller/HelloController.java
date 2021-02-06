package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloController {

	@GetMapping("/all")
	public String hello()
	{
		return "Hello World!";
	}
	@PreAuthorize(value = "hasAnyRole('ADMIN')")
	@GetMapping("/secured/all")
	public String securedHello() {
		return "Hello To Secured World";
	}
	
	@GetMapping("/secured/alternate")
	public String alternate()
	{
		return "Hello to Secured Alternate"; 
	}
}
