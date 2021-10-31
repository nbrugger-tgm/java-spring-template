package com.domain.projectname.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Greet the whole world or someone special
 */
@RequestMapping("greet")
public interface GreetingController {
	/**
	 * Greet the whole world
	 *
	 * @return a hello, world text
	 */
	@GetMapping(produces = "text/plain")
	String greetWorld();

	/**
	 * Greet a special person :)
	 *
	 * @param name the name of the special person
	 *
	 * @return the greetings for the person
	 */
	@GetMapping(value = "{name}",
	            produces = "text/plain")
	String greetHuman(@PathVariable String name) throws Exception;
}
