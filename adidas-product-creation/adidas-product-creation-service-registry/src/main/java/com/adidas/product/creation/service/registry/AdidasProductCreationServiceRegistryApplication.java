package com.adidas.product.creation.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AdidasProductCreationServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdidasProductCreationServiceRegistryApplication.class, args);
	}
}
