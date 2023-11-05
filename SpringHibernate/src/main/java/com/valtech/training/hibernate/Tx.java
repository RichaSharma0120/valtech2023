package com.valtech.training.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.apache.commons.lang.builder.ToStringBuilder;
//import org.hibernate.annotations.Table;

@Entity
@NamedQueries({
	@NamedQuery(name = "Tx.findAll", query = "SELECT tx from Tx tx"),
	@NamedQuery(name = "Tx.findAllByCityAndAmountGreaterThan", 
				query = "SELECT tx from Tx tx join tx.account.customers c WHERE c.address.city = ? and tx.amount > ?")
})
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "disc")
//@DiscriminatorValue("tx")
//@Table(name = "alttxs")
public class Tx {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float amount;	
	
	// **********Tx has a many-to-one rel with Accounts.java[many tx can have one account]
	@ManyToOne(targetEntity = Account.class, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
			fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private Account account;
	
	public Tx() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Account getAccount() {
		return account;
	}
	
	public Tx(float amount) {
		super();
		this.amount = amount;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
