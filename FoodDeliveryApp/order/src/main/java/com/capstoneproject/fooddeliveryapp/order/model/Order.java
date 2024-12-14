package com.capstoneproject.fooddeliveryapp.order.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.capstoneproject.fooddeliveryapp.order.dto.FoodItemsDTO;
import com.capstoneproject.fooddeliveryapp.order.dto.Restaurant;
import com.capstoneproject.fooddeliveryapp.order.dto.UserDTO;

@Document("order")
public class Order {
	private Integer orderId; 
	private List<FoodItemsDTO>foodItemsList;
	private Restaurant restaurant; 
	private UserDTO userDTO;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Integer orderId, List<FoodItemsDTO> foodItemsList, Restaurant restaurant, UserDTO userDTO) {
		super();
		this.orderId = orderId;
		this.foodItemsList = foodItemsList;
		this.restaurant = restaurant;
		this.userDTO = userDTO;
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

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", foodItemsList=" + foodItemsList + ", restaurant=" + restaurant
				+ ", userDTO=" + userDTO + "]";
	} 
	
	

}
