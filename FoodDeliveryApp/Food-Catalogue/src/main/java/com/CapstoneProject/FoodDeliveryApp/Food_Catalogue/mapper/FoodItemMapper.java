package com.CapstoneProject.FoodDeliveryApp.Food_Catalogue.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.CapstoneProject.FoodDeliveryApp.Food_Catalogue.dto.FoodItemDTO;
import com.CapstoneProject.FoodDeliveryApp.Food_Catalogue.model.FoodItem;

@Mapper
public interface FoodItemMapper {

	FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class); 
	
	FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO); 
	
	FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem); 
	
}
