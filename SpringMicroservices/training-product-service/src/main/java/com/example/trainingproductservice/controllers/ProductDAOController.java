package com.example.trainingproductservice.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import com.example.trainingproductservice.model.Product;
import com.example.trainingproductservice.service.ProductDAOService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dao/product")
public class ProductDAOController {

	private final ProductDAOService productDAOService;

	@GetMapping({ "/", "", "/{id}" })
	public List<Product> getProduct(@PathVariable(required = false) Integer id) {
		log.info("Get Product");
		if (id != null) {
			Product product = productDAOService.findById(id);
			product.add(linkTo(methodOn(ProductDAOController.class).getProduct(id)).withSelfRel(),
					linkTo(methodOn(ProductDAOController.class).createProduct(product)).withRel("createProduct"));
			return Collections.singletonList(productDAOService.findById(id));
		}
		return productDAOService.findAll();
	}

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		log.info("Create Product");
		return productDAOService.save(product);

	}

	@PutMapping
	public Product updateProduct(@RequestBody Product product) {
		log.info("Update Product");
		return productDAOService.update(product);

	}

	@DeleteMapping
	public Product deleteProduct(@RequestBody Product product) {
		log.info("Delete Product");
		return productDAOService.delete(product);
	}

}
