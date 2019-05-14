package com.sliit.vsafms.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sliit.vsafms.model.BreakDownJobOrder;
import com.sliit.vsafms.model.Customer;
import com.sliit.vsafms.model.Vehicle;
import com.sliit.vsafms.service.BreakDownJobOrderService;
import com.sliit.vsafms.util.DBConnection;

public class BreakDownJobOrderServiceImpl implements BreakDownJobOrderService{

	private Connection conn;
	public BreakDownJobOrderServiceImpl() {
		
		conn= DBConnection.getConnection();
	}
	@Override
	public boolean addBreakDownServiceJobOrder(BreakDownJobOrder bo, int idNumber) throws Exception {
		
		String SQL = "Insert into joborder Values(?,?,?,?)";
		System.out.println(SQL);
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, 0);
        stm.setObject(2, bo.getJobOrderDescription());
        stm.setObject(3, bo.getJobOrderStatus());
        stm.setObject(4, idNumber);
        int res = stm.executeUpdate();
        return res > 0;
		
	}
	

}
