package com.domain.projectname.api.filters;

import com.domain.projectname.models.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public interface ApiErrorHandler {
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({Exception.class, RuntimeException.class})
	default ResponseEntity<ErrorDto> handleGenericException(Exception ex) {
		return new ResponseEntity<>(
				new ErrorDto(
						ex.getMessage(),
						String.valueOf(System.currentTimeMillis()),
						ex.getClass().getSimpleName()
				),
				HttpStatus.INTERNAL_SERVER_ERROR
		);
	}
}
