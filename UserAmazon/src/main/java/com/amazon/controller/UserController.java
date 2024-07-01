package com.amazon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amazon.entity.User;
import com.amazon.service.UserService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/amazon/user/")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("saveuser")
	public User saveUserDetails(@RequestBody User user) {
		return userService.saveUserDetails(user);
	}

	@GetMapping("getUser/{userId}")
	public User getUserDetails(@PathVariable String userId) {
		return userService.getUserDetails(userId);
	}
	
	
	
	@DeleteMapping("remove/{userId}")
	public String deleteUserDetails(@PathVariable String userId) {
		return userService.deleteUserDetails(userId);
	}
	
	@PutMapping("updateUser/{userId}")
	public void updateUserDetails(@RequestBody User user) {
		userService.updateUserDetails(user);
	}

	
}
