package com.sliit.vsafms.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.sliit.vsafms.model.Customer;
import com.sliit.vsafms.service.CustomerService;
import com.sliit.vsafms.util.DBConnection;

public class CustomerServiceImpl implements CustomerService{

	private static Connection conn;
	private PreparedStatement preparedStatement;
	public CustomerServiceImpl() {
		
		conn= DBConnection.getConnection();
	}

	@Override
	public ArrayList<Customer> getAllCustomer() throws SQLException {
		String sql = "select * from customer ";
		Statement statement= conn.createStatement();
		ResultSet rst = statement.executeQuery(sql);
		
		ArrayList<Customer> cusList = new ArrayList<Customer>();
		while(rst.next()) {
			
			Customer cus = new Customer();
			cus.setCustomerID(Integer.parseInt(rst.getString("customerId")));
			cus.setCustomerFName(rst.getString("customerFName"));
			cus.setCustomerLName(rst.getString("customerSName"));
			cus.setCustomerNic(rst.getString("customerNic"));
			cus.setCustomerEmail(rst.getString("customerEmail"));
			cus.setCustomerAddress(rst.getString("customerAddress"));
			cus.setCustomerPhone(rst.getString("customerPhone"));
			
			cusList.add(cus);
			
		}
		
		return cusList;
	}

	@Override
	public ArrayList<Customer> SearchCustomer(String searchName) throws Exception {
		String sql = "select * from customer where customerFName='"+searchName+"' || customerSName='"+searchName+"'|| customerNic='"+searchName+"' ";
		Statement statement= conn.createStatement();
		ResultSet rst = statement.executeQuery(sql);
		
		ArrayList<Customer> cusList = new ArrayList<Customer>();
		while(rst.next()) {
			
			Customer cus = new Customer();
			cus.setCustomerID(Integer.parseInt(rst.getString("customerId")));
			cus.setCustomerFName(rst.getString("customerFName"));
			cus.setCustomerLName(rst.getString("customerSName"));
			cus.setCustomerNic(rst.getString("customerNic"));
			cus.setCustomerEmail(rst.getString("customerEmail"));
			cus.setCustomerAddress(rst.getString("customerAddress"));
			cus.setCustomerPhone(rst.getString("customerPhone"));
			
			cusList.add(cus);
			
			
			
		}
		
		return cusList;
		
	}

	@Override
	public int searchExcistingCustomer(String nic) throws Exception {
		
		String sql1 ="select count(customerId)from customer where customerNic='"+nic+"'";
		Statement statement= conn.createStatement();
		ResultSet rst = statement.executeQuery(sql1);
		int  number1=0;
		if(rst.next()){
	       number1= rst.getInt(1);
	    }
		return number1;
	}

	@Override
	public int getCustomerId(String nic) throws Exception {
		
		String sql1 ="select customerId from customer where customerNic='"+nic+"'";
		Statement statement= conn.createStatement();
		ResultSet rst = statement.executeQuery(sql1);
		int  number1=0;
		if(rst.next()){
	       number1= rst.getInt(1);
	    }
		return number1;
		
	}

	@Override
	public boolean addNewCustomer(Customer cus) throws Exception {
		String SQL = "Insert into customer Values(?,?,?,?,?,?,?)";
		System.out.println(SQL);
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, 0);
        stm.setObject(2, cus.getCustomerFName());
        stm.setObject(3, cus.getCustomerLName());
        stm.setObject(4, cus.getCustomerNic());
        stm.setObject(5, cus.getCustomerPhone());
        stm.setObject(6, cus.getCustomerEmail());
        stm.setObject(7, cus.getCustomerAddress());
        int res = stm.executeUpdate();
        return res > 0;
		
	}

	@Override
	public int lastId() throws Exception {
		
		String sql1 ="select Max(customerId) from customer";
		Statement statement= conn.createStatement();
		ResultSet rst = statement.executeQuery(sql1);
		int  number1=0;
		if(rst.next()){
	       number1= rst.getInt(1);
	    }
		return number1;
	
	}

}
