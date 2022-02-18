package com.example.trainingconfigurationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class TrainingConfigurationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingConfigurationServiceApplication.class, args);
	}

}
