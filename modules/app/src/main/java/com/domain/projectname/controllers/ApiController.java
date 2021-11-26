package com.domain.projectname.controllers;

import com.domain.projectname.ProjectName;
import com.domain.projectname.api.controllers.ApiInfoController;
import com.domain.projectname.models.VersionDto;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController implements ApiInfoController {

	@Override
	public VersionDto getVersion() {
		return new VersionDto(ProjectName.VERSION, !ProjectName.VERSION.contains("-"));
	}
}
