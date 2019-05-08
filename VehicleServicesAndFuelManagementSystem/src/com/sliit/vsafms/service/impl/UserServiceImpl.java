package com.sliit.vsafms.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sliit.vsafms.model.User;
import com.sliit.vsafms.service.UserService;
import com.sliit.vsafms.util.DBConnection;

public class UserServiceImpl implements UserService {

	Connection conn;
	public UserServiceImpl() {
		
		conn = DBConnection.getConnection();
		
	}
	
	@Override
	public String LoginFunction(User user) throws SQLException  {
		String sql2 =" select position from user where userNic='"+user.getNic()+"' && userPassword='"+user.getPassword()+"';";
		Statement statement= conn.createStatement();
		ResultSet rst2 = statement.executeQuery(sql2);
		String postion=null;
		if(rst2.next()) {
			
			postion=rst2.getString("position");
			
			
		}else {
			postion="error";
		}
		return postion;
	}

	@Override
	public String CheckUserNic(User user) throws Exception {
		String sql2 =" select userId from user where userNic='"+user.getNic()+"'";
		Statement statement= conn.createStatement();
		ResultSet rst2 = statement.executeQuery(sql2);
		String userNic=null;
		if(rst2.next()) {
			
			userNic=rst2.getString("userId");
			
			
		}else {
			userNic="error";
		}
		return userNic;
	}

	@Override
	public String CheckUserPassword(User user) throws Exception {
		String sql2 =" select userId from user where  userPassword='"+user.getPassword()+"'";
		Statement statement= conn.createStatement();
		ResultSet rst2 = statement.executeQuery(sql2);
		String userNic=null;
		if(rst2.next()) {
			
			userNic=rst2.getString("userId");
			
			
		}else {
			userNic="error";
		}
		return userNic;
	}
		
		
}
