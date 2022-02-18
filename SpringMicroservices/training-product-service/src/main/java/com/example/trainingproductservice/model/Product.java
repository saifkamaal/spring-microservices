package com.example.trainingproductservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends RepresentationModel<Product> {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String skuCode;
	private String description;
	private int price;
	
}
