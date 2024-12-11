package com.capstoneproject.fooddeliveryapp.userInfo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.capstoneproject.fooddeliveryapp.userInfo.dto.UserDTO;
import com.capstoneproject.fooddeliveryapp.userInfo.model.User;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class); 
	
	User mapUserDTOToUser(UserDTO userDTO); 
	
	UserDTO mapUserToUserDTO(User user); 
	
	
	

}