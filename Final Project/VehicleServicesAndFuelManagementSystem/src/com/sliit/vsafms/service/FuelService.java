package com.sliit.vsafms.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.sliit.vsafms.model.Fuel;
import com.sliit.vsafms.model.fuelPayment;

public interface FuelService {

	public ArrayList<Fuel> getFuelName()throws Exception;

	public String getPrice(String type)throws Exception;

	public double searchVolume(String fuelName)throws Exception;

	public boolean updateVolume(double newvolume, String fuelName)throws Exception;

	public boolean addPayment(fuelPayment pay)throws Exception;

	public int getPaymentLastId()throws Exception;

	public boolean addFuelPayment(fuelPayment pay)throws Exception;
	
	public double getCurrentQty(Double quantity, String nameOfFuel)throws Exception;
	
	boolean updateFuelStock(Double quantity, String nameOfFuel, Double QTT) throws Exception;

	boolean updateFuelPrice(String fuelName, Double priceIn, LocalDate updateDate) throws SQLException;

	public double getFuelQtyP92() throws Exception;

	public double getFuelQtyP95() throws Exception;
	
	public double getFuelQtyDAU() throws Exception;

	public double getFuelQtyDSU() throws Exception;
	
	public double getFuelQtyKER() throws Exception;
}