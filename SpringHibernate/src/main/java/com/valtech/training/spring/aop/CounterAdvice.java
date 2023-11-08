package com.valtech.training.spring.aop;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.aop.MethodBeforeAdvice;


//------BEFORE ADVICE
public class CounterAdvice implements MethodBeforeAdvice{
	
	private Map<String,Integer> counters = new HashMap<String, Integer>();
	
	//to save the counter values
	public void loadCounters() {
		
		// here we do de-serialization
		try {
			File file = new File("counters.txt");
			if(file.exists()) {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				counters = (Map<String, Integer>) ois.readObject();
				ois.close();
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("loading counters----" + counters); // +counters loads the current value of the counter
	}
	
	public void saveCounters() {
		System.out.println("saving values of the counters---" +counters); // +counters saves the current value of the counter
		//here we do serialization
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("counters.txt")));
			oos.writeObject(counters);
			oos.flush();
			oos.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		//mtehod is the actual method we want to invoke.
		// args is the arguments that will be psses to the method
		// taarget is the object on which this method will be executed
		
//		for (int i = 0; i < args.length; i++) { // this code negates the arguments passes by the user
//			int a = (int) args[i];
//			args[i] = a % 2==0 ? a : -a;
//		}
		
		String methodName = method.getName();
		System.out.println("method being called is: " + methodName);
		System.out.println("arguments are : " + ArrayUtils.toString(args));
		
		// to count how many times a method has been called
		if(counters.containsKey(methodName)) {
			counters.put(methodName, counters.get(methodName)+1);
		} else {
			counters.put(methodName, 1);
		}
		System.out.println(counters);		
	}

}
