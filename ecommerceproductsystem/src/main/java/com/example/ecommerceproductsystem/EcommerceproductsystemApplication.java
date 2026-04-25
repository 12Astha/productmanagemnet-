package com.example.ecommerceproductsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.ecommerceproductsystem")
public class EcommerceproductsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceproductsystemApplication.class, args);
	}

}
