package com.domain.projectname.services;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ServiceTest {
	@Bean
	ApiService apiService() {
		return new ApiServiceImpl();
	}
}
