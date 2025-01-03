package com.capstoneproject.fooddeliveryapp.userInfo.dto;

public class UserDTO {
	

	private int userId; 
	
	private String userName; 
	
	private String userPassword; 
	
	private String address; 
	
	private String city;
	
	private String role; 

	public UserDTO(int userId, String userName, String userPassword, String address, String city, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.address = address;
		this.city = city;
		this.role = role; 
	}

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	

}
