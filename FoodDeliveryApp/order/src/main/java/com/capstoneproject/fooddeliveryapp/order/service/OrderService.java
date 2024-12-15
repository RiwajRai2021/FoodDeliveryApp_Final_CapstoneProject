package com.capstoneproject.fooddeliveryapp.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capstoneproject.fooddeliveryapp.order.dto.OrderDTO;
import com.capstoneproject.fooddeliveryapp.order.dto.OrderDTOFromFE;
import com.capstoneproject.fooddeliveryapp.order.dto.UserDTO;
import com.capstoneproject.fooddeliveryapp.order.mapper.OrderMapper;
import com.capstoneproject.fooddeliveryapp.order.model.Order;
import com.capstoneproject.fooddeliveryapp.order.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	SequenceGenerator sequenceGenerator; 

	@Autowired
	RestTemplate restTemplate; 
	
	  public OrderDTO saveOrderInDb(OrderDTOFromFE orderDetails) {
	        Integer newOrderID = sequenceGenerator.generateNextOrderId();
	        UserDTO userDTO = null; //fetchUserDetailsFromUserId(orderDetails.getUserId());
	        Order orderToBeSaved = new Order(newOrderID, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDTO );
	        orderRepository.save(orderToBeSaved);
	        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
	    }

	    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
	       return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDTO.class);
	    }
	}