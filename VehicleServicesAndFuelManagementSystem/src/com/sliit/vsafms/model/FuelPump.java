package com.sliit.vsafms.model;

import java.time.LocalDate;
import java.util.Date;

public class FuelPump {
	
	int fuelPumpId;
	int fuelId;
	String fuelName;
	LocalDate serviceDate;
	double servicePrice;
	
	public FuelPump(int fuelPumpId, int fuelId, String fuelName, LocalDate serviceDate, double servicePrice) {
		this.fuelPumpId = fuelPumpId;
		this.fuelId = fuelId;
		this.fuelName = fuelName;
		this.serviceDate = serviceDate;
		this.servicePrice = servicePrice;
	}

	public FuelPump() {
		// TODO Auto-generated constructor stub
	}

	public int getFuelPumpId() {
		return fuelPumpId;
	}

	public void setFuelPumpId(int fuelPumpId) {
		this.fuelPumpId = fuelPumpId;
	}

	public int getFuelId() {
		return fuelId;
	}

	public void setFuelId(int fuelId) {
		this.fuelId = fuelId;
	}

	public String getFuelName() {
		return fuelName;
	}

	public void setFuelName(String fuelName) {
		this.fuelName = fuelName;
	}

	public LocalDate getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(LocalDate dd) {
		this.serviceDate = dd;
	}

	public double getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(double servicePrice) {
		this.servicePrice = servicePrice;
	}
	
	
}
