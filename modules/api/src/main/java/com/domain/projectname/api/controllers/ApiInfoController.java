package com.domain.projectname.api.controllers;

import com.domain.projectname.models.VersionDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api")
public interface ApiInfoController {

	@Operation(
			summary = "Get API version",
			description = "Get API version",
			tags = "ApiInfo"
	)
	@GetMapping("/version")
	VersionDto getVersion();
}
