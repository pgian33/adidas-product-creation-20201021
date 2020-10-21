package com.adidas.product.creation.rest.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adidas.product.creation.integration.model.ShortestPathModel;
import com.adidas.product.creation.rest.exception.IntegrationException;

@FeignClient("adidas-product-creation-client")
public interface ProductCreationClient {
	
	@RequestMapping("/connections-shortest-path")
	ShortestPathModel getConnectionsShortestPath(@RequestParam("departureCity") String departureCity, @RequestParam("destinationCity") String destinationCity) throws IntegrationException;

	@RequestMapping("/time-shortest-path")
	ShortestPathModel getTimeShortestPath(@RequestParam("departureCity") String departureCity, @RequestParam("destinationCity") String destinationCity) throws IntegrationException;

}