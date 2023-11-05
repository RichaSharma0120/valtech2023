package com.valtech.training.spring;

//can interface have main method??
//can interface have static method??

public class ArithmeticImpl implements Arithmetic{

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int sub(int a, int b) {
		return a - b;
	}

	@Override
	public int mul(int a, int b) {
		return a * b;
	}

	@Override
	public int div(int a, int b){
		return a / b;
	}
	
	public static void main(String[] args){
		Arithmetic a = new ArithmeticImpl();
		
	}
	
}
