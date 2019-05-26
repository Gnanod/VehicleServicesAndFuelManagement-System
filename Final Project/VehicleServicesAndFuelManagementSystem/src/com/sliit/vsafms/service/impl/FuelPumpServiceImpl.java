package com.sliit.vsafms.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sliit.vsafms.model.FuelPump;
import com.sliit.vsafms.service.FuelPumpService;
import com.sliit.vsafms.util.DBConnection;

public class FuelPumpServiceImpl implements FuelPumpService{
	
	private static Connection conn;
	private PreparedStatement preparedStatement;
	public FuelPumpServiceImpl() {
		
		conn= DBConnection.getConnection();
	}
	
	public ArrayList<FuelPump> getAllFuelPump() throws SQLException {
		String sql = "select * from fuelPump";
		Statement statement= conn.createStatement();
		ResultSet rst = statement.executeQuery(sql);
		
		ArrayList<FuelPump> pumList = new ArrayList<FuelPump>();
		while(rst.next()) {
			
			FuelPump pum = new FuelPump();
			pum.setFuelPumpId(Integer.parseInt(rst.getString("fuelPumpId")));
			pum.setFuelId(Integer.parseInt(rst.getString("fuelId")));
			pum.setFuelName(rst.getString("fuelName"));			
			
			pumList.add(pum);
			
		}
		
		return pumList;
	}
	
	

	@Override
	public boolean addNewPumpService(FuelPump newService) throws SQLException {
		String SQL = "Insert into fuelPumpService Values(?,?,?,?,?)";
		System.out.println(SQL);
        PreparedStatement stm = conn.prepareStatement(SQL); 
        
        stm.setObject(1, 0);
        stm.setObject(2, newService.getFuelPumpId());
        stm.setObject(3, newService.getFuelId());
        stm.setObject(4, newService.getServiceDate());
        stm.setObject(5, newService.getServicePrice());
        
        int res = stm.executeUpdate();
        return res > 0;
	}
	

	@Override
	public String getFuelPump(String fuelPump) throws Exception {
		String sql ="Select fuelId from fuel where fuelName='"+fuelPump+"'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		String price=null;
		while(rst.next()) {
			
			price = rst.getString("fuelId");
			
		}
		
		return price;
	}
	
	

	@Override
	public boolean addNewFuelPump(FuelPump newPump) throws SQLException {
		String SQL = "Insert into fuelpump Values(?,?,?)";
		System.out.println("New fuel pump "+SQL);
        PreparedStatement stm = conn.prepareStatement(SQL); 
        
        stm.setObject(1, 0);
        stm.setObject(2, newPump.getFuelId());
        stm.setObject(3, newPump.getFuelName());
        System.out.println("id "+stm);
        int res = stm.executeUpdate();
        return res > 0;
        
	}

	@Override
	public boolean deleteFuelPump(String pumId) throws SQLException {
		String SQL = "delete from fuelpump where fuelPumpId='"+pumId+"'";
		Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;
	}

	
	
}
