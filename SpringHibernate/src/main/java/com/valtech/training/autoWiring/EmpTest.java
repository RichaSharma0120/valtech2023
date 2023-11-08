package com.valtech.training.autoWiring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class EmpTest {

	@Test
	void test() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/valtech/training/autoWiring/ioc-autoWiring.xml");
		Employee emp = context.getBean("Emp",Employee.class);
		System.out.println(emp);
		
	}

}
