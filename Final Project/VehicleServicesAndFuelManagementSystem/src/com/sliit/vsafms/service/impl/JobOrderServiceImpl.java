 package com.sliit.vsafms.service.impl;
 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sliit.vsafms.model.JobOrder;
import com.sliit.vsafms.model.JobOrderDetails;
import com.sliit.vsafms.service.JobOrderService;
import com.sliit.vsafms.util.DBConnection;

public class JobOrderServiceImpl implements JobOrderService{
	private static Connection conn;
	
	public JobOrderServiceImpl() {
		conn = DBConnection.getConnection();
		
	}

	@Override
	public boolean addNewJobOrder(JobOrder Jb) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "Insert into jobOrder values(?,?,?)";
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setObject(1,0);
		stm.setObject(2,Jb.getJobOrderDescription());
		stm.setObject(3,Jb.getJobOrderStatus());
		
		int res = stm.executeUpdate();
		
		return res>0;
	}

	@Override
	public ArrayList<JobOrder> getAllJobOrder() throws SQLException {
		String sql = "Select * from jobOrder where jobOrderStatus = 'unAssigned'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		ArrayList<JobOrder> JbList = new ArrayList<JobOrder>();
		
		System.out.println("GGGGGGGGGGGGGGGGGGGGg");
		while(rst.next()) {
			JobOrder Jb = new JobOrder();
			
			
			Jb.setJobOrderID(Integer.parseInt(rst.getString("jobOrderId")));
			Jb.setJobOrderDescription(rst.getString("jobOrderDescription"));
			Jb.setJobOrderStatus(rst.getString("jobOrderStatus"));
		
			JbList.add(Jb);
		}
		return JbList;
	}

	@Override
	public JobOrderDetails getJobOrderDetail(String value) throws SQLException {
		
		
		String sql = "select customerFName,VehicleNumber,Model,Brand,jobOrderDescription from joborder j,customer c,vehicle v where j.customerId=c.customerId && c.customerId=v.customerId && j.joborderId='"+value+"'";
		
		System.out.println(sql);
		Statement st = conn.createStatement();
		ResultSet ans = st.executeQuery(sql);
		
		
		JobOrderDetails jb=null;
		
		while(ans.next()) {
			jb = new JobOrderDetails();
			jb.setCustomerFName(ans.getString("customerFName"));
			jb.setBrand(ans.getString("VehicleNumber"));
			jb.setVehicleNumber(ans.getString("Model"));
			jb.setModel(ans.getString("Model"));
			jb.setJobOrderDescription(ans.getString("jobOrderDescription"));
			
			
		}
		

		return jb;
	}
	
}

