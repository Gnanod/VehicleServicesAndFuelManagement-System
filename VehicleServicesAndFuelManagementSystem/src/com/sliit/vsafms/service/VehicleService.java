package com.sliit.vsafms.service;

import java.util.ArrayList;

import com.sliit.vsafms.model.Vehicle;

public interface VehicleService {

	public ArrayList<Vehicle> getAllVehicles()throws Exception;


	public ArrayList<Vehicle> SearchVehicle(String searchName)throws Exception;


	public int searchExcistingVehicle(String vehicleNumber)throws Exception;


	public boolean addNewVehicle(Vehicle veh,int lastId)throws Exception;


	public boolean deleteVehicle(String vehId)throws Exception;
}
