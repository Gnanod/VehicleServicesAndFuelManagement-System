package com.sliit.vsafms.model;

public class JobOrder {
	int jobOrderID;
	String jobOrderDescription;
	String jobOrderStatus;
	
	

	public JobOrder() {
		// TODO Auto-generated constructor stub
	}
	
	public JobOrder(int jobOrderID, String jobOrderDescription, String jobOrderStatus) {
		super();
		this.jobOrderID = jobOrderID;
		this.jobOrderDescription = jobOrderDescription;
		this.jobOrderStatus = jobOrderStatus;
	}
	


	public int getJobOrderID() {
		return jobOrderID;
	}

	public void setJobOrderID(int jobOrderID) {
		this.jobOrderID = jobOrderID;
	}

	public String getJobOrderDescription() {
		return jobOrderDescription;
	}

	public void setJobOrderDescription(String jobOrderDescription) {
		this.jobOrderDescription = jobOrderDescription;
	}

	public String getJobOrderStatus() {
		return jobOrderStatus;
	}

	public void setJobOrderStatus(String jobOrderStatus) {
		this.jobOrderStatus = jobOrderStatus;
	}
	
	
	
}