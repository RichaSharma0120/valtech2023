package com.valtech.training.springbootassignment.services;

import java.util.List;

import com.valtech.training.springbootassignment.entities.Department;

public interface DepartmentService {

	Department createDepartment(Department department);

	Department updatDepartment(Department department);

	Department getDepartment(int deptId);

	Department getFirstDepartment();

	Department getLastDepartment();

	List<Department> getAllDepartments();

}