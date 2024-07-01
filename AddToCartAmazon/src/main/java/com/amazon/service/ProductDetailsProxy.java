package com.amazon.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.amazon.entity.Product;

@Component
@FeignClient(name = "ProductAmazon", url = "localhost:8082")
public interface ProductDetailsProxy {

	@GetMapping("/amazon/product/getproduct/{productId}")
	public Product getProductDetails(@PathVariable String productId);
	
}
