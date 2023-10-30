package com.valtech.training.day5;

//VarArgs are used to add any number of arguments

public class VarArgs {
	
	//varargs should be the last argument.
	// here we need atleast 1 argument(ie a), rest will be b
	
	public int add(int a, int ... b) {
		int result = a;
		for (int b1 : b) { //int b1 in b
			
			result += b1;
		}
		return result;
		}
	
	public static void main(String[] args) {
		
		VarArgs va = new VarArgs();
		System.out.println(va.add(2)); //a = 2
		System.out.println(va.add(2,3)); //a=2, b=1
		System.out.println(va.add(2,3,4)); //a=2, b1=3, b2=4
		System.out.println(va.add(2,3,4,5)); //a=2, b1=3, b2=4....
		
	}

}
