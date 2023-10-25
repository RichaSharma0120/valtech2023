package com.valtech.training.day1;

import java.io.Serializable;

// serializable is useed to convert objects into bytes
// this is used in the file SerialTest.java

public class Point implements Comparable<Point>, Serializable{
	
	
	public static final Point ORIGIN = new Point();

	public int x;
	//public int y;
	
	public transient int y = 28;
	
	public Point() 
	{
		System.out.println("Point const - no param");
	}
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
		System.out.println("Point const - 2 param");
	}
	
	//------------------- this is the compareTo method
	
	@Override
	public int compareTo(Point o) {
		
		return (x - o.x) == 0 ? y-o.y : x - o.x;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Point p = (Point) obj;
		return p.x == x && p.y==y;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return toString().hashCode();
	}
	
	@Override
	public String toString() {
		return "X = " + x + "Y = " + y + "Distance = " + distance();
	}
	
	public double distance(Point p) {
		System.out.println("point tostring");
		System.out.println("Point -- distance method - Point param");
		return p.x + p.y;
		
	}
	
	public double distance() {
		System.out.println("Point -- distance method - no param");
		return Math.sqrt(x*x + y*y);
	}
	
	public static void main(String[] args) {
		Point p = new Point();
		p.x = 10;
		p.y = 20;
		System.out.println(p);
	}
	
}
