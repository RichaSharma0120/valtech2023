package com.valtech.training.orderInvoice;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Vendors {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vendorId;
	private String vendorName;
	
	@OneToOne(targetEntity = VendorAddress.class, cascade = {CascadeType.MERGE, CascadeType.REMOVE}, 
			fetch = FetchType.LAZY, mappedBy = "vendor")
	private VendorAddress vendorAddress;
	
	@ManyToMany(targetEntity = Items.class, fetch = FetchType.LAZY, mappedBy = "vendors")
	private Set<Items> items = new HashSet<Items>();
	

	public Vendors() {
	}

	public Vendors(String vendorName) {
		this.vendorName = vendorName;
	}

	public int getvendorId() {
		return vendorId;
	}

	public void setvendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public VendorAddress getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(VendorAddress vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}
	
	public void addItems(Items items) {
		this.items.add(items);
	}


}
