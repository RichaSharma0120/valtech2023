package com.valtech.training.autoWiring;

public class EmpDetails {
	
	private String city;
	private String country;
	
	public EmpDetails() {
	}
	
	public EmpDetails(String city, String country) {
		this.city = city;
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "EmpDetails [city=" + city + ", country=" + country + "]";
	}
	
	

}
