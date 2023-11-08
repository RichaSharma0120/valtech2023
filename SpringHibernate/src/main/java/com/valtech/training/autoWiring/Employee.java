package com.valtech.training.autoWiring;

public class Employee {
	
	private int id;
	private EmpDetails empDetails;
	
	public EmpDetails getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(EmpDetails empDetails) {
		this.empDetails = empDetails;
	}

	public Employee() {
	}
	
	public Employee(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empDetails=" + empDetails + "]";
	}
	

}
