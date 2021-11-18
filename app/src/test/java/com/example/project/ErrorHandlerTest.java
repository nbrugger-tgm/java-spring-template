package com.example.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

class ErrorHandlerTest {

	@Test
	void handleError() {
		ErrorHandler errorHandler = new ErrorHandler();
		var          errorResponse = errorHandler.handleGenericException(new IllegalAccessException());
		assertEquals(INTERNAL_SERVER_ERROR, errorResponse.getStatusCode(),
		             "Unknown errors should result in status 500 / Internal Server Error"
		);
	}
}