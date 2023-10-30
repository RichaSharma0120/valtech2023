package com.valtech.training.day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.valtech.training.day1.Point;

public class SerialTest {
	
	public static void main(String[] args) throws Exception {
		
		Point p = new Point(2,3);
		System.out.println(p);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("objects")));
		oos.writeObject(p);
		oos.flush();
		oos.close();
		
		// an objects file is created. you can access through the package explorer
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("objects")));
		//ois.readObject(); // it would read only the first object
		
	    // eg consider the string is 5 chars long ie  0   1   2   3   4   
		//										     the pointer will read only the first character ie 0
		//now this is not the same as the whole string(object in this case)
		
		Point p1 = (Point) ois.readObject(); 
		System.out.println(p1);
		System.out.println(p == p1);
		// p1 != p because p1 is a copy of p.
	}

}
