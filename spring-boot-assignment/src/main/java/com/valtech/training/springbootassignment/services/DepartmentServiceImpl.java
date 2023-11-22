package com.valtech.training.springbootassignment.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.springbootassignment.entities.Department;
import com.valtech.training.springbootassignment.repositories.DepartmentRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class DepartmentServiceImpl implements DepartmentService{
	
	
	@Autowired
	private DepartmentRepository departmentRepo;
	
	@PostConstruct
	public void populateDepartment() {
		departmentRepo.save(new Department(1, "IT dept","Bangalore"));
		departmentRepo.save(new Department(2, "Finanace","Texas"));
		departmentRepo.save(new Department(3, "Marketing","California"));
		departmentRepo.save(new Department(4, "Production","L.A"));
	}

	
	
	@Override
	public Department createDepartment(Department department) {
		System.out.println("creating department");
		return departmentRepo.save(department);
	}
	
	@Override
	public Department updatDepartment(Department department) {
		System.out.println("updating department");
		return departmentRepo.save(department);
	}

	@Override
	public Department getDepartment(int deptId) {
		System.out.println("getting department");
		return departmentRepo.getReferenceById(deptId);
	}

	@Override
	public Department getFirstDepartment() {
		System.out.println("getting first department");
		return departmentRepo.findTopByOrderById();
	}

	@Override
	public Department getLastDepartment() {
		System.out.println("getting last department");
		return departmentRepo.findTopByOrderByIdDesc();
	}
	
	@Override
	public List<Department> getAllDepartments() {
		System.out.println("getting all departments");
		return departmentRepo.findAll();
	}
}
