package com.sliit.vsafms.model;

public class Part{
	String partId;
	String partName;
	String model;
	String brand;
	String price;
	String qty;
	String photo;
	
public Part() {
		
		this.partId = null;
		this.partName = null;
		this.model= null;
		this.brand = null;
		this.price = null;
		this.qty = null;
		this.photo = null;
		
	}
	
	public Part(String partId, String partName, String model, String brand, String price, String qty, String photo) {
		super();
		this.partId = partId;
		this.partName = partName;
		this.model = model;
		this.brand = brand;
		this.price = price;
		this.qty = qty;
		this.photo = photo;
	}


	public String getPartId() {
		return partId;
	}


	public void setPartId(String partId) {
		this.partId = partId;
	}


	public String getPartName() {
		return partName;
	}


	public void setPartName(String partName) {
		this.partName = partName;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getQty() {
		return qty;
	}


	public void setQty(String quantity) {
		this.qty = quantity;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
