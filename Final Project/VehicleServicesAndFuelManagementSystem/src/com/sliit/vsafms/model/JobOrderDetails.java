package com.sliit.vsafms.model;

public class JobOrderDetails {
	private String customerFName;
	private String vehicleNumber;
	private String model;
	private String brand;
	private String jobOrderDescription;
	
	public JobOrderDetails() {
		// TODO Auto-generated constructor stub
	}

	public JobOrderDetails(String customerFName, String vehicleNumber, String model, String brand,String jobOrderDescription) {
		super();
		this.customerFName = customerFName;
		this.vehicleNumber = vehicleNumber;
		this.model = model;
		this.brand = brand;
		this.jobOrderDescription = jobOrderDescription;
	}

	public String getCustomerFName() {
		return customerFName;
	}

	public void setCustomerFName(String customerFName) {
		this.customerFName = customerFName;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
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

	public String getJobOrderDescription() {
		return jobOrderDescription;
	}

	public void setJobOrderDescription(String jobOrderDescription) {
		this.jobOrderDescription = jobOrderDescription;
	}
	
	
}
