package com.amazon.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.entity.Cart;
import com.amazon.entity.CartDetails;
import com.amazon.entity.Order;
import com.amazon.entity.OrderDetails;
import com.amazon.entity.Product;
import com.amazon.repo.OrderRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private ProductDetailsProxy productDetailsProxy;
	
	public void addtoOrder(Order order) {
		orderRepo.save(order);
	}
	
	public OrderDetails displayAllProductInorder(String userId) {

		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setUserId(userId);

		ArrayList<Order> orderList = (ArrayList<Order>) orderRepo.findByUserId(userId);
		ArrayList<Product> proList = new ArrayList<Product>();

		for (int i = 0; i < orderList.size(); i++) {
			Product product = productDetailsProxy.getProductDetails(orderList.get(i).getProductId());
		
			proList.add(product);
		}

		orderDetails.setList(proList);
		return orderDetails;

	}
}
