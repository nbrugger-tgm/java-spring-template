package com.domain.projectname.backend.arch;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.domain.projectname.backend.arch.MethodConditions.*;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.domain.projectname",
                importOptions = {ImportOption.DoNotIncludeTests.class})
public class ModelTest {


	@ArchTest
	public ArchRule hash_equals = classes()
			.that().resideInAPackage("..models..")
			.should(declareMethodThat(isHashCode))
			.andShould(declareMethodThat(isEquals))
			.andShould(declareMethodThat(isToString))
			.as("classes in package '..models..' should implement hashCode & equals (or be annotated using @Data");
}
