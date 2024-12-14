package com.capstoneproject.fooddeliveryapp.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.capstoneproject.fooddeliveryapp.order.dto.OrderDTO;
import com.capstoneproject.fooddeliveryapp.order.model.Order;

@Mapper
public interface OrderMapper {
	
	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class); 
	
	Order mapOrderDTOToOrder(OrderDTO orderDTO); 
	OrderDTO mapOrderToOrderDTO(Order order); 
	
	
	

}
