package com.sliit.vsafms.model;

public class BreakDownJobOrder {
	int jobOrderId;
	String jobOrderDescription;
	String jobOrderStatus;
	
	public BreakDownJobOrder() {
		this.jobOrderId =0;
		this.jobOrderDescription = null;
		this.jobOrderStatus = null;
	}

	public BreakDownJobOrder(int jobOrderId, String jobOrderDescription, String jobOrderStatus) {
		super();
		this.jobOrderId = jobOrderId;
		this.jobOrderDescription = jobOrderDescription;
		this.jobOrderStatus = jobOrderStatus;
	}

	public int getJobOrderId() {
		return jobOrderId;
	}

	public void setJobOrderId(int jobOrderId) {
		this.jobOrderId = jobOrderId;
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
