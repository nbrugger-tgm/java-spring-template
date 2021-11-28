package com.domain.projectname.errorhandler;

import com.domain.projectname.api.filters.ApiErrorHandler;
import com.domain.projectname.models.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ErrorHandler implements ApiErrorHandler {
	@Override
	public ResponseEntity<ErrorDto> handleGenericException(
			Exception ex
	) {
		log.debug("Unknown exception", ex);
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
