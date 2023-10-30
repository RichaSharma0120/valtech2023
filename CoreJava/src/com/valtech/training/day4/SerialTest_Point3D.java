package com.valtech.training.day4;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.valtech.training.day1.Point;
import com.valtech.training.day1.Point3D;

public class SerialTest_Point3D {

	public static void main(String[] args) throws Exception {
		Point3D p3 = new Point3D();
		System.out.println(p3);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("objects-new")));
		oos.writeObject(p3);
		oos.flush();
		oos.close(); 
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("objects-new")));	
		Point3D p4 = (Point3D) ois.readObject();
		System.out.println(p4);
		System.out.println(p4 == p3);

	}

}
