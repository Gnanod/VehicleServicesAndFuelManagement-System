package com.sliit.vsafms.service;

import java.sql.SQLException;

public interface UpdateJobOrderService {

	boolean updateJobOrder(String id, String jobOrderDescription)throws SQLException;

	boolean AddPartsJobOrder(String id, String partsId)throws SQLException;

}
