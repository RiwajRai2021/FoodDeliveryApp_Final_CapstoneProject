package com.capstoneproject.fooddeliveryapp.userInfo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	public ResponseEntity<UserDTO>fetchUserDetailsById(Integer userId) {
		Optional<User>fetchedUser =  userRepository.findById(userId);
		if(fetchedUser.isPresent())
			return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(fetchedUser.get()),HttpStatus.OK); 
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); 
	
	} 

}
