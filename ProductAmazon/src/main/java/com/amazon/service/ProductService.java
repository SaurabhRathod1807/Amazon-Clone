package com.amazon.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amazon.entity.Product;
import com.amazon.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public Product saveProductDetails(Product product) {
		return productRepo.save(product);
	}
	
	public List<Product> getAllProductDetails() {
		return productRepo.findAll();
	}
	
	public Product getProductDetails(String productId) {
		return productRepo.findByProductId(productId);
	}
	
	public String deleteProductDetails(String productId) {
	productRepo.deleteById(productId);
		return "product deleted";
	}
	
	public Product updateProductDetails(Product product) {
		return productRepo.save(product);
	}
	

}
