package com.sliit.vsafms.service;

import java.sql.SQLException;
import java.util.ArrayList;
import com.sliit.vsafms.model.JobOrder;
import com.sliit.vsafms.model.JobOrderDetails;
 

public interface JobOrderService {
	
	boolean addNewJobOrder(JobOrder Jb)throws SQLException;
	
	public ArrayList<JobOrder> getAllJobOrder() throws SQLException;
	
	JobOrderDetails getJobOrderDetail(String value) throws SQLException;

}
