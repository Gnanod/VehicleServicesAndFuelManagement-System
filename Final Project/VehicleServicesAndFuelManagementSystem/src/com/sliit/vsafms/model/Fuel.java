package com.sliit.vsafms.model;

import java.sql.Date;

public class Fuel {
	int fuelId ;
	String fuleName ;
	Double qty;
	Double price;
	Date priceUpdateDate;
	
	public Fuel(int fuelId, String fuleName, Double qty, Double price, Date priceUpdateDate) {
		this.fuelId = fuelId;
		this.fuleName = fuleName;
		this.qty = qty;
		this.price = price;
		this.priceUpdateDate = priceUpdateDate;
	}
	public Fuel() {
		// TODO Auto-generated constructor stub
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
	public Double getQty() {
		return qty;
	}
	public void setQty(Double qty) {
		this.qty = qty;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getPriceUpdateDate() {
		return priceUpdateDate;
	}
	public void setPriceUpdateDate(Date priceUpdateDate) {
		this.priceUpdateDate = priceUpdateDate;
	}
	

	


//		
	
}
