package com.sliit.vsafms.model;

public class Vehicle {
	
	private int vehicleId;
	private String engineNumber;
	private String vehicleClass;
	private String vehicleNumber;
	private String vehicleBrand;
	private String vehicleModel;
	private String yearOfManufacture;
	private String dateOfRegistration;
	private String fuelType;
	
	public Vehicle() {
		
		this.vehicleId = 0;
		this.engineNumber = null;
		this.vehicleClass = null;
		this.vehicleBrand = null;
		this.vehicleModel = null;
		this.yearOfManufacture = null;
		this.dateOfRegistration = null;
		this.fuelType = null;
		this.vehicleNumber =null;
	}

	
	public Vehicle(int vehicleId, String engineNumber, String vehicleClass, String vehicleNumber, String vehicleBrand,
			String vehicleModel, String yearOfManufacture, String dateOfRegistration, String fuelType) {
		super();
		this.vehicleId = vehicleId;
		this.engineNumber = engineNumber;
		this.vehicleClass = vehicleClass;
		this.vehicleNumber = vehicleNumber;
		this.vehicleBrand = vehicleBrand;
		this.vehicleModel = vehicleModel;
		this.yearOfManufacture = yearOfManufacture;
		this.dateOfRegistration = dateOfRegistration;
		this.fuelType = fuelType;
	}


	public String getVehicleNumber() {
		return vehicleNumber;
	}


	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}


	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getVehicleClass() {
		return vehicleClass;
	}

	public void setVehicleClass(String vehicleClass) {
		this.vehicleClass = vehicleClass;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(String yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
}
