package com.amazon.controller;

import java.util.List;
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
import com.amazon.entity.Product;
import com.amazon.service.ProductService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/amazon/product/")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("saveproduct")
	public Product saveProductDetails(@RequestBody Product product) {
		return productService.saveProductDetails(product);
	}

	@GetMapping("getallproduct")
	public List<Product> getAllProductDetails() {
		return productService.getAllProductDetails();
	}

	@GetMapping("/getproduct/{productId}")
	public Product getProductDetails(@PathVariable String productId) {
		return productService.getProductDetails(productId);
	}

	@DeleteMapping("remove/{productId}")
	public String deleteProductDetails(@PathVariable String productId) {
		return productService.deleteProductDetails(productId);

	}
	
	@PutMapping("updateproduct/{productId}")
	public Product updateProductDetails(@RequestBody Product product) {
		return productService.updateProductDetails(product);
	}

}
