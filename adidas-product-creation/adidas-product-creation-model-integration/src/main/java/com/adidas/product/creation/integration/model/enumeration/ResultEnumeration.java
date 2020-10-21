package com.adidas.product.creation.integration.model.enumeration;

public enum ResultEnumeration {
	
	OK("OK", "Query performed correctly", 200),
	GENERIC_ERROR("KO", "A generic error occurred", 500),
	NOT_EXECUTABLE_QUERY("KO", "You must not execute the query with missing fields", 400),
	DEPARTURE_CITY_MISSING("KO", "Departure city must not be null/empty", 400),
	DESTINATION_CITY_MISSING("KO", "Departure city must not be null/empty", 400),
	NO_RESULTS_FOUND("KO", "No results found for the given input", 404);
	
	private String status;
	private String message;
	private Integer httpStatusCode;
	
	private ResultEnumeration(String status, String message, Integer httpStatusCode) {
		this.status = status;
		this.message = message;
		this.httpStatusCode = httpStatusCode;
	}

	public String getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}

	public Integer getHttpStatusCode() {
		return httpStatusCode;
	}
}
