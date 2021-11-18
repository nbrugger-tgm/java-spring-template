package com.example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectName {

	public static final String VERSION = "0.1.0rc0";

	public static void main(String[] args) {
		SpringApplication.run(ProjectName.class, args);
	}

}
