package com.sliit.vsafms.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.sliit.vsafms.service.UpdateJobOrderService;
import com.sliit.vsafms.util.DBConnection;

public class UpdateJobOrderServiceImpl implements UpdateJobOrderService{

	private Connection conn;
	public UpdateJobOrderServiceImpl() {
		
		conn = DBConnection.getConnection();
	}
	@Override
	public boolean updateJobOrder(String id, String jobOrderDescription) throws SQLException {
		
		String SQL = "Update joborder set jobOrderDescription='" +jobOrderDescription+ "',jobOrderStatus='Assigned'  where jobOrderId='" +id+ "'";
        Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;
	}
	@Override
	public boolean AddPartsJobOrder(String id, String partsId) throws SQLException {
		
		String SQL = "Insert into JobOrderParts Values(?,?)";
        PreparedStatement stm = conn.prepareStatement(SQL);
        System.out.println("GGGGGGGGGG"+SQL);
        stm.setObject(1, id);
        stm.setObject(2, partsId);
        
        int res = stm.executeUpdate();
        return res > 0;
        
	}

}
