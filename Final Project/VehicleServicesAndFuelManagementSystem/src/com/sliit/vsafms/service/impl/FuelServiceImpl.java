package com.sliit.vsafms.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.sliit.vsafms.model.Fuel;
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
			
			fuel.setFuelId(Integer.parseInt(rst.getString("fuelId")));
			fuel.setFuleName(rst.getString("fuelName"));
			fuel.setQty(rst.getDouble("qty"));
			fuel.setPrice(rst.getDouble("price"));
			fuel.setPriceUpdateDate(rst.getDate("priceUpdateDate"));
			
			fuelList.add(fuel);
		}
		
		return fuelList;
	}

	@Override
	public String getPrice(String type) throws Exception {
		String sql ="Select * from fuel where fuelName='"+type+"'";
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
		String sql ="Select * from fuel where fuelName='"+fuelName+"'";
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
		String SQL = "Update fuel set qty='" +newvolume + "'  where fuelName='" +fuelName+ "'";
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
	
	@Override
	public double getCurrentQty(Double quantity, String nameOfFuel) throws Exception {
		String currentQtySQL = "SELECT qty FROM fuel WHERE fuelName='"+nameOfFuel+"'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(currentQtySQL);
		double Quentity=0;  
					
		while(rst.next()) {
			
			Quentity = Double.parseDouble(rst.getString("qty"));
			
		}
		return Quentity;
	}

	@Override
	public boolean updateFuelStock(Double quantity, String nameOfFuel, Double QTT) throws Exception {
		//String currentQtySQL = "SELECT qty FROM fuel WHERE fuleName='"+nameOfFuel+"'";
		//double QTY = Double.parseDouble(currentQtySQL);
		Double sumQty = QTT + quantity;
		String SQL = "UPDATE fuel SET qty='"+sumQty+"' where fuelName='"+nameOfFuel+"'";
		Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;
	}


	//@Override
	//public boolean updateFuelPrice(String fuelName, Double priceIn) throws SQLException {
	//	String SQL = "UPDATE fuel SET price='"+priceIn+"' where fuleName='"+fuelName+"'";
		//Statement stm = conn.createStatement();
        //
	//return stm.executeUpdate(SQL) > 0;
	//}

	@Override
	public boolean updateFuelPrice(String fuelName, Double priceIn, LocalDate updateDate) throws SQLException {
		String SQL = "UPDATE fuel SET price='"+priceIn+"',priceUpdateDate='"+updateDate+"' where fuelName='"+fuelName+"'";
		Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;
	}

	@Override
	public double getFuelQtyP92() throws Exception {
		String currentQtySQL = "SELECT qty FROM fuel WHERE fuelName='Petrol Octane 92'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(currentQtySQL);
		double Quentity=0;  
					
		while(rst.next()) {
			
			Quentity = Double.parseDouble(rst.getString("qty"));
			
		}
		return Quentity;
	}

	@Override
	public double getFuelQtyP95() throws Exception {
		String currentQtySQL = "SELECT qty FROM fuel WHERE fuelName='Petrol Octane 95'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(currentQtySQL);
		double Quentity=0;  
					
		while(rst.next()) {
			
			Quentity = Double.parseDouble(rst.getString("qty"));
			
		}
		return Quentity;
	}

	@Override
	public double getFuelQtyDAU() throws Exception {
		String currentQtySQL = "SELECT qty FROM fuel WHERE fuelName='Auto Diesel'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(currentQtySQL);
		double Quentity=0;  
					
		while(rst.next()) {
			
			Quentity = Double.parseDouble(rst.getString("qty"));
			
		}
		return Quentity;
	}

	@Override
	public double getFuelQtyDSU() throws Exception {
		String currentQtySQL = "SELECT qty FROM fuel WHERE fuelName='Supper Diesel'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(currentQtySQL);
		double Quentity=0;  
					
		while(rst.next()) {
			
			Quentity = Double.parseDouble(rst.getString("qty"));
			
		}
		return Quentity;
	}

	@Override
	public double getFuelQtyKER() throws Exception {
		String currentQtySQL = "SELECT qty FROM fuel WHERE fuelName='Kerosene'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(currentQtySQL);
		double Quentity=0;  
					
		while(rst.next()) {
			
			Quentity = Double.parseDouble(rst.getString("qty"));
			
		}
		return Quentity;
	}

	
//////////////////////////////////////////////////////
	

	


	
	



	




	
}
