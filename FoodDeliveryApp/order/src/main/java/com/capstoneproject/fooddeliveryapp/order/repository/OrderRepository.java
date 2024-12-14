package com.capstoneproject.fooddeliveryapp.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capstoneproject.fooddeliveryapp.order.model.Order;

public interface OrderRepository extends MongoRepository<Order, Integer>{
	
	

}
