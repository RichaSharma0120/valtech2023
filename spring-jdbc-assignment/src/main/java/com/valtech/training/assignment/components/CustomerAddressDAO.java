package com.valtech.training.assignment.components;

public interface CustomerAddressDAO {
	
	void setAddress(CustomerAddress address);
	void updateAddress(CustomerAddress address,int c_id);
	void deleteAddress(int c_id);
	
	int count();

}
