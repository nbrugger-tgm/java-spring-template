package com.example.project.controllers;

import com.domain.projectname.api.controllers.ApiInfoController;
import com.domain.projectname.models.VersionResponse;
import com.example.project.ProjectName;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController implements ApiInfoController {
	@Override
	public VersionResponse version() {
		return new VersionResponse(ProjectName.VERSION);
	}
}
