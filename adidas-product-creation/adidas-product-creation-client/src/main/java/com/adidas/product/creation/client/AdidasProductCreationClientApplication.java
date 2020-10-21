package com.adidas.product.creation.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.adidas.product.creation.client.repository.CityRepository;

@SpringBootApplication
public class AdidasProductCreationClientApplication {
	
	@Autowired
	CityRepository cityRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AdidasProductCreationClientApplication.class, args);
	}
}
