package com.valtech.training.day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;


public class IOTest {
	
	public static void main(String[] args) throws IOException  {
//		writeToFile();
//		readFromFile();
//		rotateAndWrite();
		rotateAndRead();
	}
	
	private static void rotateAndRead() throws IOException {
		Reader in = new Rot13Reader(new FileReader(new File("Hello.txt")));
		char [] buffer = new char[1024];
		int bytesRead = in.read(buffer);
		in.close();
		System.out.println(new String(buffer, 0 , bytesRead));
	}

	private static void rotateAndWrite() throws IOException {
		Writer out = new Rot13Writer(new FileWriter(new File("Hello.txt")));
		out.write(" Hiiiiiiiiiiiiiiiiii");
		out.flush();
		out.close();
	}
	

	private static void readFromFile() throws IOException {
		FileInputStream fis = new FileInputStream(new File("Hello.txt"));
		byte [] buffer= new byte[1024];
		int bytesRead = fis.read(buffer);
		System.out.println("Bytes read are : " + bytesRead);
		System.out.println(new String(buffer, 0, bytesRead));
	}

//	private static void writeToFile() throws IOException {
//		String message = "Hello World";
//		// open a file
//		FileOutputStream fos = new FileOutputStream(new File("Hello.txt")); // import  this java.io.File to use File
//		fos.write(message.getBytes());
//		fos.flush(); // write the contents of buffer to the underlying stream
//		fos.close();
//	}
	
	private static void writeToFile() throws IOException {
		String message = "Hello World";
		// open a file
		OutputStream fos = new FileOutputStream(new File("Hello.txt")); // import  this java.io.File to use File
		fos.write(message.getBytes());
		fos.flush(); // write the contents of buffer to the underlying stream
		fos.close();
	}

}
