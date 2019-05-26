package com.sliit.vsafms.model;

public class Supplier {
	
	String sID;
	String sName;
	String sPhone;
	String sEmail;
	String sAddress;
	
	public Supplier() {
		
	}
	
	public Supplier(String sID, String sName, String sPhone, String sEmail, String sAddress) {
		this.sID = sID;
		this.sName = sName;
		this.sPhone = sPhone;
		this.sEmail = sEmail;
		this.sAddress = sAddress;
	}

	public String getsID() {
		return sID;
	}

	public void setsID(String sID) {
		this.sID = sID;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPhone() {
		return sPhone;
	}

	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	
	

}
