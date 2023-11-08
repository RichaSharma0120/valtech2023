package com.valtech.training.orderInvoice;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Vendors {
	
	private int vendorId;
	private String vendorName;
	
	@OneToOne(targetEntity = VendorAddress.class, cascade = {CascadeType.MERGE, CascadeType.REMOVE}, 
			fetch = FetchType.LAZY, mappedBy = "vendor")
	private VendorAddress vendorAddress;
	
	@ManyToMany(targetEntity = Items.class, fetch = FetchType.LAZY, mappedBy = "vendors")
	private Set<Items> items;
	

	public Vendors() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vendors(int vendorId, String vendorName, VendorAddress vendorAddress) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
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

	public void setVndorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public VendorAddress getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(VendorAddress vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	@Override
	public String toString() {
		return "Vendors [vendorId=" + vendorId + ", vendorName=" + vendorName + ", vendorAddress=" + vendorAddress
				+ "]";
	}

	
	
	

}
