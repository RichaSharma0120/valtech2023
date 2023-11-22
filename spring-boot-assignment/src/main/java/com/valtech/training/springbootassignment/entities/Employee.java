package com.valtech.training.springbootassignment.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int seniority;
	private int experience;
	private String name;
	private int age;
	private double salary;

	@ManyToOne(targetEntity = Department.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinColumn(name = "department", referencedColumnName = "id")
	private Department department;

	public Employee() {
	}
	
	public Employee(int id,String name, int age, int seniority, int experience,  double salary, Department department) {
		super();
		this.id = id;
		this.seniority = seniority;
		this.experience = experience;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.department = department;
	}
	

	public Employee(int id, int seniority, int experience, String name, int age, double salary) {
		super();
		this.id = id;
		this.seniority = seniority;
		this.experience = experience;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	


	public Employee(int seniority, int experience, String name, int age, double salary, Department department) {
		super();
		this.seniority = seniority;
		this.experience = experience;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.department = department;
	}


	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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

	public int getExperience() {
		return experience;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
