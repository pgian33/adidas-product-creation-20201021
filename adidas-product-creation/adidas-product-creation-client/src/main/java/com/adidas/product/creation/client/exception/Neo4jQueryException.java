package com.adidas.product.creation.client.exception;

public class Neo4jQueryException extends Exception {

	private static final long serialVersionUID = -8028818526810059109L;
	
	private final String errorMessage;
	private final String status;
	private final Integer code;
	
	public Neo4jQueryException(String message, String status, Integer code) {
		this.errorMessage = message;
		this.status = status;
		this.code = code;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public String getStatus() {
		return status;
	}
	public Integer getCode() {
		return code;
	}
	
}
