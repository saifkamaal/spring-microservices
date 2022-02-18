package com.example.trainingproductservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TrainingProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingProductServiceApplication.class, args);
	}

}
