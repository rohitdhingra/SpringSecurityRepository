package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostConstruct
	public void initializeEmployeeTable() {
		employeeRepository.saveAll(
				Stream.of(new Employee("Rohit", 50000), new Employee("Rahul", 100000)).collect(Collectors.toList()));
	}

	public Employee getEmployee(int employeeId) {
		return employeeRepository.findById(employeeId).orElse(null);
	}

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
}
