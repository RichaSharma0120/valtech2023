package com.valtech.training.spring.dao;

import java.util.List;

import com.valtech.training.hibernate.Employee;



public interface EmployeeDAO {

	// methods that we might need
	Employee saveEmployee(Employee e);

	Employee updateEmployee(Employee emp);

	Employee loadEmployee(int empId);

	void deleteEmployee(int empId);

	List<Employee> getAllEmployees();

}