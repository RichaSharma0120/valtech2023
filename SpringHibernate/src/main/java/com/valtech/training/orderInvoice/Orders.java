package com.valtech.training.orderInvoice;

import java.util.Date;

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
	private OrderDescription orderDesc;
	
	@ManyToOne(targetEntity = Customers.class, cascade = {CascadeType.MERGE, CascadeType.REMOVE}, 
			fetch = FetchType.LAZY)
	private Customers customers;

	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}
