package com.domain.projectname.config;

public enum Profile {
	LOCAL;

	public String getName() {
		return name().toLowerCase();
	}
}
