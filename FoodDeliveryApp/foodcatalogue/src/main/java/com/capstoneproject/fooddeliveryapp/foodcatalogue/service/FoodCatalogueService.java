package com.capstoneproject.fooddeliveryapp.foodcatalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capstoneproject.fooddeliveryapp.foodcatalogue.dto.FoodCataloguePage;
import com.capstoneproject.fooddeliveryapp.foodcatalogue.dto.FoodItemDTO;
import com.capstoneproject.fooddeliveryapp.foodcatalogue.dto.Restaurant;
import com.capstoneproject.fooddeliveryapp.foodcatalogue.mapper.FoodItemMapper;
import com.capstoneproject.fooddeliveryapp.foodcatalogue.model.FoodItem;
import com.capstoneproject.fooddeliveryapp.foodcatalogue.repository.FoodItemRepository;

@Service
public class FoodCatalogueService {

	@Autowired
	FoodItemRepository foodItemRepository;
	
	@Autowired
	RestTemplate restTemplate; 
	

	public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
		 FoodItem foodItemSavedInDB= foodItemRepository.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO)); 
		return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItemSavedInDB); 
				
	}

	public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {
		
		//food item list
		//restaurantdetails
		
		List<FoodItem>foodItemList=fetchFoodItemList(restaurantId); 
		
		Restaurant restaurant=fetchRestaurantDetailsFromRestaurantMS(restaurantId); 

		return createFoodCataloguePage(foodItemList,restaurant); 
		
		
	}

	private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
		FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
		foodCataloguePage.setFoodItemList(foodItemList);
		foodCataloguePage.setRestaurant(restaurant);
		return foodCataloguePage;
		
		}

	private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
	return restTemplate.getForObject("http://RESTAURANTLISTING/restaurant/fetchById/"+restaurantId, Restaurant.class);
	}

	private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
		return foodItemRepository.findByRestaurantId(restaurantId); 
		
	} 
	
	
}
