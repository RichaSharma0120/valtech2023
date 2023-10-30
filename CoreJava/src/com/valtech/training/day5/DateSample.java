package com.valtech.training.day5;

import java.time.LocalDate;
import java.util.Date;

public class DateSample {

	public static void main(String[] args) {
		
//		index starts from 1900,eg 1947 is written as 47
//		month index starts from 0
//		day starts with index 1
		Date date = new Date(47,7,15);
		System.out.println(date);
		LocalDate independenceDay = LocalDate.of(1947, 8, 15);
		System.out.println(independenceDay);
	}

}
