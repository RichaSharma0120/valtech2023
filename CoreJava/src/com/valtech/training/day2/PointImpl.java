package com.valtech.training.day2;

import com.valtech.training.day1.Point;

public class PointImpl implements PointNew{

	@Override
	public Point add(Point a, Point b) {
		int x = a.x + b.x;
		int y = a.y + b.y;
		Point p = new Point(x,y);
		return p;
	}

	@Override
	public Point sub(Point a, Point b) {
		int x = a.x - b.x;
		int y = a.y - b.y;
		Point p = new Point(x,y);
		return p;
	}

	@Override
	public double distance(Point a, Point b) {
		// TODO Auto-generated method stub
		return Math.sqrt(a.x*b.x + a.y*b.y);
	}
	
	public static void main(String[] args) {
		
		PointNew p = new PointImpl();
		Point a = new Point(10,20);
		Point b = new Point(10,20);
		Point p1 = p.add(a, b);
		System.out.println(p1);
		Point p2 = p.sub(a, b);
		System.out.println(p2);
		double dist = p.distance(a, b);
		System.out.println(dist);
		
	}

}
