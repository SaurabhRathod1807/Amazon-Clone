package com.amazon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amazon.entity.Cart;
import com.amazon.entity.CartDetails;
import com.amazon.entity.Product;
import com.amazon.repo.CartRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartService {

	@Autowired
	private CartRepo cartRepo;

	@Autowired
	private ProductDetailsProxy productDetailsProxy;

	public void addToCart(Cart cart) {
		cartRepo.save(cart);
	}


//	show the list of product available in cart by using particular userId
	public CartDetails displayAllProductInCart(String userId) {

		CartDetails cartDetails = new CartDetails();
		cartDetails.setUserId(userId);

		ArrayList<Cart> cartList = cartRepo.findByUserId(userId);
		ArrayList<Product> proList = new ArrayList<Product>();

		for (int i = 0; i < cartList.size(); i++) {
			Product product = productDetailsProxy.getProductDetails(cartList.get(i).getProductId());
			proList.add(product);
		}

		cartDetails.setList(proList);
		return cartDetails;

	}
	
	 @Transactional
	    public void removeItem(String productId, String userId) {
	        cartRepo.deleteByProductIdAndUserId(productId, userId);
	    }
	 
}
