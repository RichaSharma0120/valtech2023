package com.valtech.training.orderInvoice;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;


public class CompositeKey implements Serializable{
	
	@Id
	private int itemId;
	@Id
	private int orderId;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(itemId, orderId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeKey other = (CompositeKey) obj;
		return itemId == other.itemId && orderId == other.orderId;
	}
	
	
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
	public CompositeKey(int itemId, int orderId) {
		super();
		this.itemId = itemId;
		this.orderId = orderId;
	}
	public CompositeKey() {
	}
	
	

}
