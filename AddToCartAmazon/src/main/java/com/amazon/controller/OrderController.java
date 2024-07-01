package com.amazon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.entity.Cart;
import com.amazon.entity.CartDetails;
import com.amazon.entity.Order;
import com.amazon.entity.OrderDetails;
import com.amazon.service.OrderService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/amazon/order/")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("add")
	public void addToOrder(@RequestBody Order order) {
		orderService.addtoOrder(order);
	}
	
	@GetMapping("show/{userId}")
	public OrderDetails displayAllProductInOrder(@PathVariable String userId) {
		return orderService.displayAllProductInorder(userId);
	}
}
