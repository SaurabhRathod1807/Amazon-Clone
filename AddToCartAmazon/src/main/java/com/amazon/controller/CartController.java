package com.amazon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.entity.Cart;
import com.amazon.entity.CartDetails;
import com.amazon.service.CartService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/amazon/cart/")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("add")
	public void addToCart(@RequestBody Cart cart) {
		cartService.addToCart(cart);
	}
	
	
	@GetMapping("show/{userId}")
	public CartDetails displayAllProductInCart(@PathVariable String userId) {
		return cartService.displayAllProductInCart(userId);
	}
	
	 @DeleteMapping("/remove/{userId}/{productId}")
	    public ResponseEntity<String> removeItem(@PathVariable String userId, @PathVariable String productId) {
	        cartService.removeItem(productId, userId);
	        return ResponseEntity.ok("Item removed successfully");
	    }
}
