package com.valtech.training.springbootassignment.models;

import com.valtech.training.springbootassignment.entities.Department;
import com.valtech.training.springbootassignment.entities.Employee;

public class EmployeeModel {
	
	private int id;
	private int seniority;
	private int experience;
	private String name;
	private int age;
	private double salary;
	private Department department;
	
	public EmployeeModel() {
	}


	public EmployeeModel(Employee e) {
		this.id = e.getId();
		this.seniority = e.getSeniority();
		this.experience = e.getExperience();
		this.name = e.getName();
		this.age = e.getAge();
		this.salary = e.getSalary();
		this.department = e.getDepartment();
	}
	
	public Employee getEmployee() {
		return new Employee(id, name,  age, seniority,  experience,    salary, department);
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSeniority() {
		return seniority;
	}
	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}

	
}
