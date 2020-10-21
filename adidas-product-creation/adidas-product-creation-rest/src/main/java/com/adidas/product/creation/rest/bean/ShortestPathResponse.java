package com.adidas.product.creation.rest.bean;

import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.SortedMap;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShortestPathResponse {

	private SortedMap<Integer, String> shortestPathCitiesMap;
	private String shortesPathRepresentation;
	private String status;
	private String message;

	public SortedMap<Integer, String> getShortestPathCitiesMap() {
		return shortestPathCitiesMap;
	}
	public void setShortestPathCitiesMap(SortedMap<Integer, String> shortestPathCitiesMap) {
		this.shortestPathCitiesMap = shortestPathCitiesMap;
	}
	public String getShortesPathRepresentation() {
		return shortesPathRepresentation;
	}
	public void setShortesPathRepresentation(String shortesPathRepresentation) {
		this.shortesPathRepresentation = shortesPathRepresentation;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShortestPathResponse [");
		if (shortestPathCitiesMap != null) {
			for (Entry<Integer, String> entry : shortestPathCitiesMap.entrySet()) {
				builder.append("Key: ");
				builder.append(entry.getKey());
				builder.append("Value: ");
				builder.append(entry.getValue());
			}
		}
		if (shortesPathRepresentation != null) {
			builder.append("shortesPathRepresentation=");
			builder.append(shortesPathRepresentation);
			builder.append(", ");
		}
		if (status != null) {
			builder.append("status=");
			builder.append(status);
			builder.append(", ");
		}
		if (message != null) {
			builder.append("message=");
			builder.append(message);
		}
		builder.append("]");
		return builder.toString();
	}




}
