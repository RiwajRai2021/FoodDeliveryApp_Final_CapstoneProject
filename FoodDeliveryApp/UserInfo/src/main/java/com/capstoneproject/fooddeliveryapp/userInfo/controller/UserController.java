package com.capstoneproject.fooddeliveryapp.userInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstoneproject.fooddeliveryapp.userInfo.dto.UserDTO;
import com.capstoneproject.fooddeliveryapp.userInfo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService; 
	
	@PostMapping("/addUser")
	public ResponseEntity<UserDTO>addUser(@RequestBody UserDTO userDTO){
		 UserDTO savedUser = userService.addUser(userDTO);
		 return new ResponseEntity<>(savedUser,HttpStatus.CREATED); 
		
	}

}
