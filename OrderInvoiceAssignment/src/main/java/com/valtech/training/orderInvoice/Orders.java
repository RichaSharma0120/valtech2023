package com.valtech.training.orderInvoice;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private Date orderDate;
	
	@OneToMany(targetEntity = OrderDescription.class, cascade = {CascadeType.MERGE, CascadeType.REMOVE}, 
			fetch = FetchType.LAZY , mappedBy = "orders")
	private List<OrderDescription> orderDesc;
	
	@ManyToOne(targetEntity = Customers.class, cascade = {CascadeType.MERGE, CascadeType.REMOVE}, 
			fetch = FetchType.LAZY)
	private Customers customers;

	
	public Orders() {
	}

	public Orders(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	

	public List<OrderDescription> getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(List<OrderDescription> orderDesc) {
		this.orderDesc = orderDesc;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

}
