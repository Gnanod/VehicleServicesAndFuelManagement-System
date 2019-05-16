package com.sliit.vsafms.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sliit.vsafms.model.Supplier;
import com.sliit.vsafms.service.SupplierService;
import com.sliit.vsafms.util.DBConnection;

public class SupplierServiceImpl implements SupplierService {
	
	private static Connection conn;
	private PreparedStatement preparedStatement;
	public SupplierServiceImpl() {
		
		conn= DBConnection.getConnection();
	}


	@Override
	public ArrayList<Supplier> getAllSupplier() throws SQLException {
		String sql = "select * from Supplier where supplierId like 'FU%'";
		Statement statement= conn.createStatement();
		ResultSet rst = statement.executeQuery(sql);
		
		ArrayList<Supplier> supList = new ArrayList<Supplier>();
		while(rst.next()) {
			
			Supplier sup = new Supplier();
			sup.setsID(rst.getString("supplierId"));
			sup.setsName(rst.getString("supplierName"));
			sup.setsPhone(rst.getString("supplierPhone"));
			sup.setsEmail(rst.getString("supplierEmail"));
			sup.setsAddress(rst.getString("supplierAddress"));
			
			supList.add(sup);
			
		}
		
		return supList;
	}

	@Override
	public Supplier SearchSupplier(String searchName) throws Exception {
		String sql = "select * from supplier where supplierName='"+searchName+"' || supplierId='"+searchName+"' ";
		Statement statement= conn.createStatement();
		ResultSet rst = statement.executeQuery(sql);
		
		ArrayList<Supplier> supList = new ArrayList<Supplier>();
		Supplier sup = new Supplier();
		
		while(rst.next()) {
			
			
			sup.setsID(rst.getString("supplierId"));
			sup.setsName(rst.getString("supplierName"));
			sup.setsPhone(rst.getString("supplierPhone"));
			sup.setsEmail(rst.getString("supplierEmail"));
			sup.setsAddress(rst.getString("supplierAddress"));
			
			
		}
		
		return sup;
	}

	@Override
	public int searchExcistingSupplier(String sId) throws Exception {
		String sql1 ="select count(sId)from supplier where supplierId='"+sId+"'";
		Statement statement= conn.createStatement();
		ResultSet rst = statement.executeQuery(sql1);
		int  number1=0;
		if(rst.next()){
	       number1= rst.getInt(1);
	    }
		return number1;
	}

	@Override
	public int getSupplierId(String sId) throws Exception {
		String sql1 ="select supplierId from supplier where supplierId='"+sId+"'";
		Statement statement= conn.createStatement();
		ResultSet rst = statement.executeQuery(sql1);
		int  number1=0;
		if(rst.next()){
	       number1= rst.getInt(1);
	    }
		return number1;
	}



	@Override
	public boolean addNewSupplier(Supplier newSupplier)throws SQLException  {
		String SQL = "Insert into supplier Values(?,?,?,?,?)";
		System.out.println(SQL);
        PreparedStatement stm = conn.prepareStatement(SQL); 
        
        stm.setObject(1, newSupplier.getsID());
        stm.setObject(2, newSupplier.getsName());
        stm.setObject(3, newSupplier.getsPhone());
        stm.setObject(4, newSupplier.getsEmail());
        stm.setObject(5, newSupplier.getsAddress());
        
        int res = stm.executeUpdate();
        return res > 0;
	}


	@Override
	public boolean deleteSupplier(String supId)throws Exception {
		String SQL = "delete from supplier where supplierId='"+supId+"'";
		Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;
	}
	


}
