package com.valtech.training.assignment.components;



public class Company {
	
	private int c_id;
	private String name;
	private String street;
	private String town;
	private String state;
	private int zipcode;
	
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(int c_id, String name, String street, String town, String state, int zipcode) {
		super();
		this.c_id = c_id;
		this.name = name;
		this.street = street;
		this.town = town;
		this.state = state;
		this.zipcode = zipcode;
	}

	public Company(String name, String street, String town, String state, int zipcode) {
		super();
		this.name = name;
		this.street = street;
		this.town = town;
		this.state = state;
		this.zipcode = zipcode;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	

}
