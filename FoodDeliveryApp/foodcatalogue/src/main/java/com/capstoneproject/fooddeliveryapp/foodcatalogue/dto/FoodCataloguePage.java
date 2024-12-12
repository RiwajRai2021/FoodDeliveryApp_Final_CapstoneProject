package com.capstoneproject.fooddeliveryapp.foodcatalogue.dto;

import java.util.List;

import com.capstoneproject.fooddeliveryapp.foodcatalogue.model.FoodItem;

public class FoodCataloguePage {
	
	private List<FoodItem>foodItemsList; 
	private Restaurant restaurant;
	
		
	public FoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
		super();
		this.foodItemsList = foodItemList;
		this.restaurant = restaurant;
	}
	public FoodCataloguePage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<FoodItem> getFoodItemList() {
		return foodItemsList;
	}
	public void setFoodItemList(List<FoodItem> foodItemList) {
		this.foodItemsList = foodItemList;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	} 
	
	

}
