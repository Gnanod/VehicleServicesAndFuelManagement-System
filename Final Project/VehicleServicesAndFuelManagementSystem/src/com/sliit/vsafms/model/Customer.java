package com.sliit.vsafms.model;

public class Customer {
	int customerID;
	String customerFName;
	String customerLName;
	String customerNic;
	String customerPhone;
	String customerEmail;
	String customerAddress;
	
	public Customer() {
		
		this.customerID = 0;
		this.customerFName = null;
		this.customerLName = null;
		this.customerNic = null;
		this.customerPhone = null;
		this.customerEmail = null;
		this.customerAddress = null;
		
	}

	public Customer(int customerID, String customerFName, String customerLName, String customerNic,
			String customerPhone, String customerEmail, String customerAddress) {
		super();
		this.customerID = customerID;
		this.customerFName = customerFName;
		this.customerLName = customerLName;
		this.customerNic = customerNic;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerFName() {
		return customerFName;
	}

	public void setCustomerFName(String customerFName) {
		this.customerFName = customerFName;
	}

	public String getCustomerLName() {
		return customerLName;
	}

	public void setCustomerLName(String customerLName) {
		this.customerLName = customerLName;
	}

	public String getCustomerNic() {
		return customerNic;
	}

	public void setCustomerNic(String customerNic) {
		this.customerNic = customerNic;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
}
