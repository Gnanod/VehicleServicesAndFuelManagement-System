package com.sliit.vsafms.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sliit.vsafms.model.Part;
 
import com.sliit.vsafms.service.PartService;
import com.sliit.vsafms.util.DBConnection;

public class PartServiceImpl implements PartService {
	
	private Connection conn;
	public PartServiceImpl() {
		conn = DBConnection.getConnection();
	}

	@Override
	public Part getPartDetails(String searchId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Part getPart(String searchPart) throws SQLException {
		 
		String sql = "Select * from part where partName = '"+searchPart+"'";
		System.out.println(sql);
		Statement m = conn.createStatement();
		ResultSet rst = m.executeQuery(sql);
		
		ArrayList<Part> list = new ArrayList<Part>();
		Part ps = new Part();
		
		while(rst.next())
		{
			ps.setPartName(rst.getString("partName"));
			ps.setPartId(rst.getString("partId"));
		}
		System.out.println(ps.getPartName());
		System.out.println(ps.getPartId());
		return ps;
	}

	@Override
	public ArrayList<Part> getAllParts() throws SQLException {
		 
			String sql = "select * from part ";
			Statement sta= conn.createStatement();
			ResultSet rst = sta.executeQuery(sql);
			
			ArrayList<Part> plist = new ArrayList<Part>();
			
			while(rst.next()) {
				Part p = new Part();
				p.setPartId(rst.getString("partId"));
				p.setPartName(rst.getString("partName"));
				p.setPhoto(rst.getString("photo"));
				
				System.out.println("partId"+p.getPartId());
				plist.add(p);
			}
		
			return plist;
			
		}

	@Override
	public boolean RemovePart(String delete) throws SQLException {
		String sql = "Delete from part where partId='"+delete+"'";
		Statement st = conn.createStatement();

		return st.executeUpdate(sql)>0;
	}

}
