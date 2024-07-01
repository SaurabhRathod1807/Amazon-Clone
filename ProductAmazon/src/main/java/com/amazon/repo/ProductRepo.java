package com.amazon.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.amazon.entity.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, String> {

	Product save(Product product);

	List<Product> findAll();

	Product findByProductId(String productId);
	
	
}
