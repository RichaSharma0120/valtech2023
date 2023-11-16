package com.valtech.training.firstspringboot.components;

public class SimpleInterestImpl implements SimpleInterest {
	private Arithmetic arithmetic;

	public SimpleInterestImpl(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}
	
	public void setArithmetic(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}

	@Override
	public double computeInterest(int principle, int roi, int duration) {
		
		int result = arithmetic.mul(principle, roi);
		result = arithmetic.sub(result, result);
		return arithmetic.div(result, 100);
	}
	
	public static void main(String[] args) {
		Arithmetic arithmetic = new ArithmeticImpl();
		SimpleInterest si = new SimpleInterestImpl(arithmetic);
		System.out.println(si.computeInterest(200, 3, 4));
	}

}
