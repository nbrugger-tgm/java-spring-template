package com.domain.projectname.backend.arch;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.domain.projectname",
                importOptions = {ImportOption.DoNotIncludeTests.class, IgnoreTests.class})
public class LayerArchitectureTest {
	@ArchTest
	static final ArchRule layers = layeredArchitecture()
			.layer("Entities").definedBy("..entities..")
			.layer("Repositories").definedBy("..repositories..")
			.layer("Models").definedBy("..models..")
			.layer("Services").definedBy("..services..")
			.optionalLayer("General").definedBy("..general..")

			// not possible due to https://github.com/TNG/ArchUnit/issues/154 .whereLayer("Entities").mayOnlyAccessLayers(NO)
			.whereLayer("Entities").mayOnlyBeAccessedByLayers("Services", "Models", "Repositories")
			.whereLayer("Repositories").mayOnlyBeAccessedByLayers("Services")
			.whereLayer("Models").mayOnlyBeAccessedByLayers("Services")
			.whereLayer("Services").mayNotBeAccessedByAnyLayer()
			.whereLayer("General").mayOnlyBeAccessedByLayers("Services");
}
