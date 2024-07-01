package com.amazon.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.amazon.entity.Order;

public interface OrderRepo extends CrudRepository<Order, Long> {
	
	List<Order> findByUserId(String userId);
	
	Order save(Order order);
}
