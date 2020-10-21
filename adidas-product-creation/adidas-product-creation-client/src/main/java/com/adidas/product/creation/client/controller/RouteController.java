package com.adidas.product.creation.client.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.product.creation.client.entity.City;
import com.adidas.product.creation.client.exception.Neo4jQueryException;
import com.adidas.product.creation.client.repository.CityRepository;
import com.adidas.product.creation.integration.model.ShortestPathModel;
import com.adidas.product.creation.integration.model.enumeration.ResultEnumeration;

@Component
@RestController
@RequestMapping(value = "/")
public class RouteController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RouteController.class);

	@Autowired
	private CityRepository cityRepository;

	@RequestMapping(value = "/connections-shortest-path")
	public ShortestPathModel getConnectionsShortestPath(@RequestParam(value="departureCity") String departureCity, @RequestParam(value="destinationCity") String destinationCity) {
		LOGGER.info(">> START getConnectionsShortestPath: departureCity={}, destinationCity={}", departureCity, destinationCity);

		ShortestPathModel shortestPathModel = new ShortestPathModel();

		try {
			if(departureCity == null || departureCity.isEmpty() || 
					destinationCity == null || destinationCity.isEmpty()) {
				LOGGER.warn("?? getConnectionsShortestPath: Check input parameters");
				throw new Neo4jQueryException(ResultEnumeration.NOT_EXECUTABLE_QUERY.getMessage(), ResultEnumeration.NOT_EXECUTABLE_QUERY.getStatus(), ResultEnumeration.NOT_EXECUTABLE_QUERY.getHttpStatusCode());
			}

			List<City> connectionsShortestPathList = cityRepository.getConnetionShortestPath(departureCity, destinationCity);

			if(connectionsShortestPathList == null || connectionsShortestPathList.isEmpty()) {
				throw new Neo4jQueryException(ResultEnumeration.NO_RESULTS_FOUND.getMessage(), ResultEnumeration.NO_RESULTS_FOUND.getStatus(), ResultEnumeration.NO_RESULTS_FOUND.getHttpStatusCode());
			}

			shortestPathModel.setCities(connectionsShortestPathList.stream().map(entry -> entry.getName()).collect(Collectors.toList()));
			shortestPathModel.setStatus(ResultEnumeration.OK.getStatus());
			shortestPathModel.setHttpStatusCode(ResultEnumeration.OK.getHttpStatusCode());
			shortestPathModel.setMessage(ResultEnumeration.OK.getMessage());

		}catch (Neo4jQueryException ex) {
			LOGGER.error("!! A Neo4jQueryException occurred", ex);
			shortestPathModel.setMessage(ex.getErrorMessage());
			shortestPathModel.setStatus(ex.getStatus());
			shortestPathModel.setHttpStatusCode(ex.getCode());
		}catch (Exception ex) {
			LOGGER.error("!! An Exception occurred", ex);
			shortestPathModel.setMessage(ResultEnumeration.GENERIC_ERROR.getMessage());
			shortestPathModel.setStatus(ResultEnumeration.GENERIC_ERROR.getStatus());
			shortestPathModel.setHttpStatusCode(ResultEnumeration.GENERIC_ERROR.getHttpStatusCode());
		}
		
		LOGGER.info("<< END getConnectionsShortestPath: shortestPathModel={}", shortestPathModel);
		return shortestPathModel;
	}

	@RequestMapping(value = "/time-shortest-path")
	public ShortestPathModel getTimeShortestPath(@RequestParam(value="departureCity", required=true) String departureCity, @RequestParam(value="destinationCity", required=true) String destinationCity) throws Neo4jQueryException {
		LOGGER.info(">> START getTimeShortestPath: departureCity={}, destinationCity={}", departureCity, destinationCity);

		ShortestPathModel shortestPathModel = new ShortestPathModel();

		try {
			if(departureCity == null || departureCity.isEmpty() || 
					destinationCity == null || destinationCity.isEmpty()) {
				LOGGER.warn("?? getTimeShortestPath: Check input parameters");
				throw new Neo4jQueryException(ResultEnumeration.NOT_EXECUTABLE_QUERY.getMessage(), ResultEnumeration.NOT_EXECUTABLE_QUERY.getStatus(), ResultEnumeration.NOT_EXECUTABLE_QUERY.getHttpStatusCode());
			}

			List<City> timeShortestPathList = cityRepository.getTimeShortestPath(departureCity, destinationCity);

			if(timeShortestPathList == null || timeShortestPathList.isEmpty()) {
				throw new Neo4jQueryException(ResultEnumeration.NO_RESULTS_FOUND.getMessage(), ResultEnumeration.NO_RESULTS_FOUND.getStatus(), ResultEnumeration.NO_RESULTS_FOUND.getHttpStatusCode());
			}

			shortestPathModel.setCities(timeShortestPathList.stream().map(entry -> entry.getName()).collect(Collectors.toList()));
			shortestPathModel.setStatus(ResultEnumeration.OK.getStatus());
			shortestPathModel.setHttpStatusCode(ResultEnumeration.OK.getHttpStatusCode());
			shortestPathModel.setMessage(ResultEnumeration.OK.getMessage());
			
		}catch (Neo4jQueryException ex) {
			LOGGER.error("!! A Neo4jQueryException occurred", ex);
			shortestPathModel.setMessage(ex.getErrorMessage());
			shortestPathModel.setStatus(ex.getStatus());
			shortestPathModel.setHttpStatusCode(ex.getCode());
		}catch (Exception ex) {
			LOGGER.error("!! An Exception occurred", ex);
			shortestPathModel.setMessage(ResultEnumeration.GENERIC_ERROR.getMessage());
			shortestPathModel.setStatus(ResultEnumeration.GENERIC_ERROR.getStatus());
			shortestPathModel.setHttpStatusCode(ResultEnumeration.GENERIC_ERROR.getHttpStatusCode());
		}
		
		LOGGER.info("<< END getConnectionsShortestPath: shortestPathModel={}", shortestPathModel);
		return shortestPathModel;
	}
}
