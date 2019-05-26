package com.sliit.vsafms.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sliit.vsafms.model.Part;

public interface PartManagement {
	
	public boolean addNewPart(Part pt)throws SQLException;

	public Part getPartDetails(String searchname) throws SQLException;
	
	public ArrayList<Part> getAllParts() throws SQLException;
	
	public ArrayList<Part> getPartPrice() throws SQLException;

	public boolean deletePart(String partId) throws SQLException;

	public boolean updatePartPrice(String partId, String price)throws SQLException;
}
