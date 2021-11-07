package com.domain.projectname.models;

import com.vdurmont.semver4j.Semver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VersionResponseTest {

	VersionResponse releaseCandidate = new VersionResponse(new Semver("3.2.1-RC.5"));
	VersionResponse beta             = new VersionResponse(new Semver("3.2.1-beta"));
	VersionResponse stable           = new VersionResponse(new Semver("3.2.1"));

	@Test
	void getVersion() {
		assertEquals("3.2.1", stable.getVersion());
		assertEquals("3.2.1-beta", beta.getVersion());
		assertEquals("3.2.1-RC.5", releaseCandidate.getVersion());
	}

	@Test
	void isStable() {
		assertTrue(stable.isStable());
		assertFalse(beta.isStable());
		assertFalse(releaseCandidate.isStable());
	}
}