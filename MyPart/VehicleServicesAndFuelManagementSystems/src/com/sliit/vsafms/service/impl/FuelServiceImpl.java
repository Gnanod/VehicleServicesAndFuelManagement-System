package com.sliit.vsafms.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sliit.vsafms.model.Fuel;
import com.sliit.vsafms.model.Vehicle;
import com.sliit.vsafms.model.fuelPayment;
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

	@Override
	public String getPrice(String type) throws Exception {
		String sql ="Select * from fuel where fuleName='"+type+"'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		String price=null;
		while(rst.next()) {
			
			price = rst.getString("price");
			
		}
		
		return price;
	}

	@Override
	public double searchVolume(String fuelName) throws Exception {
		String sql ="Select * from fuel where fuleName='"+fuelName+"'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		double volume=0;
		
		while(rst.next()) {
			
			volume = Double.parseDouble(rst.getString("qty"));
			
		}
		return volume;
	}

	@Override
	public boolean updateVolume(double newvolume, String fuelName) throws Exception {
		String SQL = "Update fuel set qty='" +newvolume + "'  where fuleName='" +fuelName+ "'";
        Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;
		
	}

	@Override
	public boolean addPayment(fuelPayment pay) throws Exception {

		String SQL = "Insert into payment Values(?,?)";
		System.out.println(SQL);
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, 0);
        stm.setObject(2, pay.getTotalPrice());
     
        int res = stm.executeUpdate();
        return res > 0;
	}

	@Override
	public int getPaymentLastId() throws Exception {
		String sql1 ="select Max(paymentId) from payment";
		Statement statement= conn.createStatement();
		ResultSet rst = statement.executeQuery(sql1);
		int  number1=0;
		if(rst.next()){
	       number1= rst.getInt(1);
	    }
		return number1;
	}

	@Override
	public boolean addFuelPayment(fuelPayment pay) throws Exception {
		String SQL = "Insert into fuelpayment Values(?,?,?)";
		System.out.println(SQL);
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, 0);
        stm.setObject(2, pay.getPaymentId());
        stm.setObject(3, pay.getVolume());   
        int res = stm.executeUpdate();
        return res > 0;
	}

	
}
