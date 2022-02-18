package com.example.trainingproductservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.trainingproductservice.model.Product;

@Service
public class ProductDAOService {
	
	private static List<Product> products = new ArrayList<>();
	
	private static int productCount = 4;
	
	static {
		products.add(new Product(1,"iPhone", "1", "Apple IPhone", 80000 ));
		products.add(new Product(2,"iPad", "2", "Apple iPad", 60000 ));
		products.add(new Product(3,"Mac Book Pro", "3", "Apple Laptops", 120000 ));
		products.add(new Product(4,"iPod", "4", "Apple iPods", 20000 ));
	}
	
	public List<Product> findAll(){
		return products;
	}
	
	public Product findById(int id){
		for(Product product: products) {
			if(product.getId() == id)
				return product;
		}
		return null;
	}
	
	public Product save(Product product) {
		if(product.getId()==null) {
			product.setId(++productCount);
		}
		products.add(product);
		return product;
	}
	
	public Product update(Product product) {
		//Update the product in list
		return product;
	}
	
	public Product delete(Product product) {
		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext()) {
			Product p1 = iterator.next();
			if(p1.getId() == product.getId()) {
				iterator.remove();
				return product;
			}
		}
		return product;
	}
	
	

}
