package com.example.isakusmitsch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.isakusmitsch.entities.Employee;
import com.example.isakusmitsch.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Employee findEmployeeByid(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee.orElse(null);	
	}
	
	public List<Employee> findAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public Employee saveEmployees(Employee employee) {
		return employeeRepository.save(employee);
	}
}
