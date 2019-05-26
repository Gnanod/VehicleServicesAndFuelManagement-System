 package com.sliit.vsafms.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
 

import com.sliit.vsafms.model.Part;
import com.sliit.vsafms.service.PartManagement;
import com.sliit.vsafms.util.DBConnection;
import com.sliit.vsafms.servlet.AddPartServlet;

public class PartManagementImpl implements PartManagement {

	//private Connection conn;
	private Connection conn;
	public PartManagementImpl() {
		conn= DBConnection.getConnection();
		// conn = (Connection) DBConnection.getConnection();
	}

	@Override
	public boolean addNewPart(Part pt)throws SQLException{
		 
		String sql = "insert into part values(?,?,?,?,?,?,?)";
		PreparedStatement pre =conn.prepareStatement(sql);
	//	PreparedStatement pre = conn.prepareStatement(sql);
		
		System.out.println();
		pre.setObject(1, 0);
		pre.setObject(2, pt.getPartName());
		pre.setObject(3, pt.getPrice());
		pre.setObject(4, pt.getQty());
		pre.setObject(5, pt.getBrand());
		pre.setObject(6, pt.getModel());
		pre.setObject(7, pt.getPhoto());
	int res = pre.executeUpdate();
		
		return res>0;
	}

	@Override
	public Part getPartDetails(String searchname) throws SQLException {
		String sql = "select * from Part where partName ='"+searchname+"'";
		Statement st = conn.createStatement();
		ResultSet ans = st.executeQuery(sql);
		
		ArrayList<Part> partlist= new ArrayList<Part>();
		Part ps = new Part();
		
		while(ans.next()) {
			
			ps.setPhoto(ans.getString("photo"));
			ps.setPartName(ans.getString("partName"));
			ps.setBrand(ans.getString("brand"));
			ps.setModel(ans.getString("model"));
			ps.setQty(ans.getString("qut"));
			ps.setPrice(ans.getString("price"));
			
			 
		
		}
		return ps;
	}

	@Override
	public ArrayList<Part> getAllParts() throws SQLException {
		String sql = "select * from part";
		
		Statement st = conn.createStatement();
		ResultSet ans = st.executeQuery(sql);
		ArrayList<Part> partList = new ArrayList<Part>();
		
		while(ans.next())
		{
			Part p = new Part();
			
			p.setPartId(ans.getString("partId"));
			p.setPhoto(ans.getString("photo"));
			p.setPhoto(ans.getString("photo"));
			p.setPartName(ans.getString("partName"));
			p.setBrand(ans.getString("brand"));
			p.setModel(ans.getString("model"));
			p.setQty(ans.getString("qut"));
			p.setPrice(ans.getString("price"));
			
			partList.add(p);
		}
		
		return partList;
	}

	@Override
	public ArrayList<Part> getPartPrice() throws SQLException {
		 
		String sql = "select price,partName,partId from part";
		
		Statement stme = conn.createStatement();
		ResultSet ans = stme.executeQuery(sql);
		ArrayList<Part> priceList = new ArrayList<Part>();
		
		while(ans.next())
		{
			Part pr = new Part();
			
			pr.setPartId(ans.getString("partId"));
			pr.setPartName(ans.getString("partName"));
			pr.setPrice(ans.getString("price"));
			
			priceList.add(pr);
		}
		return priceList;
	}

	@Override
	public boolean deletePart(String partId) throws SQLException {
		String sql = "Delete from part where partId='"+partId+"'";
		Statement st = conn.createStatement();
		
		return st.executeUpdate(sql)>0;
	}

	@Override
	public boolean updatePartPrice(String partId, String price) throws SQLException {
		 String sql = "update part set price='"+price+"' where partId ='"+partId+"'";
		 Statement st = conn.createStatement();
		 
		return st.executeUpdate(sql)>0;
	}

 
	 
	 
}
