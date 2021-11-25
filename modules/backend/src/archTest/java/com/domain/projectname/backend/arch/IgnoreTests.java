package com.domain.projectname.backend.arch;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.core.importer.Location;

public class IgnoreTests implements ImportOption {
	@Override
	public boolean includes(Location location) {
		return !location.contains("arch");
	}
}
