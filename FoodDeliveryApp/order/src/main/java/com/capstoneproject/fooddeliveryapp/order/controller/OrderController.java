package com.capstoneproject.fooddeliveryapp.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstoneproject.fooddeliveryapp.order.dto.OrderDTO;
import com.capstoneproject.fooddeliveryapp.order.dto.OrderDTOFromFE;
import com.capstoneproject.fooddeliveryapp.order.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/saveOrder")
	public ResponseEntity<OrderDTO>saveOrder(@RequestBody OrderDTOFromFE orderDetails){
		OrderDTO orderSavedInDB = orderService.saveOrderInDb(orderDetails);
		return new ResponseEntity<>(orderSavedInDB,HttpStatus.CREATED); 
	}
	

}
