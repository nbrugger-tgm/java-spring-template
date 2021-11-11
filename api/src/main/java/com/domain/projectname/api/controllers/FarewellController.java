package com.domain.projectname.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Greet the whole world or someone special
 */
@RequestMapping("farewell")
public interface FarewellController {
	/**
	 * Farewell the whole world
	 *
	 * @return a bye, world text
	 */
	@GetMapping(produces = "text/plain")
	String farewellWorld();

	/**
	 * Farewell a special person :)
	 *
	 * @param name the name of the special person
	 *
	 * @return the farewells for the person
	 */
	@GetMapping(value = "{name}",
	            produces = "text/plain")
	String farewellHuman(@PathVariable String name) throws Exception;
}
