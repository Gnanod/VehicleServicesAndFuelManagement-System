package com.sliit.vsafms.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sliit.vsafms.model.FuelPump;

public interface FuelPumpService {
	
	public ArrayList<FuelPump> getAllFuelPump() throws SQLException;

	String getFuelPump(String fuelPump) throws Exception;

	boolean addNewPumpService(FuelPump newService) throws SQLException;

	
	

	boolean addNewFuelPump(FuelPump newPump) throws SQLException;

	

	public boolean deleteFuelPump(String supId) throws SQLException;
	
}
