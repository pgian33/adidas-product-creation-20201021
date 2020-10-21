package com.adidas.product.creation.rest.helper;

import java.util.List;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.adidas.product.creation.rest.bean.ShortestPathResponse;

public class ProductCreationHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductCreationHelper.class);

	private ProductCreationHelper() {
		throw new IllegalStateException("It's not possibile to instanciate an Helper class");
	}

	private static TreeMap<Integer, String> getMapFromJson(List<String> citiesList) {
		LOGGER.trace(">> START: getMapFromJson()");
		TreeMap<Integer, String> treeMap = new TreeMap<>();
		for(int i = 0; i<citiesList.size(); i++) {
			String aCity = citiesList.get(i);
			int position = i+1;
			LOGGER.info("-- getMapFromJson(): Adding a new city={} in position={} to the itinerary", aCity, position);
			treeMap.put(position, aCity);
		}
		LOGGER.trace("<< END: getMapFromJson(): number of cities={}", treeMap.size());
		return treeMap;
	}

	private static String getRepresentationFromJson(List<String> citiesList) {
		LOGGER.trace(">> START: getRepresentationFromJson()");
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i<citiesList.size(); i++) {
			String aCity = citiesList.get(i);
			if(i != citiesList.size()-1) {
				builder.append(aCity);
				builder.append("->");
			} else {
				builder.append(aCity);
			}
		}
		String representation = builder.toString();
		LOGGER.trace("<< END: getRepresentationFromJson() - representation={}", representation);
		return representation;
	}

	public static ShortestPathResponse getShortestPathFromJson(List<String> citiesList) {
		LOGGER.trace(">> START: getShortestPathFromJson()");
		ShortestPathResponse shortestPathResponse = new ShortestPathResponse();
		if(citiesList != null && !citiesList.isEmpty()) {
			TreeMap<Integer, String> treeMapCities = getMapFromJson(citiesList);
			String representation = getRepresentationFromJson(citiesList);

			shortestPathResponse.setShortestPathCitiesMap(treeMapCities);
			shortestPathResponse.setShortesPathRepresentation(representation);
		}
		LOGGER.trace(">> END: getShortestPathFromJson() - shortestPathResponse= {}", shortestPathResponse);
		return shortestPathResponse;
	}
}