package com.adidas.product.creation.integration.model;

import java.util.List;

public class ShortestPathModel {

	private List<String> cities;
	private String status;
	private String message;
	private Integer httpStatusCode;

	public List<String> getCities() {
		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getHttpStatusCode() {
		return httpStatusCode;
	}
	public void setHttpStatusCode(Integer httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShortestPathModel [");
		if (cities != null) {
			builder.append("cities=");
			cities.stream().forEach(aCity->
			builder.append(aCity).append(", "));
		}
		if (status != null) {
			builder.append("status=");
			builder.append(status);
			builder.append(", ");
		}
		if (message != null) {
			builder.append("message=");
			builder.append(message);
			builder.append(", ");
		}
		if (httpStatusCode != null) {
			builder.append("httpStatusCode=");
			builder.append(httpStatusCode);
		}
		builder.append("]");
		return builder.toString();
	}


}
