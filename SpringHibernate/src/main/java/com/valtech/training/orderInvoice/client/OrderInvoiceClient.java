package com.valtech.training.orderInvoice.client;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.valtech.training.orderInvoice.CompositeKey;
import com.valtech.training.orderInvoice.CustomerAddress;
import com.valtech.training.orderInvoice.Customers;
import com.valtech.training.orderInvoice.Items;
import com.valtech.training.orderInvoice.OrderDescription;
import com.valtech.training.orderInvoice.Orders;
import com.valtech.training.orderInvoice.VendorAddress;
import com.valtech.training.orderInvoice.Vendors;

public class OrderInvoiceClient {
	
	public static void main(String[] args) throws Exception {
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		
		SessionFactory sesFac = cfg.buildSessionFactory();
		Session ses = sesFac.openSession();
		Transaction tx = (Transaction) ses.beginTransaction();
		
		cfg.addAnnotatedClass(Customers.class).addAnnotatedClass(CustomerAddress.class);
		cfg.addAnnotatedClass(Vendors.class).addAnnotatedClass(VendorAddress.class);
		cfg.addAnnotatedClass(Orders.class).addAnnotatedClass(OrderDescription.class).addAnnotatedClass(Items.class);
		cfg.addAnnotatedClass(CompositeKey.class);
		
		Customers cus1 = new Customers("Richa","7022152827","richa@gmail.com");
		
		tx.commit();
		ses.close();
		sesFac.close();
		
	}

}
