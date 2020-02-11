package com.chainsys.bloodbankapp.model;

public class BloodGroup {

	private int empId;
	private String empName;
	private String email;
	private String bloodsGroup;
	private boolean active;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBloodGroup() {
		return bloodsGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodsGroup = bloodGroup;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public BloodGroup(int empId, String empName, String email, String bloodsGroup, boolean active) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		this.bloodsGroup = bloodsGroup;
		this.active = active;
	}
	
	public BloodGroup() {
		super();
	}
	@Override
	public String toString() {
		return "BloodGroup [empId=" + empId + ", empName=" + empName + ", email=" + email + ", bloodGroup=" + bloodsGroup
				+ ", active=" + active + "]";
	}
	
}
