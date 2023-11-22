package com.valtech.training.springbootassignment.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.springbootassignment.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{


}
