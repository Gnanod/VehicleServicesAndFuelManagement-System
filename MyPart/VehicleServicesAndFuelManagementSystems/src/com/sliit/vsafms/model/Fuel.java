package com.sliit.vsafms.model;

public class Fuel {
	int fuelId ;
	String fuleName ;
	String qty;
	String price;
	String brand;
	
	public Fuel() {
		// TODO Auto-generated constructor stub
	}

	public Fuel(int fuelId, String fuleName, String qty, String price, String brand) {
		super();
		this.fuelId = fuelId;
		this.fuleName = fuleName;
		this.qty = qty;
		this.price = price;
		this.brand = brand;
	}

	public int getFuelId() {
		return fuelId;
	}

	public void setFuelId(int fuelId) {
		this.fuelId = fuelId;
	}

	public String getFuleName() {
		return fuleName;
	}

	public void setFuleName(String fuleName) {
		this.fuleName = fuleName;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
}
