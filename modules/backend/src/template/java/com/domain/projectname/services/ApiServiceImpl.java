package com.domain.projectname.services;

import org.springframework.stereotype.Service;

@Service
class ApiServiceImpl implements ApiService {
	private final String version = "${version}";

	public String getVersion() {
		return version;
	}
}
