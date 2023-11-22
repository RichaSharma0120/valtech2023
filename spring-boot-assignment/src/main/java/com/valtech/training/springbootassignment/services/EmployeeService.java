package com.valtech.training.springbootassignment.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.valtech.training.springbootassignment.entities.Employee;

public interface EmployeeService {
	
	Employee createEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	void deleteEmployee(int id);
	Employee getEmployee(int id);
	List<Employee> getAllEmployees();
	

}
