package com.sliit.vsafms.model;

public class User {
	
	private String nic;
	private String password;
	private String position;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String nic, String password, String position) {
		super();
		this.nic = nic;
		this.password = password;
		this.position = position;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	
	
	
}
