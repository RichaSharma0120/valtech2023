package com.valtech.training.assignment.components;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class CustomerOrder {

//	private DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
	
	private int order_id;
	@Basic() @Temporal(TemporalType.DATE)
	private Date order_date;
	private int c_id;

	public CustomerOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerOrder(int order_id, Date order_date, int c_id) {
		super();
		this.order_id = order_id;
		this.order_date = order_date;
		this.c_id = c_id;
	}

//	public CustomerOrder(DateFormat order_date, int c_id) {
//		super();
//		this.order_date = order_date;
//		this.c_id = c_id;
//	}

	public CustomerOrder(Date order_date, int c_id) {
		// TODO Auto-generated constructor stub
		this.order_date = order_date;
		this.c_id = c_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

}
