package com.amazon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.amazon.entity.User;
import com.amazon.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public User saveUserDetails(User user) {
		return userRepo.save(user);
	}

	
	
	public User getUserDetails(String userId) {
		return userRepo.findByUserId(userId);
	}

	public String deleteUserDetails(String userId) {
		userRepo.deleteById(userId);  //deleteById()--> in-build method
		return "user deleted";
	}

	public void updateUserDetails(User user) {
		userRepo.save(user);
	}

}
