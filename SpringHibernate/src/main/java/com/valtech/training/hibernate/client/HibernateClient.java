package com.valtech.training.hibernate.client;

import org.hibernate.SessionFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.imageio.spi.RegisterableService;
import javax.persistence.FetchType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.valtech.training.hibernate.ATMTx;
import com.valtech.training.hibernate.Account;
import com.valtech.training.hibernate.Address;
import com.valtech.training.hibernate.BankAccount;
import com.valtech.training.hibernate.BankAccountId;
import com.valtech.training.hibernate.ChequeTx;
import com.valtech.training.hibernate.Customer;
import com.valtech.training.hibernate.Employee;
import com.valtech.training.hibernate.Registration;
import com.valtech.training.hibernate.TellerTx;
import com.valtech.training.hibernate.Tx;

public class HibernateClient {
	
	public static void main(String[] args) throws Exception {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		cfg.addAnnotatedClass(Employee.class);
		
		cfg.addAnnotatedClass(Tx.class).addAnnotatedClass(ChequeTx.class).addAnnotatedClass(TellerTx.class)
			.addAnnotatedClass(ATMTx.class);
		
		cfg.addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class);
		cfg.addAnnotatedClass(Account.class);
		
		cfg.addAnnotatedClass(Registration.class);
		
		cfg.addAnnotatedClass(BankAccount.class);
		
		SessionFactory sesFac = cfg.buildSessionFactory();
		Session ses = sesFac.openSession();
		Transaction tr = ses.beginTransaction();
		
		//for bankAccount.java and 
		ses.persist(new BankAccount(new BankAccountId("saving", 1),3000));
		BankAccountId id = new BankAccountId("saving",1);
		BankAccount ba = (BankAccount) ses.load(BankAccount.class, id);

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
		Query query =  ses.getNamedQuery("Tx.findAllByCityAndAmountGreaterThan"); // this is for @NAmdQuery in Tx.java
		query.setString(0, "Blr");
		query.setFloat(1, 1000);
		query.list().forEach(t -> System.out.println(t));
		
		tr.commit();
		ses.close();
		sesFac.close();
	
	}

}
