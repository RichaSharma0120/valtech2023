package com.valtech.training.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int experience;
	private int seniority;
	private int salary;
	
	public Employee() {
	}

	public Employee(int id, String name, int experience, int seniority, int salary) {
		this.id = id;
		this.name = name;
		this.experience = experience;
		this.seniority = seniority;
		this.salary = salary;
	}

	public Employee( String name, int experience, int seniority, int salary) {
		this.name = name;
		this.experience = experience;
		this.seniority = seniority;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getSeniority() {
		return seniority;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
 