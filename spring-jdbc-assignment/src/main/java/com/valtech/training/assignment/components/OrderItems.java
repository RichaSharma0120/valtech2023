package com.valtech.training.assignment.components;



public class OrderItems {
	private int itemId;
	private int orderId;
	private int quantity;
	private int productId;
	private double amount;

	OrderItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItems(int itemId, int orderId, int quantity, int productId, double amount) {
		super();
		this.itemId = itemId;
		this.orderId = orderId;
		this.quantity = quantity;
		this.productId = productId;
		this.amount = amount;
	}

	public OrderItems(int orderId, int quantity, int productId, double amount) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.productId = productId;
		this.amount = amount;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	

}
