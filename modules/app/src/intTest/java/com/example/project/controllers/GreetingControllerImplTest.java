package com.example.project.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest
class GreetingControllerImplTest {

	@Autowired
	private MockMvc mvc;

	@Test
	void greetWorld() throws Exception {
		mvc.perform(get("/greet"))
		   .andExpect(content().string("Hello, World!"));
	}

	@Test
	void greetHuman() throws Exception {
		mvc.perform(get("/greet/Johan"))
		   .andExpect(content().string("Hello, Johan!"));
		mvc.perform(get("/greet/Niton"))
		   .andExpect(content().string("Hello, Niton!"));
	}
}