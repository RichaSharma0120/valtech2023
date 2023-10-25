package com.valtech.training.day2;

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
	public int div(int a, int b) throws DivideByZeroException{
		
		if(b==0) {
			throw new DivideByZeroException("zero cant be used as denominator");
		}
		return a / b;
	}
	
	public static void main(String[] args){
		Arithmetic a = new ArithmeticImpl();
		System.out.println(a.add(2, 3));
		try {
			System.out.println(a.div(3, 0));			
		} catch (DivideByZeroException e) {
			System.out.println(e.getMessage());	
		}
		
		// the line after catch block will be executed
		System.out.println(a.mul(8, 2));
	}
	
}
