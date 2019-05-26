package com.sliit.vsafms.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sliit.vsafms.model.Supplier;

public interface SupplierService {
	




	
	public ArrayList<Supplier> getAllSupplier() throws SQLException;

	public Supplier SearchSupplier(String searchName)throws Exception;

	public int searchExcistingSupplier(String sId)throws Exception;

	public int getSupplierId(String sId)throws Exception;

	boolean addNewSupplier(Supplier newSupplier) throws SQLException;

	public boolean deleteSupplier(String supId) throws Exception;

	

}
