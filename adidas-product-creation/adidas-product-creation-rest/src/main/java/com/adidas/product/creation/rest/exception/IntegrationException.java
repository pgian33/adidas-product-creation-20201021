package com.adidas.product.creation.rest.exception;

import org.springframework.http.HttpStatus;

public class IntegrationException extends Exception {

	private static final long serialVersionUID = -1611280895516423062L;
	private final String reason;
	private final HttpStatus status;
	
	
	public IntegrationException(String reason, HttpStatus status) {
		this.reason = reason;
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public HttpStatus getStatus() {
		return status;
	}
}
