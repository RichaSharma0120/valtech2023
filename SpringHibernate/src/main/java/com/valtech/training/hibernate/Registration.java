package com.valtech.training.hibernate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registration {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private int mobile;
	// the user also has an address but we want this address to be returned as an address only.
	// so we have created another class called RegistrationAddress.java
	@Embedded
	private RegistrationAddress regAddress;
	// we the write cfg.addAnnotatedClass in hibernate.client
	
	
	public Registration() {
	}


	public Registration(String username, String password, int mobile, RegistrationAddress regAddress) {
		super();
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.regAddress = regAddress;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getMobile() {
		return mobile;
	}


	public void setMobile(int mobile) {
		this.mobile = mobile;
	}


	public RegistrationAddress getRegAddress() {
		return regAddress;
	}


	public void setRegAddress(RegistrationAddress regAddress) {
		this.regAddress = regAddress;
	}
	
	

}
