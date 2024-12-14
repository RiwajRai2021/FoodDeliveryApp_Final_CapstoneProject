package com.capstoneproject.fooddeliveryapp.order.dto;

import java.util.List;

public class OrderDTOFromFE {
	
	private List<FoodItemsDTO>foodItemsList; 
	private Integer userId; 
	private Restaurant restaurant;
	
	public OrderDTOFromFE() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDTOFromFE(List<FoodItemsDTO> foodItemsList, Integer userId, Restaurant restaurant) {
		super();
		this.foodItemsList = foodItemsList;
		this.userId = userId;
		this.restaurant = restaurant;
	}

	public List<FoodItemsDTO> getFoodItemsList() {
		return foodItemsList;
	}

	public void setFoodItemsList(List<FoodItemsDTO> foodItemsList) {
		this.foodItemsList = foodItemsList;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	} 
	
	
	

}
