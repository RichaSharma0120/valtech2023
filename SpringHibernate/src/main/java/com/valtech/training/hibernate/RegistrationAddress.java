package com.valtech.training.hibernate;

import javax.persistence.Embeddable;

@Embeddable // means it can be embeddded inside another entity
			// we then write @embedded inside Registration.java
public class RegistrationAddress {
	
	private String street;
	private String city;
	private String zipCode;
	
	
	public RegistrationAddress() {
	}
	
	public RegistrationAddress(String street, String city, String zipCode) {
		super();
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
