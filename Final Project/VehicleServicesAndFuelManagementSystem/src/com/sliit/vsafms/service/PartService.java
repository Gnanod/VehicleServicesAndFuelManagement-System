package com.sliit.vsafms.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sliit.vsafms.model.Part;

public interface PartService {

	Part getPartDetails(String searchId);

	Part getPart(String searchPart) throws SQLException;
	
	ArrayList<Part> getAllParts() throws SQLException;

	boolean RemovePart(String delete) throws SQLException;

}
