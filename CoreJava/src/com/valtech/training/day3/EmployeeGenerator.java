package com.valtech.training.day3;

public class EmployeeGenerator {

	int age, experience, level;

	String name;

 

	public EmployeeGenerator() {

		// TODO Auto-generated constructor stub
		RandomGenerator rg = new RandomGenerator();
//		
//		while(age<20 || age>61) {age = rg.generateRandomNumber();}
//
//		while(experience>age) {experience = rg.generateRandomNumber();}
//
//		while(experience>age || experience == 0) {
//			
//			experience = rg.generateRandomNumber();
//		}
//		while (level > experience - 3) {
//			level = rg.generateRandomNumber();
//		}
//
//		name = rg.generateRandomString();
//		System.out.println("------------------");
		age = rg.generateRandomNumber(61, 20);

		experience = rg.generateRandomNumber(age, 0);

		level = rg.generateRandomNumber(experience - 10, 0);

		name = rg.generateRandomString();
		

	}

 

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		EmployeeGenerator e1 = new EmployeeGenerator();

		System.out.println("Employee details \n"+"Name: " + e1.name +" Age: "+ e1.age+" Experience: "+ e1.experience+" Level "+e1.level);

	}
	
}
