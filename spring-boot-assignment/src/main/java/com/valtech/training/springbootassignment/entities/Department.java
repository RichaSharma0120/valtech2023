package com.valtech.training.springbootassignment.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "deptName")
	private String deptName;
	@Column(name = "deptLoc")
	private String deptLoc;

	@OneToMany(targetEntity = Employee.class, cascade = { CascadeType.MERGE,
			CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "department")
	private Set<Employee> employees;

	

	public Department() {
	}

	public Department(int id, String deptName, String deptLoc, Set<Employee> employees) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
		this.employees = employees;
	}

	
	public Department(int id, String deptName, String deptLoc) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
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
