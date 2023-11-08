package com.valtech.training.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.valtech.training.hibernate.Employee;

//import com.valtech.training.autoWiring.Employee;

@Repository //All DAO classes will be defined using the repository annotation
/*
 * @service will be used for all classes that are service classes, they need transaction support
@ for all classes when we want them for presentation logic
all other classes will be designed using @Component, they are general classes which hav to be registered usingbean factory*/
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	// methods that we might need
	@Override
	public Employee saveEmployee(Employee emp) {
		Session ses = sessionFactory.openSession();
		ses.persist(emp);
		return emp;
	}
	
	@Override
	public Employee updateEmployee(Employee emp) {
		Session ses = sessionFactory.openSession();
		emp = (Employee) ses.merge(emp);
		return emp;
	}
	@Override
	public Employee loadEmployee(int empId) {
		Session ses = sessionFactory.openSession();
		Employee emp = (Employee) ses.load(Employee.class, empId);
		return emp;
	}
	@Override
	public void deleteEmployee(int empId) {
		Session ses = sessionFactory.getCurrentSession();
		ses.delete(empId);
	}
	@Override
	public List<Employee> getAllEmployees(){
		Session ses = sessionFactory.openSession();
		List<Employee> emps = ses.createQuery("from Employee e").list();
		return emps;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
