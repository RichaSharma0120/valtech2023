package com.valtech.training.orderInvoice;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(CompositeKey.class)
public class OrderDescription {
	
	@Id
	private int itemId;
	
	@Id
	private int orderId;
	
	private  int quantity;
	
	@ManyToOne(targetEntity = Orders.class, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE},
			fetch = FetchType.LAZY)
	private Orders orders;
	
	@ManyToOne(targetEntity = Items.class, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE},
			fetch = FetchType.LAZY)
	private Items items;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public OrderDescription( int orderId,Items items, int quantity) {
		this.orderId = orderId;
		this.items = items;
		this.quantity = quantity;
		
	}

	public OrderDescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderDescription [itemId=" + itemId + ", orderId=" + orderId + ", quantity=" + quantity + ", orders="
				+ orders + ", items=" + items + "]";
	}
	
	

}
