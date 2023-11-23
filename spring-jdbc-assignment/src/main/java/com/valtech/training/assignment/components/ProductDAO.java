package com.valtech.training.assignment.components;



public interface ProductDAO {
	
	void addProduct(Product product);
	void updateProduct(Product product,int pId);
	void deleteProduct(int pId);
	int countProduct();
	void getById(int pId);

}
