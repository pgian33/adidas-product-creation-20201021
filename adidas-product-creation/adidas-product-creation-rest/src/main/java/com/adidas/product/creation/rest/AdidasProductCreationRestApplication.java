package com.adidas.product.creation.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AdidasProductCreationRestApplication  {

	public static void main(String[] args) {
		SpringApplication.run(AdidasProductCreationRestApplication.class, args);
	}
}
