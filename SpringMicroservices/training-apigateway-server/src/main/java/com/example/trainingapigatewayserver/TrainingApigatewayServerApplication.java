package com.example.trainingapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TrainingApigatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingApigatewayServerApplication.class, args);
	}

}
