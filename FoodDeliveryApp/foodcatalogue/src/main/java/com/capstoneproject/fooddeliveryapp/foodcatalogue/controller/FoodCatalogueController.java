package com.capstoneproject.fooddeliveryapp.foodcatalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstoneproject.fooddeliveryapp.foodcatalogue.dto.FoodCataloguePage;
import com.capstoneproject.fooddeliveryapp.foodcatalogue.dto.FoodItemDTO;
import com.capstoneproject.fooddeliveryapp.foodcatalogue.service.FoodCatalogueService;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {
	
	@Autowired
	private FoodCatalogueService foodCatalogueService; 
	
	@PostMapping("/addFoodItem")
	public ResponseEntity<FoodItemDTO>addFoodItem(@RequestBody FoodItemDTO foodItemDTO){
		FoodItemDTO foodItemSaved = foodCatalogueService.addFoodItem(foodItemDTO); 
		return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED); 
			
	}
	
	@GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
	public ResponseEntity<FoodCataloguePage>fetchRestaurantDetailsWithFoodMenu(@PathVariable Integer restaurantId){
		FoodCataloguePage foodCataloguePage=foodCatalogueService.fetchFoodCataloguePageDetails(restaurantId); 
		return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK); 
	
	}
	
	
	
	
	
	
	
	
	

}
