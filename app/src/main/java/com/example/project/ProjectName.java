package com.example.project;

import com.vdurmont.semver4j.Semver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectName {

	public static final Semver VERSION = new Semver("0.0.0");

	public static void main(String[] args) {
		SpringApplication.run(ProjectName.class, args);
	}

}
