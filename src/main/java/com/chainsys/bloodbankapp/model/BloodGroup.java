package com.chainsys.bloodbankapp.model;

public class BloodGroup {

	private int userId;
	private String userName;
	private String email;
	private int bloodGroupId;
	private String bloodsGroup;
	private String city;
	private boolean active;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBloodGroupId() {
		return bloodGroupId;
	}
	public void setBloodGroupId(int bloodGroupId) {
		this.bloodGroupId = bloodGroupId;
	}
	public String getBloodsGroup() {
		return bloodsGroup;
	}
	public void setBloodsGroup(String bloodsGroup) {
		this.bloodsGroup = bloodsGroup;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public BloodGroup(int userId, String userName, String email, int bloodGroupId, String bloodsGroup, String city,
			boolean active) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.bloodGroupId = bloodGroupId;
		this.bloodsGroup = bloodsGroup;
		this.city = city;
		this.active = active;
	}
	public BloodGroup() {
		super();
	}
	@Override
	public String toString() {
		return "BloodGroup [userId=" + userId + ", userName=" + userName + ", email=" + email + ", bloodGroupId="
				+ bloodGroupId + ", bloodsGroup=" + bloodsGroup + ", city=" + city + ", active=" + active + "]";
	}
	
}
	