package com.valtech.training.orderInvoice;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Items {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	private String itemName;
	private int unitPrice;
	
	@ManyToMany(targetEntity = Vendors.class, fetch = FetchType.LAZY)
	@JoinTable(name = "vendor_items", 
			   joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "itemId"), 
			   inverseJoinColumns = @JoinColumn(name = "vendor_id", referencedColumnName = "vendorId"))
	private Set<Vendors> vendors = new HashSet<Vendors>();
	


	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Set<Vendors> getVendors() {
		return vendors;
	}

	public void setVendors(Set<Vendors> vendors) {
		this.vendors = vendors;
	}
	
	public void addVendors(Vendors vendor) {
		this.vendors.add(vendor);
		vendor.addItems(this);
	}

	public Items(String itemName, int unitPrice) {
		this.itemName = itemName;
		this.unitPrice = unitPrice;
	}

	public Items() {
	}




	
	

}
