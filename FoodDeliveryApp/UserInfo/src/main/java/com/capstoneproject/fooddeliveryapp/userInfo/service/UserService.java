package com.capstoneproject.fooddeliveryapp.userInfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstoneproject.fooddeliveryapp.userInfo.dto.UserDTO;
import com.capstoneproject.fooddeliveryapp.userInfo.mapper.UserMapper;
import com.capstoneproject.fooddeliveryapp.userInfo.model.User;
import com.capstoneproject.fooddeliveryapp.userInfo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public UserDTO addUser(UserDTO userDTO) {
		User savedUser = userRepository.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO)); 
		return UserMapper.INSTANCE.mapUserToUserDTO(savedUser); 
	} 

}
