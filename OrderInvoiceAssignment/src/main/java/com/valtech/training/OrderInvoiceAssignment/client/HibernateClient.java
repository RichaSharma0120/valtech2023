package com.valtech.training.OrderInvoiceAssignment.client;

import org.hibernate.SessionFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.spi.RegisterableService;
import javax.persistence.FetchType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;


import com.valtech.training.orderInvoice.CustomerAddress;
import com.valtech.training.orderInvoice.Customers;
import com.valtech.training.orderInvoice.Items;
import com.valtech.training.orderInvoice.OrderDescription;
import com.valtech.training.orderInvoice.Orders;
import com.valtech.training.orderInvoice.VendorAddress;
import com.valtech.training.orderInvoice.Vendors;

public class HibernateClient {
	
	public static void main(String[] args) throws Exception {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//		cfg.addAnnotatedClass(Employee.class);
//		
//		cfg.addAnnotatedClass(Tx.class).addAnnotatedClass(ChequeTx.class).addAnnotatedClass(TellerTx.class)
//			.addAnnotatedClass(ATMTx.class);
//		
//		cfg.addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class);
//		cfg.addAnnotatedClass(Account.class);
//		
//		cfg.addAnnotatedClass(Registration.class);
//		
//		cfg.addAnnotatedClass(BankAccount.class);
		
//		SessionFactory sesFac = cfg.buildSessionFactory();
//		Session ses = sesFac.openSession();
//		Transaction tr = ses.beginTransaction();
		
		//for bankAccount.java and 
//		ses.persist(new BankAccount(new BankAccountId("saving", 1),3000));
//		BankAccountId id = new BankAccountId("saving",1);
//		BankAccount ba = (BankAccount) ses.load(BankAccount.class, id);

//		Customer cus = new Customer("Richa", 20);
// 		ses.save(cus);
//		Address addr = new Address("JP Nagar","Blr",560059);
//		addr.setCustomer(cus); // because we have given fetch = FetchType.LAZY, in customer.java
//		ses.save(addr);
	
		
		//------------------------------------------------
//		ses.save(new Tx(1000));
//		ses.save(new ChequeTx(2000, 123123, 34345));
//		ses.save(new TellerTx(3000,123, 12345));
//		ses.save(new ATMTx(4000, 1234));
		
		
////		//persist is used for creation
//		ses.persist(new Employee("Emma", df.parse("15-08-1947"), 2000, 'F', false));
//		
//		Account acc = new Account(1000, "saving");
//		Tx tx1 = new Tx(1000);
//		Tx tx2 = new ChequeTx(2000, 123123, 34345);
//		Tx tx3 = new TellerTx(3000,123, 12345);
//		Tx tx4 = new ATMTx(4000, 1234);
//		
//		Account acc1 = new Account(20000, "current");
//		Tx tx5 = new ChequeTx(6000,98987, 4500);
//		
//		Customer cus1 = new Customer("Chan", 40);
//		Address add1 = new Address("Jaynagar","Blr", 560056);
//		Customer cus2 = new Customer("Ranjitha", 72);
//		Address add2 = new Address("Sanath Nagar","Hyd", 540050);
//		
//		ses.persist(acc);
//		ses.persist(tx1);
//		ses.persist(tx2);
//		ses.persist(tx3);
//		ses.persist(tx4);
//		
//		ses.persist(acc1);
//		ses.persist(tx5);
//		ses.persist(cus);
//		ses.persist(cus1);
//		ses.persist(cus2);
//		ses.persist(add1);
//		ses.persist(add2);
//		
//		cus1.setAddress(add1);
//		add1.setCustomer(cus1);
//		cus2.setAddress(add2);
//		add2.setCustomer(cus2);
//		
//		acc.addTx(tx1);
//		acc.addTx(tx2);
//		acc.addTx(tx3);
//		acc.addTx(tx4);
//		acc1.addTx(tx5);
//		acc1.addCustomers(cus2);
//		acc1.addCustomers(cus);
//		acc.addCustomers(cus2);
//		acc.addCustomers(cus1);
		
		//---------queries
//		ses.createQuery("Select distinct tx.account from Tx tx").list().forEach(t -> System.out.println(t));
//		Query query = ses.createQuery("SELECT DISTINCT c FROM Customer c join c.accounts a join a.txs t where t.amount > ?");
//		query.setFloat(0, 3000);
//		query.list().forEach(t -> System.out.println(t));
		
//		Query query = ses.createQuery("SELECT t FROM Tx t join t.account.customers c WHERE c.address.city = ? AND t.amount > ?");
//		Query query =  ses.getNamedQuery("Tx.findAllByCityAndAmountGreaterThan"); // this is for @NAmdQuery in Tx.java
//		query.setString(0, "Blr");
//		query.setFloat(1, 1000);
//		query.list().forEach(t -> System.out.println(t));
		
//		tr.commit();
//		ses.close();
//		sesFac.close();
		
		
		//*************************************
		
		cfg.addAnnotatedClass(Customers.class).addAnnotatedClass(CustomerAddress.class);
		cfg.addAnnotatedClass(Orders.class).addAnnotatedClass(OrderDescription.class);
		cfg.addAnnotatedClass(Vendors.class).addAnnotatedClass(VendorAddress.class);
		cfg.addAnnotatedClass(Items.class);
		DateFormat dateFormat = new SimpleDateFormat();
		
		SessionFactory sesFac = cfg.buildSessionFactory();
		Session ses = sesFac.openSession();
		Transaction tr = ses.beginTransaction();
		
		
		
		Customers cus1 = new Customers("Richa","7022152827","richa@gmail.com");
		CustomerAddress custAdd1 = new CustomerAddress("Harsha Layout","Bangalore","Karnataka",560059);
		Customers cus2 = new Customers("Chikky","9876538293","chikky@gmail.com");
		CustomerAddress custAdd2 = new CustomerAddress("Sector 62","Noida","U.P",120012);
		
		cus1.setCustomerAddress(custAdd1);
		cus2.setCustomerAddress(custAdd2);
		
		Orders order1 = new Orders(df.parse("15-08-1947"));
		Orders order2 = new Orders(df.parse("09-01-2023"));
		
		Vendors vendor1 = new Vendors("Apple"); 
		VendorAddress vendorAdd1 = new VendorAddress("Church Street","Blr","Karnataka",450034);
		vendor1.setVendorAddress(vendorAdd1 );
		Vendors vendor2 = new Vendors("Reliance"); 
		VendorAddress vendorAdd2 = new VendorAddress("BEL Road","Pune","Maharashtra",120012);
		vendor1.setVendorAddress(vendorAdd1 );
		
		Items items1 = new Items("Pencils", 5);
		Items items2 = new Items("Pens", 30);
		items1.addVendors(vendor1);
		items2.addVendors(vendor2);
//		
//		vendor1.addItems(items1);
//		vendor2.addItems(items2);
		
		OrderDescription orderDesc1 = new OrderDescription(1,15,order2,items1);
		OrderDescription orderDesc2 = new OrderDescription(2,30,order1,items2);
		orderDesc1.setOrders(order1);
		orderDesc2.setOrders(order2);
		
		

		custAdd1.setCustomer(cus1);

		custAdd2.setCustomer(cus2);
	
		vendorAdd1.setVendor(vendor1);
		
		vendorAdd2.setVendor(vendor2);
		
		order1.setCustomers(cus1);
		order2.setCustomers(cus2);
		
		List<OrderDescription> orderDescList = new ArrayList<OrderDescription>();
		orderDescList.add(orderDesc1);
		orderDescList.add(orderDesc2);
		
		
		orderDesc1.setItems(items2);
		orderDesc2.setItems(items1);
		
		ses.persist(custAdd1);
		ses.persist(cus2);
		
		ses.persist(vendorAdd1);
		ses.persist(vendor1);
		ses.persist(vendorAdd2);
		ses.persist(vendor2);
		ses.persist(order1);
		ses.persist(order2);
		ses.persist(items1);
		ses.persist(items2);
		ses.persist(orderDesc1);
		ses.persist(orderDesc2);
		ses.persist(vendor1);
		ses.persist(vendor2);
		
	
		
		tr.commit();
		ses.close();
		sesFac.close();
	
	}

}
