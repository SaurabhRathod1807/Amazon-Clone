package com.amazon.repo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.amazon.entity.Cart;

@Repository
public interface CartRepo extends CrudRepository<Cart, Long>{

	Cart save(Cart cart);
		
	ArrayList<Cart> findByUserId(String userId);
	
	void deleteByProductIdAndUserId(String productId, String userId);
	
}
