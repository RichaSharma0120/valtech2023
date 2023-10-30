// go to Point.java from training day 1 
// comment equals and hashcode methods 
package com.valtech.training.day2;

import com.valtech.training.day1.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class UtilsTest {
	
	//-----------stack-------------
	private static void testStack(Stack<Point> points) {
		//to add elements push is used
		points.push(new Point(2,3));
		points.push(new Point(2,4));
		points.push(new Point(2,3));
		points.push(new Point(2,5));
		//pop to remove elements from the tack
		System.out.println("Size = " + points.size());
		System.out.println(points.pop());
		System.out.println("Size = " + points.size());
		System.out.println(points.pop());
		System.out.println("Size = " + points.size());
	}
	
	private static void testMap(Map<String,Point> points) {
		//put method is used to add elements or objects
		points.put("2.3", new Point(2,3));
		points.put("2.3", new Point(2,3));
		points.put("3.2", new Point(2,3));
		points.put("2.4", new Point(2,3));
		// here the size of map will be 3 because the key for 2.3 is same. 
		//so instead of adding it twice it adds it only once
		// so only 3 objects are added here

	}
	
	//--------------LIST-----------
	
	public static void testList(List<Point> points) {
		Point p = new Point(2,3);
		Point p1 = new Point(2,3);
		points.add(p);
		points.add(p1);
		points.add(p);
		points.add(new Point(3,2));
		points.add(new Point(2,4));
		points.add(new Point(4,2));
		System.out.println("Size = "+ points.size());
		System.out.println(points);
	}
	
	// ---------------HASHSET-------------------
	
	public static void testHashSet() {
		Point p = new Point(2,3);
		Point p1 = new Point(2,3);
		Set<Point> points = new HashSet<>();
		points.add(p);
		points.add(p1);
		points.add(p);
		points.add(new Point(3,2));
		points.add(new Point(2,4));
		points.add(new Point(4,2));
		//when the hashcode and equals method in point.java are commented then the program will treat both p1 and p as separate objects
		// even though p and p1 are same, and since the equals method is commented it will add both p and p1 to the set
		// when we uncomment both hashcode and equals method, only p1(or p) is taken, along with the new point(3,2)
		//hence making size 2 instead of 3 in the beginning
		System.out.println("Size = "+ points.size());
		System.out.println(points);
	}
	
	
	// ---------------------TREESET------------
	
	public static void testSet(Set<Point> points) {
		Point p = new Point(2,3);
		Point p1 = new Point(2,3);
		points.add(p);
		points.add(p1);
		points.add(p);
		points.add(new Point(3,2));
		System.out.println("Size = "+ points.size());
		System.out.println(points);
	}
	

	public static void main(String[] args) {	
//		testSet(new HashSet<>());
//		testSet(new TreeSet<>());
//		testList(new ArrayList<Point>());
//		testList(new LinkedList<Point>());
//		testMap(new HashMap<>());
//		testMap(new TreeMap<>());
		testStack(new Stack<>());

	}

}
