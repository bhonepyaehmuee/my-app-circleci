package com.example.product_exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductExerciseApplication.class, args);
	}

}
