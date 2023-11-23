package com.valtech.training.assignmnet.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.assignment.entity.Employee;
import com.valtech.training.assignmnet.repo.EmployeeRepo;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@PostConstruct
	public void populateEmployee() {
		
		Employee emp = new Employee("kartik",1,2,4000);
		employeeRepo.save(emp);
	}
	
	@Override
	public Employee createEmployee(Employee emp) {

		return employeeRepo.save(emp);	
	}

//	@Override
//	public void updateEmployee(int id, Employee emp) {
//		// TODO Auto-generated method stub
////		employeeRepo.sa
//		
//	}
//
//	@Override
//	public void deleteEmployee(int id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Employee getEmployee(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Employee> getAllEmployee() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
  