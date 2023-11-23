package com.valtech.training.assignment.components;



public class Product {
	
	private int pId;
	private int unitPrice;
	private String description;
	private int companyId;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int pId, int unitPrice, String description, int companyId) {
		super();
		this.pId = pId;
		this.unitPrice = unitPrice;
		this.description = description;
		this.companyId = companyId;
	}

	public Product(int unitPrice, String description, int companyId) {
		super();
		this.unitPrice = unitPrice;
		this.description = description;
		this.companyId = companyId;
	}
	
	

	public Product(int unitPrice, String description) {
		super();
		this.unitPrice = unitPrice;
		this.description = description;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	
	

}
