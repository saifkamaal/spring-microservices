package com.example.trainingorderservice.cleint;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "training-product-service")
public interface ProductClient {
	
	@GetMapping("/api/product/{id}")
	Boolean checkProduct(@PathVariable Integer id);

}
