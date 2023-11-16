package com.valtech.training.orderInvoice;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customers {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cId;
	
	private String name;
	private String phone;
	private String email;
	
	@OneToOne(targetEntity = CustomerAddress.class, cascade = {CascadeType.MERGE,CascadeType.REMOVE}, 
			fetch = FetchType.LAZY, mappedBy = "customer")
	private CustomerAddress customerAddress;
	
	
	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public CustomerAddress getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

//	public Orders getOrder() {
//		return order;
//	}
//
//	public void setOrder(Orders order) {
//		this.order = order;
//	}

	public Customers(String name, String phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customers [cId=" + cId + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", customerAddress=" + customerAddress +  "]";
		// ", order=" + order +
	}
	
	
	
	

}
