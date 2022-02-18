package com.example.trainingorderservice.controllers;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainingorderservice.cleint.ProductClient;
import com.example.trainingorderservice.model.Order;
import com.example.trainingorderservice.service.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderJPAController {

	private final OrderRepository orderRepository;
	private final ProductClient productClient;
	//private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;
	private final CircuitBreakerFactory circuitBreakerFactory;

	@GetMapping()
	public List<Order> getOrder() {
		log.info("Get Orders");
		return orderRepository.findAll();
	}

	/*
	 * //@PostMapping public String createOrder1(@RequestBody Order order) {
	 * log.info("Create Order"); boolean isProductExist =
	 * productClient.checkProduct(order.getId()); if (!isProductExist) {
	 * orderRepository.save(order); log.info("Product created with {}",
	 * order.getId()); return "Product Created"; } else return
	 * "Product already exist!!!";
	 * 
	 * }
	 */
	
	
	@PostMapping
	public String createOrder(@RequestBody Order order) {
		log.info("Create Order");
		//Resilience4JCircuitBreaker circuitBreaker = circuitBreakerFactory.create("product");
		CircuitBreaker  circuitBreaker = circuitBreakerFactory.create("product");
		java.util.function.Supplier<Boolean>  booleanProduct = ()-> productClient.checkProduct(order.getId());
		boolean isProductExist = circuitBreaker.run(booleanProduct, throwable -> handleErrorCases());
		if (!isProductExist) {
			orderRepository.save(order);
			log.info("Product created with {}", order.getId());
			return "Product Created";
		} else
			return "Product already exist!!!";

	}

	private Boolean handleErrorCases() {
		return true;
	}

	@PutMapping
	public Order updateOrder(@RequestBody Order order) {
		log.info("Update Order");
		return orderRepository.save(order);

	}

	@DeleteMapping
	public void deleteOrder(@RequestBody Order order) {
		log.info("Delete Order");
		orderRepository.delete(order);
	}

}
