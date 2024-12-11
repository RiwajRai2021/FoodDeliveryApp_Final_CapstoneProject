package com.capstoneproject.fooddeliveryapp.userInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstoneproject.fooddeliveryapp.userInfo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	

}
