package com.valtech.training.assignment.components;

import java.util.List;

public interface CustomerOrderDAO {
	
	void createOrder(CustomerOrder customerOrder);
	CustomerOrder updateOrder(CustomerOrder customerOrder,int order_id);
	void deleteOrder(int order_id);
	CustomerOrder getById(int order_id);
	List<CustomerOrder> getAllOrder();
	
	int countOrder();

}
