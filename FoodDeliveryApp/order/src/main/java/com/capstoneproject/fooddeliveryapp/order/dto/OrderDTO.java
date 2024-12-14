package com.capstoneproject.fooddeliveryapp.order.dto;

import java.util.List;

public class OrderDTO {
	
	private Integer orderId;
	private List<FoodItemsDTO>foodItemsList; 
	private UserDTO userDTO;
	private Restaurant restaurant;
	
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDTO(Integer orderId, List<FoodItemsDTO> foodItemsList, UserDTO userDTO, Restaurant restaurant) {
		super();
		this.orderId = orderId;
		this.foodItemsList = foodItemsList;
		this.userDTO = userDTO;
		this.restaurant = restaurant;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public List<FoodItemsDTO> getFoodItemsList() {
		return foodItemsList;
	}

	public void setFoodItemsList(List<FoodItemsDTO> foodItemsList) {
		this.foodItemsList = foodItemsList;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", foodItemsList=" + foodItemsList + ", userDTO=" + userDTO
				+ ", restaurant=" + restaurant + "]";
	}
	
	

}
