package com.example.demo;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.service.EmployeeService;

@SpringBootApplication
@RestController
@RequestMapping("/employees")
public class SpringbootKeycloakExampleApplication {

	@Autowired
	private EmployeeService employeeService;
	
	
	//this method can be accessed by the user whose role is user
	@GetMapping("/{employeeId}")
	@RolesAllowed("user")
	public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId)
	{
		return ResponseEntity.ok(employeeService.getEmployee(employeeId));
	}
	
	
	//this method can be accessed by the user whose role is admin
	@GetMapping
	@RolesAllowed("admin")
	public ResponseEntity<List<Employee>> getEmployee()
	{
		return ResponseEntity.ok(employeeService.getAllEmployee());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootKeycloakExampleApplication.class, args);
	}

}
