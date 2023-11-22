package com.valtech.training.springbootassignment.services;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.springbootassignment.entities.Department;
import com.valtech.training.springbootassignment.entities.Employee;
import com.valtech.training.springbootassignment.repositories.DepartmentRepository;
import com.valtech.training.springbootassignment.repositories.EmployeeRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired 
	private DepartmentRepository departmentRepository;
	
	@PostConstruct
	private void populateEmployees() {
		Department department=departmentRepository.getReferenceById(1);
		
		employeeRepo.save(new Employee(1, "Raj", 30, 8, 10, 1300000,departmentRepository.getReferenceById(1)));
		employeeRepo.save(new Employee(2, "Anjali", 36, 9, 12, 12334456,departmentRepository.getReferenceById(2)));
		employeeRepo.save(new Employee(3, "Sarthak", 39, 10, 14, 1800000,departmentRepository.getReferenceById(3)));
		employeeRepo.save(new Employee(4, "Sana", 40, 15, 18, 2400000,departmentRepository.getReferenceById(4)));
	}
	
	
	@Override
	public void deleteEmployee(int id) {
		System.out.println("deleting employee");
		employeeRepo.deleteById(id);
	}

	@Override
	public Employee getEmployee(int id) {
		System.out.println("getting employee");
		return employeeRepo.getReferenceById(id);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		System.out.println("creating employee");
		return employeeRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		System.out.println("updating employee");
			return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		System.out.println("getting all employees");
		return employeeRepo.findAll();
	}
	

	}



