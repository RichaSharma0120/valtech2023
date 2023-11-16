package com.valtech.training.firstspringboot.components;


public interface Arithmetic {
	
	int ZERO = 0;
	
	// all methods in an interface are public
	//methods should not have a body
	//overloading is possible
	int add(int a, int b);
	int sub(int a, int b);
	int mul(int a, int b);
	int div(int a, int b);

	
}
