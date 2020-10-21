package com.adidas.product.creation.rest.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import feign.Response;
import feign.codec.ErrorDecoder;

public class IntegrationExceptionDecoder implements ErrorDecoder {

	private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationExceptionDecoder.class);


	@Override
	public Exception decode(String methodKey, Response response) {
		LOGGER.trace(">> decode - methodKey={}", methodKey);
		String reason = response.reason();
		HttpStatus httpStatus = HttpStatus.resolve(response.status());
		LOGGER.error("!! decode> An exception occurred during REST integration in: {} : Status Code={}, Reason={}",  methodKey, httpStatus, reason);
		return new IntegrationException(reason, httpStatus);
	}
}
