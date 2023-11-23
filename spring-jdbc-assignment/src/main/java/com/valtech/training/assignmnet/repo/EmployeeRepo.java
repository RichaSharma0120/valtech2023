package com.valtech.training.assignmnet.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.assignment.entity.Employee;

@Repository 
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
	
}
