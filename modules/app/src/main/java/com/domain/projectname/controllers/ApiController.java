package com.domain.projectname.controllers;

import com.domain.projectname.api.controllers.ApiInfoController;
import com.domain.projectname.models.VersionDto;
import com.domain.projectname.services.ApiService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController implements ApiInfoController {

	private final ApiService service;

	public ApiController(ApiService service) {this.service = service;}

	@Override
	public VersionDto getVersion() {
		String version = service.getVersion();
		return new VersionDto(version, !version.contains("-"));
	}
}
