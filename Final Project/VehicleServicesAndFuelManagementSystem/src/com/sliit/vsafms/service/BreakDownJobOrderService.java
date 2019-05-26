package com.sliit.vsafms.service;

import com.sliit.vsafms.model.BreakDownJobOrder;
import com.sliit.vsafms.model.Customer;
import com.sliit.vsafms.model.Vehicle;

public interface BreakDownJobOrderService {

	public boolean addBreakDownServiceJobOrder(BreakDownJobOrder bo, int idNumber)throws Exception;

	


}
