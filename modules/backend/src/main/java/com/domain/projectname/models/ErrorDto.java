package com.domain.projectname.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Carries information about an error that happened in the API
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ErrorDto {
	/**
	 * human-readable message that contains information what happened and delivers fix ideas
	 */
	@NotBlank
	private String message;
	/**
	 * unique error code that the developers can use to look up the logs
	 */
	@NotBlank
	private String code;
	/**
	 * the short error name (might be the exception classname or a short key e.g. offer_not_found)
	 */
	@Pattern(regexp = "[a-bA-B_-]+")
	private String error;
}
