 package com.valtech.training.assignment.components;



public class Customer {
	private int c_id;
	private String c_name;
	private String phone;
	private String email;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String toString() {
		return "Customer [c_id=" + c_id + ", c_name=" + c_name + ", phone=" + phone + ", email=" + email + "]";
	}




	public Customer(int c_id, String c_name, String phone, String email) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.phone = phone;
		this.email = email;
	}

	



	public Customer(String string, String i, String string2) {
		this.c_name=string;
		this.phone=i;
		this.email=string2;

		// TODO Auto-generated constructor stub
	}



	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	} 
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
