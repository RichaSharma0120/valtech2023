package com.valtech.training.day3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeCompare {

	public static void main(String[] args) {
			EmployeeDetails[] employees = {
					new EmployeeDetails(5, 10 , "Mahesh", 45, 1000000); 
					new EmployeeDetails(2, 5 , "Raj", 39, 70000);
					new EmployeeDetails(8, 20 , "Varun", 61, 1500000);
					new EmployeeDetails(1, 2 , "Ram", 27, 50000);

	};
	}		
	}

class SortEmploeeSeniority implements Comparator<EmployeeDetails> {

	@Override
	public int compare(EmployeeDetails o1, EmployeeDetails o2) {
		 return o1.getSeniority() - o2.getSeniority();
	}

	@Override
	public int compare(EmployeeDetails o1, EmployeeDetails o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}

class SortEmploeeExperience implements Comparator<EmployeeDetails> {

	@Override
	public int compare(EmployeeDetails o1, EmployeeDetails o2) {
		return o1.getExperience() - o2.getExperience();
	}
}

class SortEmploeeName implements Comparator<EmployeeDetails> {

	@Override
	public int compare(EmployeeDetails o1, EmployeeDetails o2) {
		return o1.getName().compareTo(o2.getName());

	}

}

