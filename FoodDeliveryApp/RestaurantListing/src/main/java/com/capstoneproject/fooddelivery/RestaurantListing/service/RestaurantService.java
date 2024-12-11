package com.capstoneproject.fooddelivery.RestaurantListing.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capstoneproject.fooddelivery.RestaurantListing.dto.RestaurantDTO;
import com.capstoneproject.fooddelivery.RestaurantListing.mapper.RestaurantMapper;
import com.capstoneproject.fooddelivery.RestaurantListing.model.Restaurant;
import com.capstoneproject.fooddelivery.RestaurantListing.repository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	public List<RestaurantDTO> findAllRestaurants() {
		List<Restaurant> restaurants = restaurantRepository.findAll();
		List<RestaurantDTO> restaurantDTOList = restaurants.stream()
				.map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant))
				.collect(Collectors.toList());
		return restaurantDTOList;
	}

	public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO) {
		Restaurant savedRestaurant = restaurantRepository
				.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
		return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(savedRestaurant);
	}

	public ResponseEntity<RestaurantDTO> fetchRestaurantById(Integer id) {
		Optional<Restaurant> restaurant = restaurantRepository.findById(id);
		if (restaurant.isPresent()) {
			return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get()),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

	}
}
