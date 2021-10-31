package com.domain.projectname.models;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Carries information about an error that happened in the API
 */
@Data
public class ErrorResponse {
	/**
	 * human-readable message that contains information what happened and delivers fix ideas
	 */
	@NotBlank
	private final String message;
	/**
	 * unique error code that the developers can use to look up the logs
	 */
	@NotBlank
	private final String code;
	/**
	 * the short error name (might be the exception classname or a short key e.g. offer_not_found)
	 */
	@Pattern(regexp = "[a-bA-B_-]+")
	private final String error;
}
