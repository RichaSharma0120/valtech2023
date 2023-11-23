package com.valtech.training.assignment.components;


public interface OrderItemDAO {
	
	void addOrderItems(OrderItems items);
	void updateOrderItems(OrderItems items,int itemId);
	void deleteOrderItems(int itemId );
	int countOrderItem();
	OrderItems getById(int itemId);
	

}
