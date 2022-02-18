package com.example.trainingproductservice.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trainingproductservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	

}
