package com.capstoneproject.fooddeliveryapp.foodcatalogue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstoneproject.fooddeliveryapp.foodcatalogue.model.FoodItem;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Integer>{

	List<FoodItem> findByRestaurantId(Integer restaurantId);
	
	
	

}
