package com.domain.projectname.api.controllers;

import com.domain.projectname.models.VersionDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public interface ApiInfoController {
	@GetMapping("version")
	VersionDto version();
}
