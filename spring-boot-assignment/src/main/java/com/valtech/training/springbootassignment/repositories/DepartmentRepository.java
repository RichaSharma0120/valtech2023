package com.valtech.training.springbootassignment.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.springbootassignment.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{ 
	
	// jdbc repository query
	@Query(value = "SELECT * FROM Department ORDER BY id DESC LIMIT 1")
	Department findTopByOrderByIdDesc();
	
	@Query(value = "SELECT * FROM Department ORDER BY id LIMIT 1")
	Department findTopByOrderById();

}
