package com.valtech.training.day5;

public class AdderImpl implements Adder{

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}
	
	public static void main(String[] args) {
		Adder a = new AdderImpl();
		System.out.println(a.add(2,3));
		
		//another way to implement it is using anonymous class
		Adder a1 = new Adder() {

			@Override
			public int add(int a, int b) {
				// TODO Auto-generated method stub
				return a+b;
			}
			
		};
		
		//Lambda Expression
		Adder a2 = (i,j) -> {return i+j;};
		System.out.println(a2.add(4,5));
	}
	

}
