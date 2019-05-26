package com.sliit.vsafms.service;

import com.sliit.vsafms.model.User;

public interface UserService {

	public String LoginFunction(User user)throws Exception;

	public String CheckUserNic(User user)throws Exception;

	public String CheckUserPassword(User user)throws Exception;

}
