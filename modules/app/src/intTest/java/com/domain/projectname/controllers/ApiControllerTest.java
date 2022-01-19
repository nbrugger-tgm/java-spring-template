package com.domain.projectname.controllers;

import com.domain.projectname.models.VersionDto;
import com.domain.projectname.services.ServiceTestConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(value = ApiController.class)
@Import(ServiceTestConfig.class)
class ApiControllerTest {
	//This is the official SemVer regex
	private static final String VER_REGEX    = "^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$";
	private static final String PEP440_REGEX = "^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(\\w+(\\d)*)?$";

	@Autowired
	private MockMvc      mvc;
	@Autowired
	private ObjectMapper mapper;

	@Test
	void version() throws Exception {
		String response = mvc.perform(get("/api/version"))
		                     .andReturn().getResponse().getContentAsString();
		VersionDto version = mapper.readValue(response, VersionDto.class);
		assertTrue(version.getVersion().matches(PEP440_REGEX));
	}
}