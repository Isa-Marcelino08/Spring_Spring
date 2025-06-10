package com.example.isakusmitsch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isakusmitsch.entities.Employee;
import com.example.isakusmitsch.entities.Project;

public interface  EmployeeRepository extends JpaRepository<Employee, Long> {

}