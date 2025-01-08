package com.CapstoneProject.FoodDeliveryApp.Food_Catalogue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CapstoneProject.FoodDeliveryApp.Food_Catalogue.model.FoodItem;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem, Integer>{
	
	List<FoodItem>findByRestaurantId(Integer restaurantId); 

}
