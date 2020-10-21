package com.adidas.product.creation.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.product.creation.integration.model.ShortestPathModel;
import com.adidas.product.creation.integration.model.enumeration.ResultEnumeration;
import com.adidas.product.creation.rest.bean.ApiError;
import com.adidas.product.creation.rest.bean.ShortestPathRequest;
import com.adidas.product.creation.rest.bean.ShortestPathResponse;
import com.adidas.product.creation.rest.client.ProductCreationClient;
import com.adidas.product.creation.rest.exception.IntegrationException;
import com.adidas.product.creation.rest.helper.ProductCreationHelper;


@Component
@RestController
@RequestMapping(value = "/")
public class ShortestPathController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShortestPathController.class);

	@Autowired
	private ProductCreationClient productCreationClient;

	@PostMapping("/connections-shortest-path")
	public ResponseEntity<?> getConnectionsShortestPath(@RequestBody ShortestPathRequest shortestPathRequest) {
		LOGGER.info(">> START getConnectionsShortestPath: shortestPathRequest={}", shortestPathRequest);
		ShortestPathModel shortestPathModel = null;
		try {
			String departureCity = shortestPathRequest.getDepartureCity();
			String destinationCity = shortestPathRequest.getDestinationCity();

			if(departureCity==null || departureCity.isEmpty()) {
				throw new IntegrationException(ResultEnumeration.DEPARTURE_CITY_MISSING.getMessage(), HttpStatus.valueOf(ResultEnumeration.DEPARTURE_CITY_MISSING.getStatus()));
			} else if(destinationCity==null || destinationCity.isEmpty()) {
				throw new IntegrationException(ResultEnumeration.DESTINATION_CITY_MISSING.getMessage(), HttpStatus.valueOf(ResultEnumeration.DESTINATION_CITY_MISSING.getStatus()));
			}

			shortestPathModel = productCreationClient.getConnectionsShortestPath(
					ShortestPathRequest.formatCityName(departureCity), 
					ShortestPathRequest.formatCityName(destinationCity));

			String queryResultMessage = shortestPathModel.getMessage();
			String queryResultStatus = shortestPathModel.getStatus();
			Integer queryResultCode = shortestPathModel.getHttpStatusCode();
			LOGGER.info("-- shortestPathModel: queryResultMessage={}, queryResultStatus={}, queryResultCode={}", queryResultMessage, queryResultStatus, queryResultCode);

			if("OK".equals(queryResultStatus)) {
				ShortestPathResponse shortestPathResponse = ProductCreationHelper.getShortestPathFromJson(shortestPathModel.getCities());
				return new ResponseEntity<>(shortestPathResponse, HttpStatus.valueOf(queryResultCode));
			}

			throw new IntegrationException(queryResultMessage, HttpStatus.valueOf(queryResultCode));

		} catch (IntegrationException e) {
			LOGGER.error("!! ERROR getConnectionsShortestPath: An IntegrationException occurred", e);
			ApiError error = new ApiError(String.valueOf(e.getStatus()), e.getReason());
			return new ResponseEntity<>(error, e.getStatus());
		} catch (Exception ex) {
			LOGGER.error("!! ERROR A Generic Exception Occurred", ex);
			ApiError error = new ApiError(ResultEnumeration.GENERIC_ERROR.getStatus(), String.valueOf(ex.getMessage()));
			return new ResponseEntity<>(error, HttpStatus.valueOf(ResultEnumeration.GENERIC_ERROR.getHttpStatusCode()));
		}
	}

	@PostMapping("/time-shortest-path") 
	public ResponseEntity<?> getTimeShortestPath(@RequestBody ShortestPathRequest shortestPathRequest) {
		LOGGER.info(">> START getConnectionsShortestPath: getTimeShortestPath={}", shortestPathRequest);
		ShortestPathModel shortestPathModel = null;		
		try {
			String departureCity = shortestPathRequest.getDepartureCity();
			String destinationCity = shortestPathRequest.getDestinationCity();

			if(departureCity==null || departureCity.isEmpty()) {
				throw new IntegrationException(ResultEnumeration.DEPARTURE_CITY_MISSING.getMessage(), HttpStatus.valueOf(ResultEnumeration.DEPARTURE_CITY_MISSING.getStatus()));
			} else if(destinationCity==null || destinationCity.isEmpty()) {
				throw new IntegrationException(ResultEnumeration.DESTINATION_CITY_MISSING.getMessage(), HttpStatus.valueOf(ResultEnumeration.DESTINATION_CITY_MISSING.getStatus()));
			}

			shortestPathModel = productCreationClient.getTimeShortestPath(
					ShortestPathRequest.formatCityName(shortestPathRequest.getDepartureCity()), 
					ShortestPathRequest.formatCityName(shortestPathRequest.getDestinationCity()));
			
			String queryResultMessage = shortestPathModel.getMessage();
			String queryResultStatus = shortestPathModel.getMessage();
			Integer queryResultCode = shortestPathModel.getHttpStatusCode();
			LOGGER.info("-- shortestPathModel: queryResultMessage={}, queryResultStatus={}, queryResultCode={}", queryResultMessage, queryResultStatus, queryResultCode);
			
			if(queryResultStatus.equals("OK")) {
				ShortestPathResponse shortestPathResponse = ProductCreationHelper.getShortestPathFromJson(shortestPathModel.getCities());
				return new ResponseEntity<>(shortestPathResponse, HttpStatus.valueOf(queryResultCode));
			}
			
			throw new IntegrationException(queryResultMessage, HttpStatus.valueOf(queryResultCode));

		} catch (IntegrationException e) {
			LOGGER.error("!! ERROR getConnectionsShortestPath: An IntegrationException occurred", e);
			ApiError error = new ApiError(String.valueOf(e.getStatus()), e.getReason());
			return new ResponseEntity<>(error, e.getStatus());
		} catch (Exception ex) {
			LOGGER.error("!! ERROR A Generic Exception Occurred", ex);
			ApiError error = new ApiError(String.valueOf(ResultEnumeration.GENERIC_ERROR.getStatus()), ResultEnumeration.GENERIC_ERROR.getMessage());
			return new ResponseEntity<>(error, HttpStatus.valueOf(ResultEnumeration.GENERIC_ERROR.getHttpStatusCode()));
		}
	}
}
