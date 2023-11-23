package com.valtech.training.assignment.components;



public class CustomerAddress {

	private int c_id;
	private String street;
	private String town;
	private String state;
	private int zipcode;
	
	public CustomerAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerAddress(int c_id, String street, String town, String state, int zipcode) {
		super();
		this.c_id = c_id;
		this.street = street;
		this.town = town;
		this.state = state;
		this.zipcode = zipcode;
	}

	public CustomerAddress(String street, String town, String state, int zipcode) {
		super();
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
