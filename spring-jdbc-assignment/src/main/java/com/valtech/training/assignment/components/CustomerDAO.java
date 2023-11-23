package com.valtech.training.assignment.components;

import java.util.List;

public interface CustomerDAO {
	
	Customer saveCustomer(Customer customer);
	Customer updateCustomer(Customer customer,int id);
	void deleteCustomer(int id);
	Customer getById(int id);
	long countCustomer();
	List<Customer> getAllCustomer();

}
