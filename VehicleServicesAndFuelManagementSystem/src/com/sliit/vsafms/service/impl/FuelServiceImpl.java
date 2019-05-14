package com.sliit.vsafms.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sliit.vsafms.model.Fuel;
import com.sliit.vsafms.model.Vehicle;
import com.sliit.vsafms.service.FuelService;
import com.sliit.vsafms.util.DBConnection;

public class FuelServiceImpl implements FuelService{
	
	private static Connection conn;
	
	public FuelServiceImpl() {
		
		conn = DBConnection.getConnection();
	}
	
	@Override
	public ArrayList<Fuel> getFuelName() throws Exception {
		String sql ="Select * from fuel";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<Fuel> fuelList= new ArrayList<Fuel>();
		while(rst.next()) {
			
			Fuel fuel = new Fuel();
			
			fuel.setFuleName(rst.getString("fuleName"));
			fuel.setFuelId(Integer.parseInt(rst.getString("fuelId")));
			fuel.setPrice(rst.getString("price"));
			fuel.setBrand(rst.getString("brand"));
			fuel.setQty(rst.getString("qty"));
			
			fuelList.add(fuel);
		}
		
		return fuelList;
	}

}
