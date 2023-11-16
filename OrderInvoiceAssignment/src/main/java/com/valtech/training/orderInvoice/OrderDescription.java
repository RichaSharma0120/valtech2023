package com.valtech.training.orderInvoice;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@IdClass(CompositeKey.class)
@Table(name = "order_description")
public class OrderDescription {
	
	@Id
	private int orderDescId;
	
	private  int quantity;
	
//	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int orderDescriptionId;
	
	@ManyToOne(targetEntity = Orders.class, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE},
			fetch = FetchType.LAZY)
	private Orders orders;
	
	@ManyToOne(targetEntity = Items.class, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE},
			fetch = FetchType.LAZY)
	private Items items;

	public int getOrderDescId() {
		return orderDescId;
	}

	public void setOrderDescId(int orderDescId) {
		this.orderDescId = orderDescId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}



	public OrderDescription(int orderDescId, int quantity, Orders orders, Items items) {
		this.orderDescId = orderDescId;
		this.quantity = quantity;
		this.orders = orders;
		this.items = items;
	}

//	public OrderDescription() {
//	}
}
