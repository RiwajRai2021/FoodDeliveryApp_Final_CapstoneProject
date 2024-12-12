package com.capstoneproject.fooddeliveryapp.foodcatalogue.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.capstoneproject.fooddeliveryapp.foodcatalogue.dto.FoodItemDTO;
import com.capstoneproject.fooddeliveryapp.foodcatalogue.model.FoodItem;


@Mapper
public interface FoodItemMapper {
	
	FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class); 
	
	FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO); 
	
	FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem); 

}
