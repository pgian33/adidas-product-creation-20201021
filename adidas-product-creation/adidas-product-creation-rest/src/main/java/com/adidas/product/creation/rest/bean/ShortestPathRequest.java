package com.adidas.product.creation.rest.bean;

public class ShortestPathRequest {

	private String departureCity;
	private String destinationCity;

	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public static String formatCityName(String cityName) {
		String outputCityName = "";
		if(cityName != null && cityName.length() > 2) {
			outputCityName = cityName.substring(0,1).toUpperCase().concat(cityName.substring(1).toLowerCase());
		}
		return outputCityName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShortestPathRequest [");
		if (departureCity != null) {
			builder.append("departureCity=");
			builder.append(departureCity);
			builder.append(", ");
		}
		if (destinationCity != null) {
			builder.append("destinationCity=");
			builder.append(destinationCity);
		}
		builder.append("]");
		return builder.toString();
	}
}
