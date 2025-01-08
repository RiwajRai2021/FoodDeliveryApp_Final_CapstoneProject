package com.CapstoneProject.FoodDeliveryApp.Food_Catalogue.dto;

import java.util.List;

import com.CapstoneProject.FoodDeliveryApp.Food_Catalogue.model.FoodItem;


public class FoodCataloguePage {

    private List<FoodItem> foodItemsList;
    private Restaurant restaurant;
    
    public FoodCataloguePage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FoodCataloguePage(List<FoodItem> foodItemsList, Restaurant restaurant) {
		super();
		this.foodItemsList = foodItemsList;
		this.restaurant = restaurant;
	}
	public List<FoodItem> getFoodItemsList() {
		return foodItemsList;
	}
	public void setFoodItemsList(List<FoodItem> foodItemsList) {
		this.foodItemsList = foodItemsList;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
    
	
    
}


