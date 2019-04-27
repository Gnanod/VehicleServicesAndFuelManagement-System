package com.sliit.vsafms.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sliit.vsafms.model.Customer;

public interface CustomerService {

	public ArrayList<Customer> getAllCustomer() throws SQLException;

	public ArrayList<Customer> SearchCustomer(String searchName)throws Exception;

	public int searchExcistingCustomer(String nic)throws Exception;

	public int getCustomerId(String nic)throws Exception;

	public boolean addNewCustomer(Customer cus)throws Exception;

	public int lastId()throws Exception;
}
