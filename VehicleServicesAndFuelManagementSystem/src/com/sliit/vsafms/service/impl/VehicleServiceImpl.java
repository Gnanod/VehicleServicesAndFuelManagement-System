package com.sliit.vsafms.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sliit.vsafms.model.Vehicle;
import com.sliit.vsafms.service.VehicleService;
import com.sliit.vsafms.util.DBConnection;

public class VehicleServiceImpl implements VehicleService{

	private static Connection conn;
	
	public VehicleServiceImpl() {
		conn = DBConnection.getConnection();
	}

	@Override
	public ArrayList<Vehicle> getAllVehicles() throws Exception {
		String sql ="Select * from vehicle";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<Vehicle> vehList= new ArrayList<Vehicle>();
		while(rst.next()) {
			
			Vehicle veh = new Vehicle();
			veh.setVehicleNumber(rst.getString("VehicleNumber"));
			veh.setVehicleId(Integer.parseInt(rst.getString("vehicleId")));
			veh.setEngineNumber(rst.getString("EngineNumber"));
			veh.setFuelType(rst.getString("fuelType"));
			veh.setVehicleBrand(rst.getString("Brand"));
			veh.setVehicleClass(rst.getString("VehicleClass"));
			veh.setDateOfRegistration(rst.getString("DateOfRegistration"));
			veh.setYearOfManufacture(rst.getString("YearOfManufacture"));
			veh.setVehicleModel(rst.getString("Model"));
			vehList.add(veh);
		}
		
		return vehList;
	}

	@Override
	public ArrayList<Vehicle> SearchVehicle(String searchName) throws Exception {
		String sql ="select DISTINCT v.EngineNumber,v.VehicleNumber,v.VehicleClass,v.Brand,v.Model,v.YearOfManufacture,v.DateOfRegistration,v.fuelType from vehicle v,customer c where v.customerId=c.customerId && (c.customerFName='"+searchName+"' || v.VehicleNumber='"+searchName+"')";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<Vehicle> vehList= new ArrayList<Vehicle>();
		while(rst.next()) {
			
			Vehicle veh = new Vehicle();
			veh.setVehicleNumber(rst.getString("VehicleNumber"));
			veh.setEngineNumber(rst.getString("EngineNumber"));
			veh.setFuelType(rst.getString("fuelType"));
			veh.setVehicleBrand(rst.getString("Brand"));
			veh.setVehicleClass(rst.getString("VehicleClass"));
			veh.setDateOfRegistration(rst.getString("DateOfRegistration"));
			veh.setYearOfManufacture(rst.getString("YearOfManufacture"));
			veh.setVehicleModel(rst.getString("Model"));
			vehList.add(veh);
			
		}
		
		return vehList;
	}

	@Override
	public int searchExcistingVehicle(String vehicleNumber) throws Exception {
		String sql2 ="select count(vehicleId)from vehicle where VehicleNumber='"+vehicleNumber+"'";
		Statement statement= conn.createStatement();
		ResultSet rst2 = statement.executeQuery(sql2);
		int number2=0;
		if(rst2.next()) {
			number2=rst2.getInt(1);
		}
		return number2;
	}

	@Override
	public boolean addNewVehicle(Vehicle veh,int lastId) throws Exception {
		
		String SQL = "Insert into vehicle Values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, 0);
        stm.setObject(2, veh.getEngineNumber());
        stm.setObject(3, veh.getVehicleNumber());
        stm.setObject(4, veh.getVehicleClass());
        stm.setObject(5, veh.getVehicleBrand());
        stm.setObject(6, veh.getVehicleModel());
        stm.setObject(7, veh.getYearOfManufacture());
        stm.setObject(8, veh.getDateOfRegistration());
        stm.setObject(9, veh.getFuelType());
        stm.setObject(10, lastId);
        int res = stm.executeUpdate();
        return res > 0;
		
	}

	@Override
	public boolean deleteVehicle(String vehId) throws Exception {
		String SQL = "delete from vehicle where vehicleId='"+vehId+"'";
		Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;
		
	}
	
}
