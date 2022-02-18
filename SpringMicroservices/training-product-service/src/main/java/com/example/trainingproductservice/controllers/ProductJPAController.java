package com.example.trainingproductservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainingproductservice.model.Product;
import com.example.trainingproductservice.service.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductJPAController {

	private final ProductRepository productRepository;

	@GetMapping()
	public List<Product> getProduct() {
		log.info("Get Products");
		return productRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Boolean getProductById(@PathVariable Integer id) {
		log.info("Get Product by {}", id);
		return productRepository.findById(id).isPresent() ? true : false;
	}
	 

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		log.info("Create Product");
		return productRepository.save(product);

	}

	@PutMapping
	public Product updateProduct(@RequestBody Product product) {
		log.info("Update Product");
		return productRepository.save(product);

	}

	@DeleteMapping
	public void deleteProduct(@RequestBody Product product) {
		log.info("Delete Product");
		 productRepository.delete(product);
	}

}
