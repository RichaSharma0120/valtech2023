package com.valtech.training.orderInvoice;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class VendorAddress {
	
	private String street;
	private String city;
	private String state;
	private int zipCode;
	
	@OneToOne(targetEntity = Vendors.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE},
			fetch = FetchType.EAGER)
	private Vendors vendor;

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public Vendors getVendor() {
		return vendor;
	}

	public void setVendor(Vendors vendor) {
		this.vendor = vendor;
	}

	public VendorAddress(String street, String city, String state, int zipCode, Vendors vendor) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.vendor = vendor;
	}

	public VendorAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
