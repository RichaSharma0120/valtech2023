package com.valtech.training.day2;

public class Outer {

	private int x;

	// this inner class is private. It wont be available outside the outer class
	// this is a method of return type Inner and it public. It returns an instance
	// of Inner class
	public Inner createInner() {
		return new Inner();
	}
	
	public class Inner {
		
		public void printX() {
			System.out.println("X = " + x);
		}

		public void increment() {
			x++;
		}
	}

	//INTERFACE
	public static interface abcd {
	}

	// STATIC CLASS only permitted for INNER CLASS
	// new StaticInner -> not possible because abstract
	public abstract static class StaticInner implements abcd {

		public void jumpBy10(Outer o) {
			o.x = o.x + 10;
		}

		public abstract void jumpBy100(Outer o);
	}



	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.Inner i = o.createInner();
		// this is another way of creating an object like we saw above.
		Outer.Inner i1 = o.createInner();
		System.out.println(i);
		System.out.println(i1);
		i1.increment();
		i.printX();

		// we are creating another object like object o
		// it will not get incremented
		new Outer().createInner().printX();

		
		StaticInner s1 = new StaticInner() {
			//ABSTRACT METHOD INSIDE STATICINNER
			@Override
			public void jumpBy100(Outer o) {
				// TODO Auto-generated method stub
				o.x = o.x + 100;
			}
		};
		s1.jumpBy10(o);
		s1.jumpBy100(o);
		i.printX();
		
		Arithmetic ar = new Arithmetic() {
			
			@Override
			public int sub(int a, int b) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int mul(int a, int b) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int div(int a, int b) throws DivideByZeroException {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int add(int a, int b) {
				// TODO Auto-generated method stub
				return 0;
			}
		};

	}
}
