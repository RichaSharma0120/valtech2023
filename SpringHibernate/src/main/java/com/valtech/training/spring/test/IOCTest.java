package com.valtech.training.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.spring.HelloWorld;
import com.valtech.training.spring.Line;
import com.valtech.training.spring.SimpleInterest;
import com.valtech.training.spring.UtilsBean;

class IOCTest {
	
	private ApplicationContext appCtx;
	private ApplicationContext childAppCtx;
	
	@BeforeEach
	void initialize() {
		appCtx = new ClassPathXmlApplicationContext("ioc.xml");
		childAppCtx = new ClassPathXmlApplicationContext(new String[]{"ioc-child.xml"},appCtx);
	}
	
	@Test
	void testPointSetterInjection() {
		System.out.println(appCtx.getBean("p2"));
	}

	@Test
	void test() {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("ioc.xml");
		HelloWorld hw = (HelloWorld) appCtx.getBean("hw");
		assertEquals("HelloWorld", hw.hello("World"));
		assertEquals(appCtx.getBean("hw"), appCtx.getBean("abc"));
	}
	
	@Test
	void testPoint() {
		System.out.println(appCtx.getBean("p1"));
		assertNotEquals(appCtx.getBean("p1"), appCtx.getBean("p1"));
	}
	
	@Test
	void testLine() {
		System.out.println(appCtx.getBean("l2"));
	}
	
	@Test
	void testSimpleInterest() {
		SimpleInterest si = appCtx.getBean(SimpleInterest.class);
		System.out.println(si.computeInterest(3000, 12, 3));
	}
	
	@Test
	void testUtilsBean() {
		UtilsBean ub = appCtx.getBean(UtilsBean.class);
		System.out.println(ub.getNames());
		System.out.println(ub.getSettings());
		System.out.println(ub.getPoints());
	}
	
	@Test
	void testChildAppCtx() {
		Line l = (Line) childAppCtx.getBean("line");
		System.out.println(l);
	}

}
