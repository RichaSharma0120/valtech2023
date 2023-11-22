package com.valtech.training.springbootassignment.models;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.valtech.training.springbootassignment.entities.Department;
import com.valtech.training.springbootassignment.entities.Employee;

public class DepartmentModel {
	
	private int id;
	private String deptName;
	private String deptLoc;

	private Set<Employee> employees;


	

	public DepartmentModel() {
	}

	public DepartmentModel(int id, String deptName, String deptLoc, Set<Employee> employees) {
		this.id = id;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
		this.employees = employees;
	}

	public DepartmentModel(Department d) {
		this.id = d.getId();
		this.deptName = d.getDeptName();
		this.deptLoc = d.getDeptLoc();
		this.employees = d.getEmployees();
	}
	
	public Department getDepartment(Department department) {
		return new Department(id, deptName, deptLoc, employees);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public String getDeptLoc() {
		return deptLoc;
	}


	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}


	public Set<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}


}
